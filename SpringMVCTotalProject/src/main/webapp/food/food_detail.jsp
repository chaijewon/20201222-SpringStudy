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
  width:700px;
}
h1 {
  text-align: center;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
     <table class="table">
      <tr>
        <c:forTokens items="${vo.poster }" delims="^" var="poster">
          <td>
           <img src="${poster }" width=100%>
          </td>
        </c:forTokens>
      </tr>
     </table>
     <table class="table">
      <tr>
        <td colspan="2">
         <h3>${vo.title }&nbsp;<span style="color:orange">${vo.score }</span></h3>
        </td>
      </tr>
      <tr>
        <td width=20% class="text-right">주소</td>
        <td width=80%>${vo.address }</td>
      </tr>
      <tr>
        <td width=20% class="text-right">전화</td>
        <td width=80%>${vo.tel }</td>
      </tr>
      <tr>
        <td width=20% class="text-right">음식종류</td>
        <td width=80%>${vo.type }</td>
      </tr>
      <tr>
        <td width=20% class="text-right">가격대</td>
        <td width=80%>${vo.price}</td>
      </tr>
      <tr>
        <td width=20% class="text-right">영업시간</td>
        <td width=80%>${vo.time }</td>
      </tr>
      <tr>
        <td width=20% class="text-right">주차</td>
        <td width=80%>${vo.parking }</td>
      </tr>
      <c:if test="${vo.menu!='no' }">
        <tr>
          <td width=20% class="text-right">메뉴</td>
          <td width=80%>
            <ul style="list-style-type: none">
             <c:forTokens items="${vo.menu }" delims="원" var="s">
               <li>${s }원</li>
             </c:forTokens>
            </ul>
          </td>
        </tr>
      </c:if>
      <tr>
        <td colspan="2" class="text-right">
          <a href="../food/list.do?cno=${vo.cno }" class="btn btn-sm btn-danger">목록</a>
        </td>
      </tr>
     </table>
    </div>
  </div>
</body>
</html>
