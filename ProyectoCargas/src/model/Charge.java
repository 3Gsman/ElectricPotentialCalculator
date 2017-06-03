/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Daniel
 */
public class Charge {
    
    private double x;
    private double y;
    private double value;
    
    
    Charge(double v){
        
        this.x = 0;
        this.y = 0;
        this.value = v;      
    }   
    
    Charge(double x, double y, double v){
        
        this.x = x;
        this.y = y;    
        this.value = v;        
    }   
    
    public double getX(){       
        return x;     
    }
    
    public double getY(){       
        return y;     
    }
    
    public double getVal(){       
        return value;     
    }
    
    
}
