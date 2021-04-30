<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <c:forEach var="vo" items="${list }">
     <div class="col-md-3">
	    <div class="thumbnail">
	        <img src="${vo.poster }" title="${vo.title }" style="width:250px;height:200px">
	        <div class="caption">
	          <p>${vo.chef }(${vo.hit })</p>
	        </div>
	    </div>
	  </div>
   </c:forEach>
</body>
</html>