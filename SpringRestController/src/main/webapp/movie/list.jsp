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
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
// window.onload=function(){}
$(function(){
	$('.posters').hover(function(){
		$(this).css('cursor','pointer');
	},function(){
		$(this).css('cursor',"")
	})
	
	$('.posters').click(function(){
		let mno=$(this).attr("data-no");
		// detail.do?mno=1
		$.ajax({
			type:'get',
			url:'detail.do',
			data:{"mno":mno},
			success:function(json)
			{
				/*
				     let data={"name":"홍길동","age":20}
				     data.name = data의 멤버 변수
				     data.age  = data의 멤버 변수 
				*/
				let jsonData=JSON.parse(json);
				$('#poster').attr("src",jsonData.poster);
				// <img src="">
				$('#title').text(jsonData.title);
				$('#director').text(jsonData.director);
				$('#actor').text(jsonData.actor);
				$('#genre').text(jsonData.genre);
				$('#story').text(jsonData.story);
				//$('#dialog').show();
				$('#dialog').dialog({
					autoOpen:true,
					width:600,
					height:600,
					modal:true
				})
				
			}
		})
	})
})
</script>
</head>
<body>
   <div style="height: 50px"></div>
   <div class="container-fluid">
     <div class="row">
       <div class="col-sm-8">
         <c:forEach var="vo" items="${list }">
	        <div class="col-md-3">
			    <div class="thumbnail">
			        <img src="${vo.poster }" style="width:100%" data-no="${vo.mno }" class="posters">
			        <div class="caption">
			          <p style="font-size: 8px">${vo.title }</p>
			        </div>
			    </div>
			  </div>
	      </c:forEach>
       </div>
       <div class="col-sm-4">
            <div id="dialog" title="영화 상세보기" style="display:none">
			   <table class="table">
			    <tr>
			     <td width=30% valign="top" rowspan="5">
			      <img src="" width=100% id="poster">
			     </td>
			     <td colspan="2">
			       <h3 style="color:orange" id="title"></h3>
			     </td>
			    </tr>
			    <tr>
			      <td class="text-right" width=20%>감독</td>
			      <td width=50% id="director"></td>
			    </tr>
			    <tr>
			      <td class="text-right" width=20%>출연</td>
			      <td width=50% id="director"></td>
			    </tr>
			    <tr>
			      <td class="text-right" width=20%>장르</td>
			      <td width=50% id="director"></td>
			    </tr>
			    <tr>
			      <td colspan="3" id="story"></td>
			    </tr>
			   </table>
			</div>
       </div>     
     </div>
   </div>
</body>
</html>









