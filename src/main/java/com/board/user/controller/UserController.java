package com.board.user.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.board.user.domain.UserVo;
import com.board.user.mapper.UserMapper;

@Controller
@RequestMapping("/Users")
public class UserController {
	@Autowired
	private UserMapper userMapper;
	
	//사용자 목록 /Users/List
	@RequestMapping("/List")
	public ModelAndView list() { //Model.AddAttrivute로 모델을 추가하지 않아도 되도록 리턴값을 ModelAndView로 사용
		//목록 조회
		List<UserVo> userList = userMapper.getUserList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("userList", userList); //인터페이스가 mapper로 조회해서 온 데이터를 가져옴
		
		mv.setViewName("users/list"); //이동할 페이지 이름
		
		//jsp 페이지 이동
		return mv; //모델과 이동할 페이지를 담은 ModelAndView 객체 return
	}
	
	//사용자 추가 /Users/WriteForm
	@RequestMapping("/WriteForm")
	public ModelAndView writeForm() {
		ModelAndView mv = new ModelAndView();
		LocalDateTime today = LocalDateTime.now();
		String now = today.format(DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss:SSSS"));
		//DayOfWeek 타입으로 받아도 가능
		String wkday = today.getDayOfWeek() + "";
		now += " " + wkday;
		mv.addObject("now", now);
		
		mv.setViewName("users/write");
		
		return mv;
	}
	
	@RequestMapping("/Write")
	public ModelAndView write(UserVo userVo) {
		//저장
		userMapper.insertUser(userVo);
		
		//데이터를 가지고 이동
		ModelAndView mv = new ModelAndView();
		//mv.addObject("userVo", userVo);
		mv.setViewName("redirect:/Users/List");
		
		return mv;
	}
}