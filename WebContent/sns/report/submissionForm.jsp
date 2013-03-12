<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>파일업로드</title>
<script type="text/javascript"></script>

</head>
<body>
<!--  파일 업도드 방식은 3개 리퀘스트파람, 멀티파트..리퀘스트, 커맨드 객체 

	Multipart 로 꼭 해야 올라간다. -->
	
<form action="<%= request.getContextPath() %>/report/submitReport1.do" method="post" enctype="multipart/form-data">
<%-- <input type="hidden" name="id" value="${ sessionScope.id}"/> --%>
<input type="hidden" name="id" value="${id}"/> 
업로드 : <input type="file" name="report" />
<br/>
<input type="submit" onClick="window.close();"/>
</form>

<!-- <h3>MultipartHttpServletRequest 사용</h3> -->
<%-- <form action="<%= request.getContextPath() %>/report/submitReport2.do" method="post" enctype="multipart/form-data"> --%>
<!-- 학번 : <input type="text" name="studentNumber" /> -->
<!-- <br/> -->
<!-- 레포트 파일 : <input type="file" name="report" /> -->
<!-- <br/> -->
<!-- <input type="submit" /> -->
<!-- </form> -->

<!-- <h3> 커맨드 객체 사용</h3> -->
<%-- <form action="<%= request.getContextPath() %>/report/submitReport3.do" method="post" enctype="multipart/form-data"> --%>
<!-- 학번 : <input type="text" name="studentNumber" /> -->
<!-- <br/> -->
<!-- 레포트 파일 : <input type="file" name="report" /> -->
<!-- <br/> -->
<!-- <input type="submit" /> -->
<!-- </form> -->

</body>
</html>