package edu.ejemplo.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jose.m.prieto.villar
 *
 * Este servlet es muy similar al que anteriormente creamos llamado “ServletRedireccionServlet”, salgo que para
 * enviar parámetros llena el contexto del servlet agregando atributos con lo que desea enviar y desde el
 * objeto de respuesta indica la ruta del servlet al que desea llamar.
 *
 * Nota: Fijaros que en
 */

@WebServlet(
    // Definimos la ruta (URL) por la cual el servlet podra ser invocado
    urlPatterns = { "/servlet-redireccion-servlet-parametros-contexto" })
public class ServletRedireccionServletParametrosContexto extends HttpServlet {

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

        // Asignamos las variables a los atributos del objeto de contexto del servlet
        getServletContext().setAttribute("nombre", nombre);
        getServletContext().setAttribute("apellido", apellido);

        //Redirigimos a pagina loginJSP.jsp utilizando el metodo "sendRedirect" del objeto de respuesta
        resp.sendRedirect("/AplicativoWeb/servlet-simple-receptor-contexto");

    }
}
