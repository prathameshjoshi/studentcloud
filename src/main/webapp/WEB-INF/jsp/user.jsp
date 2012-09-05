<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<title>Spring 3 MVC Series - Contact Manager</title>
	<style type="text/css">
		body {
			font-family: sans-serif;
		}
		.data, .data td {
			border-collapse: collapse;
			width: 100%;
			border: 1px solid #aaa;
			margin: 2px;
			padding: 2px;
		}
		.data th {
			font-weight: bold;
			background-color: #5C82FF;
			color: white;
		}
	</style>
</head>
<body>

<h2>Contact Manager</h2>

<form:form method="post" commandName="user">

	<table>
	<tr>
		<td><form:label path="userid"><spring:message code="label.userid"/></form:label></td>
		<td><form:input path="userid" /></td> 
	</tr>
	<tr>
		<td><form:label path="username"><spring:message code="label.username"/></form:label></td>
		<td><form:input path="username" /></td>
	</tr>
	<tr>
		<td><form:label path="password"><spring:message code="label.password"/></form:label></td>
		<td><form:input path="password" /></td>
	</tr>
	<tr>
		<td><form:label path="enabled"><spring:message code="label.enabled"/></form:label></td>
		<td><form:input path="enabled" /></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="<spring:message code="label.adduser"/>"/>
		</td>
	</tr>
</table>	
</form:form>

	
<h3>Users</h3>
<c:if  test="${!empty userList}">
<table class="data">
<tr>
	<th>UserId</th>
	<th>UserName</th>
	<th>Password</th>
	<th>Enabled</th>
	<th>&nbsp;</th>
</tr>
<c:forEach items="${userList}" var="user">
	<tr>
	  <td>${user.userid}</td>
		<td>${user.username}</td>
		<td>${user.password}</td>
		<td>${user.enabled}</td>
		<td><a href="delete/${user.userid}">delete</a></td>
	</tr>
</c:forEach>
</table>
</c:if>


</body>
</html>
