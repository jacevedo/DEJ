<%-- 
    Document   : buscar
    Created on : 12-sep-2015, 20:19:10
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
        <h1>Buscar Por id</h1>
        <%@include file="menu.jsp" %>
        <form method="get" action="BuscarVideoJuego">
            <input type="text" name="id"/>
            <input type="submit" value="Buscar"/>
        </form>
        <table>
            <tr>
                <td>Id VideoJuego</td>
                <td><c:out value="${videoJuego.id}"/></td>
            </tr>
            <tr>
                <td>Nombre VideoJuego</td>
                <td><c:out value="${videoJuego.nombre}"/></td>
            </tr>
            <tr>
                <td>Precio VideoJuego</td>
                <td><c:out value="${videoJuego.precio}"/></td>
            </tr>
            <tr>
                <td>Tipo VideoJuego</td>
                <td><c:out value="${videoJuego.tipo}"/></td>
            </tr>
        </table>
    </body>
</html>
