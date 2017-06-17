/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Charge;
import view.AddChargeFrame;

/**
 * Provide control functions for the AddChargeFrame JInternalframe, and manage
 * it's components and data access.
 * 
 * @author ALTF4
 * @version 2.0
 * @see view.AddChargeFrame, MainController, model.Charge
 */
public class AddChargeController implements ActionListener{

    AddChargeFrame win;
    MainController con;
    
    /**
    * Constructor for the AddChargeController class. Sets the parameters received
    * as class attributes.
    * 
    * @param  AddChargeFrame win, MainController con
    * @return nothing
    */
    public AddChargeController(AddChargeFrame win, MainController con){
        
        this.win = win;
        this.con = con;
    }
    
    /**
    * Parses the data in the window's TextFields as doubles, and creates a Charge
    * with them as parameters, before adding it to the main array in MainController
    * 
    * @param  ActionEvent e
    * @return nothing
    */
    @Override
    public void actionPerformed(ActionEvent e) {
       
        
        
        double x = (double)((Double.parseDouble(win.fieldx.getText()))); 
        double y = (double)((Double.parseDouble(win.fieldy.getText())));
        double val = (double)((Double.parseDouble(win.fieldvalue.getText())));
        
        Charge c = new Charge(x, y, val);
     
        MainController.addCharge(c);

        
        win.dispose();
        con.getWindow().repaint();
       
    }
    
}
