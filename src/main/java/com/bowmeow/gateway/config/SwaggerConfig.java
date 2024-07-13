package com.bowmeow.gateway.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "BowMeow APIs"
              , description = "BowMeow REST API Documentation"
              , version = "v1.0"
              , contact = @Contact(
                      name = "sohyeonlee, seoyoungKim"
                    , email = "내메일, 서영이메일"
                    , url = "https://www.bow-meow-co.kr"
            )
            , license = @License(
                    name = "Copyright from sohyeonlee, seoyoungKim"
                  , url = "https://wwww.bow-meow.co.kr"
            )
        )
)
@Configuration
public class SwaggerConfig {

//    static {
//        // JwtAuthenticationFilter 조회 비활성화
//        SpringDocUtils.getConfig().addAnnotationsToIgnore() // org.springdoc.core.SpringDocUtils 필요 >> 필요시 의존성 추가
//    }

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("Bow-meow api gateway API")
                .packagesToScan("com.bowmeow.gateway.controller") // 해당 패키지에서 swagger 관련 annotation 을 스캔하겠다는 의미
                .build();
    }







}
