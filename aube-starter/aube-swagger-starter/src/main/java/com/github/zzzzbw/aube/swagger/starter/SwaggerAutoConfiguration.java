package com.github.zzzzbw.aube.swagger.starter;


import com.github.zzzzbw.aube.common.constants.Consts;
import com.github.zzzzbw.aube.swagger.starter.properties.SwaggerProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author by zzzzbw
 * @since 2020/3/21 2:07
 */
@Slf4j
@ComponentScan(basePackages = Consts.PACKAGE.SWAGGER_STARTER)
@EnableConfigurationProperties(SwaggerProperties.class)
@EnableOpenApi
public class SwaggerAutoConfiguration {

    @Autowired
    private SwaggerProperties swaggerProperties;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .enable(swaggerProperties.isEnabled())
                .apiInfo(apiInfo())
                .select()
                // 根据配置扫描包
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .version(swaggerProperties.getVersion())
                .build();
    }
}
