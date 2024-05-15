package net.nvsoftware.APIGateway.controller;

/*
import jdk.jfr.Registered;
import net.nvsoftware.APIGateway.model.AuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @AuthenticationPrincipal OidcUser oidcUser,
            @RegisteredOAuth2AuthorizedClient("Okta") OAuth2AuthorizedClient client) {

        AuthResponse authResponse = AuthResponse.builder()
                .email(oidcUser.getEmail())
                .accessToken(client.getAccessToken().getTokenValue())
                .refreshToken(client.getRefreshToken().getTokenValue())
                .expiredAt(client.getAccessToken().getExpiresAt().toString())
                .build();

        return ResponseEntity.ok(authResponse);
    }
}
*/