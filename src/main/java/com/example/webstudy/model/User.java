package com.example.webstudy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "active")
    private boolean active;
    @Column(name = "password", length = 1000)
    private String password;

    @Override
    public String toString() {
        return String.format(
                "User: [id=%d, name='%s', email='%s']",
                id, name, email);
    }
}
