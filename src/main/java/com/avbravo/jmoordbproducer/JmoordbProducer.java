/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbproducer;

import com.mongodb.MongoClient;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

/**
 *
 * @author avbravo
 */
@Singleton
public class JmoordbProducer {
     @Produces
    @ApplicationScoped
    public MongoClient mongoClient() {
        String username =(String) JmoordbContextApplication.get("username");
        String password =(String)JmoordbContextApplication.get("password");
        MongoClient mongo = new MongoClient("localhost", 27017);
        return mongo;
    } 
}
