<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		<c:out value="${message}" />

	</p>
<!--出力側  -->
	<c:if test="${not empty userInfoFormList}">
		<table border="1">
			<tr>
				<th>名前</th><th>年齢</th><th>性別</th><th>E-mail</th><th>出身地</th><th>好きな言語</th>
			</tr>
			<!-- userInfoFormの中にいくつformがあるか　その個数分ループ -->
			<c:forEach var="userInfoForm" items="${userInfoFormList}">
				<tr>
					<td><c:out value="${userInfoForm.name}"></c:out></td>
					<td><c:out value="${userInfoForm.age}"></c:out></td>
					<td><c:out value="${userInfoForm.gender}"></c:out></td>
					<td><c:out value="${userInfoForm.email}"></c:out></td>
					<td><c:out value="${userInfoForm.birthplaces}"></c:out></td>
					<td><c:out value="${userInfoForm.favoriteLangs}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
		<br>
	</c:if>
	
	
<!--入力側  -->
                                <!-- ユーザの入力情報全部 -->
	<form:form modelAttribute="userInfoForm">
	　　　　　　　　　　　　　　　　
	<br />
	名前:<form:input path="name" placeholder="名前を入力してください" />
		<form:errors path="name"></form:errors>
		<br />
	年齢:<form:input path="age" placeholder="0" />
	     <form:errors path="age"></form:errors>
		<br />
	性別:<form:radiobuttons path="gender" items="${genders}"/>
	    <br />
	E-mail:<form:input path="email" />
	    <form:errors path="email"></form:errors>
	    <br />    
	出身地:<form:select path="birthplaces" items="${birthplaces}" multiple="false"/>
	    <br />
	好きな言語:<form:checkboxes path="favoriteLangs" items="${favoriteLangs}"/>
	    <br />
		<input type="submit" value="送信">
		<br />
	</form:form>

</body>
</html>