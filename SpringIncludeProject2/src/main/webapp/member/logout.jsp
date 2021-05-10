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
      <td class="text-right">${sessionScope.name }님 로그인되었습니다</td>
     </tr>
     <tr>
      <td>
            쪽지(3)&nbsp;이메일(3)
      </td>
     </tr>
     <tr>
       <td class="text-right">
        <form method="post" action="../member/logout_ok.do">
         <input type="submit" class="btn btn-sm btn-success" value="로그아웃">
        </form>
       </td>
     </tr>
    </table>
  </div>
</body>
</html>