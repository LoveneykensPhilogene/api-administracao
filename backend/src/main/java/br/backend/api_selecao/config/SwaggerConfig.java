package br.backend.api_selecao.config;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String BASE_PACKAGE = "br.backend.api_selecao.controllers";
	private static final String API_TITLE = "API ADMINISTRACAO";
	private static final String API_DESCRIPTION = "REST API para cadastro";
	private static final String CONTACT_NAME = "Loveneykens Philogene";
	private static final String CONTACT_GITHUB = "https://github.com/LoveneykensPhilogene";
	private static final String CONTACT_EMAIL = "loveneykens@gmail.com";

	@Bean

	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(basePackage(BASE_PACKAGE))
				.paths(PathSelectors.any()).build().useDefaultResponseMessages(false).apiInfo(buildApiInfo());
	}

	private ApiInfo buildApiInfo() {
		return new ApiInfoBuilder().title(API_TITLE).description(API_DESCRIPTION).version("1.0.0")
				.contact(new Contact(CONTACT_NAME, CONTACT_GITHUB, CONTACT_EMAIL)).build();
	}

}
