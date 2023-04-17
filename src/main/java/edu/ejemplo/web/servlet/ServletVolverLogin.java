package edu.ejemplo.web.servlet;

import edu.ejemplo.web.servlet.dto.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author jose.m.prieto.villar
 *
 * Básicamente este servlet valida si existe un usuario creado en la sesión, de ser así redirige la llamada al
 * servlet con ruta “/servlet-login”, pero en caso de no existir, redirige a la web “/login/login.jsp”.
 */

@WebServlet(
    // Definimos el nombre del servlet
    name = "ServletVolverLogin",
    // Definimos la ruta (URL) por la cual el servlet podra ser invocado
    urlPatterns = { "/servlet-volver-login" })
public class ServletVolverLogin extends HttpServlet {


    /**
     * Método que es accedido cuando se invoca al servlet utilizando el metodo GET. Realiza los siguientes pasos:
     *
     * <ul>
     *     <li>1) Recuperamos el objeto de la sesion desde la solicitud.</li>
     *     <li>2) Si el objeto recuperado no es nulo, redirige al servlet "/AplicativoWeb/servlet-login". En caso de que
     *     no, redirige a la pagina "/AplicativoWeb/login/login.jsp"</li>
     * </ul
     *
     * @param req Objeto de solicitud de la llamada
     * @param resp Objeto de respuesta de la llamada
     * @throws IOException Error de entrada/salida
     * @throws ServletException Error de componente servlet.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws
        ServletException,
        IOException {

        //Recuperamos objeto de la sesion
        Usuario usuario=(Usuario)req.getSession().getAttribute("usuarioSesion");

        //Validamos si el objeto recuperado existe
        if (usuario != null) {
            //Redirigimos la llamada al servlet "/servlet-login" utilizando el metodo "sendRedirect" de la respuesta.
            resp.sendRedirect("/AplicativoWeb/servlet-login");
        }
        else {
            //Redirigimos la llamada al servlet "/login/login.jsp" utilizando el metodo "sendRedirect" de la respuesta.
            resp.sendRedirect("/AplicativoWeb/login/login.jsp");
        }

    }
}
