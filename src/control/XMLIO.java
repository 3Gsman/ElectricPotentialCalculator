/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Charge;

/**
 * Provide methods to save data as XML files
 * 
 * @author ALTF4
 * @version 1.2
 * @see view.XMLChooser, MainController
 */
public class XMLIO {
    
    private static XStream xstream = new XStream(new StaxDriver());
    private static PrintStream ps;
    
    
    /* These three methods save, load, and add charges to the array in
    MainController, receiving as parameter the location where they will be saved,
    using the external library xstream*/
    
    /**
    * Save the charge ArrayList in MainController as an XML file.
    * 
    * @param File f
    * @return nothing
    */
    public static void saveCharges(File f) {
        
        ArrayList<Charge> charges = MainController.getList();
        
        try {
            ps = new PrintStream(f);
            String xml = xstream.toXML(charges);
            ps.println(xml);
        } catch (Exception ex) {
            //Si no se puede guardar, por cualquier motivo, hay una excepcion severa
            Logger.getLogger(XMLIO.class.getName()).log(Level.SEVERE, 
                        null, ex);
        }        
    }
    
    
    
    /**
    * Save the charge ArrayList in MainController as "test.XML"
    * 
    * @param File f
    * @return nothing
    */   
    public static void saveCharges() {
        
        ArrayList<Charge> charges = MainController.getList();
        
        try {
            ps = new PrintStream("test.xml");
            String xml = xstream.toXML(charges);
            ps.println(xml);
        } catch (Exception ex) {
            //Si no se puede guardar, por cualquier motivo, hay una excepcion severa
            Logger.getLogger(XMLIO.class.getName()).log(Level.SEVERE, 
                        null, ex);
        }        
    }
    
    /**
    * Load an XML file as an Arraylist, wipe the one on MainController, and 
    * add the former to the latter.
    * 
    * @param File f
    * @return nothing
    */   
    public static void loadCharges(File f) {
        
        ArrayList<Charge> charges;
        
        try {
            charges = (ArrayList) xstream.fromXML(f);
            MainController.wipeList();
            MainController.addCharge(charges);
        } catch (Exception ex) {
            //Si hay una excepcion, se muestra un mensaje
            System.out.println("An Error has occurred: "+ex.getMessage());
        }      
    }
    
    /**
    * Load an XML file as an Arraylist, and add it to the one in MainController.
    * 
    * @param File f
    * @return nothing
    */  
    public static void addCharges(File f) {
        
        ArrayList<Charge> charges;
        
        try {
            charges = (ArrayList) xstream.fromXML(f);
            MainController.addCharge(charges);                
        } catch (Exception ex) {
            //Si hay una excepcion, se muestra un mensaje
            System.out.println("An Error has occurred: "+ex.getMessage());
        }      
    }
    

}
