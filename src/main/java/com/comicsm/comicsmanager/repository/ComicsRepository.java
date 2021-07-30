package com.comicsm.comicsmanager.repository;

import com.comicsm.comicsmanager.entities.Comics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComicsRepository extends JpaRepository<Comics, Long> {

    List<Comics> findByUserCode(Long codeUser);

}
