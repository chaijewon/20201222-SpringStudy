<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
  margin: 0px auto;
}
h1 {
  text-align: center;
}
</style>
</head>
<body>
  <div style="height:30px"></div>
  <div class="container">
    <h1>사원정보(SUBQUERY이용)</h1>
    <div class="row">
      <table class="table table-striped">
        <tr>
         <th class="text-center">사번</th>
         <th class="text-center">이름</th>
         <th class="text-center">직위</th>
         <th class="text-center">입사일</th>
         <th class="text-center">급여</th>
        </tr>
        <c:forEach var="vo" items="${list }">
           <tr>
	         <td class="text-center">${vo.empno }</td>
	         <td class="text-center">${vo.ename }</td>
	         <td class="text-center">${vo.job }</td>
	         <td class="text-center"><fmt:formatDate value="${vo.hiredate }" pattern="yyyy-MM-dd"/></td>
	         <td class="text-center">${vo.sal }</td>
	        </tr>
        </c:forEach>
       </table>
    </div>
  </div>
</body>
</html>