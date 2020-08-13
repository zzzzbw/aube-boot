package com.github.zzzzbw.aube.mybatisplus.starter;

import com.github.zzzzbw.aube.common.constants.Consts;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author by zzzzbw
 * @since 2020/08/10 9:51
 */
@ComponentScan(Consts.PACKAGE.MYBATIS_PLUS_STARTER)
@MapperScan(Consts.PACKAGE.MAPPER_SCAN)
@Configuration
public class MybatisPlusAutoConfiguration {

}
