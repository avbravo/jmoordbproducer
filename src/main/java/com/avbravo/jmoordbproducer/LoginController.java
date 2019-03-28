/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbproducer;

import com.avbravo.jmoordbproducer.olrepository.Person;
import com.avbravo.jmoordbproducer.olrepository.Repository;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author avbravo
 */
@Named(value = "indexController")
@ViewScoped
public class LoginController implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Inject
//    @NoSQLDatabase
//    MongoClient createEntityManager;
    public static final String DB_NAME = "demo";
    public static final String COLL_NAME = "students";
    @Inject
    MongoClient mongoClient;
    protected MongoDatabase db;
    protected MongoCollection<Document> collection;

    @PostConstruct
    public void init() {
        JmoordbContextApplication.put("username", "avbravo");
        JmoordbContextApplication.put("password", "password");
        this.db = this.mongoClient.getDatabase(DB_NAME);
        this.collection = this.db.getCollection(COLL_NAME);
    }

    private Repository<Person> repository;

    public LoginController() {
    }

//@Inject
//    public IndexController(Repository<Person> baserepository) {
//        this.repository = baserepository;
//    }
    public String save() {
        try {
            Person person = new Person();
            repository.save(person);
        } catch (Exception e) {
            System.out.println("save() " + e.getLocalizedMessage());
        }

        return "";
    }

    public String create() {
        try {
            Person person = new Person("aris", "7-78");
            Document doc = new Document();
            Document addressBson = new Document();
            ObjectId id = new ObjectId();

            doc.append("name", person.getName());
            doc.append("gender", person.getCedula());
            this.collection.insertOne(doc);
            // repository.save(person);
        } catch (Exception e) {
            System.out.println("save() " + e.getLocalizedMessage());
        }

        return "";
    }

}
