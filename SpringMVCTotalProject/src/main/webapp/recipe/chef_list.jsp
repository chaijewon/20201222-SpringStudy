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
  width:700px;
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
        <table class="table">
         <tr>
           <td width=30% class="text-center" rowspan="2">
             <a href="../recipe/chef_make.do?chef=${vo.chef_name }"><img src="${vo.poster }" width=210 height=100 class="img-circle"></a>
           </td>
           <td colspan="4"><h3 style="color:orange"><a href="../recipe/chef_make.do?chef=${vo.chef_name }">${vo.chef_name }</a></h3></td> 
         </tr>
         <tr>
           <td class="text-center"><img src="../recipe/mc1.png">&nbsp;${vo.mc1 }</td>
           <td class="text-center"><img src="../recipe/mc3.png">&nbsp;${vo.mc3 }</td>
           <td class="text-center"><img src="../recipe/mc7.png">&nbsp;${vo.mc7 }</td>
           <td class="text-center"><img src="../recipe/mc2.png">&nbsp;${vo.mc2 }</td>
         </tr>
        </table>
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
		  <li><a href="chef_list.do?page=${startPage-1 }">&lt;</a></li>
		 </c:if>
		  <c:forEach var="i" begin="${startPage }" end="${endPage }">
		   <c:if test="${curpage==i }">
		    <c:set var="type" value="class=active"/>
		   </c:if>
		   <c:if test="${curpage!=i }">
		     <c:set var="type" value=""/>
		   </c:if>
		   <li ${type }><a href="chef_list.do?page=${i }">${i }</a></li>
		  </c:forEach>
		 <%-- 10,20,30,40... --%>
		 <c:if test="${endPage<allPage }">
		  <li><a href="chef_list.do?page=${endPage+1 }">&gt;</a></li>
		 </c:if>
		</ul>
      </div>
    </div>
  </div>
</body>
</html>














