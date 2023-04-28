<%@ page pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDateTime"%>

<html>
<body>

<%LocalDateTime fechaActual = LocalDateTime.now();%>

<h2>Hello World!</h2>
<h2>Son las: <%=fechaActual%></h2>
</body>
</html>
