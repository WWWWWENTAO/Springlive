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
}