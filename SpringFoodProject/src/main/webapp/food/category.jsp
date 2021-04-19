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
  margin: 0px auto;
}
h1 {
  text-align: center;
}
</style>
</head>
<!-- 
   <div class="col-md-3">
	    <div class="thumbnail">
	      <a href="detail.do?mno=${vo.mno }">
	        <img src="${vo.poster }" style="width:100%">
	        <div class="caption">
	          <p>${vo.title }</p>
	        </div>
	      </a>
	    </div>
	  </div>
 -->
<body>
  <div style="height:50px"></div>
  <div class="container">
    <div class="row">
      <div class="text-center">
       <a href="category.do?no=1" class="btn btn-lg btn-danger">믿고 보는 맛집 리스트</a>
       <a href="category.do?no=2" class="btn btn-lg btn-primary">지역별 인기 맛집</a>
       <a href="category.do?no=3" class="btn btn-lg btn-success">메뉴별 인기 맛집</a>
      </div>
    </div>
    <div style="height:50px"></div>
    <div class="row">
      <c:forEach var="vo" items="${list }">
        <div class="col-md-4">
	    <div class="thumbnail">
	      <a href="food_list.do?cno=${vo.no }">
	        <img src="${vo.poster }" style="width:100%">
	        <div class="caption">
	          <p>${vo.title }</p>
	          <p>${vo.subject }
	        </div>
	      </a>
	    </div>
	  </div>
      </c:forEach>
    </div>
  </div>
</body>
</html>







