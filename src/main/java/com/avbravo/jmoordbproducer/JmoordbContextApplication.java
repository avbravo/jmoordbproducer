/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avbravo.jmoordbproducer;


import javax.faces.context.FacesContext;

/**
 *
 * @author avbravo
 */
public class JmoordbContextApplication {

    public static void put(String key, Object value) {
        try{
             FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put(key, value);
        }catch(Exception e){
             System.out.println("error put()"+e.getLocalizedMessage());
        }  
      
       
    }
    public static Object get(String key) {
        try{
             return FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get(key);
        }catch(Exception e){
               System.out.println("error "+e.getLocalizedMessage());
        }  
      
       return "";
    }
}
