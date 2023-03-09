package edu.fpdual.webservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.MongoClient;
import edu.fpdual.webservice.model.logs.conector.MongoConnector;
import edu.fpdual.webservice.model.logs.dao.Log;
import edu.fpdual.webservice.model.logs.manager.LogManager;
import edu.fpdual.webservice.model.logs.manager.LogManagerImpl;

public class LogService {

    private LogManager manager;

    public LogService(){
        this.manager = new LogManagerImpl();
    }

    public void registerLog(Log log) throws JsonProcessingException {
        MongoClient client = new MongoConnector().getMongoConnection();
        manager.createLogRegistry(client, log);
    }

}
