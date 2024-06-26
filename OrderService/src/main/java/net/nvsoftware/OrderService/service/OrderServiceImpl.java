package net.nvsoftware.OrderService.service;

import com.netflix.discovery.converters.Auto;
import jakarta.ws.rs.PathParam;
import lombok.extern.log4j.Log4j2;
import net.nvsoftware.OrderService.client.PaymentServiceFeignClient;
import net.nvsoftware.OrderService.client.ProductServiceFeignClient;
import net.nvsoftware.OrderService.entity.OrderEntity;
import net.nvsoftware.OrderService.model.OrderRequest;
import net.nvsoftware.OrderService.model.OrderResponse;
import net.nvsoftware.OrderService.model.PaymentRequest;
import net.nvsoftware.OrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.Instant;

@Service
@Log4j2

public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductServiceFeignClient productServiceFeignClient;

    @Autowired
    private PaymentServiceFeignClient paymentServiceFeignClient;

    @Autowired
    private RestTemplate restTemplate; // Rest Api Url call ->


    @Override
    public long placeOrder(OrderRequest orderRequest) { // TODO: Transaction
        log.info("Start: OrderService placeOrder");
        // TODO: 1. use orderService create OrderEntity with status Created, save to DB

        OrderEntity orderEntity = OrderEntity.builder()
                .productId(orderRequest.getProductId())
                .quantity(orderRequest.getQuantity())
                .totalAmount(orderRequest.getTotalAmount())
                .orderDate(Instant.now())
                .orderStatus("Created")
                .build();

        orderRepository.save(orderEntity);
        log.info("Process: OrderService placeOrder, save OrderEntity with orderId: " + orderEntity.getId());

        // TODO: 2. call ProductService to check the product quantity, if OK, reduce it, or throw not enough quantity (Done in ProductService)

        productServiceFeignClient.reduceQuantity(orderEntity.getProductId(), orderEntity.getQuantity());
        log.info("Process: OrderService placeOrder FeignCall ProductService reduceQuantity");

        PaymentRequest paymentRequest = PaymentRequest.builder()
                .orderId(orderEntity.getId())
                .paymentMode(orderRequest.getPaymentMode())
                .totalAmount(orderRequest.getTotalAmount())
                .build();

        String orderStatus = null;

        try {
            paymentServiceFeignClient.dopayment(paymentRequest);
            orderStatus = "PAID";
            log.info("Process: Service placeOrder FeignCall PaymentService doPayment PAID");
        } catch (Exception e) {
            orderStatus = "PAYMENT_FAILED";
            log.info("Process: Service placeOrder FeignCall PaymentService doPayment FAILED");
        }

        orderEntity.setOrderStatus(orderStatus);
        orderRepository.save(orderEntity);

        // TODO: 3. call PaymentService to charge, if success, mark order status PAID, or status Cancelled (Call request across different micro services 1.Restful API 2.RPC Eureka (We choose this) Use FeignClient call)



        log.info("End: orderService placeOrder done with orderId: " + orderEntity.getId());
        return orderEntity.getId();
    }

    @Override
    public OrderResponse getOrderDetailById(long orderId) {
        log.info("Start: OrderService getOrderDetailById");

        OrderEntity orderEntity = orderRepository.findById(orderId)
                        .orElseThrow(() -> new RuntimeException("OrderService getOrderById: Order Not Found with Id " + orderId));

        OrderResponse.ProductResponse productResponse = restTemplate.getForObject(
                "http://PRODUCT-SERVICE/product/" + orderEntity.getProductId(),
                OrderResponse.ProductResponse.class
        );

        OrderResponse.PaymentResponse paymentResponse = restTemplate.getForObject(
                "http://PAYMENT-SERVICE/payment/" + orderEntity.getId(),
                OrderResponse.PaymentResponse.class
        );


        OrderResponse orderResponse = OrderResponse.builder()
                .orderId(orderEntity.getId())
                .orderStatus(orderEntity.getOrderStatus())
                .orderDate(orderEntity.getOrderDate())
                .totalAmount(orderEntity.getTotalAmount())
                .productResponse(productResponse)
                .paymentResponse(paymentResponse)
                .build();

        log.info("End: OrderService getOrderDetailById");
        return orderResponse;
    }
}
