package edu.fpdual.jdbc.ejemplojdbc;

import edu.fpdual.jdbc.ejemplojdbc.controller.CityController;
import edu.fpdual.jdbc.ejemplojdbc.manager.impl.CityLimitedManagerImpl;
import edu.fpdual.jdbc.ejemplojdbc.manager.impl.CityManagerImpl;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CityController cityController = new CityController(new CityManagerImpl());
        System.out.println(cityController.findAllCities().size());
        System.out.println(cityController.findCitiesByCountryCode("NLD").size());

        cityController = new CityController(new CityLimitedManagerImpl());
        System.out.println(cityController.findAllCities().size());
        System.out.println(cityController.findCitiesByCountryCode("AFG").size());
    }

}
