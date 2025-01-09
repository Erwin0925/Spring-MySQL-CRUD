package io.github.erwin.springmysqlcrud.service;

import io.github.erwin.springmysqlcrud.dto.UserDto;
import io.github.erwin.springmysqlcrud.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void addUser(User user);

    List<User> getUsers();

    User getUser(int id);

    User updateUser(int id, User user);

    void deleteUser(int id);

    User updateUserName(int id, UserDto user);

    Optional<User> getUserByName(String email);
}
