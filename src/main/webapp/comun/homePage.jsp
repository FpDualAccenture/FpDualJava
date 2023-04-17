<!--
En esta web, se valida si existe una sesión. En caso de que si, se muestra el nombre del
usuario, pero en caso de que no se indicará que no hay una sesión y un botón para que el
usuario pueda volver a esta web.
-->

<%@ page pageEncoding="UTF-8" %>
<!-- Utilizamos la propiedad import de la directiva Page para importar objetos a nuestro jsp-->
<%@ page import="edu.ejemplo.web.servlet.dto.Usuario" %>
<%@ page import="java.util.Enumeration" %>

<html>
    <body>
    <!--
    Utilizamos la etiqueta < % para incrustar codigo java dentro del JSP. En este caso abrimos un if para indicar un
     codigo html si existe una sesion activa.
     -->
        <%
        if(session.getAttribute("usuarioSesion")!=null){
            Usuario usuario = (Usuario)session.getAttribute("usuarioSesion");

            %>
            <h2> Bienvenido <%=usuario.getUsuario()%> </h2>
     <!--
     Cerramos el If y creamos un else para incrustar otro fragmento de codigo diferente en caso de que la sesion no
     este activa.
     -->
        <%} else {%>
        <form action="/AplicativoWeb/login/loginJSP.jsp" method="GET">
            <h2> No ha iniciado sesión, por favor ir al login </h2></br>
            <button type="submit">Ir a inicio de sesión</button>
        </form>
        <%}%>

<!-- El fragmento a continuación presentara los parametros recibidos en la solicitud en caso de tener alguno indicado.-->
        <%
            Enumeration<String> parameters = request.getParameterNames();
            while(parameters.hasMoreElements()){
               String name = parameters.nextElement();%>
                <h2> Parametro <%=name%>: <%=request.getParameter(name)%> </h2></br>
            <%}%>

    </body>
</html>
