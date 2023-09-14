package com.khadri.spring.mvc.Initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.khadri.spring.mvc.config.AppConfig;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { AppConfig.class };

	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
