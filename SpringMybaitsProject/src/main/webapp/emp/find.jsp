<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
  width:900px;
  margin: 0px auto;
}
h1 {
  text-align: center;
}
</style>
</head>
<body>
  <div style="height: 50px"></div>
  <div class="container">
    <h1>검색 결과</h1>
    <div class="row">
     <table class="table">
       <tr>
        <th class="text-center">사번</th>
        <th class="text-center">이름</th>
        <th class="text-center">직위</th>
        <th class="text-center">입사일</th>
        <th class="text-center">급여</th>
       </tr>
       <c:forEach var="vo" items="${list }">
        <tr>
	        <th class="text-center">${vo.empno }</th>
	        <th class="text-center">${vo.ename }</th>
	        <th class="text-center">${vo.job }</th>
	        <th class="text-center">${vo.dbday }</th>
	        <th class="text-center">${vo.sal }</th>
	       </tr>
       </c:forEach>
     </table>
    </div>
  </div>
</body>
</html>












