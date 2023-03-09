package edu.fpdual.webservice.model.logs.manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.MongoClient;
import edu.fpdual.webservice.model.logs.dao.Log;

import java.util.List;

public interface LogManager {

    void createLogRegistry(MongoClient client, Log log) throws JsonProcessingException;
    List<Log> findAll(MongoClient client) throws JsonProcessingException;

}
