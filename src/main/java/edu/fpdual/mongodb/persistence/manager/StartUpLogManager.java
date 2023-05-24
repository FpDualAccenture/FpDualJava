package edu.fpdual.mongodb.persistence.manager;


import com.mongodb.client.MongoDatabase;
import edu.fpdual.mongodb.persistence.dao.StartUpLog;
import org.bson.BsonValue;

import java.util.List;
import java.util.Set;

/**
 * Start Up Log Manager.
 *
 * Contains all the queries used to consult and manipulate Start Up Log data.
 *
 * @author jose.m.prieto.villar
 *
 */
public interface StartUpLogManager extends Manager<StartUpLog, Integer>{

    /**
     * Finds all the logs in the DB based on a hostname.
     *
     * @param mongoDatabase MongoDB connection
     * @param hostname Hostname to search
     * @return a {@link Set} of {@link StartUpLog}
     */
    List<StartUpLog> findByHostname(MongoDatabase mongoDatabase, String hostname);

    /**
     * Creates a logs in the DB based.
     *
     * @param mongoDatabase MongoDB connection
     * @param startUpLog startUpLog to save
     */
    BsonValue create(MongoDatabase mongoDatabase, StartUpLog startUpLog);

    /**
     * Updates a logs in the DB based.
     *
     * @param mongoDatabase MongoDB connection
     * @param hostname hostname to update
     * @param startUpLog data to update
     */
    long update(MongoDatabase mongoDatabase,String hostname, StartUpLog startUpLog);

    /**
     * Delete the logs in the DB based on a hostname.
     *
     * @param mongoDatabase MongoDB connection
     * @param hostname Hostname to search
     */
    void deleteByHostname(MongoDatabase mongoDatabase, String hostname);
}