package edu.ejemplo.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author jose.m.prieto.villar
 *
 * Este servlet realizara dos cosas. Primero, recuperara un parámetro conocido y mostrara su
 * resultado en la respuesta. Segundo, asumirá que no conoce ningún parámetro y recorrerá la
 * enumeración de nombres de parámetros para recuperar cada uno y agregarlos a la página de
 * salida
 */

@WebServlet(
    // Definimos el nombre del servlet
    name = "ServletFormulario",
    // Definimos la ruta (URL) por la cual el servlet podra ser invocado
    urlPatterns = { "/servlet-simple-form" })
public class ServletFormulario extends HttpServlet {

    /**
     * Método que es accedido cuando se invoca al servlet utilizando el metodo GET. Realiza los siguientes pasos:
     *
     * <ul>
     *     <li>1) Recuperamos el objeto PrintWriter del objeto de respuesta de la solicitud.</li>
     *     <li>2) Utiliza el objeto creado para indicar en la salida que se desea visualizar una pagina web. Esta web
     *            contendra una linea con el valor del parametro "nombre" recuperado del objeto request.
     *
     *            Seguido, recuperamos todos los nombres de los parametros del objeto request y mostraremos los nombres
     *            y su valor en la web.</li>
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
        // Escribimos la apertura pagina web de la respuesta.
        writer.println("<html>");
        writer.println("<body>");
        // Escribimos pagina web el valor del parametro "nombre" recuperado del objeto de request utilizando el metodo
        // "getParameter".
        writer.println("<h2>Parametro Conocido: Nombre --> " + req.getParameter("nombre") + "</h2>");

        // Recuperamos todos los nombres de los parametros recibidos en la request llamando al metodo "getPrameterNames"
        // del objeto de request.
        Enumeration<String> parameters=req.getParameterNames();

        // Iteramos sobre todos los nombres recuperados preguntando si existe un siguiente parametro. En caso de que si,
        // iterara en el while y en caso de que no terminara el ciclo.
        while (parameters.hasMoreElements()) {
            String name=parameters.nextElement();
            // Escribimos pagina web el valor del parametro recuperado del objeto de request utilizando el metodo
            // "getParameter" mediante el valor almacenado en la variable name.
            writer.println("<h2>Parametro No Conocido: " + name + " --> " + req.getParameter(name) + "</h2>");
        }

        // Escribimos el cierre pagina web de la respuesta.
        writer.println("</body>");
        writer.println("</html>");

    }
}
