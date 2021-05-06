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
<body>
   <div style="height: 30px"></div>
   <div class="container-fluid">
     <div class="row">
      <div>
        <a href="find.do" class="btn btn-lg btn-danger">검색</a>
      </div>
     </div>
     <div style="height:20px"></div>
     <div class="row">
       <c:forEach var="vo" items="${list }">
         <div class="col-md-2">
		    <div class="thumbnail">
		        <img src="${vo.poster }" style="width:100%">
		        <div class="caption">
		          <p>${vo.title }</p>
		          <p>by ${vo.chef }</p>
		        </div>
		    </div>
		  </div>
       </c:forEach>
     </div>
     <div class="row">
       <div class="text-center">
	         <ul class="pagination">
	          <c:if test="${startPage>1 }">
	            <li><a href="recipe_list.do?page=${startPage-1 }">&lt;</a></li>
	          </c:if>
	          <c:forEach var="i" begin="${startPage }" end="${endPage }">
	            <c:if test="${i==curpage }">
	              <c:set var="type" value="class=active"/>
	            </c:if>
	            <c:if test="${i!=curpage }">
	              <c:set var="type" value=""/>
	            </c:if>
	            <li ${type }><a href="recipe_list.do?page=${i }">${i }</a></li>
	          </c:forEach>
	          <c:if test="${endPage<totalpage }">
	            <li><a href="recipe_list.do?page=${endPage+1 }">&gt;</a></li>
	          </c:if>
			</ul>
       </div>
     </div>
   </div>
</body>
</html>












