<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
       참조 컬럼이 있는 경우 
       => 참조하고 있는 데이터(댓글)가 있는 경우에는 먼저 삭제하고 => 나중에 게시물을 삭제 
       => 1) 댓글은 삭제 => 게시물은 오류시에 삭제가 안된다 
       => 2) 댓글은 삭제 안됨 => 게시물만 삭제 
       => 댓글과 게시물을 동시에 처리 => 일괄처리 (트랙잭션 프로그램) => 스프링 트랜잭션 프로그램은 AOP
 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>