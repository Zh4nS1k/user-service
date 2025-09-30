package kz.narxoz.distributedsystems.userService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "OK", "service", "User Service");
    }

    @GetMapping("/info")
    public Map<String, String> info() {
        return Map.of(
                "name", "User Service",
                "description", "Microservice for user management with Keycloak",
                "version", "1.0.0"
        );
    }
}