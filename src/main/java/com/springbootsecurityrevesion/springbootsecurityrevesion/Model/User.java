package com.springbootsecurityrevesion.springbootsecurityrevesion.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private int userId;

    @Column(nullable = false)
    private String userName;
    @Column(nullable = false,unique = true)
    private String userEmail;
    @Column(nullable = false)
    private String userPassword;
    @Column(nullable = false)
    private String about;

    // one user can post multiple posts
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Post> post;

}
