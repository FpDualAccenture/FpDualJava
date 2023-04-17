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
 * Este ejemplo simplemente pretende presentar una web que indique “Mi Servler! =D” en
 * mensaje negrita en la página web. Para ello, toma del objeto de respuesta el objeto
 * “PrintWriter” para escribir lo que se desee presentar como salida.
 */

@WebServlet(
    // Definimos el nombre del servlet
    name = "MiServlet",
    // Definimos la ruta (URL) por la cual el servlet podra ser invocado
    urlPatterns = { "/mi-servlet" })
public class MiServlet extends HttpServlet {

    /**
     * Método que es accedido cuando se invoca al servlet utilizando el metodo GET. Realiza los siguientes pasos:
     *
     * <ul>
     *     <li>1) Recuperamos el objeto PrintWriter del objeto de respuesta de la solicitud.</li>
     *     <li>2) Utiliza el objeto creado para indicar en la salida que se desea visualizar una pagina web con el texto "Mi Servlet! =D"</li>
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
        // Recuperamos el objeto PrintWriter
        PrintWriter writer=resp.getWriter();

        // Escribimos pagina web de la respuesta.
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h2>Mi Servlet! =D</h2>");
        writer.println("</body>");
        writer.println("</html>");

    }
}
