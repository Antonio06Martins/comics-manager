package com.comicsm.comicsmanager.service.util.template;

import java.math.BigDecimal;
import java.util.Objects;

public class Value {

    private String type;
    private BigDecimal price;

    public Value() {}

    public Value(String type, BigDecimal price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value1 = (Value) o;
        return Objects.equals(type, value1.type) && Objects.equals(price, value1.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, price);
    }
}
