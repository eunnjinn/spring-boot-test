package com.jojoldu.book.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //여기부터 설정을 읽어나간다. 프로젝트 최상단에 위치해야 함.
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
