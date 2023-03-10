package me.seungui.demospringdata;

import me.seungui.demospringdata.post.Post;
import me.seungui.demospringdata.post.PostCustRepository;
import me.seungui.demospringdata.post.PostPublishedEvent;
import me.seungui.demospringdata.post.PostRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(PostRepositoryTestConfig.class)
class PostRepositoryTest {

    @Autowired
    PostCustRepository postCustRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void event() {
        Post post = new Post();
        post.setTitle("my new title!!!");
        PostPublishedEvent event = new PostPublishedEvent(post);
        applicationContext.publishEvent(event);
    }

    @Test
    void event2() {
        Post post = new Post();
        post.setTitle("Hello hibernate");
        postRepository.save(post.publish());
    }

    @Test
    void crudCustomTest() {
        Post post = new Post();
        post.setTitle("hibernate");
        post.setContent("hello spring data");

        Post savedPost = postCustRepository.save(post);

        List<Post> posts = postCustRepository.findMyPost();

        postCustRepository.delete(savedPost);
        postCustRepository.flush();
    }

    @Test
    void crudTest() {
        Post post = new Post();
        post.setTitle("hibernate");
        post.setContent("hello spring data");
        Post savedPost = postRepository.save(post);
        Assertions.assertTrue(postRepository.contains(post));
        List<Post> posts = postRepository.findAll();
        postRepository.delete(savedPost);
        postRepository.flush();
    }
}