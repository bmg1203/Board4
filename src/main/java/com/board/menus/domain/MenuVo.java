package com.board.menus.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

//이게 lombok, 지금은 괜찮지만 JPA에서는 사용해야 데이터 베이스가 제대로 됨
@Getter //get method가 생김
@Setter //set method가 생김
@ToString //toString method 생성
@NoArgsConstructor //매개변수가 없는 기본 생성자 생성
@AllArgsConstructor //모든 필드를 매개변수로 가지는 생성자 생성
public class MenuVo {
	@NonNull //없어도 동작은 상관없긴한데 primary key인 menu_id가 not null이게 함
	private String menu_id;
	private String menu_name;
	private int menu_seq;
}
