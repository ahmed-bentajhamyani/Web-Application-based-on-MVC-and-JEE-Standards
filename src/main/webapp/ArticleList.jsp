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
		<h1>Article Management</h1>
		<h2>
			<a href="/Atelier1/article?action=new">Add New Article</a> &nbsp;&nbsp;&nbsp;
			<a href="/Atelier1/article?action=list">List of Articles</a>

		</h2>
	</center>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of Articles</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Description</th>
				<th>Prix Unitaire</th>
				<th>Quantité</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="article" items="${listArticle}">
				<tr>
					<td><c:out value="${article.codeArt}" /></td>
					<td><c:out value="${article.nomArt}" /></td>
					<td><c:out value="${article.description}" /></td>
					<td><c:out value="${article.prixUnitaire}" /></td>
					<td><c:out value="${article.qteArt}" /></td>
					<td><a
						href="/Atelier1/article?action=edit&id=<c:out value='${article.codeArt}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/Atelier1/article?action=delete&id=<c:out value='${article.codeArt}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>