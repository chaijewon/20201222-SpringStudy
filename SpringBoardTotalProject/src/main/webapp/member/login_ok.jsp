<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
  <c:when test="${result=='NOID' }">
   <script>
    alert("ID가 존재하지 않습니다!!");
    history.back();
   </script>
  </c:when>
  <c:when test="${result=='NOPWD' }">
   <script>
    alert("비밀번호가 틀립니다!!");
    history.back();
   </script>
  </c:when>
  <c:otherwise>
    <c:redirect url="../board/list.do"/>
  </c:otherwise>
</c:choose>