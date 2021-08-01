package com.comicsm.comicsmanager.entities;

import javax.persistence.*;
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
    private Long comicId;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "authors")
    private String authors;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "description")
    private String description;

    @Column(name = "discount_day")
    private String discountDay;

    @Column(name = "active_discount")
    private Boolean activeDiscount;

    @ManyToOne
    @JoinColumn(name = "code_users", referencedColumnName = "code")
    private User user;

    public Comics() {
    }

    public Comics(Long comicId, String title, BigDecimal price, String authors, String isbn, String description, String discountDay, Boolean activeDiscount, User user) {
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

    public void getActiveDiscount(Boolean activeDiscount) {
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

    public boolean getActiveDiscount() {
        return false;
    }
}