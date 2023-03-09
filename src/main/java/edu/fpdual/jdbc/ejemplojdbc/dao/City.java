package edu.fpdual.jdbc.ejemplojdbc.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class City {

    private int id;
    private String name;
    private String countryCode;
    private String district;
    private BigInteger population;

    public City(ResultSet result) throws SQLException {
        setId(result.getInt("Id"));
        setName(result.getString("Name"));
        setCountryCode(result.getString("CountryCode"));
        setDistrict(result.getString("District"));
        setPopulation(result.getBigDecimal("Population").toBigInteger());
    }


}
