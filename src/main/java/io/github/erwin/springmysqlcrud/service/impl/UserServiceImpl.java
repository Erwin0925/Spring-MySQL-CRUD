package io.github.erwin.springmysqlcrud.service.impl;

import io.github.erwin.springmysqlcrud.dto.UserDto;
import io.github.erwin.springmysqlcrud.entity.User;
import io.github.erwin.springmysqlcrud.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import io.github.erwin.springmysqlcrud.repository.UserRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
        return user;
    }

    @Override
    public User updateUser(int id, User user) {
        User existingUser = userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        existingUser.setCountry(user.getCountry());
        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(int id) {
        User existingUser = userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
        userRepository.delete(existingUser);
    }

    @Override
    public User updateUserName(int id, UserDto user) {
        User existingUser = userRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user Id:" + id));
        existingUser.setName(user.getName());
        userRepository.save(existingUser);
        return existingUser;
    }

    public Optional<User> getUserByName(String name){
        return userRepository.findByName(name);
    }
}
