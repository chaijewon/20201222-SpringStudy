<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
  width: 350px;
  margin: 0px auto;
}
</style>
</head>
<body>
  <div style="height: 50px"></div>
  <div class="container">
   <div class="row">
    <table class="table">
     <tr>
      <th class="danger">사번</th>
      <td>${vo.empno }</td>
     </tr>
     <tr>
      <th class="danger">이름</th>
      <td>${vo.ename }</td>
     </tr>
     <tr>
      <th class="danger">직위</th>
      <td>${vo.job }</td>
     </tr>
     <tr>
      <th class="danger">사수</th>
      <td>${vo.mgr }</td>
     </tr>
     <tr>
      <th class="danger">입사일</th>
      <td><fmt:formatDate value="${vo.hiredate }" pattern="yyyy-MM-dd"/></td>
     </tr>
     <tr>
      <th class="danger">급여</th>
      <td>${vo.sal }</td>
     </tr>
     <tr>
      <th class="danger">성과급</th>
      <td>${vo.comm }</td>
     </tr>
     <tr>
      <th class="danger">부서번호</th>
      <td>${vo.deptno }</td>
     </tr>
     <tr>
      <th class="danger">부서명</th>
      <td>${vo.dvo.dname }</td>
     </tr>
     <tr>
      <th class="danger">근무지</th>
      <td>${vo.dvo.loc }</td>
     </tr>
     <tr>
       <td colspan="2" class="text-right">
        <a href="list.do" class="btn btn-sm btn-danger">목록</a>
       </td>
     </tr>
    </table>
   </div>
  </div>
</body>
</html>








