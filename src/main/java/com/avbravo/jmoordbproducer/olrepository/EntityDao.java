/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbproducer.olrepository;

import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author avbravo
 */
public interface EntityDao<T> {

    T find(int id);

    List<T> findAll(String table);

    void update(int id, Consumer<T>... updates) throws Exception;

    void save(T t);

    void remove(int id);

}
