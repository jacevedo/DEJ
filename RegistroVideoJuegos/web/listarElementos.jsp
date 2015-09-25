<%-- 
    Document   : listarElementos
    Created on : 18-sep-2015, 14:12:25
    Author     : jaime
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listar VideoJuegos</h1>
        <%@include file="menu.jsp" %>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>nombre</th>
                    <th>precio</th>
                    <th>tipo</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="videoJuego" items="${videoJuegos}">
                <tr>
                    <td><c:out value="${videoJuego.id}"/></td>
                    <td><c:out value="${videoJuego.nombre}"/></td>
                    <td><c:out value="${videoJuego.precio}"/></td>
                    <td><c:out value="${videoJuego.tipo}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>
