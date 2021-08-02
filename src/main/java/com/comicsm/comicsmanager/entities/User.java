package com.comicsm.comicsmanager.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code")
    private Long code;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "birth_date")
    private Date birthDate;

    public User() {
    }

    public User(Long code) {
        this.code = code;
    }

    public User(String name, String email, String cpf, Date birthDate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(code, user.code) && Objects.equals(name, user.name) && Objects.equals(email, user.email)
                && Objects.equals(cpf, user.cpf) && Objects.equals(birthDate, user.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, email, cpf, birthDate);
    }
}
