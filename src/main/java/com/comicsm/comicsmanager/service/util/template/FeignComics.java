package com.comicsm.comicsmanager.service.util.template;

import java.util.Objects;

public class FeignComics {

    private Data data;

    public FeignComics() {}

    public FeignComics(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) { this.data = data; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeignComics that = (FeignComics) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
