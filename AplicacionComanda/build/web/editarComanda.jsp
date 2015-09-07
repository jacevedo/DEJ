<%-- 
    Document   : editarComanda.jsp
    Created on : 07-sep-2015, 19:55:44
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
        <h1>Editar Comanda</h1>
        <%@include file="menu.jsp"%>
        <h1><c:out value="${mensaje}" /></h1>
        <form method="post" action="<c:url value="/EditarComanda"/>">
            <table>
                <tr>
                    <td>id</td>
                    <td><input type="text" name="idComanda"/></td>
                </tr>
                <tr>
                    <td>id Cocina</td>
                    <td><input type="text" name="idCocina"/></td>
                </tr>
                <tr>
                    <td>Pedido</td>
                    <td><input type="text" name="pedido"/></td>
                </tr>
                <tr>
                    <td>Numero de mesa</td>
                    <td><input type="text" name="numeroMesa"/></td>
                </tr>
                <tr colspan="2">
                    <td><input type="submit" value="editar"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
