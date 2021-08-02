package com.comicsm.comicsmanager.service.util.template;

import java.util.List;
import java.util.Objects;

public class Generator {

    private List<Part> parts;

    public Generator() {}

    public Generator(List<Part> parts) {
        this.parts = parts;
    }

    public List<Part> getItems() {
        return parts;
    }

    public void setItems(List<Part> parts) {
        this.parts = parts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Generator generator = (Generator) o;
        return Objects.equals(parts, generator.parts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parts);
    }
}
