package edu.fpdual.webservice.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import edu.fpdual.webservice.model.application.dao.City;
import edu.fpdual.webservice.model.application.manager.impl.CityManagerImpl;
import edu.fpdual.webservice.service.CityService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/city")
public class CityController {

    private final CityService cityService;

    public CityController() {
        this.cityService = new CityService(new CityManagerImpl());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() throws SQLException, ClassNotFoundException, JsonProcessingException {
        return Response.ok().entity(cityService.findAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findById(@PathParam("id") Integer id) {
        try {
            if (id == null) {
                return Response.status(400).entity("Incorrect Parameters").build();
            } else {
                return Response.ok().entity(cityService.findById(id)).build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCity(@PathParam("id") Integer id) {
        try {
            City cityToDelete = cityService.findById(id);
            if (cityToDelete != null) {
                if (cityService.deleteCity(id)) {
                    return Response.status(200).entity(cityToDelete).build();
                } else {
                    return Response.status(304).entity("City Was Not Deleted").build();
                }
            } else {
                return Response.status(404).entity("City Not Found").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCity(City city) {
        try {
            int createdId = cityService.createCity(city);
            if (createdId > 0) {
                return Response.status(201).entity(cityService.findById(createdId)).build();
            } else {
                return Response.status(500).entity("Internal Error During Creating The City").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCity(City city) {
        try {
            City cityToDelete = cityService.findById(city.getId());
            if (cityToDelete != null) {
                if (cityService.updateCity(city)) {
                    return Response.status(200).entity(cityService.findById(city.getId())).build();
                } else {
                    return Response.status(500).entity("Internal Error During City Update").build();
                }
            } else {
                return Response.status(404).entity("City Not Found").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

}
