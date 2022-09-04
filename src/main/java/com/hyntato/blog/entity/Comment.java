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
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name="parent_comment_id")
    private Comment comment;

    private String content;

    private boolean is_deleted;

    public Comment(User user, Post post, Comment comment, String content, boolean is_deleted) {
        this.user = user;
        this.post = post;
        this.comment = comment;
        this.content = content;
        this.is_deleted = is_deleted;
    }
}
