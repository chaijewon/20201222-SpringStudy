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
  <div style="height:50px"></div>
  <div class="container">
    <h1>영화목록</h1>
    <div class="row">
      <table class="table">
        <tr>
         <td>
          <a href="find.do" class="btn btn-sm btn-danger">찾기</a>
         </td>
        </tr>
      </table>
    </div>
    <div class="row">
      <c:forEach var="vo" items="${list }">
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
      </c:forEach>
    </div>
    <div class="row">
      <div class="text-center">
       <a href="list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-primary">이전</a>
         ${curpage } page / ${totalpage } pages
       <a href="list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-primary">다음</a>
      </div>
    </div>
  </div>
</body>
</html>








