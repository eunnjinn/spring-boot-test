package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
//import com.jojoldu.book.springboot.web.HelloController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) //스프링부트테스트와 JUnit사이의 연결자 역할
@WebMvcTest //Web에 집중할 수 있는 어노테이션
public class HelloControllerTest {
    @Autowired //스프링이 관리하는 bean을 주입 받음
    private MockMvc mvc; //웹 API를 테스트할 때 사용. 스프링 MVC테스트의 시작점
    @WithMockUser(roles="USER")
    @Test
    public void hello_is_comeback() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello주소로 HTTP GET요청
                .andExpect(status().isOk()) // HTTP Header의 status를 검증
                .andExpect(content().string(hello)); //응답분본의 내용을 검증
    }
}