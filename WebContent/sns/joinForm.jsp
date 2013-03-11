<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<spring:hasBindErrors name="member"/>
<form:errors path="member"/>
<form action="/sns_server/insert.do" method="post">
<p>
	ȸ�� ID
	<input type="text" name="id" value="${member.id }"/>
	<form:errors path="member.id" />
</p>
<p>
	ȸ�� PWD
	<input type="text" name="pwd" value="${member.pwd }"/>
	<form:errors path="member.pwd" />
</p>
<p>
	�̸�
	<input type="text" name="name" value="${member.name }"/>
	<form:errors path="member.name" />
</p>
<p>
	�Ҽ�	
	<input type="radio" name="sg" value="1" checked/>1 ��ũ���
	<input type="radio" name="sg" value="2"/>2 ��ũ���
	<input type="radio" name="sg" value="3"/>3 ��ũ���
	<input type="radio" name="sg" value="4"/>4 ��ũ���
	<form:errors path="member.sg" />
</p>
<p>
	��ȭ��ȣ
	<input type="text" name="tel" value="${member.tel }"/>
	<form:errors path="member.tel" />
</p>
<p>
	�ּ�
	<input type="text" name="address" value="${member.address}"/>
	
</p>
<p>
	<input type="submit" value="ȸ�� ���">
</p>
</form>
</body>
</html>