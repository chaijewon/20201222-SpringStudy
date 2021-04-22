<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <nav class="navbar navbar-inverse navbar-top-fixed">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">MVCTotal</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">영화
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="../main/main.do?cno=1">예매순위</a></li>
	          <li><a href="../main/main.do?cno=2">개봉영화</a></li>
	          <li><a href="../main/main.do?cno=3">박스오피스(주간)</a></li>
	          <li><a href="../main/main.do?cno=4">박스오피스(월간)</a></li>
	          <li><a href="../main/main.do?cno=5">박스오피스(년간)</a></li>
	          <li><a href="../main/main.do?cno=6">현재상영영화</a></li>
	          <li><a href="../main/main.do?cno=7">개봉영화</a></li>
	          <li><a href="../main/main.do?cno=8">넷플릭스(종료예정)</a></li>
	          <li><a href="../main/main.do?cno=9">넷플릭스(공개예정)</a></li>
	        </ul>
	      </li>
	      <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">레시피
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="#">레시피</a></li>
	          <li><a href="#">쉐프</a></li>
	        </ul>
	      </li>
	      <li><a href="../food/list.do">맛집</a></li>
	      <li><a href="../music/list.do">뮤직</a></li>
	    </ul>
	  </div>
	</nav>
</body>
</html>