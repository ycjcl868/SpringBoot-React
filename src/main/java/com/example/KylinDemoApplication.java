package com.example;

import com.example.util.CheckIsLogin;
import com.example.util.OnlineCount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
@SpringBootApplication
public class KylinDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KylinDemoApplication.class, args);
	}
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
				ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND,"/error_page/404.html");
				configurableEmbeddedServletContainer.addErrorPages(error404Page);
			}
		};
	}
}
