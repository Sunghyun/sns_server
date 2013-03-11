<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
[
<c:forEach var="a" items="${fList}" varStatus="roop">
<c:if test="${roop.index != 0 }">, </c:if>
{num:${a.num}, fr_id:'${a.fr_id}', info1:'${a.info1}'}
</c:forEach>
]