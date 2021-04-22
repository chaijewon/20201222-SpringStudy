<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row{
  margin: 0px auto;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#keyword').keyup(function(){
		let k=$(this).val();
		$('#user-table > tbody > tr').hide();
		let temp=$('#user-table > tbody > tr > td:nth-child(6n+4):contains("'+k+'")');
		$(temp).parent().show();
	})
});
</script>
</head>
<body>
  <div class="container">
    <div class="row">
     <table class="table">
      <tr>
       <td>
        <input type=text id="keyword" size=30 class="input-sm">
       </td>
      </tr>
     </table>
     <table class="table" id="user-table">
       <thead>
	       <tr class="info">
	         <th class="text-center">순위</th>
	         <th class="text-center"></th>
	         <th class="text-center"></th>
	         <th class="text-center">노래명</th>
	         <th class="text-center">가수명</th>
	         <th class="text-center">앨범</th>
	       </tr>
       </thead>
       <tbody>
       <c:forEach var="vo" items="${list }">
         <tr>
             <td class="text-center">${vo.no }</td>
	         <td class="text-center">
	           <img src="${vo.poster }" width="35" height="35">
	         </td>
	         <td class="text-center">
	           <c:if test="${vo.state=='상승' }">
	            <font color="blue">▲</font>&nbsp;${vo.idcrement }
	           </c:if>
	           <c:if test="${vo.state=='하강' }">
	             <font color="red">▼</font>&nbsp;${vo.idcrement }
	           </c:if>
	           <c:if test="${vo.state=='유지' }">
	             <font color="gary">-</font>
	           </c:if>
	         </td>
	         <td class="text-left">${vo.title }</td>
	         <td class="text-left">${vo.singer }</td>
	         <td class="text-left">${vo.album }</td>
         </tr>
       </c:forEach>
       </tbody>
       <tfoot>
       <tr>
         <td colspan="6" class="text-center">
          <a href="../music/list.do?page=1" class="btn btn-sm btn-danger">1~50위</a>
          <a href="../music/list.do?page=2" class="btn btn-sm btn-success">50~100위</a>
          <a href="../music/list.do?page=3" class="btn btn-sm btn-warning">101~150위</a>
          <a href="../music/list.do?page=4" class="btn btn-sm btn-info">151~200위</a>
         </td>
       </tr>
       </tfoot>
     </table>
    </div>
  </div>
</body>
</html>






