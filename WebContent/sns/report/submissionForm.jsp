<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���Ͼ��ε�</title>
<script type="text/javascript"></script>

</head>
<body>
<!--  ���� ������ ����� 3�� ������Ʈ�Ķ�, ��Ƽ��Ʈ..������Ʈ, Ŀ�ǵ� ��ü 

	Multipart �� �� �ؾ� �ö󰣴�. -->
	
<form action="<%= request.getContextPath() %>/report/submitReport1.do" method="post" enctype="multipart/form-data">
<%-- <input type="hidden" name="id" value="${ sessionScope.id}"/> --%>
<input type="hidden" name="id" value="${id}"/> 
���ε� : <input type="file" name="report" />
<br/>
<input type="submit" onClick="window.close();"/>
</form>

<!-- <h3>MultipartHttpServletRequest ���</h3> -->
<%-- <form action="<%= request.getContextPath() %>/report/submitReport2.do" method="post" enctype="multipart/form-data"> --%>
<!-- �й� : <input type="text" name="studentNumber" /> -->
<!-- <br/> -->
<!-- ����Ʈ ���� : <input type="file" name="report" /> -->
<!-- <br/> -->
<!-- <input type="submit" /> -->
<!-- </form> -->

<!-- <h3> Ŀ�ǵ� ��ü ���</h3> -->
<%-- <form action="<%= request.getContextPath() %>/report/submitReport3.do" method="post" enctype="multipart/form-data"> --%>
<!-- �й� : <input type="text" name="studentNumber" /> -->
<!-- <br/> -->
<!-- ����Ʈ ���� : <input type="file" name="report" /> -->
<!-- <br/> -->
<!-- <input type="submit" /> -->
<!-- </form> -->

</body>
</html>