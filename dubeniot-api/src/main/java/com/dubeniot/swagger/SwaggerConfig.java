/**
 * 
 */
package com.dubeniot.swagger;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme; 
/**
 * @author BUB-4
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	private SiteWherePathProvider pathProvider;
	
	 @Autowired
	    public void setServletContext(ServletContext servletContext) {
		this.pathProvider = new SiteWherePathProvider(servletContext);
	    }

	 @Bean  
	    public Docket createRestApi() {  
	       
			return new Docket(DocumentationType.SWAGGER_2)  
	                .apiInfo(apiInfo())  
	                .forCodeGeneration(true)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.dubeniot.controller"))            
	                .build()          
	                .pathProvider(pathProvider)
	               
//	                .pathMapping("api")
	                ;  
	    }  
	  




		@SuppressWarnings("deprecation")
		private ApiInfo apiInfo() {  
	        return new ApiInfoBuilder()  
	                .title("RESTful APIs")  
	                .termsOfServiceUrl("http://dubeniot.com")  
	                .contact("duben")  
	                .version("1.1")  
	                .build();  
	    }  
		
}
