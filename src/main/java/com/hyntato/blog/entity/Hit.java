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
public class Hit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hit_id")
    private int id;

    @OneToOne
    @JoinColumn(name="post_id")
    private Post post;

    private int count;

    public Hit(Post post, int count) {
        this.post = post;
        this.count = count;
    }

}
