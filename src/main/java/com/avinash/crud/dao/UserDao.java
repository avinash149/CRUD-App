package com.avinash.crud.dao;

import com.avinash.crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User findCustomerByUsernameAndHash(String username, String password);
    User findByUsername(String username);
}
