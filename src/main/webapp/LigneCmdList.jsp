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
			&nbsp;&nbsp;&nbsp; <a href="/Atelier1/commande?action=list">List
				of Commandes</a> &nbsp;&nbsp;&nbsp; <a
				href="/Atelier1/client?action=list">List of Clients</a>
			&nbsp;&nbsp;&nbsp; <a href="/Atelier1/lignecmd?action=list">List
				of Ligne Commandes</a>
		</h2>
		<h1>Ligne Commande Management</h1>
		<h2>
			<a href="/Atelier1/lignecmd?action=new">Add New Ligne Commande</a>
			&nbsp;&nbsp;&nbsp; <a href="/Atelier1/lignecmd?action=list">List
				of Ligne Commandes</a>

		</h2>
	</center>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>List of Ligne Commandes</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Quantité</th>
				<th>Commande</th>
				<th>Article</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="ligneCmd" items="${listLigneCmd}">
				<tr>
					<td><c:out value="${ligneCmd.numCmd}" /></td>
					<td><c:out value="${ligneCmd.qteCmd}" /></td>
					<c:forEach var="commande" items="${listCommande}">
						<c:if test="${ligneCmd.numCmd == commande.numCmd}">
							<td><c:out value="${ligneCmd.numCmd}" /></td>
						</c:if>
					</c:forEach>
					<c:forEach var="article" items="${listArticle}">
						<c:if test="${article.codeArt == ligneCmd.codeArt}">
							<td><c:out value="${article.nomArt}" /></td>
						</c:if>
					</c:forEach>
					<td><a
						href="/Atelier1/lignecmd?action=edit&id=<c:out value='${ligneCmd.numLigne}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/Atelier1/lignecmd?action=delete&id=<c:out value='${ligneCmd.numLigne}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>