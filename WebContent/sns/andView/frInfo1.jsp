<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <c:if test="${stat != 2 }">
{stat:${stat }, id:'${m.id}', name:'${m.name}', sg:${m.sg}, tel:'${m.tel}', address:'${m.address}'}
 </c:if>
 
  <c:if test="${stat == 2 }">
{stat:${stat }, id:'${m.id}', name:'${m.name}', sg:0, tel:'${m.tel}', address:'${m.address}'}
 </c:if>