<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	//JSTL(JSP Standard Tag Library) c:forEach를 위한 설치
	//%를 사용해서도 반복문 등을 적용 가능하지만 JSTL을 사용해 편리성을 높임
	//c로 시작하는 문법은 url의 문법으로 해석해라 라는 뜻
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menus/list.jsp</title>
<link rel="stylesheet" href="/css/common.css">
<link rel="icon" type="image/png" href="./img/favicon.png">
<!-- css내부에 css적용할 수 있는 scss 문법 적용 -->
<script src="https://cdn.jsdelivr.net/npm/browser-scss@1.0.3/dist/browser-scss.min.js"></script>
<style>
	td {
		padding: 10px;
		width: 150px;
		text-align: center;
	}
	
	tr:first-child {
		background-color: black;
		color: white;
		font-weight: bold;
		/*scss 문법을 이용한 표현(script로 설치 필요)*/
		td{
			border-color: #ffb1b1;
		}
		
	}
	/* tr 안에 td를 사용하려면 추가 적인 설정이 필요 아니면 그냥 원래 css 처럼 아래와 같이 사용 */
	/* tr:first-child > td {border-color: white}  */

	tr:nth-child(2) td {
     text-align: right;
  }
</style>
</head>
<body>
	<!-- list.jsp 수정2 -->
	<!-- jstl(java standard tag library)를 사용해 목록을 출력 - c:foreach -->
	<main>
		<h2>사용자 목록</h2>
		<table>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>이메일</td>
				<td>포인트</td>
				<td>가입일</td>
				<!-- <td>삭제</td>
				<td>수정</td>-->
			</tr>
			<tr>
				<td colspan="5">
					[<a href="/Users/WriteForm">사용자 추가</a>]
					[<a href="/">home</a>]
				</td>
			</tr>
			<!-- 추가 후 menuList를 부를 때 빈값이 넘어오는 오류로 insert도 모델을 사용하도록 수정 -->
			<c:forEach var="userVo" items="${userList}"> <!-- menuList를 할 때 forEach는 무시지만 %는 오류이기 때문에 forEach 사용 -->
				<tr>
					<td>${userVo.userid}</td>
					<td><a href="/Users/View?userid=${userVo.userid}">${userVo.username}</a></td>
					<td>${userVo.email}</td>
					<td>${userVo.upoint}</td>
					<td>${userVo.indate}</td>
					<!-- <td><a href="/Users/Delete?userid=${userVo.userid}">삭제</a></td>
					<td><a href="/Users/UpdateForm?userid=${userVo.userid}">수정</a></td>-->
				</tr>
			</c:forEach>
		</table>
	</main>
</body>
</html>