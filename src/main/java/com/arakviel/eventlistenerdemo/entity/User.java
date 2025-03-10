package com.arakviel.eventlistenerdemo.entity;

import static jakarta.persistence.EnumType.STRING;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 350, nullable = false, unique = true)
    private String email;
    @Column(length = 128, nullable = false)
    private String password;
    @Column(length = 2048, nullable = true)
    private String avatar;
    @Enumerated(STRING)
    private Role role;
    @Column(nullable = true)
    private LocalDateTime createdAt;

    public enum Role {
        ROLE_USER,
        ROLE_ADMIN
    }
}
