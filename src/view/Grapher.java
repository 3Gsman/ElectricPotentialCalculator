/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.GraphicsController;
import control.MainController;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import model.Charge;

/**
 * The grapher reads the charges ArrayList in MainController and draws them
 * on the MainFrame.
 * 
 * @author ALTF4
 * @version 1.0
 * @see control.GraphicsController, MainFrame
 */

public class Grapher extends JPanel{
    
    MainFrame win;
    GraphicsController g;
    
    /**
    * Constructor for the class. Adds the Mainframe and sets opaque to false.
    * 
    * @param MainFrame win
    * @returns nothing
    */
    Grapher(MainFrame win){
        
        this.win = win;
        this.setOpaque(false);
    }
    
    /**
    * Adds a controller to the JPanel.
    * 
    * @param GraphicsController g
    * @returns nothing
    */
    public void addController(GraphicsController g){
        
        this.g = g;
    }
       
    /**
    * Paints the charge ArrayList, depending on location and value (positive or
    * negative), as well as on the GraphicController's scale.
    * 
    * @param GraphicsController g
    * @returns nothing
    */
    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        

        for (Charge c : MainController.getList()){
        
            
            int c_rad = 10; //Radius of the charges
            
            //IT DOESNT TAKE INTO ACCOUNT CHARGES EQUAL TO 0, which shouldn't exist to begin with
            if (c.getVal() > 0 ){
                
                g.setColor(Color.blue);
            }else{
                
                g.setColor(Color.red);   
            }
            
            if (c.getVal()!= 0){
                
                g.fillOval((int)(win.getW()/2 + (c.getX()*this.g.getScale()) - c_rad ), 
                        (int)(win.getH()/2 + (-1 * c.getY()*this.g.getScale()) - c_rad ), 
                        c_rad*2, c_rad*2);
            
            }
        }
            


    }   
    /**
    * Unimplemented.
    * 
    * @param nothing
    * @returns nothing
    */
    private Object getContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
