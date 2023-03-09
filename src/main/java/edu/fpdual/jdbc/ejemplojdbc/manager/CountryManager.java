package edu.fpdual.jdbc.ejemplojdbc.manager;

import edu.fpdual.jdbc.ejemplojdbc.dao.Country;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * City DTO Manager.
 *
 * Contains all the queries used to consult and manipulate Countries data.
 *
 * @author jose.m.prieto.villar
 *
 */
public interface CountryManager extends Manager<Country, String> {

    /**
     * Find an al countries between a surface area from the DB
     *
     * @param con DB connection
     * @param startSurfaceArea the range start surface area
     * @param endSurfaceArea the range end surface area
     * @return a {@link List} of {@link Country}
     * @throws {@link SQLException}
     */
    public List<Country> findBySurfaceAreaBetween(Connection con, BigDecimal startSurfaceArea,
                                                  BigDecimal endSurfaceArea) throws SQLException;

}