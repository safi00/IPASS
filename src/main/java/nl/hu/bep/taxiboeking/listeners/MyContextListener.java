package nl.hu.bep.taxiboeking.listeners;

import nl.hu.bep.taxiboeking.persistence.PersistenceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebListener
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            PersistenceManager.loadDataFromAzure();
            System.out.println("world loaded");
        } catch (Exception e){
            System.out.println("cannot load world!");
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            PersistenceManager.saveDataToAzure();
            System.out.println("world saved");
        } catch (IOException ioe){
            System.out.println("Failed to save world!");
            System.out.println("ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ");
            ioe.printStackTrace();
        }
    }
}
