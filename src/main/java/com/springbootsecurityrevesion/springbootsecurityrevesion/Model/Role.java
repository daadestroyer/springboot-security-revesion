package com.springbootsecurityrevesion.springbootsecurityrevesion.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Role {

    @Id
    private int roleId;
    private String role;
}
