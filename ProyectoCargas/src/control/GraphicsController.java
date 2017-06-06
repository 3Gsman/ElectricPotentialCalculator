/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Point;
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
    
    private int scale = 40; //Default: 1 to 40
    
    private ArrayList<Charge> list = new ArrayList<>();
    
    Point p = new Point();
    
    
    GraphicsController(Grid gri, Grapher gra){
        
        this.gri = gri;    
        this.gra = gra;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //Add charges, arrays, or wipe the list
    
    public void addCharge(Charge c){
            
        list.add(c);
    }
    
    public void addCharge(ArrayList<Charge> c){
            
        for (Charge ch : c){
            
            list.add(ch);
        }
    }
    
    public void wipeList(){
        
        list.clear();
  
    }
    
    
    //Getters and setters
    
    public int getScale(){
        
        return scale;
    }
    
    public void setScale(double x){
        if (x != 0){
            
            scale = (int)(40 * x);
        }
        else{
            
            System.out.println("You cannot set 0 as the scale");
        }    
    }
    
    public Grapher getGrapher(){
            
        return gra;
    }
        
    public Grid getGrid(){
            
        return gri;
    }
    
    public ArrayList<Charge> getList(){
        
        return list;
    }
            

    
}
