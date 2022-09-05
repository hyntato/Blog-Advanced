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
    public void createComment() {
        User user = new User("hyntato", "hyntato@gamil.com");
        User savedUser = userRepository.save(user);

        Post post = new Post(user, "hyntatoPost", "hyntatoContent");
        Post savedPost = postRepository.save(post);

        Comment comment = new Comment(savedUser, savedPost, "newComment", false);
        Comment savedComment = commentRepository.save(comment);
        Comment newComment = commentRepository.findById(savedComment.getId()).get();

        assertEquals("newComment", newComment.getContent());
    }

    @Test
    @Order(2)
    public void findCommentById() {
        Optional<Comment> comment = commentRepository.findById(1);
        assertNotNull(comment.get());
    }

    @Test
    @Order(3)
    public void findAllComments() {
        List<Comment> comments = commentRepository.findAll();
        assertNotNull(comments);
    }

    @Test
    @Order(4)
    public void updateComment() {
        Optional<Comment> comment = commentRepository.findById(1);
        comment.ifPresent( currentComment -> {
            currentComment.setContent("updateContent");
            commentRepository.save(currentComment);
        });
        assertEquals("updateContent", comment.get().getContent());
    }

}
