<%-- 
    Document   : listaComanda
    Created on : 10-sep-2015, 20:29:49
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
        <h1>Listar</h1>
        <%@include file="menu.jsp" %>
        <br/>
        <br/>
        <br/>
        <br/>
        <table>
            <thead>
                <tr>
                    <td>Id</td>
                    <td>Id Cocina</td>
                    <td>Pedido</td>
                    <td>Mesa</td>
                </tr>
            </thead>
            <tbody>
        <c:forEach var="c" items="${todas}"> 
            <tr>
                <td><c:out value="${c.id}"/></td>
                <td><c:out value="${c.idCocina}"/></td>
                <td><c:out value="${c.pedido}"/></td>
                <td><c:out value="${c.mesa}"/></td>
            </tr> 
        </c:forEach>
            </tbody>
        </table>
    </body>
</html>
