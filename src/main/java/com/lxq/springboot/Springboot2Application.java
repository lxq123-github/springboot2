package com.lxq.springboot;

import com.lxq.springboot.util.StringToDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Springboot2Application {

	@Autowired
	private RequestMappingHandlerAdapter handlerAdapter;

	@PostConstruct
	public void addConversionConfig() {
		ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer)handlerAdapter.getWebBindingInitializer();
		if (initializer.getConversionService() != null) {
			GenericConversionService genericConversionService = (GenericConversionService)initializer.getConversionService();
			genericConversionService.addConverter(new StringToDateConverter());
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Springboot2Application.class, args);
	}

}
