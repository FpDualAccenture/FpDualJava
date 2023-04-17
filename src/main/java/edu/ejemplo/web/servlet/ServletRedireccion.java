package edu.ejemplo.web.servlet;

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
 * En este ejemplo nuestro servlet simplemente redirecciona la llamada a la nueva web
 * llamada “redirección.jsp”. Hay que fijarse que para que esta sea efectiva, se debe
 * indicar la ruta completa de la web, incluyendo el contexto.
 */

@WebServlet(
    // Definimos el nombre del servlet
    name = "ServletRedireccion",
    // Definimos la ruta (URL) por la cual el servlet podra ser invocado
    urlPatterns = { "/servlet-redireccion" })
public class ServletRedireccion extends HttpServlet {

    /**
     * Método que es accedido cuando se invoca al servlet utilizando el metodo GET.
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
        //Redirigimos a pagina loginJSP.jsp utilizando el metodo "sendRedirect" del objeto de respuesta
        resp.sendRedirect(req.getContextPath() + "/redireccion.jsp");
    }
}
