package demo.utils.mappers;

import demo.adapters.outbound.entities.JpaUserEntity;
import demo.domain.dto.UserRequestDTO;
import demo.domain.dto.UserResponseDTO;
import demo.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(source = "dto.name", target = "name"),
            @Mapping(source = "dto.email", target = "email"),
            @Mapping(source = "dto.password", target = "password")
    })
    User dtoToEntity(UserRequestDTO dto);

    @Mappings({
            @Mapping(source = "entity.id", target = "id"),
            @Mapping(source = "entity.name", target = "name"),
            @Mapping(source = "entity.email", target = "email")
    })
    UserResponseDTO entityToDtoResponse(User entity);
}
