<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row_login{
  margin: 0px auto;
  width:180px;
}
</style>
</head>
<body>
  <div class="row row_login">
    <table class="table">
     <tr>
      <td width="20%" class="text-right">ID</td>
      <td width=80%>
       <input type="text" name="id" class="input-sm">
      </td>
     </tr>
     <tr>
      <td width="20%" class="text-right">PW</td>
      <td width=80%>
       <input type="password" name="pwd" class="input-sm">
      </td>
     </tr>
     <tr>
       <td colspan="2" class="text-right">
         <input type="button" class="btn btn-sm btn-success" value="로그인">
       </td>
     </tr>
    </table>
  </div>
</body>
</html>