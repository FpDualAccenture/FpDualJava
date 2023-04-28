<%@ page pageEncoding="UTF-8" %>

<html>
    <body>
        <form action="/EjemploJSP/servlet-login-jsp" method="POST">
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
