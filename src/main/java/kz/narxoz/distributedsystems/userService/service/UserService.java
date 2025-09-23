package kz.narxoz.distributedsystems.userService.service;

import kz.narxoz.distributedsystems.userService.dto.UserDTO;
import kz.narxoz.distributedsystems.userService.mapper.UserMapper;
import kz.narxoz.distributedsystems.userService.model.User;
import kz.narxoz.distributedsystems.userService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDTO> getUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    public UserDTO getUser(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElse(null);
    }

    public UserDTO addUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        return userMapper.toDto(userRepository.save(user));
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setEmail(userDTO.getEmail());
        existingUser.setLogin(userDTO.getLogin());
        existingUser.setFullName(userDTO.getFullName());

        return userMapper.toDto(userRepository.save(existingUser));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
