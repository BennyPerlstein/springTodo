package com.task.tasks.cors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc

public class WebConfig implements WebMvcConfigurer{
	
//	 @Override
//	    public void addCorsMappings(CorsRegistry registry) {
//	        registry.addMapping("/*").allowedOrigins("*").allowedMethods("GET", "POST", "OPTIONS", "PUT", "DELETE")
//	                .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
//	                        "Access-Control-Request-Headers")
//	                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
//	                .allowCredentials(true).maxAge(3600);
//	    }
	@Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**").allowedOrigins("http://localhost:4200");
	    }
	 
//	 @RequestMapping(value= "/**", method=RequestMethod.OPTIONS)
//	 public void corsHeaders(HttpServletResponse response) {
//	     response.addHeader("Access-Control-Allow-Origin", "*");
//	     response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//	     response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
//	     response.addHeader("Access-Control-Max-Age", "3600");
//	 }
	

}
