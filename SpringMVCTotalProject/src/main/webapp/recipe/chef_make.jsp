<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
  margin: 0px auto;
  width:800px;
}
h1 {
  text-align: center;
}
</style>
</head>
<body>
  <div class="container">
     <div class="row">
     <c:forEach var="vo" items="${list }">
             <div class="col-md-3">
			    <div class="thumbnail">
			        <img src="${vo.poster }" alt="Lights" style="width:100%" class="recipe_img" value="${vo.no }">
			        <div class="caption">
			          <p style="font-size: 8px">${vo.title }</p>
			        </div>
			    </div>
		      </div>
     </c:forEach>
    </div>
    <div class="row">
      <div class="text-center">
        <ul class="pagination pagination-lg">
         <%-- startPage : 1,11,21,31... --%>
         <%--
             11 => 10 ==> startPage=1
          --%>
         <c:if test="${startPage>1 }">
		  <li><a href="chef_make.do?page=${startPage-1 }&chef=${chef}">&lt;</a></li>
		 </c:if>
		  <c:forEach var="i" begin="${startPage }" end="${endPage }">
		   <c:if test="${curpage==i }">
		    <c:set var="type" value="class=active"/>
		   </c:if>
		   <c:if test="${curpage!=i }">
		     <c:set var="type" value=""/>
		   </c:if>
		   <li ${type }><a href="chef_make.do?page=${i }&chef=${chef}">${i }</a></li>
		  </c:forEach>
		 <%-- 10,20,30,40... --%>
		 <c:if test="${endPage<allPage }">
		  <li><a href="chef_make.do?page=${endPage+1 }&chef=${chef}">&gt;</a></li>
		 </c:if>
		</ul>
      </div>
    </div>
    </div>
  </div>
</body>
</html>











