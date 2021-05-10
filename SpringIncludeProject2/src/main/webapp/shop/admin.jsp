<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row_home{
  margin: 0px auto;
  width:800px;
}
</style>
</head>
<body>
  <div style="height: 30px"></div>
  <div class="row row_home">
   <table class="table">
     <tr>
       <td class="text-right">
        <a href="../shop/list.do" class="btn btn-sm btn-info">목록</a>
       </td>
     </tr>
   </table>
   <table class="table">
     <tr class="danger">
      <th class="text-center">번호</th>
      <th class="text-center"></th>
      <th class="text-center">ID</th>
      <th class="text-center">상품명</th>
      <th class="text-center">구매일</th>
      <th class="text-center">구매갯수</th>
      <th class="text-center">구매금액</th>
      <th class="text-center">상태</th>
     </tr>
     <c:forEach var="vo" items="${list }">
      <tr>
       <td class="text-center">${vo.no }</td>
       <td class="text-center"><img src="${vo.svo.poster }" width=30 height=30/></td>
       <td class="text-center">${vo.id }</td>
       <td class="text-center">${vo.svo.title }</td>
       <td class="text-center"><fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/></td>
       <td class="text-center">${vo.goods_count }</td>
       <td class="text-center">${vo.total_price }</td>
       <td class="text-center">
         <c:if test="${vo.state=='n' }">
           <a href="../shop/admin_ok.do?no=${vo.no }" class="btn btn-sm btn-danger">승인요청</a>
         </c:if>
         <c:if test="${vo.state=='y' }">
            <span class="btn btn-sm btn-success">승인완료</span>
         </c:if>
       </td>
       </tr>
     </c:forEach>
   </table>
  </div>
</body>
</html>
