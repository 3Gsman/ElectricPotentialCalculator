/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import model.Charge;
import view.Grapher;
import view.Grid;

/**
 *
 * @author Daniel
 */
public class GraphicsController implements ActionListener,MouseWheelListener {
    

    private Grid gri;
    private Grapher gra;
    
    private Point pnt;
    
    final private double zm_ch = 0.50; //Zoom change per instruction
    private int scale = MainController.PIXELRATIO; //Default: 1 to 40
    private double ratio = scale;
    
    Point p = new Point();
    
    
    GraphicsController(Grid gri, Grapher gra){
        
        this.gri = gri;    
        this.gra = gra;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        
        int notches = e.getWheelRotation();
        
        if (notches < 0) {
            
            setScale(true);    
        }
        else{
            
            setScale(false);   
        }
        
    } 
    

    
    
    //Getters and setters
    
    public int getScale(){
        
        return scale;
    }
        
    public int getRatio(){
        
        return scale;
    }
    
    public Point getPoint(){
        
        return pnt;
    }
    
    public void setPoint(Point pnt){
        
        this.pnt = pnt;
    }
    
    public void setScale(boolean add){
        
        if (add){

            ratio = ratio / zm_ch;
            scale = (int)ratio;
            //Repaint the components using a scale
            gri.repaint();
            gra.repaint();
        }
        
        else{
            ratio = ratio * zm_ch;
            scale = (int)ratio;
            //Repaint the components using a scale
            gri.repaint();
            gra.repaint();
        }    
    }
   
    
    public Grapher getGrapher(){
            
        return gra;
    }
        
    public Grid getGrid(){
            
        return gri;
    }
    
}
