<%@ page pageEncoding="UTF-8" %>
<%@ page import="edu.ejemplo.jsp.servlet.dto.Usuario" %>
<%@ page import="java.util.Enumeration" %>

<html>
    <body>
        <%
        if(session.getAttribute("usuarioSesion")!=null){
            Usuario usuario = (Usuario)session.getAttribute("usuarioSesion");

            %>
            <h2> Bienvenido <%=usuario.getUsuario()%> </h2>
        <%} else {%>
        <form action="/EjemploJSP/login/loginJSP.jsp" method="GET">
            <h2> No ha iniciado sesión, por favor ir al login </h2></br>
            <button type="submit">Ir a inicio de sesión</button>
        </form>
        <%
        }

        Enumeration<String> parameters = request.getParameterNames();%>

        <table>
        <tr>
            <th>Nombre</th>
            <th>Valor</th>
        </tr>
        <%while(parameters.hasMoreElements()){
            String name = parameters.nextElement();
            String valor = request.getParameter(name);%>
            <tr>
                <td><%=name%></td>
                <td><%=valor%></td>
            </tr>
        <%}%>
        </table>
    </body>
</html>
