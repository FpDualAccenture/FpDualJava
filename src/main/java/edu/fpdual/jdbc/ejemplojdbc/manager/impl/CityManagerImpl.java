package edu.fpdual.jdbc.ejemplojdbc.manager.impl;

import edu.fpdual.jdbc.ejemplojdbc.dao.City;
import edu.fpdual.jdbc.ejemplojdbc.dao.Country;
import edu.fpdual.jdbc.ejemplojdbc.manager.CityManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * City DTO Manager.
 *
 * Contains all the queries used to consult and manipulate Cities data.
 *
 * @author jose.m.prieto.villar
 *
 */
public class CityManagerImpl implements CityManager {

    @Override
    public List<City> findAll(Connection con) {
        // Create general statement
        try (Statement stmt = con.createStatement()) {
            // Queries the DB
            ResultSet result = stmt.executeQuery("SELECT * FROM City");
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initializes variables
            List<City> cities = new ArrayList<>();
            Map<Integer, String> countries = new HashMap();

            // Run through each result
            while (result.next()) {
                // Initializes a city per result
                cities.add(new City(result));
                // Groups the countried by city
                countries.put(result.getInt("ID"), result.getString("CountryCode"));
            }

            // Fills the country of each city
            fillCountries(con, countries, cities);

            return cities;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public City findById(Connection con, Integer id) {
        //prepare SQL statement
        String sql = "select * "
                + "from city a, Country b "
                + "where a.id = ? "
                + "and a.CountryCode = b.Code";

        // Create general statement
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            //Add Parameters
            stmt.setInt(1, id);
            // Queries the DB
            ResultSet result = stmt.executeQuery();
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initialize variable
            City city = null;

            // Run through each result
            while (result.next()) {
                // Initializes a city per result
                city = new City(result);
                Country country = new Country(result);
                city.setCountry(country);
            }

            return city;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<City> findAllByIds(Connection con, Set<Integer> ids) {
        //prepare SQL statement
        String sql = String.format("select * "
                + "from city a, Country b "
                + "where a.CountryCode = b.Code "
                + "and a.id IN (%s)",
                ids.stream().map(data -> "\"" + data + "\"").collect(Collectors.joining(", ")));

        // Create general statement
        try (Statement stmt = con.createStatement()) {
            // Queries the DB
            ResultSet result = stmt.executeQuery(sql);
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initialize variable
            List<City> cities = new ArrayList<>();

            // Run through each result
            while (result.next()) {
                // Initializes a city per result
                City city = new City(result);
                Country country = new Country(result);
                city.setCountry(country);
                cities.add(city);
            }

            return cities;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Set<City> findByCountryCode(Connection con, String countryCode) {
        //prepare SQL statement
        String sql = "select * "
                + "from city a, Country b "
                + "where  a.CountryCode = b.Code "
                + "and b.Code = ? ";

        // Create general statement
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            //Add Parameters
            stmt.setString(1, countryCode);
            // Queries the DB
            ResultSet result = stmt.executeQuery();
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initialize variable
            Set<City> cities = new HashSet<>();

            // Run through each result
            while (result.next()) {
                // Initializes a city per result
                City city = new City(result);
                Country country = new Country(result);
                city.setCountry(country);
                cities.add(city);
            }

            return cities;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Fills all the countries for each city.
     *
     * @param con       the Db connection
     * @param countries the map of cities and countries.
     * @param cities    the list of cities to update.
     */
    private void fillCountries(Connection con, Map<Integer, String> countries, List<City> cities) {
        // Obtains all the country codes to search
        Set<String> countryCodes = new HashSet<>(countries.values());

        // Looks for all countries and groups them by id.
        Map<String, Country> countriesMap = new CountryManagerImpl().findAllByIds(con, countryCodes).stream()
                .collect(Collectors.toMap(Country::getId, data -> data));

        // Associates the corresponding Country to each City
        cities.forEach(city -> {
            String countryCode = countries.get(city.getId());
            Country foundCountry = countriesMap.get(countryCode);
            city.setCountry(foundCountry);
        });

    }

}
