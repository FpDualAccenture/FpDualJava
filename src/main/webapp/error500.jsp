<!--
En esta web lo primero que se indica es que es una página que presenta un error mediante el uso de
la directiva <%@ page isErrorPage=”true”%>. Seguido, presenta un texto que indica que algo ha
ocurrido seguido de la excepción que ha ocurrido.

-->

<%@ page isErrorPage="true" %>
<html>
    <body>
        <h3>Sorry an exception occured!</h3>
        Exception is: <%= exception %>
    </body>
</html>