/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventsystem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import view.TelaInicio;


/**
 *
 * @author victo
 */
public class EventSystem {

    static  EntityManagerFactory  emf
             = Persistence.createEntityManagerFactory("EventSystemPU");
    static  EntityManager em = emf.createEntityManager();
     
    public static void main(String[] args) {
        TelaInicio t1 = new TelaInicio();
        t1.setVisible(true);
    }
    
}
