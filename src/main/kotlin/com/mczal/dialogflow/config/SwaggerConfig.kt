package com.mczal.dialogflow.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.service.Parameter
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig{

  private fun apiInfo(): ApiInfo {
    val apiInfo = ApiInfo(
      "REST API",
      "MCZAL REST API.",
      "v1",
      "Terms of service",
      Contact("mczal", "https://github.com/mczal",
        "fahrizalseptrianto@gmail.com"),
      "License of API",
      "API license URL"
    )
    return apiInfo
  }

  @Bean
  fun api(): Docket {
    val objectList = ArrayList<Parameter>()
    return Docket(DocumentationType.SWAGGER_2).globalOperationParameters(objectList).select()
      .apis(RequestHandlerSelectors.basePackage("com.mczal.dialogflow.controller"))
      .paths(PathSelectors.ant("/api/**")).build().apiInfo(apiInfo())
  }

}