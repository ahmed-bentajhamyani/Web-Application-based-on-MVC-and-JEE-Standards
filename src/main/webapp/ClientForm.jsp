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
		<h1>Clients Management</h1>
		<h2>
			<a href="/Atelier1/client?action=new">Add New Client</a> &nbsp;&nbsp;&nbsp; <a
				href="/Atelier1/client?action=list">List of Clients</a>
		</h2>
	</center>
	<div align="center">
		<c:if test="${client != null}">
			<form action="/Atelier1/client?action=update" method="post">
		</c:if>
		<c:if test="${client == null}">
			<form action="/Atelier1/client?action=add" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${client != null}">
                        Edit Client
                    </c:if>
					<c:if test="${client == null}">
                        Add New Client
                    </c:if>
				</h2>
			</caption>
			<c:if test="${client != null}">
				<input type="hidden" name="id"
					value="<c:out value='${client.codeCli}' />" />
			</c:if>
			<tr>
				<th>Nom:</th>
				<td><input type="text" name="nomCli" size="45"
					value="<c:out value='${client.nomCli}' />" /></td>
			</tr>
			<tr>
				<th>Prenom:</th>
				<td><input type="text" name="prenomCli" size="45"
					value="<c:out value='${client.prenomCli}' />" /></td>
			</tr>
			<tr>
				<th>Telephone:</th>
				<td><input type="text" name="teleCli" size="45"
					value="<c:out value='${client.teleCli}' />" /></td>
			</tr>
			<tr>
				<th>Adresse:</th>
				<td><input type="text" name="adresseCli" size="45"
					value="<c:out value='${client.adresseCli}' />" /></td>
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