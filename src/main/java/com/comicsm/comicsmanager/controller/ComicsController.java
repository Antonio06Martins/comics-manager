package com.comicsm.comicsmanager.controller;

import com.comicsm.comicsmanager.entities.Comics;
import com.comicsm.comicsmanager.service.ComicsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
