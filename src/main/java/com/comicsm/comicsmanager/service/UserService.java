package com.comicsm.comicsmanager.service;

import com.comicsm.comicsmanager.entities.User;
import com.comicsm.comicsmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        //User userSave = validateExistingCPF(user.getCpf());
        return userRepository.save(user);
    }

    // verificar a regra para analizar se já existe o cpf cadastrado o mesmo para o email
    private User validateExistingCPF(String cpf) {
        Optional<User> user = userRepository.findByCpf(cpf);
        if (cpf.isEmpty()) {
            throw new EmptyResultDataAccessException(1);
        }
        return user.get();
    }
}
