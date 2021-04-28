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
   <div style="height:50px"></div>
   <div class="container">
     <h1>Login</h1>
     <div class="row">
      <form method="post" action="../member/login_ok.do">
       <table class="table">
        <tr>
         <th class="text-right" width="30%">ID</th>
         <td width="70%"><input type=text name=id size=15 class="input-sm"></td>
        </tr>
        <tr>
         <th class="text-right" width="30%">PW</th>
         <td width="70%"><input type=password name=pwd size=15 class="input-sm"></td>
        </tr>
        <tr>
          <td class="text-center" colspan="2">
           <button class="btn btn-sm btn-primary">로그인</button>
          </td>
        </tr>
       </table>
      </form>
     </div>
   </div>
</body>
</html>













