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
.board_row{
   margin: 0px auto;
   width:960px;
}
</style>
</head>
<body>
  <div class="wrapper row3 board_row">
   
    <table class="table">
      <tr>
        <td class="text-left">
         <a href="../board/insert.do" class="btn btn-sm btn-danger">등록</a>
        </td>
      </tr>
    </table>
    <div style="height: 500px">
	    <table class="table">
	      <tr>
	        <th class="text-center" width="10%">번호</th>
	        <th class="text-center" width="45%">제목</th>
	        <th class="text-center" width="15%">이름</th>
	        <th class="text-center" width="20%">작성일</th>
	        <th class="text-center" width="10%">조회수</th>
	      </tr>
	      <c:forEach var="vo" items="${list }">
	        <tr>
		        <td class="text-center" width="10%">${vo.no }</td>
		        <td class="text-left" width="45%">${vo.subject }</td>
		        <td class="text-center" width="15%">${vo.name }</td>
		        <td class="text-center" width="20%">${vo.dbday }</td>
		        <td class="text-center" width="10%">${vo.hit }</td>
		      </tr>
	      </c:forEach>
	    </table>
   </div>
   <table class="table">
     <tr>
       <td class="text-center">
         <ul class="pagination">
             <li><a href="#">&lt;</a></li>
	         <c:forEach var="i" begin="${startPage }" end="${endPage }">
	           <li><a href="../board/list.do?page=${i }">${i }</a></li>
	         </c:forEach>
	         <li><a href="#">&gt;</a></li>
	     </ul>
       </td>
     </tr>
   </table>
   <table class="table">
     <tr>
       <td>
         <ul class="inline">
          <input type="checkbox" value="name" name="fs" class="input-sm">이름
          <input type="checkbox" value="subject" name="fs" class="input-sm">제목
          <input type="checkbox" value="content" name="fs" class="input-sm">내용
          <input type=text name="ss" size=15 class="input-sm">
          <input type=submit value="검색" class="btn btn-sm btn-primary">
         </ul>
       </td>
     </tr>
   </table>
  </div>
</body>
</html>








