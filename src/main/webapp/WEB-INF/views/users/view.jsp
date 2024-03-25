<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="/css/common.css">
<link rel="icon" type="image/png" href="/img/favicon.png">
<style>
	td {
		padding: 10px;
		width: 700px;
		text-align: center;
	}
	td:not([colspan]):first-child {
		background-color: black;
		color: white;
		font-weight: bold;
	}
	td:nth-of-type(1) {
		width: 200px;
	}
	input:not(input[type=submit], input[type=button]) {
		width: 100%;
	}
	input[type=submit], input[type=button] {
		width: 100px;
	}
	
	input[readonly] {
		background: #ebebeb;
	}
	
	tr:not(tr:last-child) > td:last-child {
		text-align: left;
	}
	
</style>
</head>
<body>
	<main>
		<a href="/"><h1>Board</h1></a>
		<h2>사용자 상세 정보</h2>
			<table>
				<tr>
					<td>아이디</td>
					<td>${vo.userid}</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>${vo['passwd']}</td> <!-- map을 꺼낼 때는 이렇게 키값을 넣어서 꺼내준다 ${vo['passwd'] } -->
				</tr>
				<tr>
					<td>이름</td>
					<td>${vo.username}</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>${vo.email}</td>
				</tr>
				<tr>
					<td>회원등급</td>
					<td>${vo.upt}</td>
				</tr>
				<tr>
					<td>포인트</td>
					<td> <!-- upoint가 0이 아니면 포인트를 표시함 -->
						<!--<c:if test="${vo.upoint ne 0 }">
							${vo['upoint'] }
						</c:if>-->
						
						<c:choose>
							<c:when test="${vo.upoint ne 0 }">
								${vo['upoint'] }
							</c:when>
							<c:otherwise>
								<span style="color: red">없음</span>
							</c:otherwise>
						</c:choose>
						
					</td>
					<!-- <td>${vo['upoint']}</td>-->
					<%-- <td>${vo['upoint'] + 1000}</td> 계산식도 넣을 수 있음 --%>
				</tr>
				<tr>
					<td>가입일</td>
					<td>${vo.indate}</td>
				</tr>
				<tr>
					<td colspan="4">
						<a class="btn btn-primary btn-sm" href="/Users/WriteForm" role="button">회원가입</a>
						<a class="btn btn-primary btn-sm" href="/Users/UpdateForm?userid=${vo.userid}" role="button">회원수정</a>
						<a class="btn btn-danger btn-sm" href="/Users/Delete?userid=${vo.userid}" role="button">회원삭제</a>
						<a class="btn btn-primary btn-sm" href="/Users/List" role="button">회원목록</a>
						<a class="btn btn-outline-dark btn-sm" href="/" role="button">home</a>
					</td>
				</tr>
			</table>
	</main>
</body>

<!-- <script>
	const goListEl = document.getElementById("goList");
	
	goListEl.addEventListener('click', function(e) {
		//alert("Ok");
		location.href = '/Users/List';
	});
</script> -->

</html>