package com.arakviel.eventlistenerdemo.service;

import com.arakviel.eventlistenerdemo.dto.CreateUserRequest;
import com.arakviel.eventlistenerdemo.entity.User;
import com.arakviel.eventlistenerdemo.event.CreatedUserEvent;
import com.arakviel.eventlistenerdemo.mapper.UserMapper;
import com.arakviel.eventlistenerdemo.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ApplicationEventPublisher publisher;
    private final UserMapper userMapper;

    public void save(CreateUserRequest userRequest) {
        User user = userRepository.save(userMapper.map(userRequest));
        var createdUserEvent = new CreatedUserEvent(this, user);
        publisher.publishEvent(createdUserEvent);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
