package com.hyntato.blog.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private String title;

    private String content;

    public Post(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

}
