package io.springbatch.springbatchseulgae;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor // @Autowired 의존성 주입
@Configuration // 하나의 배치 Job을 정의하고 빈 설정
public class HelloJobConfiguration {

     private final JobBuilderFactory jobBuilderFactory; // Job을 생성하는 빌더 팩토리
     private final StepBuilderFactory stepBuilderFactory; // Step을 생성하는 빌더 팩토리

    @Bean
    public Job helloJob() { // helloJob 이름으로 Job 생성
        return jobBuilderFactory.get("hello Job")
                .start(helloStep1())
                .next(helloStep2())
                .build();
    }

    @Bean
    public Step helloStep1() { // helloStep 이름으로 Step생성
        return stepBuilderFactory.get("helloStep1")
                .tasklet(new Tasklet() { // Step 안에서 단일 태스크로 수행되는 로직 구현
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        // 내용기술
                        System.out.println("Step1 테스트");

                        return RepeatStatus.FINISHED;
                    }
                })
                .build()
                ;
    }

    @Bean
    public Step helloStep2() {
        return stepBuilderFactory.get("helloStep1")
                .tasklet(new Tasklet() {
                    @Override
                    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                        // 내용기술
                        System.out.println("Step2 테스트");

                        return RepeatStatus.FINISHED;
                    }
                })
                .build()
                ;
    }

    // 최종 동작 : Job 구동 -> Step을 실행 -> Teskelt을 실행

}
