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
  width:600px;
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
    <h1>사원 명단</h1>
    <div class="row">
     <form method=post action="find.do">
     <table class="table">
       <tr>
         <td>
           <c:forEach var="name" items="${list }">
            <input type="checkbox" name="names" value="${name }">${name }
           </c:forEach>
         </td>
       </tr>
       <tr>
         <td class="text-center">
           <button class="btn btn-sm btn-danger">전송</button>
         </td>
       </tr>
     </table>
     </form>
    </div>
    <h1>직위 목록</h1>
    <div class="row">
     <form method=post action="find2.do">
     <table class="table">
       <tr>
         <td>
           <c:forEach var="job" items="${jList }">
            <input type="checkbox" name="jobs" value="${job }">${job}
           </c:forEach>
         </td>
       </tr>
       <tr>
         <td class="text-center">
           <button class="btn btn-sm btn-danger">전송</button>
         </td>
       </tr>
     </table>
     </form>
    </div>
   </div>
</body>
</html>