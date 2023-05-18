package context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class Context_4_fileupload {

	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		
		multipartResolver.setDefaultEncoding("utf-8");
		
		// 최대 업로드 용량 10mb 로 지정
		multipartResolver.setMaxUploadSize(10485760);
		
		return multipartResolver;
	}
	

	
	
}
