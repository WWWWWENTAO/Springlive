package net.nvsoftware.OrderService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PaymentRequest {
    private long orderId;
    private String paymentMode;
    private long totalAmount;
}
