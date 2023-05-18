package mvc;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.korea.fileupload.FileUploadController;



//어노테이션에도 상속관계가 있다
/*
*@Component
*	ㄴ@Controller
*	ㄴ@Service
*	ㄴ@Repository 
* */
//컴포넌트의 자식객체가 들어있으면 사실 Controller가 아니어도 만들어 질 수 있다.


@Configuration
@EnableWebMvc
@ComponentScan("com.korea.fileupload")
public class ServletContext implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	
//	  @Bean 
//	  public InternalResourceViewResolver resolver() {
//	  InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//	  resolver.setViewClass(JstlView.class); resolver.setPrefix("/WEB-INF/views/");
//	  resolver.setSuffix(".jsp"); return resolver; }
	
	
//	 @Bean
//	 public VisitController visitController(VisitDAO visit_dao) {
//		 
//		 VisitController visitController = new VisitController();
//		 visitController.setVisit_dao(visit_dao);
//		 return visitController;
//	 };
	
//	@Bean
//	public FileUploadController controller() {
//		return new FileUploadController();
//	}
	

}
