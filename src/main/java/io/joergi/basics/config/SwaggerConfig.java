package io.joergi.basics.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class SwaggerConfig implements WebMvcConfigurer {

	private final String baseUrl;

	public SwaggerConfig(
		@Value("${springfox.documentation.swagger-ui.base-url:}") String baseUrl) {
		this.baseUrl = baseUrl;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String baseUrl = StringUtils.trimTrailingCharacter(this.baseUrl, '/');
		registry.
			addResourceHandler(baseUrl + "/swagger-ui/**")
			.resourceChain(false);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController(baseUrl + "/swagger-ui/")
			.setViewName("forward:" + baseUrl + "/swagger-ui/index.html");
	}

//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry
//			.addMapping("/api/pet")
//			.allowedOrigins("http://editor.swagger.io");
//		registry
//			.addMapping("/v2/api-docs.*")
//			.allowedOrigins("http://editor.swagger.io");
//	}

}
