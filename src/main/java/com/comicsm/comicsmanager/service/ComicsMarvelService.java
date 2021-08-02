package com.comicsm.comicsmanager.service;

import com.comicsm.comicsmanager.service.util.template.FeignComics;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="api-comics", url = "http://gateway.marvel.com/v1/public/comics/")
public interface ComicsMarvelService {

    @GetMapping("{comicId}?ts={ts}&hash={hash}&apikey={api}")
    FeignComics returnComic(
            @PathVariable("comicId") Long comicId, @PathVariable("ts") String ts,
            @PathVariable("hash") String hash, @PathVariable("api") String api);
}
