package edu.fpdual.jsp.service;

import edu.fpdual.jsp.persistence.conector.MySQLConnector;
import edu.fpdual.jsp.persistence.dao.City;
import edu.fpdual.jsp.persistence.manager.CityManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CityService {

    private MySQLConnector connector;

    private CityManager manager;

    public CityService(MySQLConnector connector, CityManager manager){
        this.connector = connector;
        this.manager = manager;
    }

    public List<City> findAllCities()
        throws
        SQLException,
        ClassNotFoundException {

        Connection con = null;

        try {
            con = connector.getMySQLConnection();

            return manager.findAll(con);
        }finally {
            if(con!=null){
                con.close();
            }
        }
    }

    public City findCityById(int id)
        throws
        SQLException,
        ClassNotFoundException {

        Connection con = null;

        try {
            con = connector.getMySQLConnection();

            return manager.findById(con, id);
        }finally {
            if(con!=null){
                con.close();
            }
        }
    }
}
