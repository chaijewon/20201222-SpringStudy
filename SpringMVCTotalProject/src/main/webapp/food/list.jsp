<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row {
  margin: 0px auto;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.cate_img').css("cursor","pointer");
	$('.cate_img').click(function(){
		let no=$(this).attr("value");
		$.ajax({
		   type:'POST',
		   url:'../food/food_list.do',
		   data:{"no":no},
		   success:function(result)
		   {
			   //alert(result);
			   let json=JSON.parse(result);//[{키:값,키:값},{},{},{}]
			   let html="";
			   for(let i=0;i<json.length;i++)
			   {
				   html+='<table class="table">'
					        +'<tr>'
					        +'<td width=30% rowspan="3" class="text-center">'
					        +'<a href="../food/food_detail.do?no='+json[i].no+'"><img src="'+json[i].poster+'" style="width:100%;height:180px"></a>'
					        +'</td>'
					        +'<td width=70%>'
					        +'<h3><a href="../food/food_detail.do?no='+json[i].no+'">'+json[i].title+'</a>&nbsp;<span style="color:orange">'+json[i].score+'</span></h3>'
					        +'</td>'
					        +'</tr>'
					        +'<tr>'
					        +'<td width=70%>'+json[i].address+'</td>'
					        +'</tr>'
					        +'<tr>'
					        +'<td style="height:50px"></td>'
					        +'</tr>'
				       +'</table>';
			   }
			   $('#cateFood').html(html);
		   }
		})
	})
})
</script>
</head>
<body>
  <div class="container-fluid">
    <div class="row">
     <div class="text-center">
       <a href="../food/list.do?no=1" class="btn btn-lg btn-primary">믿고 보는 맛집 리스트</a>
       <a href="../food/list.do?no=2" class="btn btn-lg btn-danger">지역별 인기 맛집</a>
       <a href="../food/list.do?no=3" class="btn btn-lg btn-success">메뉴별 인기 맛집</a>
     </div>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <div class="col-sm-6">
	      <c:forEach var="vo" items="${list }">
		       <div class="col-md-4">
			    <div class="thumbnail">
			        <img src="${vo.poster }" alt="Lights" style="width:100%" class="cate_img" value="${vo.no }">
			        <div class="caption">
			          <p>${vo.title }</p>
			        </div>
			    </div>
		      </div>
	      </c:forEach>
      </div>
      <div class="col-sm-6">
        <table class="table">
          <tr>
            <td class="text-center" id="cateFood">
             
            </td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</body>
</html>








