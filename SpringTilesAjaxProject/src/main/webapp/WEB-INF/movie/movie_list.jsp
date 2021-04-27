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
<div id="portfolio" class="container-fluid text-center bg-grey">
  <h2>검색결과</h2><br>
  <div class="row text-center slideanim">
   <c:forEach var="vo" items="${list }">
    <div class="col-sm-4">
      <div class="thumbnail">
        <img src="${vo.poster }" alt="Paris" width="400" height="300">
        <p><strong>${vo.title }</strong></p>
      </div>
    </div>
   </c:forEach>
  </div>
 </div>
</body>
</html>