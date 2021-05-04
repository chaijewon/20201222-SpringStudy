<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  $(function(){
	  $.ajax({
		  type:'get',
		  url:'recipe_list.do',
		  success:function(result)
		  {
			  let json=JSON.parse(result);
			  $('#count').text(json[0].count);
			  let recipeData="";
			  for(let i=0;i<json.length;i++)
			  {
				  recipeData+='<div class="col-md-4">'
				    +'<div class="thumbnail">'
				    +'<span>'
				    +'<img src="'+json[i].poster+'" title="'+json[i].chef+'" style="width:100%" onclick=detail('+json[i].no+')>'
				    +'<div class="caption">'
				    +'<p>'+json[i].title.substring(0,15)+'</p>'
				    +'</div>'
				    +'</span>'
				    +'</div>'
				    +'</div>'
			  }
			  $('.list_row').html(recipeData);
			  
			  let startPage=json[0].startPage;
			  let endPage=json[0].endPage;
			  let BLOCK=json[0].BLOCK;
			  let totalpage=json[0].totalpage;
			  let curpage=json[0].curpage;
			  /*
			       <ul class="pagination">
					  <li><a href="#">1</a></li>
					  <li class="active"><a href="#">2</a></li>
					  <li><a href="#">3</a></li>
					  <li><a href="#">4</a></li>
					  <li><a href="#">5</a></li>
					</ul>
			  */
			  let pageData='<ul class="pagination">';
			  if(startPage>1)
			  {
				  pageData+='<li><a href=javascript:pagePrint("start",'+startPage+')>&lt;</a></li>'
			  }
			  for(var i=startPage;i<=endPage;i++)
			  {
				    let type="";
				    if(i==curpage)
				    	type="class=active";
				    else
				    	type="";
				    pageData+='<li '+type+'><a href=javascript:pagePrint("real",'+i+')>'+i+'</a></li>'
			  }
			  if(endPage<totalpage)
			  {
				  pageData+='<li><a href=javascript:pagePrint("end",'+endPage+')>&gt;</a></li>'
			  }
			  pageData+="</ul>";
			  
			  $('#page-data').html(pageData);
		  }
	  })
  })
  function pagePrint(type,page)
  {
	  let s=0;
	  if(type=="start")
		  s=page-1;
	  else if(type=="real")
		  s=page;
	  else if(type=="end")
		  s=page+1;
	  
	  $.ajax({
		  type:'get',
		  url:'recipe_list.do',
		  data:{"page":s},
		  success:function(result)
		  {
			  let json=JSON.parse(result);
			  $('#count').text(json[0].count);
			  let recipeData="";
			  for(let i=0;i<json.length;i++)
			  {
				  recipeData+='<div class="col-md-4">'
				    +'<div class="thumbnail">'
				    +'<span>'
				    +'<img src="'+json[i].poster+'" title="'+json[i].chef+'" style="width:100%" onclick=detail('+json[i].no+')>'
				    +'<div class="caption">'
				    +'<p>'+json[i].title.substring(0,15)+'</p>'
				    +'</div>'
				    +'</span>'
				    +'</div>'
				    +'</div>'
			  }
			  $('.list_row').html(recipeData);
			  
			  let startPage=json[0].startPage;
			  let endPage=json[0].endPage;
			  let BLOCK=json[0].BLOCK;
			  let totalpage=json[0].totalpage;
			  let curpage=json[0].curpage;
			  /*
			       <ul class="pagination">
					  <li><a href="#">1</a></li>
					  <li class="active"><a href="#">2</a></li>
					  <li><a href="#">3</a></li>
					  <li><a href="#">4</a></li>
					  <li><a href="#">5</a></li>
					</ul>
			  */
			  let pageData='<ul class="pagination">';
			  if(startPage>1)
			  {
				  pageData+='<li><a href=javascript:pagePrint("start",'+startPage+')>&lt;</a></li>'
			  }
			  for(var i=startPage;i<=endPage;i++)
			  {
				    let type="";
				    if(i==curpage)
				    	type="class=active";
				    else
				    	type="";
				    pageData+='<li '+type+'><a href=javascript:pagePrint("real",'+i+')>'+i+'</a></li>'
			  }
			  if(endPage<totalpage)
			  {
				  pageData+='<li><a href=javascript:pagePrint("end",'+endPage+')>&gt;</a></li>'
			  }
			  pageData+="</ul>";
			  
			  $('#page-data').html(pageData);
		  }
	  })
  }
  function detail(no)
  {
	  $.ajax({
		  type:'get',
		  url:'detail.do',
		  data:{"no":no},
		  success:function(result)
		  {
			  let json=JSON.parse(result);
			  $('#poster').attr("src",json.poster);
			  $('#title').text(json.title);
			  $('#content').text(json.content);
			  $('#info1').text(json.info1);
			  $('#info2').text(json.info2);
			  $('#info3').text(json.info3);
			  $('#chef').html('<img src='+json.chef_poster+' width=30 height=30>'
					         +'<span>'+json.chef+'</span>');
			  let ss=json.food_make.split("\n");
			  let kk='<ul style="list-style-type:none">'
			  for(var i=0;i<ss.length;i++)
			  {
				  kk+='<li>'+ss[i]+'</li>';
			  }
			  kk+='</ul>';
			  $('#make').html(kk);
			  
			  $('#recipe_detail').show();
		  }
	  })
  }
  </script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">RestController예제</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">세프</a></li>
      <li><a href="#">뉴스</a></li>
    </ul>
    <form class="navbar-form navbar-left" action="/action_page.php">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
  </div>
</nav>

<div class="container-fluid">
  <h3>총 <span id="count" style="font-size: 30px;color:orange"></span>개의 맛있는 레시피가 있습니다.</h3>
   <div class="col-sm-8">
     <div class="row list_row">
     
     </div>
     <div class="row">
       <div id="page-data" class="text-center">
       
       </div>
     </div>  
   </div>
   <div class="col-sm-4">
      <div id="recipe_detail" style="display:none">
       <table class="table">
        <tr>
         <td class="text-center">
          <img src="" id="poster" width="100%">
         </td>
        </tr>
        <tr>
         <td class="text-center" style="color:red" id="title"></td>
        </tr>
        <tr>
         <td class="text-center" id="content"></td>
        </tr>
       </table>
       <table class="table">
         <tr>
          <td class="text-center" id="info1"></td>
          <td class="text-center" id="info2"></td>
          <td class="text-center" id="info3"></td>
         </tr>
         <tr>
           <td colspan="3" id="make">
             
           </td>
         </tr>
         <tr>
           <td colspan="3" class="text-center" id="chef">
           
           </td>
         </tr>
       </table>
      </div>
   </div>
</div>
</body>
</html>







