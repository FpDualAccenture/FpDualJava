package edu.fpdual.jsp.persistence.manager;

import edu.fpdual.jsp.persistence.dao.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityManager {

    public List<City> findAll(Connection con) {

        try (Statement stm=con.createStatement()) {

            ResultSet result=stm.executeQuery("SELECT * FROM City");

            result.beforeFirst();

            List<City> cities=new ArrayList<>();

            while (result.next()) {
                cities.add(new City(result));
            }

            return cities;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public City findById(Connection con, int id) {

        try (PreparedStatement stm=con.prepareStatement("SELECT * FROM City WHERE ID = ?")) {

            stm.setInt(1, id);

            ResultSet result=stm.executeQuery();

            result.beforeFirst();

            City city=null;

            while (result.next()) {
                city=new City(result);
            }

            return city;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
