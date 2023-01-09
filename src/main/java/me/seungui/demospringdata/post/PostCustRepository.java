package me.seungui.demospringdata.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCustRepository extends JpaRepository<Post, Long>, PostCustomRepository<Post> {
}
