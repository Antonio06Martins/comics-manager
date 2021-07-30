package com.comicsm.comicsmanager.dto.comics;

import com.comicsm.comicsmanager.entities.Comics;
import com.comicsm.comicsmanager.entities.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel("Comics request DTO")
public class ComicsRequestDTO {

    @ApiModelProperty(value = "Comic Id")
    @NotNull(message = "comic Id")
    private Long comicId;

    @ApiModelProperty(value = "Title")
    @NotBlank(message = "Title")
    @Length(min = 3, max = 50, message = "Title")
    private String title;

    @ApiModelProperty(value = "Price")
    @NotNull(message = "Price")
    private BigDecimal price;

    @ApiModelProperty(value = "Authors")
    @NotBlank(message = "Authors")
    @Length(min = 3, max = 50, message = "Authors")
    private String authors;

    @ApiModelProperty(value = "ISBN")
    @NotBlank(message = "ISBN")
    @Length(min = 3, max = 50, message = "ISBN")
    private String isbn;

    @ApiModelProperty(value = "Description")
    @NotBlank(message = "Description")
    @Length(min = 3, max = 100, message = "Description")
    private String description;

    @ApiModelProperty(value = "Discount Day")
    @NotBlank(message = "DiscountDay")
    @Length(min = 3, max = 50, message = "DiscountDay")
    private String discountDay;

    @ApiModelProperty(value = "Active Discount")
    @NotNull(message = "Active Discount")
    private Boolean activeDiscount;

    public Comics convertToEntity(Long codeUser) {
        return new Comics(comicId, title, price, authors, isbn, description, discountDay, activeDiscount,
                new User(codeUser));
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
}
