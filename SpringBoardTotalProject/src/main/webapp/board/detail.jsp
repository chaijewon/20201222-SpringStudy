<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
  width:800px;
  margin: 0px auto;
}
h1 {
  text-align: center;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let u=0;
let i=0;
$(function(){
	$('.updateBtn').click(function(){
		$('.updates').hide();
		$('.inserts').hide();
		let no=$(this).attr("data-no");
		if(u==0)
		{
			$('#m'+no).show();
			$(this).text("취소");
			u=1;
		}
		else
		{
			$('#m'+no).hide();
			$(this).text("수정");
			u=0;
		}
	})
	$('.insertBtn').click(function(){
		$('.updates').hide();
		$('.inserts').hide();
		let no=$(this).attr("data-no");
		if(i==0)
		{
			$(this).text("취소");
			$('#in'+no).show();
			i=1;
		}
		else
		{
			$(this).text("댓글");
			$('#in'+no).hide();
			i=0;
		}
	});
})
</script>
</head>
<body>
   <div style="height:50px"></div>
   <div class="container">
    <h1>내용보기</h1>
    <div class="row">
     <table class="table">
       <tr>
        <th width=20% class="danger text-center">번호</th>
        <td width=30% class="text-center">${vo.no }</td>
        <th width=20% class="danger text-center">작성일</th>
        <td width=30% class="text-center"><fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/></td>
       </tr>
       <tr>
        <th width=20% class="danger text-center">이름</th>
        <td width=30% class="text-center">${vo.name}</td>
        <th width=20% class="danger text-center">조회수</th>
        <td width=30% class="text-center">${vo.hit }</td>
       </tr>
       <tr>
         <th width=20% class="danger text-center">제목</th>
         <td colspan="3">${vo.subject}</td>
       </tr>
       <tr>
         <td colspan="4" height="200" valign="top" class="text-left">
          <pre style="white-space: pre-wrap;border:none;background-color:white">${vo.content }</pre>
         </td>
       </tr>
       <tr>
         <td colspan="4" class="text-right">
           <a href="update.do?no=${vo.no }&page=${page}" class="btn btn-xs btn-success">수정</a>
           <a href="delete.do?no=${vo.no }&page=${page}" class="btn btn-xs btn-warning">삭제</a>
           <a href="list.do?page=${page }" class="btn btn-xs btn-info">목록</a>
         </td>
       </tr>
     </table>
    </div>
    <div style="height: 30px"></div>
    <div class="row">
      <c:forEach var="rvo" items="${rList }">
       <table class="table">
        <tr>
          <td class="text-left">
           <c:if test="${rvo.group_tab>0 }">
             <c:forEach var="i" begin="1" end="${rvo.group_tab }">
               &nbsp;&nbsp;
             </c:forEach>
             <img src="re_icon.png">
           </c:if>
                       ◐${rvo.name }(${rvo.dbday })
          </td>
          <td class="text-right">
            <c:if test="${sessionScope.id!=null }">
              <c:if test="${sessionScope.id==rvo.id }">
                <span class="btn btn-xs btn-success updateBtn" data-no="${rvo.no }">수정</span>
                <a href="reply_delete.do?no=${rvo.no }&bno=${vo.no}&page=${page}" class="btn btn-xs btn-info">삭제</a>
              </c:if>
              <span class="btn btn-xs btn-danger insertBtn" data-no="${rvo.no }">댓글</span>
            </c:if>
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <c:if test="${rvo.group_tab>0 }">
             <c:forEach var="i" begin="1" end="${rvo.group_tab }">
               &nbsp;&nbsp;
             </c:forEach>
            </c:if>
            <pre style="white-space: pre-wrap;border:none;background-color:white;">${rvo.msg }</pre>
          </td>
        </tr>
        <%--수정 데이터 --%>
           <tr class="updates" style="display:none" id="m${rvo.no }">
	         <td class="text-center" colspan="2">
	          <form method="post" action="reply_update.do">
	           <input type="hidden" name=no value="${rvo.no }">
	           <input type="hidden" name=bno value="${vo.no }">
	           <input type="hidden" name=page value="${page }">
	           <textarea rows="4" cols="95" name="msg" style="float: left">${rvo.msg }</textarea>
	           <button class="btn btn-sm btn-primary" style="height: 80px;float:left">댓글수정</button>
	          </form>
	         </td>
	        </tr>
	     <%-- 댓글올리기 --%>
	       <tr class="inserts" style="display:none" id="in${rvo.no }">
	         <td class="text-center" colspan="2">
	          <form method="post" action="reply_to_reply_insert.do">
	           <input type="hidden" name=pno value="${rvo.no }">
	           <input type="hidden" name=bno value="${vo.no }">
	           <input type="hidden" name=page value="${page }">
	           <textarea rows="4" cols="95" name="msg" style="float: left"></textarea>
	           <button class="btn btn-sm btn-primary" style="height: 80px;float:left">댓글</button>
	          </form>
	         </td>
	        </tr>
       </table>
      </c:forEach>
      <c:if test="${sessionScope.id!=null }">
	      <table class="table">
	        <tr>
	         <td class="text-center">
	          <form method="post" action="reply_insert.do">
	           <input type="hidden" name=bno value="${vo.no }">
	           <input type="hidden" name=page value="${page }">
	           <textarea rows="4" cols="95" name="msg" style="float: left"></textarea>
	           <button class="btn btn-sm btn-primary" style="height: 80px;float:left">댓글쓰기</button>
	          </form>
	         </td>
	        </tr>
	      </table>
      </c:if>
    </div>
   </div>
</body>
</html>














