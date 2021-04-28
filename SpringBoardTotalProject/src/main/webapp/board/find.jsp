<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
  width:900px;
  margin: 0px auto;
}
h1 {
  text-align: center;
}
</style>
</head>
<body>
   <div style="height: 50px"></div>
   <div class="container">
     <h1>검색결과</h1>
     <div class="row">
       <c:if test="${count==0 }">
         <table class="table">
          <tr>
           <td class="text-center">
             <h3>검색된 결과값 없습니다!!</h3>
           </td>
          </tr>
         </table>
       </c:if>
       <c:if test="${count!=0 }">
          <table class="table">
           <tr>
            <td class="text-right">검색결과:${count }개</td>
           </tr>
          </table>
          <table class="table">
            <tr class="warning">
             <th width=10% class="text-center">번호</th>
             <th width=45% class="text-center">제목</th>
             <th width=15% class="text-center">이름</th>
             <th width=20% class="text-center">작성일</th>
             <th width=10% class="text-center">조회수</th>
            </tr>
            <c:forEach var="vo" items="${list }">
              <tr>
	             <td width=10% class="text-center">${vo.no }</td>
	             <td width=45% class="text-left">${vo.subject }</td>
	             <td width=15% class="text-center">${ vo.name}</td>
	             <td width=20% class="text-center"><fmt:formatDate value="${vo.regdate }" 
	                                            pattern="yyyy-MM-dd"/></td>
	             <td width=10% class="text-center">${vo.hit }</td>
	            </tr>
            </c:forEach>
          </table>
       </c:if>
       <hr>
       <table class="table">
        <tr>
          <td class="text-right">
            <a href="list.do" class="btn btn-sm btn-primary">목록</a>
          </td>
        </tr>
       </table>
     </div>
   </div>
</body>
</html>















