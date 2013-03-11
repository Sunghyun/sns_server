<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
[
<c:forEach var="a" items="${articles}" varStatus="roop">
<c:if test="${roop.index != 0 }">, </c:if>
{num:${a.num}, writer_id:'${a.writer_id}', content:'${a.content}'}
</c:forEach>
]