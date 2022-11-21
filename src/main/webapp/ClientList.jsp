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
		<h1>Client Management</h1>
		<h2>
			<a href="/Atelier1/client?action=new">Add New Client</a> &nbsp;&nbsp;&nbsp; <a
				href="/Atelier1/client?action=list">List of Clients</a>

		</h2>
	</center>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of Clients</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Telephone</th>
				<th>Adresse</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="client" items="${listClient}">
				<tr>
					<td><c:out value="${client.codeCli}" /></td>
					<td><c:out value="${client.nomCli}" /></td>
					<td><c:out value="${client.prenomCli}" /></td>
					<td><c:out value="${client.teleCli}" /></td>
					<td><c:out value="${client.adresseCli}" /></td>
					<td><a
						href="/Atelier1/client?action=edit&id=<c:out value='${client.codeCli}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/Atelier1/client?action=delete&id=<c:out value='${client.codeCli}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>