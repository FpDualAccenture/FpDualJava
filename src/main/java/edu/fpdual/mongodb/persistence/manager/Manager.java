package edu.fpdual.mongodb.persistence.manager;

import com.mongodb.client.MongoDatabase;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

public interface Manager<T, U> {
    /**
     * Finds all the entities in the DB
     *
     * @param con DB connection
     * @return a {@link List} of {@link T}
     */
    List<T> findAll(MongoDatabase con);


}
