<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Shopping</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="../main/main.do">Home</a></li>
      <li><a href="../member/join.do">회원가입</a></li>
      <li><a href="../shop/list.do">쇼핑몰</a></li>
      <c:if test="${sessionScope.id!=null && sessionScope.admin==1 }">
       <li><a href="../shop/mypage.do">마이페이지</a></li>
      </c:if>
      <c:if test="${sessionScope.id!=null && sessionScope.admin==0 }">
       <li><a href="../shop/admin.do">관리자페이지</a></li>
      </c:if>
    </ul>
  </div>
</nav>

<div style="height: 30px"></div>
<div class="container">
  <div class="col-sm-3">
    <c:if test="${sessionScope.id==null }">
     <jsp:include page="../member/login.jsp"></jsp:include>
    </c:if>
    <c:if test="${sessionScope.id!=null }">
     <jsp:include page="../member/logout.jsp"></jsp:include>
    </c:if>
  </div>
  <div class="col-sm-9">
    <jsp:include page="${main_jsp }"></jsp:include>
  </div>
</div>
</body>
</html>













