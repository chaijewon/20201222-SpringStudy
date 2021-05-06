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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#findBtn').click(function(){
		let fd=$('#fd').val();
		let ss=$('#ss').val();
		if(ss.trim()=="")
		{
			$('#ss').focus();
			return;
		}
		$.ajax({
			type:'post',
			url:'find_ok.do',
			data:{"fd":fd,"ss":ss},
			success:function(result)
			{
				let json=JSON.parse(result);
				let jsonData='';
				for(let i=0;i<json.length;i++)
				{
					jsonData+='<div class="col-md-3">'
							  +'<div class="thumbnail">'
						      +'<img src="'+json[i].poster+'" style="width:100%">'
						      +'<div class="caption">'
						      +'<p>'+json[i].title+'</p>'
						      +'<p>'+json[i].chef+'</p>'
						      +'</div>'
						      +'</div>'
						      +'</div>'
				}
				$('#print').html(jsonData)
			}
		})
	})
})
</script>
</head>
<body>
   <div style="height: 30px"></div>
   <div class="container-fluid">
     <div class="row">
      <!-- <form method=post action="find_ok.do"> -->
       <table class="table">
         <tr>
          <td>
           <select id="fd" class="input-sm">
             <option value="T">제목</option>
             <option value="C">쉐프</option>
             <option value="TC">제목+쉐프</option>
           </select>
           <input type=text id=ss class="input-sm" size=15>
           <input type=button class="btn btn-sm btn-danger" id="findBtn" value="검색">
          </td>
         </tr>
       </table>
      <!-- </form> -->
     </div>
     <div class="row" id="print">
       <%-- <c:if test="${list!=null }">
        <c:forEach var="vo" items="${list }">
         <div class="col-md-3">
		    <div class="thumbnail">
		        <img src="${vo.poster }" style="width:100%">
		        <div class="caption">
		          <p>${vo.title }</p>
		          <p>by ${vo.chef }</p>
		        </div>
		    </div>
		  </div>
         </c:forEach>
       </c:if> --%>
     </div>
   </div>
</body>
</html>





