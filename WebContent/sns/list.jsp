<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
function a(){
	pwd1 = prompt("�н����带 �Է��϶�");
	f.pwd.value = pwd1;
	f.action="/sns_server/out.do";
	f.submit();
}

function c(n){
	if(n=="1"){		
		f.action="/sns_server/updateForm.do"; 
	}else if(n=="2"){		
		f.action="/sns_server/logout.do"; 
	}
	f.submit();
}

</script>
</head>
<body>
<form action="/sns_server/updateForm.do" method="post" name="f">
<input type="button" value="����������" onclick="c('1')">
<input type="button" value="�α׾ƿ�" onclick="c('2')">
<input type="hidden" name="pwd"/>
<input type="button" value="Ż��" onclick="a()"/>
</form>

</body>
</html>





