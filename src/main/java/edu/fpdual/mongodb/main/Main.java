package edu.fpdual.mongodb.main;

import com.mongodb.client.MongoDatabase;
import edu.fpdual.mongodb.persistence.connector.MongoDBConnector;
import edu.fpdual.mongodb.persistence.dao.StartUpLog;
import edu.fpdual.mongodb.persistence.manager.impl.StartUpLogManagerImpl;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args)
        throws
        ClassNotFoundException,
        SQLException {

        MongoDatabase database=new MongoDBConnector().getMongoDBDatabase();

        StartUpLog newStartUpLog = StartUpLog.builder().startTime(LocalDate.now()).hostname("prueba").startTimeLocal("Prueba").build();

        // Buscar hostname C11-DIF7QTGL65W
        System.out.println(new StartUpLogManagerImpl().findByHostname(database, "C11-DIF7QTGL65W"));

        // Crear y Buscar hostname prueba
        System.out.println(new StartUpLogManagerImpl().create(database, newStartUpLog));
        System.out.println(new StartUpLogManagerImpl().findByHostname(database, "prueba"));

        // Modificar hostname prueba a Prueba 2 y Buscar hostname Prueba 2
        newStartUpLog.setHostname("Prueba 2");
        System.out.println(new StartUpLogManagerImpl().update(database, "prueba", newStartUpLog));
        System.out.println(new StartUpLogManagerImpl().findByHostname(database, "Prueba 2"));

        // Borrar hostname Prueba 2
        new StartUpLogManagerImpl().deleteByHostname(database, "Prueba 2");
        System.out.println(new StartUpLogManagerImpl().findByHostname(database, "Prueba 2"));

    }

}
