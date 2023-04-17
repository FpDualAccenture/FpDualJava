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
 * Este servlet es muy similar al “ServletFormulario” creado anteriormente, con la salvedad que en vez
 * de recuperar los parámetros de la request este recuperar los atributos del contexto de la aplicación, quienes serán
 * alimentados por el servlet responsable de invocarle.
 */

@WebServlet(
    // Definimos el nombre del servlet
    name = "ServletReceptorContexto",
    // Definimos la ruta (URL) por la cual el servlet podra ser invocado
    urlPatterns = { "/servlet-simple-receptor-contexto" })
public class ServletReceptorContexto extends HttpServlet {

    /**
     * Método que es accedido cuando se invoca al servlet utilizando el metodo GET. Realiza los siguientes pasos:
     *
     * <ul>
     *     <li>1) Recuperamos el objeto PrintWriter del objeto de respuesta de la solicitud.</li>
     *     <li>2) Utiliza el objeto creado para indicar en la salida que se desea visualizar una pagina web. Esta web
     *            contendra una linea con el valor del atributo "nombre" recuperado del objeto de contexto del servlet.
     *
     *            Seguido, recuperamos todos los nombres de los atributos del objeto request y mostraremos los nombres
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

        try {
            // Recuperamos el objeto PrintWriter
            PrintWriter writer=resp.getWriter();
            // Escribimos la apertura pagina web de la respuesta.
            writer.println("<html>");
            writer.println("<body>");
            writer.println("<h2>Redireccion por contexto</h2></br></br>");
            // Escribimos pagina web el valor del atributo "nombre" recuperado del objeto de request utilizando el metodo
            // "getAttribute".
            writer.println(
                "<h2>Parametro Conocido: Nombre --> " + getServletContext().getAttribute("nombre") + "</h2>");

            // Recuperamos todos los nombres de los atributos recibidos en la request llamando al metodo "getAttributeNames"
            // del objeto del contexto del servlet.
            Enumeration<String> parameters=getServletContext().getAttributeNames();

            // Iteramos sobre todos los nombres recuperados preguntando si existe un siguiente parametro. En caso de que si,
            // iterara en el while y en caso de que no terminara el ciclo.
            while (parameters.hasMoreElements()) {
                String name=parameters.nextElement();
                writer.println(
                    "<h2>Parametro No Conocido: " + name + " --> " + getServletContext().getAttribute(name) + "</h2>");
            }

            // Escribimos el cierre pagina web de la respuesta.
            writer.println("</body>");
            writer.println("</html>");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        finally {
            // Al finalizar la ejecución, borramos los parametros del contexto del servlet.
            getServletContext().removeAttribute("nombre");
            getServletContext().removeAttribute("apellido");
        }

    }
}
