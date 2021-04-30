<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="js/js/jquery.easing.1.3.js"></script>
<script type="text/javascript">
$(function() {

	//Custom settings
	var style_in = 'easeOutBounce';
	var style_out = 'jswing';
	var speed_in = 1000;
	var speed_out = 300;


	//Calculation for corners
	var neg = Math.round($('.qitem').width() / 2) * (-1);
	var pos = neg * (-1);
	var out = pos * 2;
	
	var wneg = Math.round($('.qitem').width() / 2) * (-1);
	var wpos = wneg * (-1);
	
	var hneg = Math.round($('.qitem').height() / 2) * (-1);
	var hpos = hneg * (-1);
	
	$('.qitem').each(function () {
	
		url = $(this).find('a').attr('href');
		img = $(this).find('img').attr('src');
		alt = $(this).find('img').attr('img');
		
		$('img', this).remove();
		$(this).append('<div class="topLeft"></div><div class="topRight"></div><div class="bottomLeft"></div><div class="bottomRight"></div>');
		$(this).children('div').css('background-image','url('+ img + ')');
		$(this).children('div').css('background-size','350px 180px');

		$(this).find('div.topLeft').css({top:0, left:0, width:wpos , height:hpos});	
		$(this).find('div.topRight').css({top:0, left:wpos, width:wpos , height:hpos});	
		$(this).find('div.bottomLeft').css({bottom:0, left:0, width:wpos , height:hpos});	
		$(this).find('div.bottomRight').css({bottom:0, left:wpos, width:wpos , height:hpos});	

	}).hover(function () {
	
		$(this).find('div.topLeft').stop(false, true).animate({top:wneg, left:hneg}, {duration:speed_out, easing:style_out});	
		$(this).find('div.topRight').stop(false, true).animate({top:wneg, left:out}, {duration:speed_out, easing:style_out});	
		$(this).find('div.bottomLeft').stop(false, true).animate({bottom:wneg, left:hneg}, {duration:speed_out, easing:style_out});	
		$(this).find('div.bottomRight').stop(false, true).animate({bottom:wneg, left:out}, {duration:speed_out, easing:style_out});	
				
	},
	
	function () {

		$(this).find('div.topLeft').stop(false, true).animate({top:0, left:0}, {duration:speed_in, easing:style_in});	
		$(this).find('div.topRight').stop(false, true).animate({top:0, left:wpos}, {duration:speed_in, easing:style_in});	
		$(this).find('div.bottomLeft').stop(false, true).animate({bottom:0, left:0}, {duration:speed_in, easing:style_in});	
		$(this).find('div.bottomRight').stop(false, true).animate({bottom:0, left:wpos}, {duration:speed_in, easing:style_in});	
	
	}).click (function () {
		window.location = $(this).find('a').attr('href');	
	});	

});
</script>

<style>
    .row{
		  margin: 0px auto;
		}
		h1 {
		  text-align: center;
		}
	.qitem {
		width:350px;
		height:180px;	
		border:2px solid #222;	
		margin:5px 5px 5px 0;
		
		
		/* required to hide the image after resized */
		overflow:hidden;
		
		/* for child absolute position */
		position:relative;
		
		/* display div in line */
		float:left;
		cursor:hand; cursor:pointer;
	}

	.qitem img {
		border:0;
	
		/* allow javascript moves the img position*/
		position:absolute;
		z-index:200;
	}

	.qitem .caption {
		position:absolute;
		z-index:0;	
		color:#ccc;
		display:block;
		height: 100%;
		line-height: 22px;
		width: 100%;
		text-align: center;
		vertical-align: middle;
	}

	.qitem .caption h4 {
		font-size:15px;
		padding:10px 5px 0 8px;
		margin:0;
		color:#369ead;
	}

	.qitem .caption p {
		font-size:12px;	
		padding:3px 5px 0 8px;
		margin:0;
	}


	/* Setting for corners */

	.topLeft, .topRight, .bottomLeft, .bottomRight {
		position:absolute;
		background-repeat: no-repeat; 
		float:left;
	}
	
	.topLeft {
		background-position: top left; 	
	} 
	
	.topRight {
		background-position: top right; 
	} 
	
	.bottomLeft {
		background-position: bottom left; 
	} 
	
	.bottomRight {
		background-position: bottom right; 
	}
	
	.clear {
		clear:both;	
	}
</style>
</head>
<body>
  <div style="height: 50px"></div>
  <div class="container">
    <div class="row">
     <div class="text-right">
      <a href="chef.do" class="btn btn-lg btn-success">쉐프</a>
      <a href="find.do" class="btn btn-lg btn-danger">검색</a>
     </div>
    </div>
    <div class="row">
     <h3>총 <span style="color:orange;font-size:35px"><fmt:formatNumber value="${count }" pattern="000,000"/></span>개의 맛있는 레시피가 있습니다.</h3>
    </div>
    <div class="row">
      <c:set var="i" value="1"/>
      <c:forEach var="vo" items="${list }">
        <div class="qitem">
         <a href="detail.do?no=${vo.no }"><img src="${vo.poster }" style="width:350px;height:180px"></a>
         <span class="caption">
           <h4>${vo.title }</h4>
           <p>${vo.chef }</p>
         </span>
        </div>
        <c:if test="${i%3==0 }">
          <div class="clear"></div>
        </c:if>
        <c:set var="i" value="${ i+1}"/>
      </c:forEach>
    </div>
    <div class="row">
      <div class="text-center">
        <ul class="pagination">
           <li><a href="list.do?page=${startPage>1?startPage-1:startPage}">이전</a></li>
         <c:forEach var="i" begin="${startPage }" end="${endPage }">
           <c:if test="${i==curpage }">
             <c:set var="type" value="class=active"/>
           </c:if>
           <c:if test="${i!=curpage }">
             <c:set var="type" value=""/>
           </c:if>
           <li ${type }><a href="list.do?page=${i }">${i }</a></li>
         </c:forEach>
           <li><a href="list.do?page=${endPage<allPage?endPage+1:endPage}">다음</a></li>
		</ul>
      </div>
    </div>
  </div>
</body>
</html>







