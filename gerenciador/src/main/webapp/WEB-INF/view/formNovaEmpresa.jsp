<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntrada"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:import url="LogoutParcial.jsp" />

	<form action="${linkEntrada}" method="POST">
		Nome: <input type="text" name="nome" />
		Data Abertura: <input type="text" name="data" />
		<input type="hidden" name="acao" value="NovaEmpresa" />
	
		<input type="submit" />
	</form>

</body>
</html>