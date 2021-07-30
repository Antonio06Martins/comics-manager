package com.comicsm.comicsmanager.service;

import com.comicsm.comicsmanager.entities.Comics;
import com.comicsm.comicsmanager.repository.ComicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicsService {

    @Autowired
    private ComicsRepository comicsRepository;

    public List<Comics> listAll(Long codeUser) {
        return comicsRepository.findByUserCode(codeUser);
    }
}
