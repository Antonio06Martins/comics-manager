package com.comicsm.comicsmanager.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "comics")
public class Comics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_id")
    private Long codeId;

    @Column(name = "comic_id")
    @NotNull(message = "comic Id")
    private Long comicId;

    @Column(name = "title")
    @NotBlank(message = "Name")
    @Length(min = 3, max = 50, message = "Name")
    private String title;

    @Column(name = "price")
    @NotNull(message = "Price")
    private BigDecimal price;

    @Column(name = "authors")
    @NotBlank(message = "Authors")
    @Length(min = 3, max = 50, message = "Authors")
    private String authors;

    @Column(name = "isbn")
    @NotBlank(message = "ISBN")
    @Length(min = 3, max = 50, message = "ISBN")
    private String isbn;

    @Column(name = "description")
    @NotBlank(message = "Description")
    @Length(min = 3, max = 100, message = "Description")
    private String description;

    @Column(name = "discount_day")
    @NotBlank(message = "DiscountDay")
    @Length(min = 3, max = 50, message = "DiscountDay")
    private String discountDay;

    @Column(name = "active_discount")
    @NotNull(message = "Active Discount")
    private Boolean activeDiscount;

    @ManyToOne
    @JoinColumn(name = "code_users", referencedColumnName = "code")
    @NotNull(message = "Code User")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comics comics = (Comics) o;
        return Objects.equals(codeId, comics.codeId) && Objects.equals(comicId, comics.comicId) && Objects.equals(title, comics.title) && Objects.equals(price, comics.price) && Objects.equals(authors, comics.authors) && Objects.equals(isbn, comics.isbn) && Objects.equals(description, comics.description) && Objects.equals(discountDay, comics.discountDay) && Objects.equals(activeDiscount, comics.activeDiscount) && Objects.equals(user, comics.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeId, comicId, title, price, authors, isbn, description, discountDay, activeDiscount, user);
    }
}
