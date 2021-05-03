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
   <div style="height: 50px"></div>
   <div class="container-fluid">
     <div class="row">
       <div class="col-sm-8">
         <c:forEach var="vo" items="${list }">
	        <div class="col-md-3">
			    <div class="thumbnail">
			        <img src="${vo.poster }" style="width:100%">
			        <div class="caption">
			          <p style="font-size: 8px">${vo.title }</p>
			        </div>
			    </div>
			  </div>
	      </c:forEach>
       </div>
       <div class="col-sm-4">
        
       </div>     
     </div>
   </div>
</body>
</html>









