package edu.fpdual.webservice.model.application.manager;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface Manager<T, U> {
    /**
     * Finds all the entities in the DB
     *
     * @param con DB connection
     * @return a {@link List} of {@link T}
     */
    List<T> findAll(Connection con);

    /**
     * Delete a city using its id.
     *
     * @param con DB connection
     * @param id Entities id to delete.
     * @return a {@link Boolean}
     */
    boolean delete(Connection con, U id);

    /**
     * Creates an entity
     *
     * @param con DB connection
     * @param entity The entity to create
     * @return a {@link Boolean}
     */
    int create(Connection con, T entity);

    /**
     * updates a city
     *
     * @param con DB connection
     * @param entity The entity to update
     * @return a {@link Boolean}
     */
    boolean update(Connection con, T entity);

    /**
     * Finds all the entities in the DB based on a list of ids.
     *
     * @param con DB connection
     * @param id Entities id to search for.
     * @return a {@link T}
     */
    T findById(Connection con, U id)  throws SQLException, ClassNotFoundException;

    /**
     * Finds all the entities in the DB based on a list of ids.
     *
     * @param con DB connection
     * @param ids Entities id set to search for.
     * @return a {@link List} of {@link T}
     */
    List<T> findAllByIds(Connection con, Set<U> ids);


}
