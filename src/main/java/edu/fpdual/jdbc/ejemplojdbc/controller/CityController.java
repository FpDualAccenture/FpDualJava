package edu.fpdual.jdbc.ejemplojdbc.controller;

import edu.fpdual.jdbc.ejemplojdbc.connector.MySQLConnector;
import edu.fpdual.jdbc.ejemplojdbc.dao.City;
import edu.fpdual.jdbc.ejemplojdbc.manager.CityManager;
import edu.fpdual.jdbc.ejemplojdbc.manager.impl.CityManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

public class CityController {

    private CityManager cityManager;

    public CityController (final CityManager cityManager){
        this.cityManager = cityManager;
    }

    public Set<City> findAllCities() throws SQLException, ClassNotFoundException {
        Connection connection = new MySQLConnector().getMySQLConnection();
        Set<City> cities = cityManager.findAllCities(connection);

        for(City city : cities){
            city.setName(city.getName().toUpperCase());
        }

        return cities;
    }

    public Set<City> findCitiesByCountryCode(String countryCode)
            throws SQLException, ClassNotFoundException {
        Connection connection = new MySQLConnector().getMySQLConnection();
        return cityManager.findCitiesByCountryCode(connection, countryCode);
    }

    public Set<City> findCityByCountryCodeBetweenPopulation(String countryCode, int startLimit, int endLimit)
            throws SQLException, ClassNotFoundException {
        Connection connection = new MySQLConnector().getMySQLConnection();
        return cityManager.findCityByCountryCodeBetweenPopulation(connection, countryCode, startLimit, endLimit);
    }

}
