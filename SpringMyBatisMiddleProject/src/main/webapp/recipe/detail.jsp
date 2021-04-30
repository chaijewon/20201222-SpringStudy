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
.row {
  width: 900px;
  margin: 0px auto;
}
</style>
</head>
<body>
   <div style="height:50px"></div>
   <div class="container">
     <div class="row">
       <table class="table">
        <tr>
          <td class="text-right">
            <a href="list.do" class="btn btn-sm btn-primary">목록</a>
          </td>
        </tr>
        <tr>
         <td class="text-center">
          <img src="${vo.poster }" width=700 height=250>
         </td>
        </tr>
        <tr>
          <td class="text-center">${vo.title }</td>
        </tr>
        <tr>
          <td class="text-center">${vo.content }</td>
        </tr>
       </table>   
       <table class="table">
         <tr>
          <td class="text-center">${vo.info1 }</td>
          <td class="text-center">${vo.info2 }</td>
          <td class="text-center">${vo.info3 }</td>
         </tr>
         <tr>
           <td colspan="3">
            <ul style="list-style-type: none">
             <c:forEach var="s" items="${vo.list }">
               <li>${s }</li>
             </c:forEach>
            </ul>
           </td>
         </tr>
         <tr>
          <td colspan="3" class="text-center">
            <img src="${vo.chef_poster }" width="100" height="100" class="img-circle">
            <br>
            ${vo.chef }(${vo.chef_info })
          </td>
         </tr>
       </table>  
     </div>
   </div>
</body>
</html>












