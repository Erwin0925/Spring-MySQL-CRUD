package io.github.erwin.springmysqlcrud.repository;

import io.github.erwin.springmysqlcrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}
