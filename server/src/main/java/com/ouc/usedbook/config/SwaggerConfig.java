package com.ouc.usedbook.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author 孙浩杰
 * @version 1.0
 * @description Swagger2的配置文件
 * @date 2020/6/1 20:53
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ouc.usedbook.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "UserBook Market后端Api文档",
                "restful风格的api接口",
                "API V1.0",
                "https://github.com/sunshine2285/used-books-market-miniProgram",
                new Contact("UserBook Market",
                        "https://github.com/sunshine2285/used-books-market-miniProgram",
                        "sunshine2285@163.com"),
                "Apache2", "http://www.apache2.org/", Collections.emptyList());
    }
}