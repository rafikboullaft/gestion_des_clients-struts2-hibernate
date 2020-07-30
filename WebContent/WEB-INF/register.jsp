<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<s:head />
<style type="text/css">

body {
    text-align: center;
}
form {
    display: inline-block;
}
.affichage {
margin-top : 30px;
font-family: sans-serif;
display: inline-block;
}


.TableStrut {
	
	border-width: 1px 1px 1px 1px;
	border-spacing: 3px;
	
}

.userTable td {
	border-width: 1px 1px 1px 1px;
	border-spacing: 2px;
	border-style: outset outset outset outset;
	border-color: black black black black;
	border-collapse: collapse;
}

.userTable th {
	border-width: 1px 1px 1px 1px;
	border-spacing: 2px;
	border-style: outset outset outset outset;
	border-color: black black black black;
	border-collapse: collapse;
	background-color: rgb(255, 255, 255);
}

.odd {
background-color: #FFFD2E;
}

.even {
background-color: #7DFA0E;
}
</style>
</head>
<body >
<h1>ajouter/modifier un client</h1>
<s:form action="addClient" class="maform">
	<s:textfield name="	code" label="CODE" />
	<s:textfield name="nom" label="NOM" />
	<s:textfield name="prenom" label="PRENOM" />
	<s:textfield name="age" label="AGE" />
	<s:textfield name="ville" label="VILLE" />
	<%--  <s:radio name="gender" label="Gender" list="{'Male','Female'}" /> 
	<s:select name="ville" list="{'India','USA','UK'}" headerKey=""
		headerValue="Country" label="Select a country" />
	<s:textarea name="aboutYou" label="About You" />
	<s:checkbox name="mailingList"
		label="Would you like to join our mailing list?" /> --%>
	<s:submit  />
</s:form>
<br>
<h1> affichage des clients</h1>
<s:if test="clientList.size() > 0">
	<div class="affichage">
	<table class="TableStrut" cellpadding="5px" >
		<tr class="even">
			<th>code</th>
			<th>nom</th>
			<th>prenom</th>
			<th>age</th>
			<th>ville</th>
			<th>modifier</th>
			<th>supprimer</th>
		</tr>
		<s:iterator value="clientList" status="clientStatus">
			<tr
				class="<s:if test="#clientStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td><s:property value="code" /></td>
				<td><s:property value="nom" /></td>
				<td><s:property value="prenom" /></td>
				<td><s:property value="age" /></td>
				<td><s:property value="ville" /></td>
				<td>
                <s:url id="editURL" action="editClient">
					<s:param name="code" value="%{code}"></s:param>
				</s:url>
                <s:a href="%{editURL}">Modifier</s:a>
                </td>
				<td>
                <s:url id="deleteURL" action="deleteClient">
					<s:param name="code" value="%{code}"></s:param>
				</s:url>
                <s:a href="%{deleteURL}">supprimer</s:a>
                </td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:if>
</body>
</html>