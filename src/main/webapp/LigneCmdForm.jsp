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
		<h1>Ligne Commandes Management</h1>
		<h2>
			<a href="/Atelier1/lignecmd?action=new">Add New Ligne de Commande</a>
			&nbsp;&nbsp;&nbsp; <a href="/Atelier1/lignecmd?action=list">List of
				Ligne Commandes</a>
		</h2>
	</center>
	<div align="center">
		<c:if test="${ligneCmd != null}">
			<form action="/Atelier1/lignecmd?action=update" method="post">
		</c:if>
		<c:if test="${ligneCmd == null}">
			<form action="/Atelier1/lignecmd?action=add" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${ligneCmd != null}">
                        Edit Ligne de Commande
                    </c:if>
					<c:if test="${ligneCmd == null}">
                        Add New Ligne de Commande
                    </c:if>
				</h2>
			</caption>
			<c:if test="${ligneCmd != null}">
				<input type="hidden" name="id"
					value="<c:out value='${ligneCmd.numLigne}' />" />
			</c:if>
			<tr>
				<th>Quantité:</th>
				<td><input type="number" name="qteCmd" size="45"
					value="<c:out value='${ligneCmd.qteCmd}' />" /></td>
			</tr>
			<tr>
				<th>Commande:</th>
				<td><input type="number" name="numCmd" size="45"
					value="<c:out value='${ligneCmd.numCmd}' />" /></td>
			</tr>
			<tr>
				<th>Article:</th>
				<td><input type="number" name="codeArt" size="45"
					value="<c:out value='${ligneCmd.codeArt}' />" /></td>
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