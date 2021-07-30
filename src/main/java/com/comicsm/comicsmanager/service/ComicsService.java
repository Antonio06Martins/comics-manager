package com.comicsm.comicsmanager.service;

import com.comicsm.comicsmanager.entities.Comics;
import com.comicsm.comicsmanager.exception.BusinessRuleException;
import com.comicsm.comicsmanager.repository.ComicsRepository;
import com.comicsm.comicsmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicsService {

    @Autowired
    private ComicsRepository comicsRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Comics> listAll(Long codeUser) {
        return comicsRepository.findByUserCode(codeUser);
    }

    public Comics save(Comics comics) {
        validateComicsUserExists(comics.getUser().getCode());
        validateDuplicateComics(comics);
        return comicsRepository.save(comics);
    }

    private void validateDuplicateComics(Comics comics) {
        if (comicsRepository.findByUserCodeAndTitle(comics.getUser().getCode(), comics.getTitle()).isPresent()) {
            throw new BusinessRuleException(String.format("The comics %s is already registered", comics.getTitle()));
        }
    }


    private void validateComicsUserExists(Long codeUser) {
        if (codeUser == null) {
            throw new BusinessRuleException("User cannot be null.");
        }

        if (userRepository.findById(codeUser).isEmpty()) {
            throw new BusinessRuleException(String.format("User code %s does not exist.", codeUser));
        }
    }
}
