<%-- 
    Document   : AgregarComanda
    Created on : 06-sep-2015, 18:03:01
    Author     : jaime
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h1>Agregar Comanda</h1>
        <form method="post" action="<c:url value="/AgregarComanda"/>">
            <h1><c:out value="${mensaje}"/></h1>
            <table>
                <tr>
                    <td>id cocina</td>
                    <td><input type="text" name="idCocina"/></td>
                </tr>
                <tr>
                    <td>Pedido</td>
                    <td><input type="text" name="pedido"/></td>
                </tr>
                <tr>
                    <td>mesa</td>
                    <td><input type="text" name="mesa"/></td>
                </tr>
                <tr colspan="2">
                    <td><input type="submit" value="guardar"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
