package net.nvsoftware.APIGateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AuthResponse {
    private String userid;

    private String accessToken;

    private String refreshToken;
    
    private long expiredAt;

    private Collection<String> authList;
}
