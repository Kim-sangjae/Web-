package vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class VisitVO {
	
	private int idx;
	private String name,content,pwd,ip,regdate,filename;
	private MultipartFile photo;

}
