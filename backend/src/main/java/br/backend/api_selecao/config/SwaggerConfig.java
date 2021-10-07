package br.backend.api_selecao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
	/*
	 * public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
	 * .select() .apis(RequestHandlerSelectors.basePackage(
	 * "br.backend.api_selecao.controllers")) .paths(PathSelectors.any()) .build()
	 * .useDefaultResponseMessages(false)
	 * 
	 * .securitySchemes(Arrays.asList(new ApiKey("Token Access",
	 * HttpHeaders.AUTHORIZATION, In.HEADER.name())))
	 * 
	 * .apiInfo(apiInfo()); //.globalResponseMessage(RequestMethod.GET,
	 * responseMessageForGET())
	 * //.securityContexts(Arrays.asList(securityContext())) }
	 * 
	 * private ApiInfo apiInfo() { return new ApiInfoBuilder()
	 * .title("Simple Spring Boot REST API") .description("") .version("1.0.0")
	 * .license("Apache License Version 2.0")
	 * .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
	 * 
	 * .build(); //.contact(new Contact("Wladimilson", "https://treinaweb.com.br",
	 * "contato@treinaweb.com.br")) }
	 */

}
