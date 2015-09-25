<%-- 
    Document   : index
    Created on : 11-sep-2015, 21:10:46
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
        <h1>Agregar Juego</h1>
        <%@include file="menu.jsp" %>
        <br/>
        <form method="post" action="<c:url value="/AgregarJuego"/>">
            <table>
                <tr>
                    <td>Nombre del Juego</td>
                    <td><input type="text" name="nombreJuego" 
                               value="<c:out value="${nombre}"/>"/></td>
                </tr>
                <tr>
                    <td>Precio del Juego</td>
                    <td><input type="text" name="precioJuego"
                               value="<c:out value="${precio}"/>"/></td>
                </tr>
                <tr>
                    <td>Genero del Juego</td>
                    <td><input type="text" name="generoJuego"
                               value="<c:out value="${genero}"/>"/></td>
                </tr>
                <tr colspan="2">
                    <td><input type="submit" value="Guardar"/></td>
                </tr>
            </table>
            
        </form>
        
    </body>
</html>
