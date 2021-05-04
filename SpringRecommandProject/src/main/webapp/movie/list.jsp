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

h1 {
  text-align: center;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.category').click(function(){
		let no=$(this).attr("data-no");
		$.ajax({
	       type:'post',
	       url:'category_sub.do',
	       data:{"no":Number(no)},
	       success:function(result)
	       {
	    	   let json=JSON.parse(result);
	    	   let html="";
	    	   for(let i=0;i<json.length;i++)
	    	   {
	    		   html+='<td class="text-center"><span class="btn btn-sm btn-danger" onclick=recommand("'+json[i].subject+'")>'+json[i].subject+'</span></td>';
	    	   }
	    	   $('#subject').html(html);
	       }
		})
	})
})
function recommand(rdata)
{
	$.ajax({
		type:'POST',
		url:'recommand_data.do',
		data:{"fd":rdata},
		success:function(result)
		{
			let json=JSON.parse(result);
			let html="";
			for(let i=0;i<json.length;i++)
			{
				html+='<div class="col-md-3">'
			          +'<div class="thumbnail">'
			          +'<img src="'+json[i].poster+'" alt="Lights" style="width:100%">'
			          +'<div class="caption">'
			          +'<p>'+json[i].title+'</p>'
			          +'</div>'
			          +'</div>'
			          +'</div>'
			}
			
			$('#blog').html(html)
		}
	})
}
</script>
</head>
<body>
   <div style="height: 30px"></div>
   <div class="container-fluid">
    <h1>영화 추천(네이버 블로그사용)</h1>
    <div class="col-sm-8">
      <div class="row">
       <div class="text-center">
        <c:set var="i" value="1"/>
        <c:forEach var="cate" items="${category }">
          <span class="btn btn-sm btn-primary category" data-no="${i}">${cate }</span>
          <c:set var="i" value="${i+1 }"/>
        </c:forEach>
       </div>
      </div>
      <div class="row">
       <table class="table">
        <tr id="subject">
         
        </tr>
       </table>
      </div> 
      <div class="row" id="blog">
        
      </div>
    </div>
    <div class="col-sm-4">
      
    </div>
   </div>
</body>
</html>













