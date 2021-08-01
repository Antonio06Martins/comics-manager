package com.comicsm.comicsmanager.controller;

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

@Api(tags = "Comics")
@RestController
@RequestMapping("/user{codeUser}/comics")
public class ComicsController {

    @Autowired
    private ComicsService comicsService;

//    @ApiOperation(value = "List All", nickname = "listAll")
//    @GetMapping
//    public List<ComicsResponseDTO> listAll(@PathVariable Long codeUser) {
//        return comicsService.listAll(codeUser).stream().map(comics -> ComicsResponseDTO.convertToComicsDTO(comics))
//                .collect(Collectors.toList());
//    }

    //******
    @ApiOperation(value = "List All", nickname = "listAll")
    @GetMapping
    public List<Comics> listAll(@PathVariable Long codeUser) {
        return comicsService.listAll(codeUser);
    }

//    @ApiOperation(value = "Save", nickname = "saveComics")
//    @PostMapping
//    public ResponseEntity<ComicsResponseDTO> save(@PathVariable Long codeUser, @Valid @RequestBody ComicsRequestDTO comicsDto) {
//        Comics comicsSave = comicsService.save(codeUser, comicsDto.convertToEntity(codeUser));
//        return ResponseEntity.status(HttpStatus.CREATED).body(ComicsResponseDTO.convertToComicsDTO(comicsSave));
//    }

//    @ResponseStatus(value = HttpStatus.CREATED)
//    @PostMapping
//    public Comics adicionaComic(@PathVariable Long codeUser, @RequestBody Comics comicRequest) {
//
//
//
//        return comicsService.salvar(codeUser, comicRequest);
//
//    }

    //*****
    @ApiOperation(value = "Save", nickname = "saveComics")
    @PostMapping
    public ResponseEntity<Comics> save(@PathVariable Long codeUser, @Valid @RequestBody Comics comicId) {
        Comics comicsSave = comicsService.save(codeUser, comicId);

        return ResponseEntity.status(HttpStatus.CREATED).body(comicsSave);
    }

    @ApiOperation(value = "Delete", nickname = "deleteComics")
    @DeleteMapping("/{codeComics}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long codeComics) {
        comicsService.delete(codeComics);
    }
}
