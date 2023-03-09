package edu.fpdual.jdbc.ejemplojdbc.manager.impl;

import edu.fpdual.jdbc.ejemplojdbc.dao.City;
import edu.fpdual.jdbc.ejemplojdbc.manager.CityManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class CityManagerImpl implements CityManager {

    @Override
    public Set<City> findAllCities(Connection connection){

        try(Statement stm = connection.createStatement()) {

            ResultSet result = stm.executeQuery("SELECT * FROM city");

            Set<City> citySet = new HashSet<>();
            result.beforeFirst();
            while (result.next()) {
                City city = new City(result);
                citySet.add(city);
            }

            return citySet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Set<City> findCitiesByCountryCode(Connection connection, String countryCode) {
        try(PreparedStatement stm = connection.prepareStatement("SELECT * FROM city WHERE CountryCode like ?")) {

            stm.setString(1, countryCode);

            ResultSet result = stm.executeQuery();

            Set<City> citySet = new HashSet<>();
            result.beforeFirst();
            while (result.next()) {
                City city = new City(result);
                citySet.add(city);
            }

            return citySet;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Set<City> findCityByCountryCodeBetweenPopulation(Connection con, String countryCode, int startLimit, int endLimit) throws SQLException {
        try(PreparedStatement prepstm = con.prepareStatement("SELECT * FROM city " +
                    "where CountryCode = ? AND Population BETWEEN ? AND ?")) {

            prepstm.setString(1, countryCode);
            prepstm.setInt(2, startLimit);
            prepstm.setInt(3, endLimit);

            ResultSet result = prepstm.executeQuery();

            Set<City> citySet = new HashSet<>();
            result.beforeFirst();
            while (result.next()) {
                City city = new City(result);
                citySet.add(city);
            }

            return citySet;
        }
    }
}
