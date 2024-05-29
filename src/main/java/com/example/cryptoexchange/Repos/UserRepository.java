package com.example.cryptoexchange.Repos;

import com.example.cryptoexchange.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
