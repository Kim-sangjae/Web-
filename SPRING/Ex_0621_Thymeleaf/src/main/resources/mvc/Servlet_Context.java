package mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import com.korea.thyme.ThymeControlloer;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;


@Configuration
@EnableWebMvc
//@ComponentScan(basePackages = { "com.korea.json" })
//컨트롤러 뿐만 아니라 Component의 자식요소를 전부 탐색해서 객체로 만들어준다.
/*
 * @Component ㄴ@Controller ㄴ@Service ㄴ@Repository
 */
//컴포넌트의 자식객체가 들어있으면 사실 Controller가 아니어도 만들어 질 수 있다.
public class Servlet_Context implements WebMvcConfigurer {
	
	@Autowired
	ApplicationContext applicationContext;
	
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		
		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setPrefix("/WEB-INF/views/");
		templateResolver.setSuffix(".html");
		templateResolver.setCacheable(false); // 캐시사용안함 (자동으로 캐시화된 파일들은 서버를 재가동 하지않으면 바뀌지않는다)
		return templateResolver;
	}
	
	
	// 타임리프의 템플릿 엔진 설정 , 템플릿 파일을 읽어올 때 선언한 TemplateResolver를 사용한다.
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
		
		springTemplateEngine.setTemplateResolver(templateResolver());
		springTemplateEngine.setEnableSpringELCompiler(true); // el식을 사용할 것인지 여부
		springTemplateEngine.addDialect(new Java8TimeDialect()); // 자바8의 시간타입을 지원하기 위한 Dialect추가
		springTemplateEngine.addDialect(new LayoutDialect()); // 레이아웃 추가 기능
		return springTemplateEngine;
	}
	
	
	
	@Bean
	public ThymeleafViewResolver thymeleafViewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setContentType("text/html");
		resolver.setCharacterEncoding("UTF-8");
		resolver.setTemplateEngine(templateEngine());
		return resolver;
	}
	
	
	
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.viewResolver(thymeleafViewResolver());
	}
		
	
	@Bean
	public ThymeControlloer thymeControlloer() {
		return new ThymeControlloer();
	} 
	


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

//	  @Bean 
//	  public InternalResourceViewResolver resolver() {
//	  InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//	  resolver.setViewClass(JstlView.class); resolver.setPrefix("/WEB-INF/views/");
//	  resolver.setSuffix(".jsp"); return resolver; }

	




}
