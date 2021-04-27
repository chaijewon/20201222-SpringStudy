<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.board_row{
   margin: 0px auto;
   width:960px;
}
</style>
</head>
<body>
  <div class="wrapper row3 board_row">
    <div style="height: 700px">
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
		        <td class="text-left" width="45%">
		        <a href="../board/detail.do?no=${vo.no }&page=${curpage}">${vo.subject }</a>
		        </td>
		        <td class="text-center" width="15%">${vo.name }</td>
		        <td class="text-center" width="20%"><fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/></td>
		        <td class="text-center" width="10%">${vo.hit }</td>
		      </tr>
	      </c:forEach>
	    </table>
   </div>
  </div>

</body>
</html>