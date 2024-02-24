package com.springbootsecurityrevesion.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
public class CategoryDto {
    private int catId;

    @NotEmpty(message = "please enter category title")
    private String catTitle;
    @Email(message = "please enter category description")
    private String catDesc;
}
