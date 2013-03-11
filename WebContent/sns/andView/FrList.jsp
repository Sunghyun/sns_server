<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

[
<c:forEach var="m" items="${m}" varStatus="roop">
<c:if test="${roop.index != 0 }">, </c:if>
{id:'${m.id}', name:'${m.name}', sg:${m.sg}, tel:'${m.tel}', address:'${m.address}'}
</c:forEach>
]