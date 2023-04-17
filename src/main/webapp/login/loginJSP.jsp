<!--
En esta página, solicitaremos que el usuario inserte un usuario y una contraseña y para
validarlos se enviará la solicitud al servlet con url “servlet-login-jsp” mediante método http
“POST”, haciendo que los parámetros no viajen en la URL. Adicionalmente, en caso de ser
invocado y retener en la Request el atributo “error”, mostrara su mensaje
-->
<%@ page pageEncoding="UTF-8" %>

<html>
    <body>
        <form action="/AplicativoWeb/servlet-login-jsp" method="POST">
            <p>Usuario: </p> <input type="text" name="usuario"/>
            <p>Contraseña: </p> <input type="password" name="contrasena"/></br></br>

            <button type="submit">Iniciar Sesión</button>
            <button type="reset">Cancelar</button>

            <% if(request.getAttribute("error")!=null){ %>
                <p style="color: red"><%=request.getAttribute("error")%></p>
            <%}%>
        </form>
    </body>
</html>
