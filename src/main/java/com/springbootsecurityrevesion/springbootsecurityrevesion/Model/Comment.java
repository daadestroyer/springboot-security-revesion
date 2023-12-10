package com.springbootsecurityrevesion.springbootsecurityrevesion.Model;


import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @SequenceGenerator(
            name = "comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )
    private int commentId;

    private String content;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;
}
