package edu.fpdual.jsp.web.filter;


import edu.fpdual.jsp.web.servlet.dto.Usuario;

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

@WebFilter(filterName="FiltroSesion", urlPatterns={"/comun/*"}, dispatcherTypes= {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class FiltroSesion implements  Filter {

    @Override
    public void init(FilterConfig filterConfig)
        throws
        ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws
        IOException,
        ServletException {

        HttpServletRequest req = (HttpServletRequest)servletRequest;

        Usuario usuario = (Usuario)req.getSession().getAttribute("usuarioSesion");

        if(usuario == null){
            ((HttpServletResponse)servletResponse).sendRedirect("/EjemploJSP/login/loginJSP.jsp");
        } else {
            System.out.println("Antes de pasar filtro");
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("Despues de pasar filtro");
        }
    }
}
