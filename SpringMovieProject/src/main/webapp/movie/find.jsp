<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
    <h1>검색결과</h1>
    <div class="row">
      <table class="table">
        <tr>
         <td>
          <form method=post action="find.do" autocomplete="off">
            <input type=text name=title size=20 class="input-sm">
            <input type=submit value="찾기" class="btn btn-sm btn-primary">
          </form>
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
  </div>
</body>
</html>
