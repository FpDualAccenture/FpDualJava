package edu.fpdual.mongodb.persistence.connector;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class responsible for creation of MySQL DB connection.
 *
 * @author jose.m.prieto.villar
 */
public class MongoDBConnector {

    @Setter
    @Getter
    Properties prop=new Properties();

    public MongoDBConnector() {
        try {
            //Loads all the properties of file "config.properties".
            prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the connection object for a MySQL DDBB
     *
     * @return a {@link Connection}
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public MongoDatabase getMongoDBDatabase()
        throws
        ClassNotFoundException,
        SQLException {

        //            MongoClient mongoClient =MongoClients.create(MongoClientSettings.builder().applyConnectionString(new ConnectionString(getURL())).build());

        MongoClient mongoClient= MongoClients.create("mongodb://localhost:27017");
        return mongoClient.getDatabase(prop.getProperty(MongoDBConstants.URL_DATABASE));

    }

    /**
     * Obtains the URL to connect to a MySQL DDBB.
     *
     * @return an URL
     */
    private String getURL() {
        //mongodb+srv:/<username>:<password>@<hostname>:<port>?connectTimeoutMS(2000)
        return new StringBuilder().append(prop.getProperty(MongoDBConstants.URL_PREFIX))
            .append(prop.getProperty(MongoDBConstants.USER)).append(":")
            .append(prop.getProperty(MongoDBConstants.PASSWD)).append("@")
            .append(prop.getProperty(MongoDBConstants.URL_HOST)).append(":")
            .append(prop.getProperty(MongoDBConstants.URL_PORT)).append("?connectTimeoutMS(2000)")
            .toString();
    }

    public static void main(String[] args)
        throws
        SQLException,
        ClassNotFoundException {
        MongoDBConnector connector=new MongoDBConnector();
        MongoDatabase database=connector.getMongoDBDatabase();
        database.listCollectionNames().forEach(System.out::println);

    }

}
