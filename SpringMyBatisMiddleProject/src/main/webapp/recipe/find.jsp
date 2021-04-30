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
  margin: 0px auto;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		type:'post',
		url:'find_ok.do',
		success:function(result)
		{
			$('.find').html(result);
		}
	})
	
	$('.images').hover(function(){
		$(this).css('cursor','pointer')
	},function(){
		$(this).css('cursor','')
	})
	
	$('.images').click(function(){
		let no=$(this).attr("data-no");
		$.ajax({
			type:'post',
			url:'find_ok.do',
			data:{"no":no},
			success:function(result)
			{
				$('.find').html(result);
			}
		})
	});
})
</script>
</head>
<body>
  <div style="height: 50px"></div>
  <div class="container">
    <div class="row">
     <table class="table">
      <tr>
       <td>
        <c:set var="j" value="0"/>
        <c:forEach var="i" begin="1" end="57">
          <img src="image/${i }.png" width=50 height=50 data-no="${j }" class="images" title="${names[i-1]}">
          <c:set var="j" value="${j+1 }"/>
        </c:forEach>
       </td>
      </tr>
     </table>
    </div>
    <div style="height:50px"></div>
    <div class="row find">
    
    </div>
  </div>
</body>
</html>










