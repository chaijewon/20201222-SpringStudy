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
  width:350px;
  margin: 0px auto;
}
h1 {
  text-align: center;
}
</style>
</head>
<body>
   <div style="height: 50px"></div>
   <div class="container">
    <h1>삭제하기</h1>
    <div class="row">
     <form method="post" action="delete_ok.do">
	     <table class="table">
	      <tr>
	       <td class="text-center">
	       비밀번호:<input type="password" name=pwd size=15 class="input-sm">
	       <input type=hidden name=no value="${no }">
	       <input type=hidden name=page value="${page }">
	       </td>
	      </tr>
	      <tr>
	        <td class="text-center">
	         <button class="btn btn-sm btn-info">삭제</button>
	         <input type=button value="취소" class="btn btn-sm btn-success"
	          onclick="javascript:history.back()">
	        </td>
	      </tr>
	     </table>
     </form>
    </div>
   </div>
</body>
</html>














