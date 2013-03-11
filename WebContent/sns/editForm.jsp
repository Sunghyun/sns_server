<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="/sns_server/edit.do" method="post">
		<table border="1">
			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>글내용</th>
			</tr>
			<tr>
				<td><input type="text" name="num" value="${article.num }"
					readonly /></td>
				<td><input type="text" name="writer_id"
					value="${article.writer_id }" readonly /></td>
				<td><input type="text" name="content"
					value="${article.content }" /></td>
			</tr>
		</table>
		<input type="submit" value="수정완료" />
	</form>
</body>
</html>




