package edu.fpdual.jsp.persistence.dao;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
public class City {
    int id;
    String name;
    String countryCode;
    String district;
    BigDecimal population;

    public City() {

    }

    public City(ResultSet result) {
        try {
            this.id = result.getInt("ID");
            this.name = result.getString("name");
            this.countryCode = result.getString("CountryCode");
            this.district = result.getString("District");
            this.population = result.getBigDecimal("Population");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
