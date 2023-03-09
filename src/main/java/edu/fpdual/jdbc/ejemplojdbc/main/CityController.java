package edu.fpdual.jdbc.ejemplojdbc.main;

import edu.fpdual.jdbc.ejemplojdbc.connector.MySQLConnector;
import edu.fpdual.jdbc.ejemplojdbc.dao.City;
import edu.fpdual.jdbc.ejemplojdbc.dao.Country;
import edu.fpdual.jdbc.ejemplojdbc.manager.CityManager;
import edu.fpdual.jdbc.ejemplojdbc.manager.impl.CityManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class CityController {

    private CityManager cityManager;

    public CityController(CityManagerImpl cityManagerImpl) {
        this.cityManager = cityManagerImpl;
    }

    public List<City> getAllCities() throws ClassNotFoundException, SQLException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            List<Country> countries = new ArrayList<>();
            Country conun = new Country();
            Consumer<City> consu = data -> {
                countries.add(data.getCountry());
                System.out.println(conun);
            };
            cityManager.findAll(con).forEach(consu);

            return cityManager.findAll(con);
        }
    }

}
