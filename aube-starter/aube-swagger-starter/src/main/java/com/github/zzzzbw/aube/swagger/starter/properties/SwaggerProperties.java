package com.github.zzzzbw.aube.swagger.starter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author by zzzzbw
 * @since 2020/3/21 2:29
 */
@Data
@ConfigurationProperties(prefix = "aube.swagger")
public class SwaggerProperties {

    private boolean enabled = true;

    private String basePackage = "";

    private String title = "Swagger document";

    private String description = "Auto create by SwaggerAutoConfiguration";

    private String version = "";

}
