package com.hyntato.blog;

import com.hyntato.blog.entity.Hit;
import com.hyntato.blog.entity.Post;
import com.hyntato.blog.entity.User;
import com.hyntato.blog.repository.HitRepository;
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
public class HitRepositoryTest {

    @Autowired
    private HitRepository hitRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Test
    @Order(1)
    public void findHitById() {
        Optional<Hit> hit = hitRepository.findById(1);
        assertNotNull(hit.get());
    }

    @Test
    @Order(2)
    public void findAllHits() {
        List<Hit> hits = hitRepository.findAll();
        assertNotNull(hits);
    }

    @Test
    @Order(3)
    public void createHit() {
        User user = userRepository.findAll().get(1);
        Post post = new Post(user, "newPost", "newContent");
        Post savedPost = postRepository.save(post);
        Post newPost = postRepository.findById(savedPost.getId()).get();

        Hit Hit = new Hit(newPost, 1);
        Hit savedHit = hitRepository.save(Hit);
        Hit newHit = hitRepository.findById(savedHit.getId()).get();

        assertEquals("newPost", newHit.getPost().getTitle());
    }

}
