<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>로그인</h2>
<form action="/sns_server/login.do" method="post">
id : <input type="text" name="id"/><br/>
pwd : <input type="text" name="pwd"/><br/>
<input type="submit" value="로그인"/><br/>
</form>
<a href="/sns_server/regist.do">회원가입</a>
</body>
</html>



