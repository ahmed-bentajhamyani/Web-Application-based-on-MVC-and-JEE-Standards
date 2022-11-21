<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Mini Market Application</title>
</head>
<body>
	<center>
		<h2>
			<a href="/Atelier1/article?action=list">List of Articles</a>
			&nbsp;&nbsp;&nbsp; <a href="/Atelier1/commande?action=list">List of
				Commandes</a> &nbsp;&nbsp;&nbsp; <a href="/Atelier1/client?action=list">List
				of Clients</a> &nbsp;&nbsp;&nbsp; <a href="/Atelier1/lignecmd?action=list">List
				of Ligne Commandes</a>
		</h2>
		<h1>Commande Management</h1>
		<h2>
			<a href="/Atelier1/commande?action=new">Add New Commande</a>
			&nbsp;&nbsp;&nbsp; <a href="/Atelier1/commande?action=list">List of
				Commandes</a>

		</h2>
	</center>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of Commandes</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Date</th>
				<th>Client</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="commande" items="${listCommande}">
				<tr>
					<td><c:out value="${commande.numCmd}" /></td>
					<td><c:out value="${commande.dateCmd}" /></td>
					<c:forEach var="client" items="${listClient}">
						<c:if test="${client.codeCli == commande.codeCli}">
							<td><c:out value="${client.nomCli}" /></td>
						</c:if>
					</c:forEach>
					<td><a
						href="/Atelier1/commande?action=edit&id=<c:out value='${commande.numCmd}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/Atelier1/commande?action=delete&id=<c:out value='${commande.numCmd}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>