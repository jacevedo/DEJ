<%-- 
    Document   : index
    Created on : 17-ago-2015, 19:54:14
    Author     : jaime
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Request JSP</title>
    </head>
    <body>
        <%! boolean enviarGet = false; %>
        <h1>Aplicación JSP</h1>
        <h2>¿El tipo de llamada es GET?: <%=enviarGet%></h2>
        <%
            if(!enviarGet)
            {
                %>
                <h3>Llamada por POST</h3>
                <form method="post" action="RequestAplication">
                    <input type="submit" value="Enviar Datos"/>
                </form>
           <% }
            else
            { %>
        
                <h3>Llamada por GET</h3>
                <form method="get" action="RequestAplication">
                    <input type="submit" value="Enviar Datos"/>
                </form>
           <%}%>
    </body>
</html>
