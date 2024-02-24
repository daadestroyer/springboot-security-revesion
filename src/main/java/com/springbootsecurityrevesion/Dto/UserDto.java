package com.springbootsecurityrevesion.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private int userId;

    @NotEmpty(message = "please enter username")
    @Size(min = 2, max = 30, message = "username can't be less than length of 2 or more than 30")
    private String userName;

    @Email(message = "please enter correct email")
    @NotEmpty(message = "please enter email")
    @Column(unique = true)
    private String userEmail;

    @NotEmpty(message = "please enter password")
    @Size(min = 3, max = 6, message = "password can't be less than 3 or greater than 6")
    private String password;

    @NotEmpty(message = "please enter about")
    @Size(min = 10, message = "about can't be less than 10")
    private String about;

    public Set<RoleDto> roles = new HashSet<>();



    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }


}
