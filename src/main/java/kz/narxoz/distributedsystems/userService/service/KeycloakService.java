package kz.narxoz.distributedsystems.userService.service;

import kz.narxoz.distributedsystems.userService.client.KeycloakClient;
import kz.narxoz.distributedsystems.userService.dto.UserCreateDTO;
import kz.narxoz.distributedsystems.userService.dto.UserLoginDTO;
import kz.narxoz.distributedsystems.userService.dto.UserTokenDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeycloakService {
    private final KeycloakClient keycloakClient;

    public void createUser(UserCreateDTO userCreateDTO) {
        keycloakClient.createUser(userCreateDTO);
    }

    public UserTokenDTO authenticate(UserLoginDTO userLoginDTO) {
        return keycloakClient.signIn(userLoginDTO);
    }

    public void changePassword(String username, String newPassword) {
        keycloakClient.changePassword(username, newPassword);
    }
}