package com.comicsm.comicsmanager.controller;

import com.comicsm.comicsmanager.dto.comics.ComicsRequestDTO;
import com.comicsm.comicsmanager.dto.comics.ComicsResponseDTO;
import com.comicsm.comicsmanager.entities.Comics;
import com.comicsm.comicsmanager.service.ComicsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "Comics")
@RestController
@RequestMapping("/user{codeUser}/comics")
public class ComicsController {

    @Autowired
    private ComicsService comicsService;

    @ApiOperation(value = "List All", nickname = "listAll")
    @GetMapping
    public List<ComicsResponseDTO> listAll(@PathVariable Long codeUser) {
        return comicsService.listAll(codeUser).stream().map(comics -> ComicsResponseDTO.convertToComicsDTO(comics))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Save", nickname = "saveComics")
    @PostMapping
    public ResponseEntity<ComicsResponseDTO> save(@PathVariable Long codeUser, @Valid @RequestBody ComicsRequestDTO comicsDto) {
        Comics comicsSave = comicsService.save(codeUser, comicsDto.convertToEntity(codeUser));
        return ResponseEntity.status(HttpStatus.CREATED).body(ComicsResponseDTO.convertToComicsDTO(comicsSave));
    }

    @ApiOperation(value = "Delete", nickname = "deleteComics")
    @DeleteMapping("/{codeComics}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long codeComics) {
        comicsService.delete(codeComics);
    }
}
