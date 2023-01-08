package me.seungui.demospringdata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    void crudTest() {
        Post post = new Post();
        post.setTitle("hibernate");
        post.setContent("hello spring data");

        Post savedPost = postRepository.save(post);

        List<Post> posts = postRepository.findMyPost();

        postRepository.delete(savedPost);
        postRepository.flush();
    }
}