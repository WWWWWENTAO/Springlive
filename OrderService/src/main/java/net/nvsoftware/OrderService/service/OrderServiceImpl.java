package net.nvsoftware.OrderService.service;

import com.netflix.discovery.converters.Auto;
import lombok.extern.log4j.Log4j2;
import net.nvsoftware.OrderService.entity.OrderEntity;
import net.nvsoftware.OrderService.model.OrderRequest;
import net.nvsoftware.OrderService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2

public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public long placeOrder(OrderRequest orderRequest) {
        log.info("Start: OrderService placeOrder");
        // TODO: 1. use orderService create OrderEntity with status Created, save to DB
        // TODO: 2. call ProductService to check the product quantity, if OK, reduce it, or throw not enough quantity
        // TODO: 3. PaymentService to charge, if success, mark order status PAID, or status Cancelled
        log.info("End: orderService placeOrder");
        return 88;
    }
}
