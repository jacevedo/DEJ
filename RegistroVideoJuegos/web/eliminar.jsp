<%-- 
    Document   : eliminar
    Created on : 14-sep-2015, 23:16:22
    Author     : jaime
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Eliminar Video Juego</h1>
        <%@include file="menu.jsp" %>
        <form method="get" action="<c:url value="/EliminarVideoJuego"/>">
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
            <tr colspan="2">
                <td>
                    <form method="post" action="<c:url value="/EliminarVideoJuego"/>">
                        <input type="hidden" name="idEliminar" value="<c:out value="${videoJuego.id}"/>"/>
                        <input type="submit" value="Eliminar"/>
                    </form>
                </td>
            </tr>
            <tr colspan="2">
                <td><c:out value="${mensaje}"/></td>
            </tr>
        </table>
    </body>
</html>
