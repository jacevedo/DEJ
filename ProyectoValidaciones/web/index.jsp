<%-- 
    Document   : index
    Created on : 17-ago-2015, 20:45:52
    Author     : jaime
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validaciones</title>
    </head>
    <body>
        <div>
            <h1>Formulario Validaciones</h1>
            <%-- Creamos una tabla de 3 columas una para el nombre del dato,
                 otra para la caja de texto y finalmente la ultima
                 para el mensaje de validacion.  --%>
            <form method="post" action="<c:url value="/Validaciones" />">
                <table>
                    <tr>
                        <td>Nombre</td>
                        <%-- en la caja de texto colocamos la variable value
                             en ella introduciremos el valor del formulario
                             siempre y cuando exista para ello usaremos una
                             expresion ternaria, la cual es muy similar a un
                             if, pero todo en una linea, la estructura es la
                             siguiente:  
                             (expresion) ? valor positivo : valor negativo 
                             el signo de interrogacion indica que es una 
                             expresion ternaria y los 2 puntos es la separacion
                             entre el valor positivo y el negativo--%>
                        <td><input type="text" 
                                   name="nombre" 
                                   value="<c:out value="${nombre}"/>"/></td>
                        
                        <%-- en la ultima columna ingresaremos el valor retornado de
                         la validacion, tomar en cuenta que en la caja de texto se utiliza
                         getParameter y en el campo se utliza getAttribute, esto es 
                         debido a que por medio del formulario se envian parametros y 
                         desde el servlet se envian atributos--%>
                        <td><c:out value="${mensajes['nombre']}"/></td>
                    </tr>
                    <tr>
                        <%-- Repetimos el mismo paso en todos los campos --%>
                        <td>Apellido 1</td>
                        <td><input type="text" 
                                   name="apellido1"
                                   value="<c:out value="${apellido1}"/>"/></td>
                        <td><c:out value="${mensajes['apellido1']}"/></td>
                    </tr>
                    <tr>
                        <td>Apellido 2</td>
                        <td><input type="text" 
                                   name="apellido2"
                                   value="<c:out value="${apellido2}"/>"/></td>
                        <td><c:out value="${mensajes['apellido2']}"/>"</td>
                    </tr>
                    <tr>
                        <td>Rut</td>
                        <td><input type="text" 
                                   name="rut"
                                   value="<%= request.getParameter("rut") != null ?
                                           request.getParameter("rut") : "" %>"/>-
                            <input type="text" 
                                   name="dv"
                                   value="<%= request.getParameter("dv") != null ? 
                                           request.getParameter("dv") : "" %>"/></td>
                        <td><%= request.getAttribute("rut") != null ?
                                request.getAttribute("rut") : ""  %></td>
                    </tr>
                    <tr>
                        <td>Mail</td>
                        <td><input type="text" 
                                   name="mail"
                                   value="<%= request.getParameter("mail") != null ? 
                                           request.getParameter("mail") : "" %>"/></td>
                        <td><%= request.getAttribute("mail") != null ? 
                                request.getAttribute("mail") : "" %></td>
                    </tr>
                    <tr>
                        <td>Teléfono</td>
                        <td><input type="text"
                                   name="telefono"
                                   value="<%= request.getParameter("telefono") != null ? 
                                           request.getParameter("telefono") : "" %>"/></td>
                        <td><%= request.getAttribute("telefono") != null ? 
                                request.getAttribute("telefono") : ""  %></td>
                    </tr>

                    <tr>
                        <td colspan="2"><input type="submit" value="Enviar"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
