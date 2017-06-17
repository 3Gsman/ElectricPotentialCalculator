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
import view.Grapher;
import view.Grid;

/**
 * Control the JPanel children Grapher and Grid so to change the display as needed
 * keeping it consistent with the data. Mostly, it managed scale.
 * 
 * @author ALTF4
 * @version 2.0
 * @see view.Grapher, view.Grid, view.MainFrame, MainController
 */
public class GraphicsController implements ActionListener,MouseWheelListener {
    

    private Grid gri;
    private Grapher gra;
    
    private Point pnt;
    
    final private double zm_ch = 0.50; //Zoom change per instruction
    private int scale = MainController.PIXELRATIO; //Default: 1 to 40
    private double ratio = scale;
    
    Point p = new Point();
    
    /**
    * Constructor for GraphicsController. Set points to Grid and Grapher.
    * 
    * @param  Grid gri, Grapher gra
    * @return nothing
    */
    GraphicsController(Grid gri, Grapher gra){
        
        this.gri = gri;    
        this.gra = gra;
    }
    
    /**
    * Changes the scale as the mousewheel rotates. 
    * 
    * @param MouseWheelEvent e
    * @return nothing
    */   
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

    
    /**
    * Getter method for the scale
    * 
    * @param nothing
    * @return int scale
    */
    public int getScale(){
        
        return scale;
    }
    
    /**
    * Getter method for the ratio
    * 
    * @param nothing
    * @return double scale
    */   
    public double getRatio(){
        
        return ratio;
    }
        
    /**
    * Getter method for the point in which calculations take place
    * 
    * @param nothing
    * @return Point pnt
    */   
    public Point getPoint(){
        
        return pnt;
    }
    
    /**
    * Setter method for the point in which calculations take place
    * 
    * @param Point pnt
    * @return nothing
    */   
    public void setPoint(Point pnt){
        
        this.pnt = pnt;
    }
    
    /**
    * Setter method for the scale, repainting the Grapher and Grid. It takes a
    * boolean that indicates whether the scale's zooming in or out.
    * 
    * @param boolean add
    * @return nothing
    */   
    public void setScale(boolean add){
        
        if (add){
            if(scale != 2560){
                ratio = ratio / zm_ch;
                scale = (int)ratio;
                //Repaint the components using a scale
                gri.repaint();
                gra.repaint();
            }
        }
        
        else{
            if(scale != 1){
                ratio = ratio * zm_ch;
                scale = (int)ratio;
                //Repaint the components using a scale
                gri.repaint();
                gra.repaint();
            }
        }    
    }
   
    /**
    * Getter method for the Grapher
    * 
    * @param nothing
    * @return Grapher gra
    */  
    public Grapher getGrapher(){
            
        return gra;
    }
    
    /**
    * Getter method for the Grid
    * 
    * @param nothing
    * @return Grid gri
    */      
    public Grid getGrid(){
            
        return gri;
    }
    
    /**
    * Unimplemented ActionListener function.
    * 
    * @param ActionEvent e
    * @return nothing
    */   
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
