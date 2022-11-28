package com.example.webstudy.repository;

import com.example.webstudy.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    //Получить пользователя по id
    Optional<User> findById(Long id);

    //Сохранение в базу
    User save(User user);
}
