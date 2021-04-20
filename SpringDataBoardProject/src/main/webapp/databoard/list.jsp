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
  width:800px;
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
     <h1>자료실</h1>
     <div class="row">
      <div style="height:500px">
          <table class="table">
            <tr>
             <td class="text-right">
              <a href="insert.do" class="btn btn-sm btn-success">등록</a>
             </td>
            </tr>
          </table>
	      <table class="table table-striped">
	        <tr class="warning">
	          <th class="text-center" width="10%">번호</th>
	          <th class="text-center" width="45%">제목</th>
	          <th class="text-center" width="15%">이름</th>
	          <th class="text-center" width="20%">작성일</th>
	          <th class="text-center" width="10%">조회수</th>
	        </tr>
	        <c:forEach var="vo" items="${list }">
	          <tr>
	            <td class="text-center" width="10%">${vo.no }</td>
	            <td width="45%"><a href="detail.do?no=${vo.no }">${vo.subject }</a></td>
	            <td class="text-center" width="15%">${vo.name }</td>
	            <td class="text-center" width="20%">${vo.dbday }</td>
	            <td class="text-center" width="10%">${vo.hit }</td>
	          </tr>
	        </c:forEach>
	      </table>
      </div>
      <table class="table">
        <tr>
          <td class="text-right">
           <a href="#" class="btn btn-sm btn-success">이전</a>
           ${curpage } page / ${totalpage } pages
           <a href="#" class="btn btn-sm btn-info">다음</a>
          </td>
        </tr>
      </table>
     </div>
   </div>
</body>
</html>
