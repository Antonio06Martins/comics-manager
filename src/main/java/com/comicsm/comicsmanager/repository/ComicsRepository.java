package com.comicsm.comicsmanager.repository;

import com.comicsm.comicsmanager.entities.Comics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComicsRepository extends JpaRepository<Comics, Long> {

    List<Comics> findByUserCode(Long codeUser);

    Optional<Comics> findByUserCodeAndTitle(Long codeUser, String title);

}
