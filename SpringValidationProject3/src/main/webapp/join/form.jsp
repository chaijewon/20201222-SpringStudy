<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="formData" method="POST">
  <p>
    <label>ID<br>
    <form:input path="id"/>
    <form:errors path="id"/>
  </p>
  <p>
    <label>Password<br>
    <form:input path="pwd"/>
    <form:errors path="pwd"/>
  </p>
  <p>
    <label>Name<br>
    <form:input path="name"/>
    <form:errors path="name"/>
  </p>
  <p>
    <label>Age<br>
    <form:input path="age"/>
    <form:errors path="age"/>
  </p>
  <p>
    <label>Email<br>
    <form:input path="email"/>
    <form:errors path="email"/>
  </p>
  <input type="submit" value="전송">
</form:form>
</body>
</html>