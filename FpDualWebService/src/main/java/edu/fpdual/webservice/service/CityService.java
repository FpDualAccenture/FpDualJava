package edu.fpdual.webservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.fpdual.webservice.model.application.conector.MySQLConnector;
import edu.fpdual.webservice.model.application.dao.City;
import edu.fpdual.webservice.model.application.manager.CityManager;
import edu.fpdual.webservice.model.application.manager.impl.CityManagerImpl;
import edu.fpdual.webservice.model.logs.dao.Log;
import edu.fpdual.webservice.model.logs.dao.LogStatus;
import edu.fpdual.webservice.model.logs.manager.LogManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class CityService {

    private final CityManager cityManager;
    private final LogService logService;

    public CityService(CityManagerImpl cityManager){

        this.cityManager = cityManager;
        this.logService = new LogService();
    }

    public List<City> findAll() throws SQLException, ClassNotFoundException, JsonProcessingException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            logService.registerLog(
                    Log.builder().fecha(LocalDateTime.now())
                            .logStatus(LogStatus.OK).titulo("Buscando Todos las ciudades.")
                            .mensaje("Buscando todas las ciudades sin filtro.").build());
            List<City> cities = cityManager.findAll(con);
            logService.registerLog(
                    Log.builder().fecha(LocalDateTime.now())
                            .logStatus(LogStatus.OK).titulo("Busqueda de ciudades exitosa.")
                            .mensaje("Busqueda de ciudades sin filtro  exitosa. Encontradas "+cities.size()+" ciudades.").build());
            return cities;
        }
    }

    public City findById(Integer id) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return cityManager.findById(con, id);
        }
    }

    public boolean deleteCity(Integer id) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return cityManager.delete(con, id);
        }
    }

    public int createCity(City city) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return cityManager.create(con, city);
        }
    }

    public boolean updateCity(City city) throws SQLException, ClassNotFoundException {
        try (Connection con = new MySQLConnector().getMySQLConnection()) {
            return cityManager.update(con, city);
        }
    }

}
