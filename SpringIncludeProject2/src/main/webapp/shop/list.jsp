<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row_shop{
  margin: 0px auto;
  width:800px;
}
</style>
</head>
<body>
  <div class="row row_shop">
    <div class="text-center">
     <a href="../shop/list.do?cno=45" class="btn btn-lg btn-success">냉동/가공식품</a>
     <a href="../shop/list.do?cno=59" class="btn btn-lg btn-info">건강식품</a>
     <a href="../shop/list.do?cno=83" class="btn btn-lg btn-warning">기타식품</a>
     <a href="../shop/list.do?cno=60" class="btn btn-lg btn-danger">소스류</a>
    </div>
  </div>
  <div style="height: 10px"></div>
  <div class="row row_shop">
    <c:forEach var="vo" items="${list }">
     <div class="col-md-4">
	    <div class="thumbnail">
	      <a href="detail.do?no=${vo.no }">
	        <img src="${vo.poster }" style="width:260px;height: 250px">
	        <div class="caption">
	          <p>${vo.title }</p>
	          <p class="text-right">${vo.price }</p>
	        </div>
	      </a>
	    </div>
	  </div>
    </c:forEach>
  </div>
  <div class="row row_shop">
    <div class="text-center">
     <a href="../shop/list.do?cno=${cno }&page=${curpage>1?curpage-1:curpage}" class="btn btn-sm btn-danger">이전</a>
     ${curpage } page / ${totalpage } pages
     <a href="../shop/list.do?cno=${cno }&page=${curpage<totalpage?curpage+1:curpage}" class="btn btn-sm btn-danger">다음</a>
    </div>
  </div>
</body>
</html>







