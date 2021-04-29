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
  width:700px;
  margin: 0px auto;
}
h1 {
  text-align: center;
}
</style>
</head>
<body>
   <div style="height:50px"></div>
   <div class="container">
    <h1>사원 목록</h1>
    <div class="row">
      <table class="table">
       <tr>
         <th>사번</th>
         <th>이름</th>
         <th>직위</th>
         <th>급여</th>
         <th>부서</th>
       </tr>
       <c:forEach var="vo" items="${list }">
        <tr>
         <th>${vo.empno }</th>
         <th>${vo.ename }</th>
         <th>${vo.job }</th>
         <th>${vo.sal }</th>
         <th>${vo.deptno }</th>
       </tr>
       </c:forEach>
      </table>
    </div>
   </div>
</body>
</html>