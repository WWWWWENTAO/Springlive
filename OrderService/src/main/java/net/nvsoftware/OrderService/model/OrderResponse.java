package net.nvsoftware.OrderService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class OrderResponse {

    private long orderId;

    private long totalAmount;

    private Instant orderDate;

    private String orderStatus;

    private ProductResponse productResponse;

    @Data // auto generate getter and setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder // predefine some implementations

    public static class ProductResponse {
        private long id;
        private String name;
        private long price;
        private long quantity;
    }



}