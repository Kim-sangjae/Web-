package vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PhotoVO {
	
	private String title; // 우리가 설정한 제목
	private MultipartFile photo; // 넘어온 파일의 정보
	private String filename; // 파일의 실제 이름

}
