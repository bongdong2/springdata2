package me.seungui.demospringdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(repositoryImplementationPostfix = "Default") // 커스텀 리포지토리 접미어
@EnableJpaRepositories(repositoryBaseClass = SimpleMyRepository.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
