package edu.fpdual.jsp.web.servlet;

import edu.fpdual.jsp.persistence.conector.MySQLConnector;
import edu.fpdual.jsp.persistence.manager.CityManager;
import edu.fpdual.jsp.service.CityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CityServlet", urlPatterns = { "/servlet-ciudades" })
public class CityServlet extends HttpServlet {

    private CityService service;

    @Override
    public void init()
        throws
        ServletException {
        service=new CityService(new MySQLConnector(), new CityManager());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws
        ServletException,
        IOException {

        try {

            if (req.getParameter("id") !=null && !req.getParameter("id").trim().isEmpty()) {
                int id=Integer.parseInt(req.getParameter("id"));
                req.getSession().setAttribute("ciudad", service.findCityById(id));
            }
            else {
                req.getSession().setAttribute("ciudades", service.findAllCities());
            }

            resp.sendRedirect("/EjemploJSP/bbdd/listaCiudades.jsp");

        }
        catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
