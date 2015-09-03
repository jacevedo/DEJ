<%-- 
    Document   : index
    Created on : 17-ago-2015, 20:45:52
    Author     : jaime
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- linea que indica la libreria de tag a utilizar --%>
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
            <%-- la instrucción c:url crea una url absoluta a la direccion
                 que nosotros le indiquemos--%>
            <form method="post" action="<c:url value="/Validaciones"/>"">
                <table>
                    <tr>
                        <td>Nombre</td>
                        <%-- El elemento c:out imprime un atributo enviado
                             por el servlet, si el atributo es null no 
                             muestra nada--%>
                        <td><input type="text" 
                                   name="nombre" 
                                   value="<c:out value="${nombre}"/>"/></td>
                    
                        <td><c:out value="${mensajes['nombre']}"/></td>
                    </tr>
                    <tr>
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
                        <td><c:out value="${mensajes['apellido2']}"/></td>
                    </tr>
                    <tr>
                        <td>Rut</td>
                        <td><input type="text" 
                                   name="rut"
                                   value="<c:out value="${rut}"/>"/>-
                            <input type="text" 
                                   name="dv"
                                   value="<c:out value="${dv}"/>"/></td>
                        <td><c:out value="${mensajes['rut']}"/></td>
                    </tr>
                    <tr>
                        <td>Mail</td>
                        <td><input type="text" 
                                   name="mail"
                                   value="<c:out value="${mail}"/>"/></td>
                        <td><c:out value="${mensajes['mail']}"/></td>
                    </tr>
                    <tr>
                        <td>Teléfono</td>
                        <td><input type="text"
                                   name="telefono"
                                   value="<c:out value="${telefono}"/>"/></td>
                        <td><c:out value="${mensajes['telefono']}"/></td>
                    </tr>

                    <tr>
                        <td colspan="2"><input type="submit" value="Enviar"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
