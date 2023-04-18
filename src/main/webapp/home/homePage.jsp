<!-- Utilizamos la propiedad import de la directiva Page para importar objetos a nuestro jsp-->
<%@ page import="edu.ejemplo.javaweb.servlet.dto.Usuario"%>

<html>
<head>
<link href="/AplicativoWebTemplate/css/loginCss.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="wrapper fadeInDown">
      <div id="formContent">
        <form>
        <!--Recuperamos el nombre del usuario de la sesión para mostrarlo como parte del mensaje-->
          <h3>Sesion iniciada con: <%=((Usuario)session.getAttribute("userLogin")).getUsuario()%></h3>
        <!--Recuperamos el tiempo de vida de la sesión para mostrarlo como parte del mensaje-->
          <h4>La Sesion termina en <%=session.getMaxInactiveInterval()%> segundos</h3>
        </form>
      </div>
    </div>
</body>
</html>
