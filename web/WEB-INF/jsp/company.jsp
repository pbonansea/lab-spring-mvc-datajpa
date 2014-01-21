<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN""http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>companies form</title>
</head>
<body>
	<h1>list compamnies</h1>
	<ul>
		<c:forEach var="company" items="${listCompany}">
			<li>${company.name}
				<form method="post"
					action="<c:url value='/delete.xhtml?id=${company.id}'/>">
					<input type="submit" name="delete" value="delete" />
				</form>
			</li>
		</c:forEach>
	</ul>

	<h3>new company</h3>
	<form:form method="POST" commandName="company"
		action="create.xhtml">
		<table>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
		</table>
		<input type="submit" name="submit" value="submit" />
	</form:form>

</body>

</html>
