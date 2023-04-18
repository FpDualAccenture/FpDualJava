<html>
<head>
<link href="/AplicativoWebTemplate/css/loginCss.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="wrapper fadeInDown">
      <div id="formContent">
        <!-- Tabs Titles -->
        <h2 class="active"></h2>
        <h2 class="inactive underlineHover"></h2>
        <!-- Icon -->
        <div class="fadeIn first">
          <img src="/AplicativoWebTemplate/img/login.png" id="icon" alt="User Icon" />
        </div>

        <!-- Login Form -->
        <form action="/AplicativoWebTemplate/servlet-login" method="POST">
          <input type="text" id="user" class="fadeIn second" name="user" placeholder="user">
          <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">
          <input type="submit" class="fadeIn fourth" value="Log In">
        </form>
        <%if(request.getAttribute("error")!=null){%>
            <p class="fadeIn fifth"><%=request.getAttribute("error")%></p>
         <%}%>
        <!-- Remind Passowrd -->
        <div id="formFooter">
          <a class="underlineHover" href="/AplicativoWebTemplate/forgotPassword.jsp">Forgot Password?</a>
        </div>

      </div>
    </div>
</body>
</html>
