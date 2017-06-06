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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import view.*;


/**
 *
 * @author Daniel Vilar
 */
public class MainController implements ActionListener{

    
    //Here we store the mainFrame window, from which all others branch
    MainFrame win;
    GraphicsController g;

          
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
        
            System.out.println("Unimplemented");
            
        }
        
        //Open the "Help" frame
        if (e.getActionCommand().equals(C_HELP)){
            
            System.out.println("Unimplemented");
   
        }
        
        //Open the "Add File" chooser
        if (e.getActionCommand().equals(C_ADD)){
            
            System.out.println("Unimplemented");
   
        }    
        
        //Open the "Load" chooser
        if (e.getActionCommand().equals(C_LOAD)){
            
            System.out.println("Unimplemented");
   
        }   
        
        //Open the file saver
        if (e.getActionCommand().equals(C_SAVE)){
            
            System.out.println("Unimplemented");
   
        }   
       
        //Use the "Wipe Board" function 
        if (e.getActionCommand().equals(C_WIPE)){
            
            System.out.println("Unimplemented");
   
        }  
        
        //Open the "New Charge" prompt
        if (e.getActionCommand().equals(C_NEW)){
            
            System.out.println("Unimplemented");
   
        }             

    }   
     
    
}
        
    
    


