/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Daniel
 */

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame; 
import javax.swing.JPanel;
import model.Charge;
import view.*;


/**
 *
 * @author Daniel Vilar
 */
public class MainController implements ActionListener{

    
    public final static int PIXELRATIO = 40;
    
    //Here we store the mainFrame window, from which all others branch
    private MainFrame win;
    private GraphicsController g;
    private static ArrayList<Charge> list = new ArrayList<>();
    private static Point2D.Double p = new Point2D.Double();

          
    /*
    Commands:
    Commands are used to identify which action is to be executed by the
    controller based on input received. Mostly used to sort the MenuBar.
    
    Their name starts with a C, sort for Command.
    */ 
    public final static String C_CALC = "C";    //Open the "Calculations" frame
    public final static String C_HELP = "H";    //Open the "Help" frame
    public final static String C_ADD = "A";     //Open the "Add File" chooser
    public final static String C_LOAD = "L";    //Open the "Load" chooser
    public final static String C_SAVE = "S";    //Open the file saver
    public final static String C_WIPE = "W";    //Use the "Wipe Board" function  
    public final static String C_NEW = "N";     //Open the "New Charge" prompt
    public final static String C_ZI = "I";      //Zoom in
    public final static String C_ZO = "O";      //Zoom out
    
    
    /*The application code. It's only meant to create the main window and 
    it's controller. The rest will be handled with user input*/
    public static void main(String[] args) {
       
        MainFrame window = new MainFrame();  
        MainController c = new MainController(window);          
        window.addController(c);    
        window.create();
        
        GraphicsController gc = new GraphicsController(
        window.getGrid(), window.getGrapher());
        c.addController(gc);
        
        window.getGrid().addController(gc);
        window.getGrapher().addController(gc);
        
        c.testCharge();
        
   
    }
                    

    public MainController(MainFrame win){
        
        this.win = win;

        
    }
    
    public void addController(GraphicsController g){
        
        this.g = g;
    }
    
    
    /*IMPORTANT: When implementing a new command, be it a filechooser, or an
    internal window, you must change the code associated with that command here.*/    
    @Override
    public void actionPerformed(ActionEvent e){
        
        //Open the "Calculations" frame
        if (e.getActionCommand().equals(C_CALC)){
               
               
                //TEMPORARY IMPLEMENTATION OF TESTING INTERNALFRAMES
                //testFrame();
                
                //
                CalcFrame j = new CalcFrame();
                CalcController cal = new CalcController(j);
                j.addController(cal);
                j.crearVista();
                win.addFrame(j);
                
            System.out.println("Unimplemented");
            
        }
        
        //Open the "Help" frame
        if (e.getActionCommand().equals(C_HELP)){
            
                HelpFrame k = new HelpFrame();
                HelpController hel = new HelpController(k);
                k.addController(hel);
                k.crearVista();
                hel.showText();
                win.addFrame(k);
                
        }
        
        //Open the "Add File" chooser
        if (e.getActionCommand().equals(C_ADD)){
            
            XMLChooser fc = new XMLChooser(); 
            
            
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                
                System.out.println("Selected File: " + fc.getSelectedFile());
                XMLIO.addCharges(fc.getSelectedFile());
                win.repaint();
            } else {
                    
                System.out.println("Aborted without selection");
            }
   
        }    
        
        //Open the "Load" chooser
        if (e.getActionCommand().equals(C_LOAD)){
            
            XMLChooser fc = new XMLChooser(); 
            
            
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                
                System.out.println("Selected File: " + fc.getSelectedFile());
                XMLIO.loadCharges(fc.getSelectedFile());
                win.repaint();
            } else {
                    
                System.out.println("Aborted without selection");
            }
   
        }   
        
        //Open the file saver
        if (e.getActionCommand().equals(C_SAVE)){
            
            XMLIO.saveCharges();
   
        }   
       
        //Use the "Wipe Board" function 
        if (e.getActionCommand().equals(C_WIPE)){
            
            
          wipeList();
          win.repaint();
   
        }  
        
        //Open the "New Charge" prompt
        if (e.getActionCommand().equals(C_NEW)){
            
            AddChargeFrame j = new AddChargeFrame();
            AddChargeController cal = new AddChargeController(j,this);
            j.addController(cal);
            j.crearVista();
            win.addFrame(j);
   
        } 
        
        if (e.getActionCommand().equals(C_ZI)){
            
            g.setScale(true);
   
        }
        
        if (e.getActionCommand().equals(C_ZO)){
            
            g.setScale(false);
   
        }    

    }   

    
    public static Point2D.Double getPoint(){
        
        return p;
        
    }

    public static void setPoint(double x, double y){
        
        p.x = x;
        p.y = y;
    }
 
    
    //Add charges, arrays, or wipe the list
    
    public static void addCharge(Charge c){
        
        if (chargeSanityCheck(c)){
               
            list.add(c);
        }

    }
    
    public static void addCharge(ArrayList<Charge> cl){
        

        for (Charge c : cl){
           
           if (chargeSanityCheck(c)){
               
               list.add(c);
           }
        }
        
    }
    
    static private boolean chargeSanityCheck(Charge c){
        
            boolean sane = true;
        
        //Check if another charge is in the same position
            for (Iterator<Charge> it = MainController.getList().iterator(); it.hasNext();) {
                Charge ch = it.next();
                if(c.getX() == ch.getX() &&
                        c.getY() == ch.getY()){

                    ch.setVal( ch.getVal() + c.getVal() );
                    sane = false;
                }
                if (c.getVal() == 0){

                    MainController.getList().remove(it);
                }
            }
            if(sane){
                return true;
            }
            else{
                return false;
            }
        
    }
    
    
    
    public static void wipeList(){
        
        list.clear();
  
    }
        
    public static ArrayList<Charge> getList(){
        
        return list;
    }
    
    public MainFrame getWindow(){
        
        return win;
    }
    
    public void setWindow(MainFrame f){
        
        win = f;
    }
    
    
    
    //This function creates an internalFrame and adds it, to test that
    //internalframes are working properly
    private void testFrame() {
                JInternalFrame intf = new JInternalFrame("Ventana",true,true,true,true);
                intf.setPreferredSize(new Dimension(800, 640));
                intf.setLocation(win.getWidth()/2-400, win.getHeight()/2-320);
                intf.setSize(intf.getPreferredSize());
                intf.setVisible(true);
                win.addFrame(intf);
    }
     
    
    
    private void testCharge(){
        
        Charge c1 = new Charge(6,5,30);
        Charge c2 = new Charge((double)-20);
        Charge c3 = new Charge(-4,-2.5,40);
        Charge c4 = new Charge(-8,3.6,40);
        
        addCharge(c1);
        addCharge(c2);
        addCharge(c3);
        addCharge(c4);
        
    }
}
        
    
    


