package com.springbootsecurityrevesion.Dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
public class CategoryDto {
    private int catId;

    private String catTitle;
    private String catDesc;
}
