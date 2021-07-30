package com.comicsm.comicsmanager.service;

import com.comicsm.comicsmanager.entities.User;
import com.comicsm.comicsmanager.exception.BusinessRuleException;
import com.comicsm.comicsmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        validateExistingCPF(user);
        validateExistingEmail(user);
        return userRepository.save(user);
    }

    public void delete(Long code) {
        userRepository.deleteById(code);
    }

    private void validateExistingCPF(User user) {
        User userCpf = userRepository.findByCpf(user.getCpf());
        if (userCpf != null && userCpf.getCpf() != user.getCpf()) {
            throw new BusinessRuleException(String.format("The cpf %s is already registered.", user.getCpf().toUpperCase()));
        }
    }

    private void validateExistingEmail(User user) {
        User userEmail= userRepository.findByEmail(user.getEmail());
        if (userEmail != null && userEmail.getEmail() != user.getEmail()) {
            throw new BusinessRuleException(String.format("The Email %s is already registered.", user.getEmail().toUpperCase()));
        }
    }
}
