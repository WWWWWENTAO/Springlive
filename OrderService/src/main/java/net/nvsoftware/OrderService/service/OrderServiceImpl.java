package net.nvsoftware.OrderService.service;

import com.netflix.discovery.converters.Auto;
import jakarta.ws.rs.PathParam;
import lombok.extern.log4j.Log4j2;
import net.nvsoftware.OrderService.entity.OrderEntity;
import net.nvsoftware.OrderService.model.OrderRequest;
import net.nvsoftware.OrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2

public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public long placeOrder(OrderRequest orderRequest) {
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

        // TODO: 3. call PaymentService to charge, if success, mark order status PAID, or status Cancelled (Call request across different micro services 1.Restful API 2.RPC Eureka)

        

        log.info("End: orderService placeOrder");
        return orderEntity.getId();
    }
}
