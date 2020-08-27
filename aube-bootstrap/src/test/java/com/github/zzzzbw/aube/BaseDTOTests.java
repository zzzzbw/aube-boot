package com.github.zzzzbw.aube;

import com.github.zzzzbw.aube.common.model.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author by zzzzbw
 * @since 2020/08/27 13:29
 */
@Slf4j
@SpringBootTest
public class BaseDTOTests {

    @Test
    public void convertTo() {
        TestEntity entity = TestDTO.builder()
                .id(1)
                .name("test")
                .time(System.currentTimeMillis())
                .build()
                .convertTo();
        log.info("{}", entity);

    }

    @Test
    public void convertFrom(){
        TestEntity entity = TestEntity.builder()
                .id(1)
                .name("test")
                .time(new Date())
                .build();

        TestDTO testDTO = new TestDTO().convertFrom(entity);
        log.info("{}", testDTO);
    }



    @Data
    @Builder
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static final class TestEntity {
        private long id;
        private String name;
        private Date time;
    }

    @Data
    @Builder
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static final class TestDTO implements BaseDTO<TestDTO, TestEntity> {
        private long id;
        private String name;
        private long time;
    }

}
