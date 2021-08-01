package com.comicsm.comicsmanager.service;

import com.comicsm.comicsmanager.entities.Comics;
import com.comicsm.comicsmanager.exception.BusinessRuleException;
import com.comicsm.comicsmanager.repository.ComicsRepository;
import com.comicsm.comicsmanager.repository.UserRepository;
import com.comicsm.comicsmanager.service.util.Discount;
import com.comicsm.comicsmanager.service.util.Hash;
import com.comicsm.comicsmanager.service.util.Timestamp;
import com.comicsm.comicsmanager.service.util.model.FeignComics;
import com.comicsm.comicsmanager.service.util.model.Part;
import com.comicsm.comicsmanager.service.util.model.Recover;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicsService {

    @Autowired
    private ComicsRepository comicsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ComicsMarvelService comicsMarvelService;

    @Autowired
    private UserService userService;

    @Value("${marvel.privateKey}")
    private String privateKey;

    @Value("${marvel.publicKey}")
    private String publicKey;

    private String ts;
    private String hash;

    public List<Comics> listAll(Long codeUser) {
        return comicsRepository.findByUserCode(codeUser);
    }

//    public Comics save(Long codeUser, Comics comics) {
//        validateComicsUserExists(codeUser);
//        validateDuplicateComics(comics);
//        return comicsRepository.save(comics);
//    }
       //*****
    public Comics save(Long code, Comics comics) {

        ts = Timestamp.createTimestamp();
        hash = Hash.createHashMd5(ts, privateKey, publicKey);
        try {

            Long comicId = comics.getComicId();
            Comics createComic = new Comics();
            FeignComics feignComics = comicsMarvelService.returnComic(comicId, ts, hash, publicKey);
            Recover resultado = feignComics.getData().getResults().get(0);

            createComic.setTitle(resultado.getTitle());
            createComic.setComicId(resultado.getId());
            createComic.setDescription(resultado.getDescription());
            createComic.setIsbn(resultado.getIsbn());

            List<Part> autores = resultado.getCreators().getItems();
            StringBuilder sb = new StringBuilder();
            autores.forEach(autor -> sb.append(autor.getName()).append(", "));
            if (!autores.isEmpty()) {
                String autor = sb.toString();
                createComic.setAuthors(autor.substring(0, autor.length() - 2));
            }

            String diaDesconto = Discount.TheDiscountDay(resultado.getIsbn());
            createComic.setDiscountDay(diaDesconto);
            Boolean activeDiscount = Discount.checkActiveDiscount(diaDesconto);
            createComic.getActiveDiscount(activeDiscount);

            createComic.setPrice(resultado.getPrices().get(0).getPrice());

            return comicsRepository.save(createComic);

        } catch (FeignException e) {
            throw new BusinessRuleException("Not found");
        }
    }

    public void delete(Long codeComics) {
        comicsRepository.deleteById(codeComics);
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
