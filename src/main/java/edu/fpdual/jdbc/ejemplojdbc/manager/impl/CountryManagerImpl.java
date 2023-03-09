package edu.fpdual.jdbc.ejemplojdbc.manager.impl;

import edu.fpdual.jdbc.ejemplojdbc.dao.Country;
import edu.fpdual.jdbc.ejemplojdbc.manager.CountryManager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Country DTO Manager.
 * <p>
 * Contains all the queries used to consult and manipulate Countries data.
 *
 * @author jose.m.prieto.villar
 */
public class CountryManagerImpl implements CountryManager {

    @Override
    public List<Country> findAll(Connection con) {
        // Creates the SQL command
        String sql = "SELECT * FROM Country";

        // Create a prepared statement
        try (Statement stmt = con.createStatement()) {

            // Executes sql command
            ResultSet result = stmt.executeQuery(sql);
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initializes variables
            List<Country> countries = new ArrayList<>();

            // Run through each result
            while (result.next()) {
                // Initializes a country per result
                countries.add(new Country(result));
            }

            return countries;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Country findById(Connection con, String id) {
        // Creates the SQL command
        String sql = "SELECT * FROM Country WHERE code = ?";

        // Create a prepared statement
        try (PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, id);

            // Executes sql command
            ResultSet result = stmt.executeQuery();
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initializes variables
            Country country = null;

            // Run through each result
            while (result.next()) {
                // Initializes a country per result
                country = new Country(result);
            }

            return country;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Country> findAllByIds(Connection con, Set<String> ids) {
        // Creates the SQL command
        String sql = String.format("SELECT * FROM Country WHERE Code IN (%s)",
                ids.stream().map(data -> "\"" + data + "\"").collect(Collectors.joining(", ")));
        // "ESP","FR","DEU","UK","PR"
        // SELECT * FROM Country WHERE Code in ("ESP","FR","DEU","UK","PR"

        // Create a prepared statement
        try (Statement stmt = con.createStatement()) {

            // Executes sql command
            ResultSet result = stmt.executeQuery(sql);
            // Set before first registry before going through it.
            result.beforeFirst();

            // Initializes variables
            List<Country> countries = new ArrayList<>();

            // Run through each result
            while (result.next()) {
                // Initializes a country per result
                countries.add(new Country(result));
            }

            return countries;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Country> findBySurfaceAreaBetween(Connection con, BigDecimal startSurfaceArea,
                                                  BigDecimal endSurfaceArea) throws SQLException {

        try (PreparedStatement prepStmt = con
                .prepareStatement("SELECT * FROM Country where SurfaceArea between ? and ?")) {
            prepStmt.setBigDecimal(1, startSurfaceArea);
            prepStmt.setBigDecimal(2, endSurfaceArea);

            return prepareReturn(prepStmt.executeQuery());
        }

    }

    /**
     * Prepare the return of a result set
     * @param result the result set to prepate
     * @return a {@link List} of {@link Country}
     * @throws {@link SQLException}
     */
    private List<Country> prepareReturn(ResultSet result) throws SQLException {

        List<Country> countries = new ArrayList<>();

        while (result.next()) {
            countries.add(new Country(result));
        }

        return countries;
    }

}
