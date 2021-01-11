<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to Spring Security Project</h1>
	<p>
		User  : <security:authentication property="principal.username"/>
		<br><br>
		Role  : <security:authentication property="principal.authorities"/> 
	</p>
	<security:authorize access = "hasRole('MANAGER')">
	<hr>
		<p>
			<a href ="${pageContext.request.contextPath}/leaders"> LeaderShip meetings </a>
		</p>
	</security:authorize>
	<security:authorize access = "hasRole('ADMIN')">
	<hr>
		<p>
			<a href ="${pageContext.request.contextPath}/systems"> Only for Admin peeps</a>
		</p>
	</security:authorize>
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<!-- Check for login error -->
		<div style="margin-top: 10px" class="form-group">
			<div class="col-sm-6 controls">
				<button type="submit" class="btn btn-success">Logout</button>
			</div>
		</div>
	</form:form>
</body>
</html>