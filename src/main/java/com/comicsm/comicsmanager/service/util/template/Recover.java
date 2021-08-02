package com.comicsm.comicsmanager.service.util.template;

import java.util.List;
import java.util.Objects;

public class Recover {

    private Long id;
    private String title;
    private String description;
    private String isbn;
    private List<Value> values;
    private Generator creators;

    public Recover() {}

    public Recover(Long id, String title, String description, String isbn, List<Value> values, Generator creators) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.values = values;
        this.creators = creators;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<Value> getPrices() {
        return values;
    }

    public void setPrices(List<Value> values) {
        this.values = values;
    }

    public Generator getCreators() {
        return creators;
    }

    public void setCreators(Generator creators) {
        this.creators = creators;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recover recover = (Recover) o;
        return Objects.equals(id, recover.id) && Objects.equals(title, recover.title)
                && Objects.equals(description, recover.description) && Objects.equals(isbn, recover.isbn)
                && Objects.equals(values, recover.values) && Objects.equals(creators, recover.creators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, isbn, values, creators);
    }
}
