<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	$.ajax({
		type:'POST',
		url:'movie_list.do',
		success:function(result)
		{
			//alert(result);
			let json=JSON.parse(result);
			let res="";
			for(let i=0;i<json.length;i++)
			{
				res+="<tr>"
				    +"<td>"
				    +"<img src=http://www.kobis.or.kr"+json[i].thumbUrl+" width=30 height=30></td>"
				    +"<td>"+json[i].movieNm+"</td>"
				    +"<td>"+json[i].director+"</td>"
				    +"<td>"+json[i].genre+"</td>"
				    +"<td>"+json[i].watchGradeNm+"</td>"
				    +"</tr>";
			}
			$('#movie_list').html(res);
		}
		
	})
	$('.buttons').click(function(){
		let no=$(this).attr("value");
		$.ajax({
			type:'POST',
			url:'movie_list.do',
			data:{"no":no},
			success:function(result)
			{
				//alert(result);
				let json=JSON.parse(result);
				let res="";
				for(let i=0;i<json.length;i++)
				{
					res+="<tr>"
					    +"<td>"
					    +"<img src=http://www.kobis.or.kr"+json[i].thumbUrl+" width=30 height=30></td>"
					    +"<td>"+json[i].movieNm+"</td>"
					    +"<td>"+json[i].director+"</td>"
					    +"<td>"+json[i].genre+"</td>"
					    +"<td>"+json[i].watchGradeNm+"</td>"
					    +"</tr>";
				}
				$('#movie_list').html(res);
			}
			
		})
	})
})
</script>
</head>
<body>
  <div style="height: 30px"></div>
  <div class="container-fluid">
    <h1 id="type">영화 목록</h1>
    <div class="row">
      <div class="text-center">
        <span value="1" class="btn btn-sm btn-success buttons">일일 박스오피스</span>
        <span value="2" class="btn btn-sm btn-danger buttons">실시간 예매율</span>
        <span value="3" class="btn btn-sm btn-info buttons">좌석점유율순위</span>
        <span value="4" class="btn btn-sm btn-warning buttons">온라인상영관 일일</span>
      </div>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <div class="col-sm-6">
        <table class="table"></table>
      </div>
      <div class="col-sm-6">
        <table class="table">
         <thead>
	         <tr class="danger">
	          <th class="text-center"></th>
	          <th class="text-center">영화명</th>
	          <th class="text-center">감독</th>
	          <th class="text-center">장르</th>
	          <th class="text-center">등급</th>
	         </tr>
         </thead>
         <tbody id="movie_list">
         
         </tbody>
        </table>
      </div>
    </div>
  </div>
</body>
</html>















