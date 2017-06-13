/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import model.Charge;
import view.AddChargeFrame;

/**
 *
 * @author Daniel
 */
public class AddChargeController implements ActionListener{

    AddChargeFrame win;
    
    public AddChargeController(AddChargeFrame win){
        
        this.win = win;
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
       
        
        
        double x = (double)((Double.parseDouble(win.fieldx.getText()))); 
        double y = (double)((Double.parseDouble(win.fieldy.getText())));
        double val = (double)((Double.parseDouble(win.fieldvalue.getText())));
        
        //Clear the textfields here
        
        Charge c = new Charge(x, y, val);
        boolean add = true;
        
        //Check if another charge is in the same position
        for (Iterator<Charge> it = MainController.getList().iterator(); it.hasNext();) {
            Charge ch = it.next();
            if(c.getX() == ch.getX() &&
                    c.getY() == ch.getY()){
                
                ch.setVal( ch.getVal() + c.getVal() );
                add = false;
            }
            if (c.getVal() == 0){
                
                MainController.getList().remove(it);
            }
        }
        if(add){
            MainController.addCharge(c);
        }
        
        win.dispose();
       
    }
    
}
