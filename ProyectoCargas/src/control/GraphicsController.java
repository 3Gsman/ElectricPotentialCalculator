/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.Charge;
import view.Grapher;
import view.Grid;

/**
 *
 * @author Daniel
 */
public class GraphicsController implements ActionListener {

    private Grid gri;
    private Grapher gra;
    
    private int scale = 40;
    
    ArrayList<Charge> list = new ArrayList<>();
    
 
    
    
    GraphicsController(Grid gri, Grapher gra){
        
        this.gri = gri;    
        this.gra = gra;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getScale(){
        
        return scale;
    }
    
    public Grapher getGrapher(){
            
        return gra;
    }
        
    public Grid getGrid(){
            
        return gri;
    }
            
}
