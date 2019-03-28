/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbproducer.olrepository;

/**
 *
 * @author avbravo
 */
public class Person {
    private String name;
    private String cedula;

    public Person() {
    }

    public Person(String name, String cedula) {
        this.name = name;
        this.cedula = cedula;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
}
