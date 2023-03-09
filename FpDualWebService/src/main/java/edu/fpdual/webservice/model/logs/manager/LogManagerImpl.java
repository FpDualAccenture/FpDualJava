package edu.fpdual.webservice.model.logs.manager;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import edu.fpdual.webservice.model.logs.conector.MongoConnector;
import edu.fpdual.webservice.model.logs.dao.Log;
import edu.fpdual.webservice.model.logs.dao.LogStatus;
import org.bson.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class LogManagerImpl implements LogManager {

    private static final String DB = "local";
    private static final String COLLECTION = "logs";

    @Override
    public List<Log> findAll(MongoClient client) throws JsonProcessingException {
        MongoDatabase db = client.getDatabase(DB);

        MongoCollection<Document> collection = db.getCollection(COLLECTION);

        FindIterable<Document> documents = collection.find();

        MongoCursor<Document> cursor = documents.projection(Projections.excludeId()).iterator();

        List<Log> logs = new ArrayList<>();

        while(cursor.hasNext()){
            Log readLog = new ObjectMapper().readValue(cursor.next().toJson(), Log.class);
            logs.add(readLog);
        }

        return logs;
    }

    @Override
    public void createLogRegistry(MongoClient client, Log log) throws JsonProcessingException {
        MongoDatabase db = client.getDatabase(DB);

        MongoCollection<Document> collection = db.getCollection(COLLECTION);

        Document logDocument = new Document();
        logDocument.append("fecha",log.getFecha().toString());
        logDocument.append("logStatus",log.getLogStatus().name());
        logDocument.append("titulo",log.getTitulo());
        logDocument.append("mensaje",log.getMensaje());

        //Document logDocument = Document.parse(new ObjectMapper().writeValueAsString(log));

        collection.insertOne(logDocument);
    }

    public static void main(String[] args) throws JsonProcessingException {
        Log log = Log
                .builder()
                .fecha(LocalDateTime.now())
                .logStatus(LogStatus.OK)
//                .titulo("Prueba Con Object Mapper")
//                .mensaje("Probando Log Con Object Mapper")
                .titulo("Prueba Con Asignacion Manual")
                .mensaje("Probando Log Con Asignacion Manual")
                .build();

        MongoClient client = new MongoConnector().getMongoConnection();
       // new LogManagerImpl().createLogRegistry(client, log);
        new LogManagerImpl().findAll(client).forEach(System.out::println);

    }

}
