package edu.ejemplo.web.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jose.m.prieto.villar
 *
 * Este servlet es muy similar al que anteriormente creamos llamado “ServletRedireccionServlet”, salvo
 * que en vez de llamar al método “sendRedirect”, para poder redirigir a otro punto y enviar parámetros
 * necesita crear un objeto llamado “RequestDispatcher” indicando en su constructor la ruta del servlet
 * a llamar e invocar al método “forward” para redirigir el flujo al nuevo servlet
 */

@WebServlet(
    // Definimos el nombre del servlet
    name = "ServletRedireccionServletParametros",
    // Definimos la ruta (URL) por la cual el servlet podra ser invocado
    urlPatterns = { "/servlet-redireccion-servlet-parametros" })
public class ServletRedireccionServletParametros extends HttpServlet {

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

        // Recuperamos parametros del objeto de solicitud
        String nombre=req.getParameter("nombre");
        String apellido=req.getParameter("apellido");

        // Si no existen o no han llegado parametros, rellenamos las variables con valores por defecto.
        if (nombre == null) {
            nombre="Jose";
        }

        if (apellido == null) {
            apellido="Prieto";
        }

        // Asignamos las variables a los atributos del objeto de solicitud
        req.setAttribute("nombre", nombre);
        req.setAttribute("apellido", apellido);

        //Recuperamos el dispatcher de la aplicación desde el objeto de solicitud
        RequestDispatcher rd=req.getRequestDispatcher("/servlet-simple-receptor");

        //Indicamos al dispatcher que haga un forward de la solicitud. TEner en cuenta que esta solicitud es la recibida
        // en este servlet mas los parametros indicados en los atributos.
        rd.forward(req, resp);

    }
}
