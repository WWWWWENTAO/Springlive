package net.nvsoftware.OrderService.service;

import net.nvsoftware.OrderService.model.OrderRequest;
import org.hibernate.query.Order;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);
}
