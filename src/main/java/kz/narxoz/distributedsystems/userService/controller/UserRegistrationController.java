package kz.narxoz.distributedsystems.userService.controller;

import kz.narxoz.distributedsystems.userService.dto.UserCreateDTO;
import kz.narxoz.distributedsystems.userService.dto.UserDTO;
import kz.narxoz.distributedsystems.userService.service.KeycloakService;
import kz.narxoz.distributedsystems.userService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
public class UserRegistrationController {

    private final KeycloakService keycloakService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserCreateDTO userCreateDTO) {
        try {
            keycloakService.createUser(userCreateDTO);

            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(userCreateDTO.getEmail());
            userDTO.setLogin(userCreateDTO.getUsername());
            userDTO.setFullName(userCreateDTO.getFirstName() + " " + userCreateDTO.getLastName());

            userService.addUser(userDTO);

            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error registering user: " + e.getMessage());
        }
    }
}