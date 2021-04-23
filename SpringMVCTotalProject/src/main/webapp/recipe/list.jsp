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
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
$(function(){
	$('.recipe_img').css("cursor","pointer");
	$('.recipe_img').click(function(){
		let no=$(this).attr("value");
		$.ajax({
			type:'GET',
			url:'detail.do',
			data:{"no":no},
			success:function(result)
			{
				$('#dialog').html(result);
				$('#dialog').dialog({
					autoOpen:true,
					width:1300,
					height:900,
					modal:true
				})
				$('#dialog').show()
			}
		})
		
	})
});
</script>
</head>
<body>
  <div style="height: 30px"></div>
  <div class="container-fluid">
    <div class="row">
     <c:forEach var="vo" items="${list }">
             <div class="col-md-3">
			    <div class="thumbnail">
			        <img src="${vo.poster }" alt="Lights" style="width:100%" class="recipe_img" value="${vo.no }">
			        <div class="caption">
			          <p style="font-size: 8px">${vo.title }</p>
			        </div>
			    </div>
		      </div>
     </c:forEach>
    </div>
    <div class="row">
      <div class="text-center">
        <ul class="pagination pagination-lg">
         <%-- startPage : 1,11,21,31... --%>
         <%--
             11 => 10 ==> startPage=1
          --%>
         <c:if test="${startPage>1 }">
		  <li><a href="list.do?page=${startPage-1 }">&lt;</a></li>
		 </c:if>
		  <c:forEach var="i" begin="${startPage }" end="${endPage }">
		   <c:if test="${curpage==i }">
		    <c:set var="type" value="class=active"/>
		   </c:if>
		   <c:if test="${curpage!=i }">
		     <c:set var="type" value=""/>
		   </c:if>
		   <li ${type }><a href="list.do?page=${i }">${i }</a></li>
		  </c:forEach>
		 <%-- 10,20,30,40... --%>
		 <c:if test="${endPage<allPage }">
		  <li><a href="list.do?page=${endPage+1 }">&gt;</a></li>
		 </c:if>
		</ul>
      </div>
    </div>
    <div id="dialog" title="레시피 만드는 방법" style="display:none">
      
    </div>
  </div>
</body>
</html>









