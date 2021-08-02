package com.comicsm.comicsmanager.service;

import com.comicsm.comicsmanager.entities.Comics;
import com.comicsm.comicsmanager.entities.User;
import com.comicsm.comicsmanager.exception.BusinessRuleException;
import com.comicsm.comicsmanager.repository.ComicsRepository;
import com.comicsm.comicsmanager.service.util.Discount;
import com.comicsm.comicsmanager.service.util.GenerateHash;
import com.comicsm.comicsmanager.service.util.template.FeignComics;
import com.comicsm.comicsmanager.service.util.template.Part;
import com.comicsm.comicsmanager.service.util.template.Recover;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ComicsService {

    @Autowired
    private ComicsRepository comicsRepository;

    @Autowired
    private ComicsMarvelService comicsMarvelService;

    @Value("${marvel.privateKey}")
    private String privateKey;

    @Value("${marvel.publicKey}")
    private String publicKey;

    private String ts;
    private String hash;

    public List<Comics> listAll(Long codeUser) {
        return comicsRepository.findByUserCode(codeUser);
    }

    public Comics save(Long code, Comics comics) {

        ts = "1";
        hash = GenerateHash.createHashMd5(ts, privateKey, publicKey);
        try {

            Long comicId = comics.getComicId();
            Comics createComic = new Comics();
            FeignComics feignComics = comicsMarvelService.returnComic(comicId, ts, hash, publicKey);
            Recover recover = feignComics.getData().getResults().get(0);

            createComic.setTitle(recover.getTitle());
            createComic.setComicId(recover.getId());
            createComic.setDescription(recover.getDescription());
            createComic.setIsbn(recover.getIsbn());
            createComic.setUser(new User(code));

            List<Part> authors = recover.getCreators().getItems();
            StringBuilder sb = new StringBuilder();
            authors.forEach(autor -> sb.append(autor.getName()).append(", "));
            if (!authors.isEmpty()) {
                String author = sb.toString();
                createComic.setAuthors(author.substring(0, author.length() - 2));
            }

            String discountDay = Discount.TheDiscountDay(recover.getIsbn());
            createComic.setDiscountDay(discountDay);
            Boolean activeDiscount = Discount.checkActiveDiscount(discountDay);
            createComic.setActiveDiscount(activeDiscount);

            BigDecimal DiscountedValue = createComic.applyValue(recover.getPrices().get(0).getPrice());
            createComic.setPrice(DiscountedValue);

            return comicsRepository.save(createComic);

        } catch (FeignException e) {
            throw new BusinessRuleException("Not found");
        }
    }

    public void delete(Long codeComics) {
        comicsRepository.deleteById(codeComics);
    }
}
