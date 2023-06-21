package vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MemberVO {
	
	private int memNo;
	private String memId;
	private String memNm; // 이름
	private LocalDateTime regDt; // 등록날짜
	private LocalDateTime modDt; // 수정날짜

}
