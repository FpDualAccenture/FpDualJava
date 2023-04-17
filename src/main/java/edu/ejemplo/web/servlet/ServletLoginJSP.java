package edu.ejemplo.web.servlet;

import edu.ejemplo.web.servlet.dto.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletLoginJSP", urlPatterns ={"/servlet-login-jsp"})
public class ServletLoginJSP extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws
        ServletException,
        IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
        ServletException,
        IOException {

        Usuario usuario = (Usuario) req.getSession().getAttribute("usuarioSesion");

        if(usuario!=null){
            resp.sendRedirect("/AplicativoWeb/comun/homePage.jsp");
        } else {

            String usuarioConfigurado=getServletContext().getInitParameter("usuario");
            String passwordConfigurado=getServletContext().getInitParameter("password");

            String usuarioIntroducido=req.getParameter("usuario");
            String passwordIntroducido=req.getParameter("contrasena");

            if ((usuarioIntroducido != null && usuarioIntroducido.equals(usuarioConfigurado))
                && (passwordIntroducido != null && passwordIntroducido.equals(passwordConfigurado))) {

                usuario=Usuario.builder().usuario(usuarioIntroducido).password(passwordIntroducido).build();

                req.getSession().setMaxInactiveInterval(5);
                req.getSession().setAttribute("usuarioSesion", usuario);

                resp.sendRedirect("/AplicativoWeb/comun/homePage.jsp");

            }
            else {
                req.setAttribute("error","Error al insertar usuario o contraseña");
                req.getRequestDispatcher("/login/loginJSP.jsp").forward(req, resp);
            }
        }

    }
}
