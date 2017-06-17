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
 *
 * @author Daniel
 *
 */
public class XMLIO {
    
    private static XStream xstream = new XStream(new StaxDriver());
    private static PrintStream ps;
    
    
    /* These three methods save, load, and add charges to the array in
    MainController, receiving as parameter the location where they will be saved,
    using the external library xstream*/
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
    
    
    /*Overwite Test File*/
    
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
    
    /*Load a file from the FileChooser and replace existing charges with it*/
    
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
    
    /*Add the charges of a file to the existing charges without disposing of them*/
    
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
