<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:if test="${flag == false }">
${msg }<br/>
<a href="/sns_server/list.do">이전으로</a>
</c:if>
<c:if test="${flag == true }">
친구정보<br/>
id : ${m.id }<br/>
name : ${m.name }<br/>
소셜 그룹 : ${m.sg }테크놀로지<br/>
tel : ${m.tel }<br/>
address : ${m.address }<br/>
<form action="/sns_server/reqFr.do">
<input type="hidden" name="id" value="${m.id }"/>
<input type="submit" value="친구요청" />
</form>
</c:if>
</body>
</html>