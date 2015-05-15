package com.cckjs.cmall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableWebMvc
@EnableSwagger
@ComponentScan("com.mangofactory.swagger")
public class SwaggerConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private SpringSwaggerConfig springSwaggerConfig;

	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(
				apiInfo()).includePatterns(".*?");
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("cmall api", "用作cmall的restful api",
				"services", "email", "type", "url");
		return apiInfo;
	}
}
