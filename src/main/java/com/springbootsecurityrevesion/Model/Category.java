package com.springbootsecurityrevesion.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Category {
    @Id
    @SequenceGenerator(
            name = "category-sequence",
            sequenceName = "category-sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "category-sequence")
    private int catId;

    private String catTitle;
    private String catDesc;

    // for this single category there are multiple post
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Post> post;
}
