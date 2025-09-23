package kz.narxoz.distributedsystems.userService.mapper;

import kz.narxoz.distributedsystems.userService.dto.UserDTO;
import kz.narxoz.distributedsystems.userService.model.User;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
    User toEntity(UserDTO userDTO);
    List<UserDTO> toDtoList(List<User> users);
}