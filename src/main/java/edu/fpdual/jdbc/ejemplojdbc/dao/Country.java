package edu.fpdual.jdbc.ejemplojdbc.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Country implements Comparable<Country>{

    String id;
    String code;
    String name;
    String continent;
    String region;
    BigDecimal surfaceArea;
    int independenceYear;
    BigInteger population;
    Double lifeExpectancy;
    Double gnp;
    Double gnpoId;
    String localName;
    String govermentForm;
    String headOfState;
    int capitalCode;

    public Country() {

    }
    public Country(ResultSet result) {
        try {
            this.id = result.getString("Code");
            this.code = result.getString("Code2");
            this.name = result.getString("Name");
            this.continent = result.getString("Continent");
            this.region = result.getString("Region");
            this.surfaceArea = result.getBigDecimal("SurfaceArea");
            this.independenceYear = result.getInt("IndepYear");
            this.population = result.getBigDecimal("population").toBigInteger();
            this.lifeExpectancy = result.getDouble("LifeExpectancy");
            this.gnp = result.getDouble("GNP");
            this.gnpoId = result.getDouble("GNPOld");
            this.localName = result.getString("LocalName");
            this.govermentForm = result.getString("GovernmentForm");
            this.headOfState = result.getString("HeadOfState");
            this.capitalCode = result.getInt("Capital");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public int compareTo(Country o) {
        return this.name.compareTo(o.getName());
    }


}