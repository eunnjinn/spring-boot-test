package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //JSON을 반환하는 컨트롤러로 만듦
public class HelloController {
    @GetMapping("/hello") // HTTP Method인 Get의 요청을 발을 수 있는 API를 만듦
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, // 외부에서  API로 넘긴 파라미터를 가져오는 어노테이션
                                     @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }

}
