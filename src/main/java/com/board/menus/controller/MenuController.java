package com.board.menus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.menus.domain.MenuVo;
import com.board.menus.mapper.MenuMapper;

@Controller
@RequestMapping("/Menus") //공통된 /Menus를 위로 뺌
public class MenuController {
	
	@Autowired
	private MenuMapper menuMapper;
	
	// 메뉴 입력받는 화면
	// /Menus/WriteForm
	//@RequestMapping("/Menus/WriteForm")
	@RequestMapping("/WriteForm")
	public String writeForm() {
		return "menus/write"; // /WEB-INF/views/ + menus/write + .jsp
	}
	
	// 메뉴 저장(db 추가)
	// /Menus/Write
	//@RequestMapping("Menus/Write")
	@RequestMapping("/Write")
	public String write(MenuVo menuVo) {	
		//넘어온 데이터를 db에 저장하고 매개변수 객체에 값들이 담김
		// /Menus/Write?menu_id=MENU02&menu_name=JSP&menu_seq=2
		menuMapper.insertMenu(menuVo);
		
		//menuList 다시 조회(리스트가 빈값이 되지 않도록)
//		List<MenuVo> menuList = menuMapper.getMenuList();
//		model.addAttribute("menuList", menuList);
		
		//menuList 를 조회하는 중복 코드를 없애기 위해서 아래와 같이 redirect:Menus/list로 아래의 메뉴 목록 조회 메소드 실행
		return "redirect:/Menus/List"; // menus/list.jsp
	}
	//오류 난 코드 -> menu_id를 찾을 수 없음
	/*@RequestMapping("/Write")
	public String write(String menu_id, String menu_name, int menu_seq) {
		//넘어온 데이터를 db에 저장하고
		// /Menus/Write?menu_id=MENU02&menu_name=JSP&menu_seq=2
		menuMapper.insertMenu(menu_id, menu_name, menu_seq);
		
		return "menus/list"; // menus/list.jsp
	}*/
	
	//-------------------------------------------------------------------------
	// 메뉴 목록 조회
	// /Menus/List
	@RequestMapping("/List") // /Menus/List
	public String list(Model model) {
		// 메뉴 목록을 select 조회
		// ArrayList의 상위 클래스인 List 인터페이스 사용 우측이 무슨형이든 상관없이 하려고 List 사용
		List<MenuVo> menuList = menuMapper.getMenuList();
		
		// 조회 결과를 모델에 넘겨줌(Model)
		model.addAttribute("menuList", menuList);
		System.out.println("MenuController list() menuList: " + menuList);
		
		return "menus/list";
	}
	
	//----------------------------------------------------------------
	// 메뉴 수정
	// /Menus/UpdateForm?menu_id=${menu_id}
	@RequestMapping("/UpdateForm")
	public String updateForm(MenuVo menuVo, Model model) {
		//넘어온 MenuVo 객체
		System.out.println("menuVo: " + menuVo);
		
		String menu_id = menuVo.getMenu_id();
		
		//수정할 데이터 조회
		//조회한 MenuVo 객체
		MenuVo menu = menuMapper.getMenu(menu_id);
		
		//조회한 내용을 모델에 담기
		model.addAttribute("menu", menu);
		
		return "/menus/update";
	}
	
	// /Menus/Update
	@RequestMapping("/Update")
	public String update(MenuVo menuVo) {
		//수정
		menuMapper.updateMenu(menuVo);
		
		//수정후 조회
		return "redirect:/Menus/List";
		//return "";
	}
	
	
	//----------------------------------------------------------------
	// 메뉴 삭제
	// /Menus/Delete
	/*
	@RequestMapping("/Delete")
	public String Delete(MenuVo menuVo) {
		//특정 메뉴를 삭제
		menuMapper.deleteMenu(menuVo);
		
		//menuList 다시 조회(리스트가 빈값이 되지 않도록)
//		List<MenuVo> menuList = menuMapper.getMenuList();
//		model.addAttribute("menuList", menuList);
		
		//이동할 파일, menuList 조회 중복 코드 제거
		return "redirect:/Menus/List";
	}
	*/
	
	// 메뉴 삭제 방법 2
	// /Menus/Delete?menu_id = menu_id
	@RequestMapping("/Delete")
	@ResponseBody //이걸 하면 return에 들어있는 alert이 스크립트로 실행됨
	public String delete(MenuVo menuVo) {
		menuMapper.deleteMenu(menuVo);
		
		//script를 이용해 삭제 알림 멘트와 location.href를 통해 list.jsp의 menuList 또한 출력해줌
		String html = "<script>alert('삭제 되었습니다.');";
		html += "location.href='/Menus/List';</script>";
		
		return html;
	}
	
	
	//-------------------------------------------------------------------------
	// 새 메뉴 추가 2 관련
	@RequestMapping("/WriteForm2")
	public String writeForm2() {
		return "menus/write2"; // /WEB-INF/views/ + menus/write + .jsp
	}
	
	@RequestMapping("/Write2")
	public String write2(MenuVo menuVo) {	
		//저장
		//Write2는 메뉴이름만 받고 나머진 자동 생성 /Menus/Write?menu_name=JSP
		menuMapper.insertMenuByName(menuVo);
		
		//조회로 이동
		return "redirect:/Menus/List"; // menus/list.jsp
	}
}
