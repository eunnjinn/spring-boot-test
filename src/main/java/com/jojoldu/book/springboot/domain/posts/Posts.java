package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor //기본생성자 자동추가. public Posts(){}와 같은효과
@Entity //테이블과 링크될 클래스임을 나타냄. 클래스의 카멜케이스 이름을 _를 사용해 테이블 이름을 매칭
public class Posts {

    @Id //해당 테이블의 PK를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성규칙을 나타냄
    private Long id;

    @Column(length = 500, nullable = false) //굳이 사용하지 않아도 되지만 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당클래스의 빌더패턴클래스 생성. 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}


/*
롬복 어노테이션은 코드 변경량을 최소화 시켜주기 때문에 적극 사용
롬복: getter, noargsconstructor, builder

entity클래스 에서는 절대 setter메소드를 만들지 않는다. -> 해당 클래스의 인스턴스 값들의 변화를 코드상으로 구분하기 힘들기 때문

 */