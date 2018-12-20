<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="data" method="post">
SKU: <input type="text" name="sku" ><br>
Data produkcji: <input type="text" name="produkcja" value="yyyy-MM-dd" ><br/>
Cena: <input type="text" name="cena"><br>
Producent:<br>
USA: <input type="radio" name="producent" value="usa"><br>
Europa: <input type="radio" name="producent" value="europa"><br>
Ilosc: <input type="text" name="qty" ><br>
Kolory:<br>
Kolorowe: <input type="checkbox" name="kolory" value="kolorowe"><br>
Obrazki: <input type="checkbox" name="kolory" value="obrazki"><br>




<input type="submit" value="ok">
</form>

</body>
</html>