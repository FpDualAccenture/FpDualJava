<%@ page pageEncoding="UTF-8" %>
<%@ page import="edu.ejemplo.jsp.persistence.dao.City" %>
<%@ page import="java.util.List" %>

<html>
    <body>
        <form action="/EjemploJSP/servlet-ciudades" method="GET">
                <p>Id Ciudad: </p> <input type="text" name="id"/></br>
                <button type="submit">Buscar</button>
                <button type="reset">Cancelar</button>
        </form>
        <%
        City city = (City)session.getAttribute("ciudad");
        List<City> cities = (List<City>)session.getAttribute("ciudades");
        session.removeAttribute("ciudad");
        session.removeAttribute("ciudades");
        if(city!=null){%>
            <h2>Ciudad Seleccionada</h2>
            <table>
            <tr>
                <th>id</th>
                <th>Nombre</th>
                <th>Codigo Pais</th>
            </tr>
            <tr>
                <td><%=city.getId()%></td>
                <td><%=city.getName()%></td>
                <td><%=city.getCountryCode()%></td>
            </tr>
            </table>
        <%}

        if(cities!=null && cities.size() > 0){%>
            <h2>Listado de Ciudades</h2>
            <table>
            <tr>
                <th>id</th>
                <th>Nombre</th>
                <th>Codigo Pais</th>
            </tr>
            <%for(City ciudad: cities){%>
                <tr>
                    <td><%=ciudad.getId()%></td>
                    <td><%=ciudad.getName()%></td>
                    <td><%=ciudad.getCountryCode()%></td>
                </tr>
            <%}%>
            </table>
        <%}%>
    </body>
</html>
