package com.sparta.week03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//반드시 있어야함
@EnableJpaAuditing //JPA를 사용할 건데 데이터 변동있으면 JPA가 알아서 반영하도록 해달라, 생성, 수정시간 바뀌었을때 반영
@SpringBootApplication
public class Week03Application {

    public static void main(String[] args) {
        SpringApplication.run(Week03Application.class, args);
    }

}
