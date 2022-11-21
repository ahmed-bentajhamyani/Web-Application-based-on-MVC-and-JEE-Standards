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
		<h1>Articles Management</h1>
		<h2>
			<a href="/Atelier1/article?action=new">Add New Article</a> &nbsp;&nbsp;&nbsp;
			<a href="/Atelier1/article?action=list">List of Articles</a>
		</h2>
	</center>
	<div align="center">
		<c:if test="${article != null}">
			<form action="/Atelier1/article?action=update" method="post">
		</c:if>
		<c:if test="${article == null}">
			<form action="/Atelier1/article?action=add" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${article != null}">
                        Edit Article
                    </c:if>
					<c:if test="${article == null}">
                        Add New Article
                    </c:if>
				</h2>
			</caption>
			<c:if test="${article != null}">
				<input type="hidden" name="id"
					value="<c:out value='${article.codeArt}' />" />
			</c:if>
			<tr>
				<th>Nom:</th>
				<td><input type="text" name="nomArt" size="45"
					value="<c:out value='${article.nomArt}' />" /></td>
			</tr>
			<tr>
				<th>Description:</th>
				<td><input type="text" name="description" size="45"
					value="<c:out value='${article.description}' />" /></td>
			</tr>
			<tr>
				<th>Prix Unitaire:</th>
				<td><input type="number" step="0.01" name="prixUnitaire"
					size="45" value="<c:out value='${article.prixUnitaire}' />" /></td>
			</tr>
			<tr>
				<th>Quantité:</th>
				<td><input type="number" name="qteArt" size="45"
					value="<c:out value='${article.qteArt}' />" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>