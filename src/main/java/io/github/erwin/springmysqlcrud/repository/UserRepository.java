package io.github.erwin.springmysqlcrud.repository;

import io.github.erwin.springmysqlcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);
}
