<!--
En esta página, solicitaremos que el usuario inserte un usuario y una contraseña y para
validarlos se enviará la solicitud al servlet con url “servlet-login” mediante método http
“POST”, haciendo que los parámetros no viajen en la URL.
-->

<html>
<body>
<form action="/AplicativoWeb/servlet-login" method="POST">
<p>Usuario: </p> <input type="text" name="usuario"/>
<p>Contraseña: </p> <input type="password" name="contrasena"/></br></br>
<button type="submit">Iniciar Sesión</button>
<button type="reset">Cancelar</button>
</form>
</body>
</html>
