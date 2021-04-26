<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <form method="POST" action="../board/insert_ok.do">
    <table class="table">
     <tr>
       <th class="text-right" width=15%>이름</th>
       <td width="85%">
         <input type=text size=15 class="input-sm" name=name>
       </td>
     </tr>
     <tr>
       <th class="text-right" width=15%>제목</th>
       <td width="85%">
         <input type=text size=50 class="input-sm" name=subject>
       </td>
     </tr>
     <tr>
       <th class="text-right" width=15%>내용</th>
       <td width="85%">
         <textarea rows="10" cols="55" name="content"></textarea>
       </td>
     </tr>
     <tr>
       <th class="text-right" width=15%>비밀번호</th>
       <td width="85%">
         <input type="password" name=pwd size=10 class="input-sm">
       </td>
     </tr>
     <tr>
       <td colspan="2" class="text-center">
         <input type=submit value="글쓰기" class="btn btn-sm btn-primary">
         <input type=button value="취소" class="btn btn-sm btn-primary"
          onclick="javascript:history.back()"
         >
       </td>
       
     </tr>
    </table>
    </form>
    </div>
  </div> 
</body>
</html>







