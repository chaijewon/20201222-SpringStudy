<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form method=post action="output.do">
     <input type=text value="홍길동" name="list[0]"><br>
     <input type=text value="심청이" name="list[1]"><br>
     <input type=text value="박문수" name="list[2]"><br>
     <input type=text value="춘향이" name="list[3]"><br>
     <input type=text value="이순신" name="list[4]"><br>
     <input type=submit value="전송">
   </form>
</body>
</html>