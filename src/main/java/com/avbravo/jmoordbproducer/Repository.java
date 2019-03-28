/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbproducer;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import org.bson.Document;

/**
 *
 * @author avbravo
 */
public abstract class Repository <T> implements EntityDao<T>{

    private MongoClient mongoClient;
    private Class<T> entityClass;

    @Inject
    public Repository(
            @NoSQLDatabase MongoClient mongoClient,
             Class<T> entityClass) {
        this.mongoClient = mongoClient;
        this.entityClass = entityClass;
    }

    @Override
    public void save(T t) {  
        MongoDatabase db= mongoClient.getDatabase("midatanew");
          // Fetching the database from the mongodb.
      
 
        // Fetching the collection from the mongodb.
        MongoCollection<Document> coll = db.getCollection("micoleccion");
        Document emp1 = new Document();
        emp1.put("name", "yatin batra");
        emp1.put("website", "javacodegeeks.com");
 
        Document emp1_addr = new Document();
        emp1_addr.put("addr_line1", "Savannah, Illinois");      
        emp1_addr.put("zip_code", "85794");
        emp1.put("address", emp1_addr);
 
        coll.insertOne(emp1);
       
    }

    @Override
    public T find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> findAll(String table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}