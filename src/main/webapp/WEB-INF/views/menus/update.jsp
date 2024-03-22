<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common.css">
<link rel="icon" type="image/png" href="./img/favicon.png">
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
	
</style>
</head>
<body>
	<main>
		<h2>메뉴 수정</h2>
		<form action="/Menus/Update" method="get">
			<table>
				<tr>
					<td>메뉴 아이디</td>
					<td><input type="text" name="menu_id" value="${menu.menu_id}" readonly></td>
				</tr>
				<tr>
					<td>메뉴 이름</td>
					<td><input type="text" name="menu_name" value="${menu.menu_name}"></td>
				</tr>
				<tr>
					<td>메뉴 순서</td>
					<td><input type="number" name="menu_seq" value="${menu.menu_seq}"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="수정">
						<input type="button" value="목록" id="goList">
					</td>
				</tr>
			</table>
		</form>
	</main>
</body>

<script>
	const goListEl = document.getElementById("goList");
	
	goListEl.addEventListener('click', function(e) {
		//alert("Ok");
		location.href = '/Menus/List';
	});
</script>

</html>