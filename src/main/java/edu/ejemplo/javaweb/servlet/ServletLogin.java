package edu.ejemplo.javaweb.servlet;

import edu.ejemplo.javaweb.servlet.dto.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jose.m.prieto.villar
 *
 * Este servlet pretende validar los parametros recibidos con las credenciales de la aplicacion. En caso de coincidir
 * crea un objeto de usuario y lo almacena en la sesion, y en caso contrario redirige el flujo a la web de login con
 * un mensaje de error para informar al usuario de lo que ha ocurrido.
 */

@WebServlet(
    // Definimos el nombre del servlet
    name="ServletLogin",
    // Definimos la ruta (URL) por la cual el servlet podra ser invocado
    urlPatterns="/servlet-login")
public class ServletLogin extends HttpServlet {

    /**
     * Método que es accedido cuando se invoca al servlet utilizando el metodo POST. Realiza los siguientes pasos:
     *
     * <ul>
     *     <li> 1) Recuperamos los parametros de usuario y contraseña de la solicitud.</li>
     *     <li> 2) Validamos si las credenciales del sistema coinciden con los parametros recibidos. En caso de que si:
     *           <ul>
     *               <li>a. Se crea un objeto de usuario con estos parametros.</li>
     *               <li>b. Se asigna el objeto de usuario a la sesion.</li>
     *               <li>c. Se indica el tiempo de expiración de la sesion.</li>
     *               <li>d. Se indica en la respuesta la ruta de la redirección.</li>
     *           </ul>
     *           En caso de que no coincidan, se indica un mensaje de error y se hace forward a la pantalla de login.
     *     </li>
     * </ul
     *
     * @param req Objeto de solicitud de la llamada
     * @param resp Objeto de respuesta de la llamada
     * @throws IOException Error de entrada/salida
     * @throws ServletException Error de componente servlet.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
        ServletException,
        IOException {

        // Recuperamos parametros de la entrada
        String usuario = req.getParameter("user");
        String password = req.getParameter("password");

        //Se valida si los parametros coinciden con las credenciales
        if(usuario.equals("admin") && password.equals("123456")){
            //Se crea usuario con los datos de los parametros
            Usuario user = Usuario.builder().usuario(usuario).password(password).build();

            //Se asocia el objeto a la sesion
            req.getSession().setAttribute("userLogin", user);
            //Se indica el tiempo de expiración de la sesion
            req.getSession().setMaxInactiveInterval(10);

            //Redirigimos a pagina homePage.jsp utilizando el metodo "sendRedirect" del objeto de respuesta
            resp.sendRedirect("/AplicativoWebTemplate/home/homePage.jsp");
        } else {
            //Se indica mensaje de error en los atributos de la solicitud
            req.setAttribute("error","Error al validar usuario y contraseña");

            //Indicamos al dispatcher que haga un forward de la solicitud. Tener en cuenta que esta solicitud es la
            //recibida en este servlet mas los parametros indicados en los atributos.
            req.getRequestDispatcher("/AplicativoWebTemplate/index.jsp").forward(req,resp);
        }

    }

}
