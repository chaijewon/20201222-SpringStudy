<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row_join{
  margin: 0px auto;
  width:780px;
}
h3{
   text-align: center;
}
</style>
</head>
<body>
    <div class="row row_join">
      <h3>회원가입</h3>
      <form:form method="post" modelAttribute="memberVO">
	      <table class="table">
	        <tr>
	         <th width=15% class="text-right danger">ID</th>
	         <td width=55%>
	           <form:input path="id" size="15" class="input-sm"/>
	           <input type="button" class="btn btn-sm btn-primary" value="중복체크">
	         </td>
	         <td width="30%">
	           <form:errors path="id"/>
	         </td>
	        </tr>
	        
	        <tr>
	         <th width=15% class="text-right danger">Password</th>
	         <td width=55%>
	           <form:input path="pwd" size="15" class="input-sm"/>
	           <input type="pwd1" size=15 class="input-sm" placeholder="비밀번호 재입력">
	         </td>
	         <td width="30%">
	           <form:errors path="pwd"/>
	         </td>
	        </tr>
	        
	        <tr>
	         <th width=15% class="text-right danger">이름</th>
	         <td width=55%>
	           <form:input path="name" size="15" class="input-sm"/>
	         </td>
	         <td width="30%">
	           <form:errors path="name"/>
	         </td>
	        </tr>
	        
	        <tr>
	         <th width=15% class="text-right danger">성별</th>
	         <td width=55%>
	           <form:radiobutton path="sex" value="남자"/>남자
	           <form:radiobutton path="sex" value="여자"/>여자
	         </td>
	         <td width="30%">
	           <form:errors path="sex"/>
	         </td>
	        </tr>
	        
	        <tr>
	         <th width=15% class="text-right danger">이메일</th>
	         <td width=55%>
	           <form:input path="email" size="35" class="input-sm"/>
	         </td>
	         <td width="30%">
	           <form:errors path="email"/>
	         </td>
	        </tr>
	        
	        <tr>
	         <th width=15% class="text-right danger">우편번호</th>
	         <td width=55%>
	           <form:input path="post" size="10" class="input-sm"/>
	           <input type="button" class="btn btn-sm btn-primary" value="검색">
	         </td>
	         <td width="30%">
	           <form:errors path="post"/>
	         </td>
	        </tr>
	        
	        <tr>
	         <th width=15% class="text-right danger">주소</th>
	         <td width=55%>
	           <form:input path="addr1" size="35" class="input-sm"/>
	         </td>
	         <td width="30%">
	           <form:errors path="addr1"/>
	         </td>
	        </tr>
	        
	        <tr>
	         <th width=15% class="text-right danger">상세주소</th>
	         <td width=55%>
	           <form:input path="addr2" size="35" class="input-sm"/>
	         </td>
	         <td width="30%">
	           <form:errors path="addr2"/>
	         </td>
	        </tr>
	        
	        <tr>
	         <th width=15% class="text-right danger">전화번호</th>
	         <td width=55%>
	           <form:input path="tel" size="15" class="input-sm"/>
	         </td>
	         <td width="30%">
	           <form:errors path="tel"/>
	         </td>
	        </tr>
	        
	        <tr>
	         <td colspan="3" class="text-center">
	           <input type=submit value="회원가입" class="btn btn-sm btn-info">
	           <input type=button value="취소" class="btn btn-sm btn-success"
	             onclick="javascript:history.back()">
	         </td>
	        </tr>
	      </table>
      </form:form>
    </div>
</body>
</html>











