<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row {
  width: 900px;
  margin: 0px auto;
}
</style>
</head>
<body>
   <div style="height: 50px"></div>
   <div class="container">
     <h1 class="text-center">사원 목록</h1>
     <div class="row">
      <table class="table">
        <tr class="success">
         <th class="text-center">사번</th>
         <th class="text-center">이름</th>
         <th class="text-center">직위</th>
         <th class="text-center">사수</th>
         <th class="text-center">입사일</th>
         <th class="text-center">급여</th>
         <th class="text-center">상과급</th>
         <th class="text-center">부서번호</th>
         <th class="text-center">부서명</th>
         <th class="text-center">근무지</th>
        </tr>
        <c:forEach var="vo" items="${list }">
          <tr>
             <td class="text-center">${vo.empno }</td>
	         <td class="text-center"><a href="detail.do?empno=${vo.empno }">${vo.ename }</a></td>
	         <td class="text-center">${vo.job }</td>
	         <td class="text-center">${vo.mgr }</td>
	         <td class="text-center"><fmt:formatDate value="${vo.hiredate }" pattern="yyyy-MM-dd"/></td>
	         <td class="text-center">${vo.sal }</td>
	         <td class="text-center">${vo.comm }</td>
	         <td class="text-center">${vo.deptno }</td>
	         <td class="text-center">${vo.dvo.dname }</td>
	         <td class="text-center">${vo.dvo.loc }</td>
          </tr>
        </c:forEach>
      </table>
     </div>
     <div class="row">
      <form method="POST" action="find.do">
      <table class="table">
        <caption>검색</caption>
        <tr>
          <td>
            <c:forEach var="vo" items="${list }">
             <input type="checkbox" name="names" value="${vo.ename }">${vo.ename }
            </c:forEach> 
          </td>
        </tr>
        <tr>
          <td class="text-center">
           <button class="btn btn-sm btn-info">검색</button>
          </td>
        </tr>
      </table>
      </form>
     </div>
   </div>
</body>
</html>









