package com.hyntato.blog;

import com.hyntato.blog.entity.*;
import com.hyntato.blog.repository.*;
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
public class LikeCommentRepositoryTest {

    @Autowired
    private LikeCommentRepository likeCommentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Test
    @Order(1)
    public void findLikeCommentById() {
        Optional<LikeComment> likeComment = likeCommentRepository.findById(1);
        assertNotNull(likeComment.get());
    }

    @Test
    @Order(2)
    public void findAllLikeComments() {
        List<LikeComment> likeComments = likeCommentRepository.findAll();
        assertNotNull(likeComments);
    }

    @Test
    @Order(3)
    public void createLikeComment() {
        User user = userRepository.findAll().get(1);
        Comment comment = commentRepository.findAll().get(1);

        LikeComment likeComment = new LikeComment(user, comment);
        LikeComment savedLikeComment = likeCommentRepository.save(likeComment);
        LikeComment newLikeComment = likeCommentRepository.findById(savedLikeComment.getId()).get();

        assertEquals("user2", newLikeComment.getUser().getName());
    }

}
