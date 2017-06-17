/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import model.Charge;
import view.*;


/**
 * MainController holds the main method. It handles the main data structures in
 * the program, such as the ArrayList of charges to operate with, the menus and
 * creation of different windows, and some constants.
 * 
 * @author ALTF4
 * @version 5.5
 * @see view.MainFrame, GraphicsController, model.Charge
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
    
    
    /**
    * The main method. Creates the MainFrame and it's MainController, as well as
    * the GraphicsController, Graphic, and Grid.
    * 
    * @param StringP[] args
    * @return nothing
    */
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
        
        //c.testCharge();
    }
                    
    /**
    * Construction for the class. Sets it's MainFrame.
    * 
    * @param MainFrame win
    * @return nothing
    */
    public MainController(MainFrame win){
        
        this.win = win;

        
    }
        
    /**
    * Adds a GraphicsController.
    * 
    * @param GraphicsController g
    * @return nothing
    */
    public void addController(GraphicsController g){
        
        this.g = g;
    }
    
    
    /**
    * Reacts to actions on the MainFrame's JMenuBar, according to the flag set
    * on each component.
    * 
    * C_CALC    Open "Calculate" window.
    * C_HELP    Open "Help" window.
    * C_ADD     Open XMLChooser to add an XML file.
    * C_LOAD    Open XMLChooser to wipe the array, then add an XML file.
    * C_SAVE    Save the current array to "test.xml"
    * C_WIPE    Wipe the array.
    * C_NEW     Open the "New Charge" window.
    * C_ZI      Zooms the graph and grid in.
    * C_ZO      Zooms the graph and grid out.
    * 
    * @param ActionEvent e
    * @return nothing
    */  
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

    /**
    * Getter method for the Point in which operations will take place.
    * 
    * @param nothing
    * @return Point2D.Double
    */
    public static Point2D.Double getPoint(){
        
        return p;
        
    }
    
    /**
    * Setter method for the Point in which operations will take place.
    * 
    * @param double x, double y
    * @return nothing
    */
    public static void setPoint(double x, double y){
        
        p.x = x;
        p.y = y;
    }
 
    
    /**
    * Adds a charge to the ArrayList if the sanity check equals true
    * 
    * @param Charge c
    * @return nothing
    */
    public static void addCharge(Charge c){
        
        if (chargeSanityCheck(c)){
               
            list.add(c);
        }

    }
    
    /**
    * Adds a charge ArrayList to the ArrayList if the sanity check equals true
    * 
    * @param ArrayList Charge c
    * @return nothing
    */
    public static void addCharge(ArrayList<Charge> cl){
        

        for (Charge c : cl){
           
           if (chargeSanityCheck(c)){
               
               list.add(c);
           }
        }
        
    }
    
    /**
    * Iterates the charge ArrayList to check if any charge is in the same
    * position, or has a non-valid value. If so, it's modified or deleted, and
    * the method returns "False". Else, it returns "True", indicating it's safe
    * to add.
    * 
    * @param Charge c
    * @return boolean
    */
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
    
    
    /**
    * Deletes the contents of the charge ArrayList
    * 
    * @param nothing
    * @return nothing
    */
    public static void wipeList(){
        
        list.clear();
  
    }
    
    /**
    * Returns the main ArrayList
    * 
    * @param nothing
    * @return ArrayList Charge list
    */   
    public static ArrayList<Charge> getList(){
        
        return list;
    }
    
    /**
    * Returns the main window
    * 
    * @param nothing
    * @return MainFrame win
    */   
    public MainFrame getWindow(){
        
        return win;
    }
    
    /**
    * Returns the main window
    * 
    * @param MainFrame f
    * @return nothing
    */ 
    public void setWindow(MainFrame f){
        
        win = f;
    }
    
    
    //TEST CLASSES FOR DEBUGGING ONLY
    
    //This function creates an internalFrame and adds it, to test that
    //internalframes are working properly
   /* private void testFrame() {
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
        
    }*/
}
        
    
    


