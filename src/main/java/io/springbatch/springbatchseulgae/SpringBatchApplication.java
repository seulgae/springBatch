package io.springbatch.springbatchseulgae;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing // 스프링 배치 초기 선언 어노테이션
public class SpringBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchApplication.class, args);
    }

}

// @EnableBatchProcessing
// 총 4개의 설정 클래스를 실행, 스프링 배치의 모든 초기화 및 실행 구성이 이뤄짐.
// 스프링 부트 배치의 자동 설정 클래스가 실행됨으로 빈으로 등록된 모든 Job을 검색해서 초기화와 동시에 Job을 수행하도록 구성.

// 스프링 배치 초기화 설정 클래스

// SimpleBatchConfiguration
// - JobBuilderFactory와 StepBuilderFactory 생성, Job과 Step 생성용
// - 스프링 배치의 주요 구성 요소 생성 - 프록시 객체로 생성됨.
// Q. 프록시 객체란 : 대리인 역활을 하는 객체, 누군가 대신해서 일을 처리해주는 대리인
// A. Proxy(대리인) -> Target(대상)

// BatchConfigurerConfiguration
// a. BasicBatchConfigurer
// - SimpleBatchConfiguration에서 생성한 프록시 객체의 실제 대상 객체를 설정하는 설정 클래스
// - Bean으로 의존성 주입 받아서 주요 객체들을 참조해서 사용할 수 있음.

// b. JpaBatchConfigurer
// - JPA 관련 객체를 생성하는 설정 클래스
// - 사용자 정의 BatchConfigurer 인터페이스를 사용할 수 있음.

// BatchAutoConfiguration
// - 스프링 배치가 초기화 될 때 자동으로 실행되는 설정 클래스
// - Job을 수행하는 JobLauncherApplicationRunner 빈을 생성
