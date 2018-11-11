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

<jsp:setProperty name="rodo" property="*" /> 

<%

if (rodo.isZgoda2()){
	response.sendRedirect(request.getContextPath() + "/FinPurchase.jsp");
}
else
	out.println("<p>Bez wyrażenia zgody na przetwarzanie danych zgodnie z RODO nie"+
" można dokonać finalizacji zakupu. <a href='RodoForm.jsp'>Powrót do zgód.</a></p>");

%>

</body>
</html>