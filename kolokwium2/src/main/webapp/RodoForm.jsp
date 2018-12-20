<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="rodo" class="pl.shop.javaee.domain.Rodo" scope="session" />


<h2>Dodatkowe zgody w celu finalizacji zakupu:</h2>
<form action="RodoCheck.jsp" method="post">
<input type="checkbox" name="zgoda2" value="true">
Wyrażam zgodę na przetwarzanie danych zgodnie z RODO.
<br/>
<input type="checkbox" name="zgoda3" value="true">
Wyrażam zgodę na kontakt w celach marketingowych.

<br/><br/>
<input type="submit" value="OK">
</form>

</body>
</html>