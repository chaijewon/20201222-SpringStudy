<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <center>
    <h1>회원정보</h1>
    <form method=post action="output2.do">
    <table border=1 bordercolor=black width=350>
      <tr>
       <td width=30% align=right>이름</td>
       <td width=70%><input type=text name=name size=15></td>
      </tr>
      <tr>
       <td width=30% align=right>성별</td>
       <td width=70%><input type=text name=sex size=15></td>
      </tr>
      <tr>
       <td width=30% align=right>주소</td>
       <td width=70%><input type=text name=addr size=15></td>
      </tr>
      <tr>
       <td width=30% align=right>전화</td>
       <td width=70%><input type=text name=tel size=15></td>
      </tr>
      <tr>
       <td width=30% align=right>나이</td>
       <td width=70%><input type=text name=age size=15></td>
      </tr>
      <tr>
        <td colspan=2 align=center>
         <input type=submit value="전송">
        </td>
      </tr>
    </table>
    </form>
  </center>
</body>
</html>