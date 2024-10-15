package com.arakviel.eventlistenerdemo.repository;

import com.arakviel.eventlistenerdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
