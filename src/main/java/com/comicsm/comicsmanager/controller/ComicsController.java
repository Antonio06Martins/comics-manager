package com.comicsm.comicsmanager.controller;

import com.comicsm.comicsmanager.entities.Comics;
import com.comicsm.comicsmanager.service.ComicsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Comics")
@RestController
@RequestMapping("/user{codeUser}/comics")
public class ComicsController {

    @Autowired
    private ComicsService comicsService;

    @ApiOperation(value = "List All", nickname = "listAll")
    @GetMapping
    public List<Comics> listAll(@PathVariable Long codeUser) {
        return comicsService.listAll(codeUser);
    }

    @ApiOperation(value = "Save", nickname = "saveComics")
    @PostMapping
    public ResponseEntity<Comics> save(@RequestBody Comics comics) {
        Comics comicsSave = comicsService.save(comics);
        return ResponseEntity.status(HttpStatus.CREATED).body(comicsSave);
    }
}
