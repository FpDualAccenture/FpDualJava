package edu.ejemplo.web.filtro;

import edu.ejemplo.web.servlet.dto.Usuario;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jose.m.prieto.villar
 *
 * Filtro que es invocado cuando la ruta de la solicitud al servidor del tipo “Request” y “Forward” que coincide con
 * “/homePage” para solicitudes. En caso de que sea invocado, recuperara el atributo “usuarioSesion” de la sesión de la
 * solicitud y si existe continuara su proceso, pero sino redirigirá nuevamente al fichero “loginJSP.jsp”.
 */
@WebFilter(
    // Definimos como nombre del filtro "FiltroSesion"
    filterName = "FiltroSesion",
    // Indicamos que el filtro será ejecutado cuando la solicitud realizada  inicie por la ruta /comun/
    urlPatterns = { "/comun/*" },
    // Indicamos que las solicitudes que provocarán la ejecución del filtro deberan de ser Request o Forward
    dispatcherTypes = {
        DispatcherType.REQUEST,
        DispatcherType.FORWARD
    })
public class FiltroSesion implements Filter {

    /**
     * Metodo de inicializacion del filtro.
     *
     * @param filterConfig Configuración inicial del filtro. De momento, no lo usamos.
     * @throws ServletException Error
     */
    @Override
    public void init(FilterConfig filterConfig)
        throws
        ServletException {
        // Metodo de inicialización del filtro. En este ejemplo no hace nada.
    }

    /**
     * Metodo principal del filtro. Realiza los siguientes pasos:
     * <ul>
     *     <li>1) Recuperamos el usuario de lasesión.</li>
     *     <li>2) Si existe un usuario en la sesión, continuamos con el flujo normal, pero si no redirigimos la llamada a "/AplicativoWeb/login/loginJSP.jsp"</li>
     * </ul
     *
     * @param servletRequest Objeto de solicitud de la llamada
     * @param servletResponse Objeto de respuesta de la llamada
     * @param filterChain Objeto principal del filtro. Es el que indica como continuar con la llamada.
     * @throws IOException Error de entrada/salida
     * @throws ServletException Error de componente servlet.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws
        IOException,
        ServletException {

        //Casteamos a objeto HttpServletRequest
        HttpServletRequest req=(HttpServletRequest)servletRequest;

        //Recuperamos usuario de la sesion
        Usuario usuario=(Usuario)req.getSession().getAttribute("usuarioSesion");

        //Validamos si existe usuario en la sesion
        if (usuario == null) {
            //Redirigimos a pagina loginJSP.jsp utilizando el metodo "sendRedirect" del objeto de respuesta
            ((HttpServletResponse)servletResponse).sendRedirect("/AplicativoWeb/login/loginJSP.jsp");
        }
        else {
            /*Indicamos al filtro que continue su camino con los mismos objetos request y response que recibimos como parametros del metodo  */
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
