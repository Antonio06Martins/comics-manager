package com.comicsm.comicsmanager.dto.user;

import com.comicsm.comicsmanager.entities.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@ApiModel("User request DTO")
public class UserRequestDTO {

    @ApiModelProperty(value = "Name")
    @NotBlank(message = "Name")
    @Length(min = 3, max = 50, message = "Name")
    private String name;

    @ApiModelProperty(value = "Email")
    @NotBlank(message = "Email")
    @Length(min = 3, max = 35, message = "Email")
    private String email;

    @ApiModelProperty(value = "CPF")
    @NotBlank(message = "CPF")
    @Length(min = 3, max = 20, message = "CPF")
    @CPF
    private String cpf;

    @ApiModelProperty(value = "Birth Date")
    private Date birthDate;

    public User convertToEntity() {
        return new User(name, email, cpf, birthDate);
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
}
