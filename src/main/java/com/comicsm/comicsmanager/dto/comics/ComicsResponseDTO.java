package com.comicsm.comicsmanager.dto.comics;

import com.comicsm.comicsmanager.dto.user.UserResponseDTO;
import com.comicsm.comicsmanager.entities.Comics;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel("Comics return DTO")
public class ComicsResponseDTO {

    @ApiModelProperty(value = "Code Id")
    private Long codeId;

    @ApiModelProperty(value = "Comic Id")
    private Long comicId;

    @ApiModelProperty(value = "Title")
    private String title;

    @ApiModelProperty(value = "Price")
    private BigDecimal price;

    @ApiModelProperty(value = "Authors")
    private String authors;

    @ApiModelProperty(value = "ISBN")
    private String isbn;

    @ApiModelProperty(value = "Description")
    private String description;

    @ApiModelProperty(value = "Discount Day")
    private String discountDay;

    @ApiModelProperty(value = "Active Discount")
    private Boolean activeDiscount;

    @ApiModelProperty(value = "User")
    private UserResponseDTO user;

    public ComicsResponseDTO(Long codeId, Long comicId, String title, BigDecimal price, String authors, String isbn, String description, String discountDay, Boolean activeDiscount, UserResponseDTO user) {
        this.codeId = codeId;
        this.comicId = comicId;
        this.title = title;
        this.price = price;
        this.authors = authors;
        this.isbn = isbn;
        this.description = description;
        this.discountDay = discountDay;
        this.activeDiscount = activeDiscount;
        this.user = user;
    }

    public static ComicsResponseDTO convertToComicsDTO(Comics comics) {
        return new ComicsResponseDTO(comics.getCodeId(), comics.getComicId(), comics.getTitle(), comics.getPrice(), comics.getAuthors(),
                comics.getIsbn(), comics.getDescription(), comics.getDiscountDay(), comics.getActiveDiscount(),
                UserResponseDTO.convertToUserDTO(comics.getUser()));
    }

    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    public Long getComicId() {
        return comicId;
    }

    public void setComicId(Long comicId) {
        this.comicId = comicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscountDay() {
        return discountDay;
    }

    public void setDiscountDay(String discountDay) {
        this.discountDay = discountDay;
    }

    public Boolean getActiveDiscount() {
        return activeDiscount;
    }

    public void setActiveDiscount(Boolean activeDiscount) {
        this.activeDiscount = activeDiscount;
    }

    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        this.user = user;
    }
}
