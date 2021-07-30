package com.comicsm.comicsmanager.dto.user;

import com.comicsm.comicsmanager.entities.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("User return DTO")
public class UserResponseDTO {

    @ApiModelProperty(value = "Code")
    private Long code;

    @ApiModelProperty(value = "Name")
    private String name;

    @ApiModelProperty(value = "Email")
    private String email;

    public UserResponseDTO(Long code, String name, String email) {
        this.code = code;
        this.name = name;
        this.email = email;
    }

    public static UserResponseDTO convertToUserDTO(User user) {
        return new UserResponseDTO(user.getCode(), user.getName(), user.getEmail());
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
}
