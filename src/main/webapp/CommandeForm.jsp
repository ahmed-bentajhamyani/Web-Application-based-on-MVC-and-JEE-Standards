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
		<h1>Commandes Management</h1>
		<h2>
			<a href="/Atelier1/commande?action=new">Add New commande</a>
			&nbsp;&nbsp;&nbsp; <a href="/Atelier1/commande?action=list">List of
				Commandes</a>
		</h2>
	</center>
	<div align="center">
		<c:if test="${commande != null}">
			<form action="/Atelier1/commande?action=update" method="post">
		</c:if>
		<c:if test="${commande == null}">
			<form action="/Atelier1/commande?action=add" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${commande != null}">
                        Edit commande
                    </c:if>
					<c:if test="${commande == null}">
                        Add New commande
                    </c:if>
				</h2>
			</caption>
			<c:if test="${commande != null}">
				<input type="hidden" name="id"
					value="<c:out value='${commande.numCmd}' />" />
			</c:if>
			<tr>
				<th>Date:</th>
				<td><input type="date" name="dateCmd" size="45"
					value="<c:out value='${commande.dateCmd}' />" /></td>
			</tr>
			<tr>
				<th>Client:</th>
				<td><input type="number" name="codeCli" size="5"
					value="<c:out value='${commande.codeCli}' />" /></td>
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