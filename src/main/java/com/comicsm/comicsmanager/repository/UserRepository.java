package com.comicsm.comicsmanager.repository;

import com.comicsm.comicsmanager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByCpf(String cpf);
    User findByEmail(String email);
}
