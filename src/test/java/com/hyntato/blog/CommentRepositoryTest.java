package com.hyntato.blog;

import com.hyntato.blog.entity.Comment;
import com.hyntato.blog.entity.Post;
import com.hyntato.blog.entity.User;
import com.hyntato.blog.repository.CommentRepository;
import com.hyntato.blog.repository.PostRepository;
import com.hyntato.blog.repository.UserRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Test
    @Order(1)
    public void findCommentById() {
        Optional<Comment> comment = commentRepository.findById(1);
        assertNotNull(comment.get());
    }

    @Test
    @Order(2)
    public void findAllComments() {
        List<Comment> comments = commentRepository.findAll();
        assertNotNull(comments);
    }

    @Test
    @Order(3)
    public void createComment() {
        User user = new User("hyntato3", "hyntato3@gamil.com");
        User savedUser = userRepository.save(user);

        Post post = new Post(user, "hyntatoPost2", "hyntatoContent2");
        Post savedPost = postRepository.save(post);

        List<Comment> comments = commentRepository.findAll();
        Comment comment = new Comment(savedUser, savedPost, comments.get(0), "comment6", true);
        Comment savedComment = commentRepository.save(comment);
        Comment newComment = commentRepository.findById(savedComment.getId()).get();

        assertEquals("comment6", newComment.getContent());
    }

}
