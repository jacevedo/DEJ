<%-- 
    Document   : modificar
    Created on : 18-sep-2015, 13:50:47
    Author     : jaime
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Modificar Video Juego </h1>
        <%@include file="menu.jsp" %>
         <form method="get" action="<c:url value="/ModificarVideoJuego"/>">
            <input type="text" name="id"/>
            <input type="submit" value="Buscar"/>
        </form>
        <form method="post" action="<c:url value="/ModificarVideoJuego"/>">
            <table>
                <tr>
                    <td>Id VideoJuego</td>
                    <td><input type="text" name="idVideoJuego" value="<c:out value="${videoJuego.id}"/>"/></td>
                </tr>
                <tr>
                    <td>Nombre VideoJuego</td>
                    <td><input type="text" name="nombreVideoJuego" value="<c:out value="${videoJuego.nombre}"/>"/></td>
                </tr>
                <tr>
                    <td>Precio VideoJuego</td>
                    <td><input type="text" name="precioVideoJuego" value="<c:out value="${videoJuego.precio}"/>"/></td>
                </tr>
                <tr>
                    <td>Tipo VideoJuego</td>
                    <td><input type="text" name="tipoVideoJuego" value="<c:out value="${videoJuego.tipo}"/>"/></td>
                </tr>
                <tr colspan="2">
                    <td>
                        <input type="submit" value="Modificar"/>
                       
                    </td>
                </tr>
                <tr colspan="2">
                    <td><c:out value="${mensaje}"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
