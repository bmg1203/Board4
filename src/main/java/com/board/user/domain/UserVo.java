package com.board.user.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;



//이게 lombok, 지금은 괜찮지만 JPA에서는 사용해야 데이터 베이스가 제대로 됨
//@Data : @Getter, @Setter, @ToString 가 모두 생성됨
//추가적으로 @EqualsAndHashCode(object 상속된 것도 있음), @RequiredArgsConstructor도 있음
@Data
@NoArgsConstructor
//lombok.noArgsConstructor.extraPrivate = true;
//@Data에는 @NoArgsConstructor가 기본적으로 lombok.noArgsConstructor.extraPrivate = [true | false] (default: false) 기본으로 안들어감
//true로 해주어야 생성됨, 다른 생성자가 없으면 있겠지만 다른 생성자를 써주면 없어짐
@AllArgsConstructor
public class UserVo {
	@NonNull
	private String userid;
	@NonNull
	private String passwd;
	@NonNull
	private String username;
	
	private String email;
	private int upoint;
	private String indate;
}
