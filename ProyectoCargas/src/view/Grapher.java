/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.GraphicsController;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class Grapher extends JPanel{
    
    MainFrame win;
    GraphicsController g;
    
    
    Grapher(MainFrame win){
        
        this.win = win;
    }
    
    public void addController(GraphicsController g){
        
        this.g = g;
    }
       
    
    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        
        setOpaque(false);

    }   

    private Object getContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
