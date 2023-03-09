package edu.fpdual.webservice;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Path("nombre")
    @Produces(MediaType.APPLICATION_JSON)
    public String getNombre(@QueryParam("name") String nombre) {
        return "Got it "+nombre+"!";
    }

    @POST
    @Path("nombre/{name}")
    @Produces(MediaType.APPLICATION_XML)
    public String getNombrePorPath(@PathParam("name") String nombre) {
        return "Got it "+nombre+"!";
    }
}
