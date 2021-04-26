<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%--
     1. JSP (요청 => button,a)
     2. FreeBoardController : @GetMapping,@PostMapping => 메소드에서 전송된 데이터 매개변수로 받는다 
     3. freeboard-mapper.xml (SQL)
     4. FreeBoardDAO 처리 
     5. FreeBoardController  => DAO의 메소드 호출 
     6. JSP에서 model로 전송받은 데이터를 출력 
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.board_row{
   margin: 0px auto;
   width:800px;
}
</style>
</head>
<body>
  <div class="wrapper row3 board_row">
   <div style="height:700px">
	    <table class="table">
	     <tr>
	      <th width=20% class="text-center">번호</th>
	      <td width=30% class="text-center">${vo.no }</td>
	      <th width=20% class="text-center">작성일</th>
	      <td width=30% class="text-center"><fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/></td>
	     </tr>
	     <tr>
	      <th width=20% class="text-center">이름</th>
	      <td width=30% class="text-center">${vo.name }</td>
	      <th width=20% class="text-center">조회수</th>
	      <td width=30% class="text-center">${vo.hit }</td>
	     </tr>
	     <tr>
	       <th width=20% class="text-center">제목</th>
	       <td colspan="3">${vo.subject }</td>
	     </tr>
	     <tr>
	       <td class="text-left" valign="top" height="200" colspan="4">
	         <pre style="white-space: pre-wrap;background-color: white;border:none">${vo.content }</pre>
	       </td>
	     </tr>
	     <tr>
	       <td class="text-right" colspan="4">
	         <a href="../board/update.do?no=${vo.no }&page=${page}" class="btn btn-xs btn-success">수정</a>
	         <a href="#" class="btn btn-xs btn-info">삭제</a>
	         <a href="../board/list.do?page=${page }" class="btn btn-xs btn-warning">목록</a>
	       </td>
	     </tr>
	    </table>
    </div>
  </div>
</body>
</html>









