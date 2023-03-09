package edu.fpdual.webservice.model.logs.conector;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.function.Consumer;

/**
 * Class responsible for creation of MySQL DB connection.
 * @author jose.m.prieto.villar
 *
 */
public class MongoConnector {

    @Setter
    @Getter
    Properties prop = new Properties();

    public MongoConnector() {
        try {
            //Loads all the properties of file "mongoconfig.properties".
            prop.load(getClass().getClassLoader().getResourceAsStream("mongoconfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the connection object for a Mongo DDBB
     * @return a {@link MongoClient}
     */
    public MongoClient getMongoConnection(){
            return  new MongoClient(prop.getProperty(MongoConstants.URL_HOST),
                    Integer.parseInt(prop.getProperty(MongoConstants.URL_PORT)));
    }

    public static void main(String[] args) {
        MongoConnector connector = new MongoConnector();
        MongoClient connection = connector.getMongoConnection();
        Consumer<String> consumer = System.out::println;
        connection.listDatabaseNames().forEach(consumer);
    }

}