package com.example.webstudy.model;

import com.example.webstudy.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "serial")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "active")
    private boolean active;
    @Column(name = "password", length = 1000)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", columnDefinition = "default 'USER'")
    private Role role = Role.USER;

    @Override
    public String toString() {
        return String.format(
                "User: [id=%d, name='%s', email='%s']",
                id, name, email);
    }
}
