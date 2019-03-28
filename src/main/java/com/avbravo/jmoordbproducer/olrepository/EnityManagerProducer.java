/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbproducer.olrepository;

import com.mongodb.MongoClient;
import java.io.Serializable;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

/**
 *
 * @author avbravo
 */
public class EnityManagerProducer implements Serializable{

    //private MongoClient mongoClient;

    @Produces
    @NoSQLDatabase
    public MongoClient createEntityManager() {
        MongoClient mongoClient= new MongoClient();
        return mongoClient;
    }

    public void close(
            @Disposes @NoSQLDatabase MongoClient mongoClient) {
        mongoClient.close();
    }
}
