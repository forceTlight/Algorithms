package com.server.config;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${request.url}")
    private String host;

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .host(host)
                .apiInfo(getApiInfo())
                .useDefaultResponseMessages(false);
    }
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("[Geek-sasaeng] REST API")
                .description("긱사생 API 명세서 입니다.\n" +
                        "2022.07.04 ~ 2022.07.10 로그인 ~ 회원가입 API 구현 완료")
                .contact(new Contact("긱사생 팀", "https://geeksa.notion.site/3de47b97eeb141c19af75e2373a425a5", "geeksasaeng@gmail.com" ))
                .version("1.0")
                .build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header"); //이건 Bearer 방식은 아닌 듯. 임의로 지정
    }
}