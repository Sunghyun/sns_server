<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
	function a() {
		pwd1 = prompt("패스워드를 입력하라");
		f.pwd.value = pwd1;
		f.action = "/sns_server/out.do";
		f.submit();
	}
	function b(n, id) {
		if (n == "1") {
			ft.action = "/sns_server/addFr.do?id=" + id;
			ft.submit();
		} else if (n == "2") {
			ft.action = "/sns_server/delFr.do?id=" + id;
			ft.submit();
		}
		//	alert("잘못된 작동");
	}
	function c(n) {
		if (n == "1") {
			f.action = "/sns_server/updateForm.do";
		} else if (n == "2") {
			f.action = "/sns_server/logout.do";
		}
		f.submit();
	}
	function d(n, form) {
		if (n == 1) {
			form.action = "/sns_server/editForm.do";
		} else if (n == 2) {
			form.action = "/sns_server/delAr.do";
		}
		form.submit();
	}
</script>
</head>
<body>

	<form action="/sns_server/updateForm.do" method="post" name="f">
		<input type="button" value="내정보수정" onclick="c('1')"> <input
			type="button" value="로그아웃" onclick="c('2')"> <input
			type="hidden" name="pwd" /> <input type="button" value="탈퇴"
			onclick="a()" />
	</form>


	<table border="1">
		<tr>
			<th style="width: 600px;">글목록</th>
			<th>인맥관리</th>
		</tr>
		<tr>
			<td rowspan="3"><a href="/sns_server/writeForm.do">글쓰기</a><br />
				<table border="1">
					<tr>
						<th>글번호</th>
						<th>작성자</th>
						<th style="width: 300px;">내용</th>
						<th>편집</th>
					</tr>
					<c:forEach var="a" items="${articles}">
						<tr>
							<td>${a.num}</td>
							<td>${a.writer_id}</td>
							<td>${a.content}</td>
							<td><c:if test="${a.writer_id == sessionScope.id }">
									<form method="post">
										<input type="hidden" name="num" value="${a.num}" /> <input
											type="hidden" name="writer_id" value="${a.writer_id}" /> <input
											type="hidden" name="content" value="${a.content}" /> <input
											type="button" value="수정" onclick="d(1, this.form)" /> <input
											type="button" value="삭제" onclick="d(2, this.form)" />
									</form>
								</c:if></td>
						</tr>
					</c:forEach>
				</table></td>
			<td>
				<h3>알 수 있는 사람</h3> <c:forEach var="m" items="${data}">
					<a href="/sns_server/frInfo.do?id=${m.id }">${m.id }</a>
					<br />
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td>
				<h3>내 인맥</h3>
				<form name="ft" method="post">
					<table border="1">
						<tr>
							<th>수락대기 친구</th>
							<th>내가 요청한 친구</th>
							<th>친구</th>
						</tr>
						<c:forEach var="f" items="${fdata}">
							<tr>
								<td><c:if test="${f.info1 =='no'}">${f.fr_id }
	<input type="button" value="수락" onclick="b('1', '${f.fr_id }')" />
										<input type="button" value="거절"
											onclick="b('2', '${f.fr_id }')" />
									</c:if></td>
								<td><c:if test="${f.info1 =='my'}">${f.fr_id }
	<input type="button" value="취소" onclick="b('2', '${f.fr_id }')" />
									</c:if></td>
								<td><c:if test="${f.info1 =='yes'}">${f.fr_id }</c:if></td>
							</tr>
						</c:forEach>
					</table>
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<h3>친구 찾기(id로 검색)</h3>
				<form action="/sns_server/searchFr.do" method="post">
					<input type="text" name="id" /> <input type="submit" value="검색" />
				</form>
			</td>
		</tr>
	</table>

</body>
</html>





