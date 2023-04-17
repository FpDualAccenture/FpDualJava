package edu.ejemplo.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jose.m.prieto.villar
 *
 * En este ejemplo, indicamos que redireccione a la ruta de un servlet también indicando
 * en la ruta el contexto de la aplicación
 */
@WebServlet(
    // Definimos el nombre del servlet
    name = "ServletRedireccionServlet",
    // Definimos la ruta (URL) por la cual el servlet podra ser invocado
    urlPatterns = { "/servlet-redireccion-servlet" })
public class ServletRedireccionServlet extends HttpServlet {

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
        //Redirigimos al servler mi-servlet utilizando el metodo "sendRedirect" del objeto de respuesta
        resp.sendRedirect("/AplicativoWeb/mi-servlet");

    }
}
