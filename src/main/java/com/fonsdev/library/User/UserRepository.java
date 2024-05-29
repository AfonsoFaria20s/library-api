package com.fonsdev.library.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,  Integer> {
    List<User> findAllByName(String name);
    List<User> findByEmail(String email);
}
