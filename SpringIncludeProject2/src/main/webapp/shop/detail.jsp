<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row_detail{
  margin: 0px auto;
  width:800px;
}
</style>
</head>
<%--
        NO      NOT NULL NUMBER        
		CNO              NUMBER        
		TITLE   NOT NULL VARCHAR2(300) 
		POSTER  NOT NULL VARCHAR2(500) 
		PRICE   NOT NULL VARCHAR2(30)  
		ACCOUNT          NUMBER
 --%>
<body>
  <div style="height: 30px"></div>
  <div class="row row_detail">
  <form method="post" action="../shop/input.do">
    <table class="table">
     <tr>
       <td width="30%" rowspan="4" class="text-center">
        <img src="${vo.poster }" width=100%>
       </td>
       <td colspan="2">
        <h3>${vo.title }</h3>
       </td>
     </tr>
     <tr>
       <td width=20% class="text-right">가격</td>
       <td width=50%>${vo.price }</td>
     </tr>
     <tr>
       <td width=20% class="text-right">수량</td>
       <td width=50%>
        <c:if test="${vo.account>0 }">
          <select name="su">
           <c:forEach var="i" begin="1" end="${vo.account }">
            <option>${i }</option>
           </c:forEach>
          </select>
        </c:if>
        <c:if test="${vo.account==0 }">
         <span style="color:red">재고 없음</span>
        </c:if>
       </td>
     </tr>
     <tr>
       <td colspan="2" class="text-right">
          <input type=hidden name="no" value="${vo.no }">
          <input type=hidden name="price" value="${vo.price }">
        <c:if test="${sessionScope.id!=null }">
          <input type="submit" value="구매" class="btn btn-sm btn-danger">
        </c:if>
        <a href="../shop/list.do" class="btn btn-sm btn-success">목록</a>
       </td>
     </tr>
    </table>
    </form>
  </div>
</body>
</html>












