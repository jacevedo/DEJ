<%-- 
    Document   : index
    Created on : 02-sep-2015, 21:48:36
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
        <form action="<c:url value="/LoginServlet" />" method="post">
            <table>
                <tr>
                    <td>Usuario</td>
                    <td><input type="text" name="usuario" value="<c:out value="${usuario}"/>"</td>
                </tr>
                <tr>
                    <td>Contraseña</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td colspan="2"><c:out value="${error}" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Ingresar"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
