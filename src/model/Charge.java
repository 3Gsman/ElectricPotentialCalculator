/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Data representation of an electrical charge, including position and value.
 * 
 * @author ALTF4
 * @version 1.1
 * @see control.MainController
 */
public class Charge {
    
    private double x;
    private double y;
    private double value;
    
    /**
    * Constructor without position (Set on 0,0)
    * 
    * @param double v
    * @return Charge
    */
    public Charge(double v){
        
        this.x = 0;
        this.y = 0;
        this.value = v;      
    }   
    
    /**
    * Constructor for the class.
    * 
    * @param double x, double y, double v
    * @return Charge
    */
    public Charge(double x, double y, double v){
        
        this.x = x;
        this.y = y;    
        this.value = v;        
    }   
    
    /**
    * Setter for the X axis.
    * 
    * @param double x
    * @return nothing
    */
    public double getX(){       
        return x;     
    }
    
    /**
    * Setter for the Y axis
    * 
    * @param double y
    * @return nothing
    */
    public double getY(){       
        return y;     
    }
    
    /**
    * Getter for the charge's value in microCoulombs.
    * 
    * @param nothing
    * @return double value
    */
    public double getVal(){       
        return value;     
        
    }
    
    /**
    * Setter for the charge's value in microCoulombs.
    * 
    * @param double v
    * @return nothing
    */
    public void setVal(double v){       
        this.value = v;          
    }
    
    
    
}
