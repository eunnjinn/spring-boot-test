package com.jojoldu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //JSON을 반환하는 컨트롤러로 만듦
public class HelloController {
    @GetMapping("/hello") // HTTP Method인 Get의 요청을 발을 수 있는 API를 만듦
    public String hello() {
        return "hello";
    }

}
