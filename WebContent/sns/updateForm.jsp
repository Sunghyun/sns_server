<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
function a(){
	n = parseInt(f.sgValue.value);
	f.sg[n-1].checked=true;
}
</script>
</head>
<body onload="a()">
<form action="/sns_server/update.do" method="post" name="f">
<p>
	ȸ�� ID
	<input type="text" name="id" value="${member.id }" readonly/>
	
</p>
<p>
	ȸ�� PWD
	<input type="text" name="pwd" value="${member.pwd }"/>
	
</p>
<p>
	�̸�
	<input type="text" name="name" value="${member.name }" readonly/>
	
</p>
<p>
	�Ҽ�	
	<input type="hidden" name="sgValue" value="${member.sg }" />
	<input type="radio" name="sg" value="1"/>1 ��ũ���
	<input type="radio" name="sg" value="2"/>2 ��ũ���
	<input type="radio" name="sg" value="3"/>3 ��ũ���
	<input type="radio" name="sg" value="4"/>4 ��ũ���
	
</p>
<p>
	��ȭ��ȣ
	<input type="text" name="tel" value="${member.tel }"/>
	
</p>
<p>
	�ּ�
	<input type="text" name="address" value="${member.address}"/>
	
</p>
<p>
	<input type="submit" value="����">
</p>
</form>
</body>
</html>