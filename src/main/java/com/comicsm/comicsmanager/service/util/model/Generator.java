package com.comicsm.comicsmanager.service.util.model;

import java.util.List;

public class Generator {
    private List<Part> parts;

    public Generator() {}

    public Generator(List<Part> parts) {
        super();
        this.parts = parts;
    }

    public List<Part> getItems() {
        return parts;
    }

    public void setItems(List<Part> parts) {
        this.parts = parts;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((parts == null) ? 0 : parts.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Generator other = (Generator) obj;
        if (parts == null) {
            if (other.parts != null)
                return false;
        } else if (!parts.equals(other.parts))
            return false;
        return true;
    }
}
