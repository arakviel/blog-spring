package com.arakviel.eventlistenerdemo.mapper;

import com.arakviel.eventlistenerdemo.dto.CreateUserRequest;
import com.arakviel.eventlistenerdemo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    User map(CreateUserRequest request);
}