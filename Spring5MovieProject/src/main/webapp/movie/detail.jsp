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
  margin: 0px auto;
  width:800px;
}
h1 {
  text-align: center;
}
</style>
</head>
<body>
  <div style="height:50px"></div>
  <div class="container">
    <h1>영화상세보기</h1>
    <div class="row">
      <table class="table">
       <tr>
         <td>
          <iframe src="http://youtube.com/embed/${vo.key }" width="800" height="350"></iframe>
         </td>
       </tr>
      </table>
      <table class="table">
        <tr>
          <td width="30%" class="text-center" rowspan="7">
           <img src="${vo.poster }" width="100%">
          </td>
          <td colspan="2"><span style="color:orange">${vo.title }</span></td>
        </tr>
        <tr>
          <td width=15% class="text-right">국가</td>
          <td width=55%>${vo.nation }</td>
        </tr>
        <tr>
          <td width=15% class="text-right">장르</td>
          <td width=55%>${vo.genre }</td>
        </tr>
        <tr>
          <td width=15% class="text-right">등급</td>
          <td width=55%>${vo.grade }</td>
        </tr>
        <tr>
          <td width=15% class="text-right">누적관객</td>
          <td width=55%>${vo.showUser }</td>
        </tr>
        <tr>
          <td width=15% class="text-right">박스오피스</td>
          <td width=55%>${vo.boxOffice }</td>
        </tr>
        <tr>
          <td width=15% class="text-right">평점</td>
          <td width=55%>${vo.score }</td>
        </tr>
        <tr>
          <td colspan="3">
           ${vo.story }
          </td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>







