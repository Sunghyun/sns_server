<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">

<title>Insert title here</title>
</head>
<body>

<c:forEach var="item" items="${list}">
<table>
�����̸� : ${item}
<input type="button" value="�ٿ� " onclick="location.href='<%=request.getContextPath()%>/file.do?list=${item}'"/>
<input type="button" value="���� " onclick="location.href='<%=request.getContextPath()%>/filedel.do?fid=${item}'"/>
</table>
</c:forEach>

</body>
</html>