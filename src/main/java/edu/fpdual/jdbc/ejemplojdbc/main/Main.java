package edu.fpdual.jdbc.ejemplojdbc.main;

import edu.fpdual.jdbc.ejemplojdbc.connector.MySQLConnector;
import edu.fpdual.jdbc.ejemplojdbc.manager.impl.CityManagerImpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Connects to the DB

        try (Connection con = new MySQLConnector().getMySQLConnection()){
            // Looks for all the cities in the DB and prints them.
            System.out.println(new CityManagerImpl().findById(con, 2));

//			List<Country> countries = new CountryManager().findBySurfaceAreaBetween(con, BigDecimal.valueOf(100),
//					BigDecimal.valueOf(1000));
//			System.out.println(countries.size());
//			countries.forEach(country -> System.out.println(country));
//			new GeneralManager().findLanguajeDataWithPercentageGreaterThan(con, 0)
//					.forEach(data -> System.out.printf(
//							"Datos de la ciudad %s: lenguaje -> %s - Porcentaje de habla: %f - Pais: (%s) %s ",
//							data.getCityName(), data.getCityLanguage(), data.getLanguagePercentage(),
//							data.getCountryCode(), data.getCountryName() + "\n"));
        }
    }

}
