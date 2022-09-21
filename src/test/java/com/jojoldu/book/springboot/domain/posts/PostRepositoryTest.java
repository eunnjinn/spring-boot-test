package com.jojoldu.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After //Junit에서 단위 테스트가 끝날때마다 수행되는 메소드를 지정. 배포 전 전체 테스트를 수행할 때 테스트 간 침범을 막기 위해 사용

    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void save_post_call(){
        String title = "Test post";
        String content = "Test content";

        postsRepository.save(Posts.builder() //postRepo.save 테이블 posts에 id가 있으면 update, 없으면 insert쿼리 실행
                .title(title)
                .content(content)
                .author("dmswls1107@gmail.com")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
/*
 별다른 설정없이 @SpringBootTest를 사용할 경우 자동으로 H2데이터베이스를 실행해 줍니다.
 */