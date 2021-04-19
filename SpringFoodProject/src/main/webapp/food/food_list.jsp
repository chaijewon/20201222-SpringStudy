<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
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
    <div class="jumbotron">
      <h3 class="text-center">${cvo.title }</h3>
      <h5 class="text-center" style="color:#999">${cvo.subject }</h5>
    </div>
    <div class="row">
     <c:forEach var="vo" items="${list }">
       <table class="table">
        <tr>
          <td width=30% rowspan="3" class="text-center">
            <a href="food_detail.do?no=${vo.no }"><img src="${vo.poster }" style="width:100%;height:180px"></a>
            <%--
                 food_detail.do?no=10
                 
                 => @RequestMapping("food_detail.do")
                    public String food_detail(int no,Model model)
                    
                    public String food_detail(@RequestParam("no") int no,Model model)
                                             ===================== 생략이 가능  => 
                 => @GetMapping("food_detail.do")  ==> 4.3이상 
                    public String food_detail(int no,Model model)
             --%>
          </td>
          <td width=70%>
           <h3><a href="food_detail.do?no=${vo.no }">${vo.title }</a>&nbsp;<span style="color:orange">${vo.score }</span></h3>
          </td>
        </tr>
        <tr>
          <td width=70%>${vo.address }</td>
        </tr>
        <tr>
          <td style="height:50px"></td>
        </tr>
       </table>
     </c:forEach>
    </div>
  </div>
</body>
</html>










