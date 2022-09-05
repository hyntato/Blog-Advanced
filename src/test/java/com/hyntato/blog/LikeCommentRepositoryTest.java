package com.hyntato.blog;

import com.hyntato.blog.entity.Comment;
import com.hyntato.blog.entity.LikeComment;
import com.hyntato.blog.entity.Post;
import com.hyntato.blog.entity.User;
import com.hyntato.blog.repository.CommentRepository;
import com.hyntato.blog.repository.LikeCommentRepository;
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
public class LikeCommentRepositoryTest {

    @Autowired
    private LikeCommentRepository likeCommentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Test
    @Order(1)
    public void createLikeComment() {
        User user = new User("hyntato", "hyntato@gamil.com");
        User savedUser = userRepository.save(user);

        Post post = new Post(user, "hyntatoPost", "hyntatoContent");
        Post savedPost = postRepository.save(post);

        Comment comment = new Comment(savedUser, savedPost, "newComment", false);
        Comment savedComment = commentRepository.save(comment);

        LikeComment likeComment = new LikeComment(user, savedComment);
        LikeComment savedLikeComment = likeCommentRepository.save(likeComment);
        LikeComment newLikeComment = likeCommentRepository.findById(savedLikeComment.getId()).get();

        assertEquals("hyntato", newLikeComment.getUser().getName());
    }

    @Test
    @Order(2)
    public void findLikeCommentById() {
        Optional<LikeComment> likeComment = likeCommentRepository.findById(1);
        assertNotNull(likeComment.get());
    }

    @Test
    @Order(3)
    public void findAllLikeComments() {
        List<LikeComment> likeComments = likeCommentRepository.findAll();
        assertNotNull(likeComments);
    }

}
