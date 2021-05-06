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
   <div class="container">
     <div class="row">
      <form method=post action="find_ok.do">
      <table class="table">
       <tr>
        <td>
         <input type="checkbox" name="data" value="T" class="input-sm">제목
         <input type="checkbox" name="data" value="S" class="input-sm">줄거리
         <input type="checkbox" name="data" value="G" class="input-sm">장르
         <input type="checkbox" name="data" value="A" class="input-sm">출연
         <input type="checkbox" name="data" value="D" class="input-sm">감독
         <input type=text name=ss size=20 class="input-sm">
         <button class="btn btn-sm btn-danger">검색</button>
        </td>
       </tr>
      </table>
      </form>
     </div>
     <div class="row">
       <c:forEach var="vo" items="${list }">
         <div class="col-md-3">
		    <div class="thumbnail">
		        <img src="${vo.poster }" style="width:100%">
		        <div class="caption">
		          <p>${vo.title }</p>
		        </div>
		    </div>
		  </div>
       </c:forEach>
     </div>
   </div>
</body>
</html>












