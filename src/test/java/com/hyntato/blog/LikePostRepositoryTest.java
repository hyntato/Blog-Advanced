package com.hyntato.blog;

import com.hyntato.blog.entity.*;
import com.hyntato.blog.repository.CommentRepository;
import com.hyntato.blog.repository.LikePostRepository;
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
public class LikePostRepositoryTest {

    @Autowired
    private LikePostRepository likePostRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Test
    @Order(1)
    public void findLikePostById() {
        Optional<LikePost> likePost = likePostRepository.findById(1);
        assertNotNull(likePost.get());
    }

    @Test
    @Order(2)
    public void findAllLikePosts() {
        List<LikePost> likePosts = likePostRepository.findAll();
        assertNotNull(likePosts);
    }

    @Test
    @Order(3)
    public void createLikePost() {
        User user = userRepository.findAll().get(1);
        Post post = postRepository.findAll().get(1);

        LikePost likePost = new LikePost(user, post);
        LikePost savedLikePost = likePostRepository.save(likePost);
        LikePost newLikePost = likePostRepository.findById(savedLikePost.getId()).get();

        assertEquals("user2", newLikePost.getUser().getName());
    }

}
