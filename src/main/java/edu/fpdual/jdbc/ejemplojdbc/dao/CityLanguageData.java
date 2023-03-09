package edu.fpdual.jdbc.ejemplojdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CityLanguageData {

    private String cityName;
    private String cityLanguage;
    private float languagePercentage;
    private String countryCode;
    private String countryName;

    public CityLanguageData(ResultSet result) throws SQLException {
        this.cityName = result.getString(1);
        this.cityLanguage = result.getString("cityLanguage");
        this.languagePercentage = result.getFloat(3);
        this.countryCode = result.getString("code");
        this.countryName = result.getString("name");

    }

}
