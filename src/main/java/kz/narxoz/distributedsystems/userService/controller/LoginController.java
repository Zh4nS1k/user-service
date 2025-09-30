package kz.narxoz.distributedsystems.userService.controller;

import kz.narxoz.distributedsystems.userService.dto.UserLoginDTO;
import kz.narxoz.distributedsystems.userService.dto.UserTokenDTO;
import kz.narxoz.distributedsystems.userService.service.KeycloakService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final KeycloakService keycloakService;

    @GetMapping
    public String getItems() {
        return "This is login page";
    }

    @PostMapping("/token")
    public UserTokenDTO signIn(@RequestBody UserLoginDTO userLoginDTO) {
        return keycloakService.authenticate(userLoginDTO);
    }
}