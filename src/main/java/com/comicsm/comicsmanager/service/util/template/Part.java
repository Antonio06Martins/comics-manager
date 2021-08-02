package com.comicsm.comicsmanager.service.util.template;

import java.util.Objects;

public class Part {

    private String name;
    private String role;

    public Part() {}

    public Part(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return Objects.equals(name, part.name) && Objects.equals(role, part.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role);
    }
}
