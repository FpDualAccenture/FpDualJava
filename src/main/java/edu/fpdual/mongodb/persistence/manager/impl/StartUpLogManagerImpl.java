package edu.fpdual.mongodb.persistence.manager.impl;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.fpdual.mongodb.persistence.dao.StartUpLog;
import edu.fpdual.mongodb.persistence.manager.StartUpLogManager;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
/**
 * Start Up Log Manager Implementation.
 *
 * Defines the behavior all the queries used to consult and manipulate Start Up Log data.
 *
 * @author jose.m.prieto.villar
 *
 */
public class StartUpLogManagerImpl implements StartUpLogManager {

    @Override
    public List<StartUpLog> findAll(MongoDatabase database) {
        return getCollection(database).find().into(new ArrayList<>());
    }

    @Override
    public List<StartUpLog> findByHostname(MongoDatabase database, String hostname) {
        MongoCollection<StartUpLog> collection=getCollection(
            database);
        Document searchQuery = new Document();
        searchQuery.put("hostname", hostname);
        return collection.find(searchQuery).into(new ArrayList<>());
    }

    @Override
    public BsonValue create(MongoDatabase mongoDatabase, StartUpLog startUpLog) {
        return getCollection(mongoDatabase).insertOne(startUpLog).getInsertedId();
    }

    @Override
    public long update(MongoDatabase mongoDatabase, String hostname, StartUpLog startUpLog) {

        Document document = new Document();
        document.put("hostname", hostname);

        Document updateObject = new Document();
        updateObject.put("$set", startUpLog);

        return getCollection(mongoDatabase).updateOne(document, updateObject).getModifiedCount();
    }

    @Override
    public void deleteByHostname(MongoDatabase mongoDatabase, String hostname) {
        Document document = new Document();
        document.put("hostname", hostname);

        getCollection(mongoDatabase).deleteOne(document);
    }

    private static MongoCollection<StartUpLog> getCollection(MongoDatabase database) {
        MongoCollection<StartUpLog> collection = database.withCodecRegistry(getCodecRegistry()).getCollection("startup_log", StartUpLog.class);
        return collection;
    }

    private static CodecRegistry getCodecRegistry() {
        PojoCodecProvider codecProvider = PojoCodecProvider.builder()
            .automatic(true)
            .build();
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), fromProviders(codecProvider));
        return pojoCodecRegistry;
    }
}
