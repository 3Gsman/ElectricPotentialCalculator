/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.GraphicsController;
import control.MainController;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * The grid reads draws the X and Y Axis, the marks, and the numbers on them,
 * depending on the scale on the GraphicsController.
 * 
 * @author ALTF4
 * @version 1.1
 * @see control.GraphicsController, MainFrame
 */
public class Grid extends JPanel {
   
    MainFrame win;
    GraphicsController gra;
    
    /**
    * Constructor for the class. Adds the Mainframe and sets opaque to false.
    * 
    * @param MainFrame win
    * @returns nothing
    */
    Grid(MainFrame win){
        
        this.win = win;
        this.setOpaque(false);
    }
    
    /**
    * Adds a controller to the Grid
    * 
    * @param GraphicsController gra
    * @returns nothing
    */
    public void addController(GraphicsController gra){
        
        this.gra = gra;
        this.addMouseWheelListener(gra);
    }
    /**
    * Depending on the scale, draws the X and Y axis, it's marks, and numbers.
    * 
    * @param Graphics g
    * @returns nothing
    */
    @Override
    public void paintComponent(Graphics g){
          
        super.paintComponent(g);
        
       
        //X and Y Axis marks
        for (int i = MainController.PIXELRATIO; (i + MainController.PIXELRATIO) <= win.getW() ; i += MainController.PIXELRATIO){
            
            g.drawLine(i, win.getH()/2+10, i, win.getH()/2-10);
            g.drawLine(win.getW()/2+10, i , win.getW()/2-10, i);
            
        }   
        
        //Y Axis marks
        /*for (int i = MainController.PIXELRATIO ; (i + gra.getScale()) <= win.getH() ; i += MainController.PIXELRATIO){
            
        }*/
        

        //Axis
        g.drawLine(0, win.getH()/2, win.getW(), win.getH()/2);
        g.drawLine(win.getW()/2, 0, win.getW()/2, win.getH());
        
                        
        //Calculate ratio for numbers:
        
        
        double r = 0;
        System.out.println(this.gra.getScale());
        System.out.println(MainController.PIXELRATIO);
        System.out.println((double)MainController.PIXELRATIO/(double)this.gra.getScale());
        r = (double)MainController.PIXELRATIO/(double)this.gra.getScale();       
        r = Math.floor(r * 100) / 100;       
           
        if (r%1 == 0){
            
            printNumbers(g,(int)r );
            
        } else {
            
            printNumbers(g,r);
        }

    }   

    /**
    * Prints numbers on the marks as doubles.
    * 
    * @param Graphics g, double r.
    * @returns nothing
    */
    public void printNumbers(Graphics g,double r){
        
        //This variable is created so the result may be truncated before print
        double num;

        //Y Axis Numbers
        for(int i = 0; i<=win.getH()/MainController.PIXELRATIO;i++){
            
            num = (double)i * (double)r;
            num = Math.floor(num * 100) / 100;
            if (i !=0){
                g.drawString(""+ -num, win.getW()/2+5, win.getH()/2 + 20 + i * MainController.PIXELRATIO);
                g.drawString(""+ num, win.getW()/2+5, win.getH()/2 + 20 + i * -MainController.PIXELRATIO);
            }   
        }
        //X Axis Numbers
        for(int i = 0; i<=win.getW()/MainController.PIXELRATIO;i++){
            
            num = (double)i * (double)r;
            num = Math.floor(num * 100) / 100;
            if (i !=0){    
                g.drawString(""+ num, win.getW()/2+5 + i * MainController.PIXELRATIO, win.getH()/2 + 20);
                g.drawString(""+ -num, win.getW()/2+5 + i * -MainController.PIXELRATIO, win.getH()/2 + 20);
            }    
        }
        
        g.drawString(""+ 0, win.getW()/2+5 + 0, win.getH()/2 + 20);
        
    }
    
    /**
    * Prints numbers on the marks as ints.
    * 
    * @param Graphics g, double r.
    * @returns nothing
    */
    public void printNumbers(Graphics g,int r){
        
        //Y Axis Numbers
        for(int i = 0; i<=win.getH()/MainController.PIXELRATIO;i++){
            g.drawString(""+ -i*r, win.getW()/2+5, win.getH()/2 + 20 + i * MainController.PIXELRATIO);
            g.drawString(""+ i*r, win.getW()/2+5, win.getH()/2 + 20 + i * -MainController.PIXELRATIO);
            
        }
        //X Axis Numbers
        for(int i = 0; i<=win.getW()/MainController.PIXELRATIO;i++){
            g.drawString(""+ i*r, win.getW()/2+5 + i * MainController.PIXELRATIO, win.getH()/2 + 20);
            g.drawString(""+ -i*r, win.getW()/2+5 + i * -MainController.PIXELRATIO, win.getH()/2 + 20);
            
        }
    }
}
