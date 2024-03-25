package com.board.user.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.user.domain.UserVo;

@Mapper
public interface UserMapper {

	List<UserVo> getUserList();

	void insertUser(UserVo userVo);

	//hashmap : 키와 값이 한쌍인 자료구조
	HashMap<String, Object> getUser(UserVo userVo);
	
	void updateUser(UserVo userVo);
	
	void deleteUser(UserVo userVo);
}
