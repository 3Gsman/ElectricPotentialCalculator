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
 *
 * @author Daniel
 */
public class Grid extends JPanel {
   
    MainFrame win;
    GraphicsController gra;
    
    
    Grid(MainFrame win){
        
        this.win = win;
        this.setOpaque(false);
    }
    
    public void addController(GraphicsController gra){
        
        this.gra = gra;
        this.addMouseWheelListener(gra);
    }
 
    @Override
    public void paintComponent(Graphics g){
          
        super.paintComponent(g);
        
       
        //X Axis marks
        for (int i = MainController.PIXELRATIO; (i + MainController.PIXELRATIO) <= win.getW() ; i += MainController.PIXELRATIO){
            
            g.drawLine(i, win.getH()/2+10, i, win.getH()/2-10);
            
        }   
        
        //Y Axis marks
        for (int i = 0 + ((win.getH()-win.getW())/2); (i + gra.getScale()) <= win.getH() ; i += MainController.PIXELRATIO){
            
            g.drawLine(win.getW()/2+10, i , win.getW()/2-10, i);
            
        }
        

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
        System.out.println(r);
        
           
        if (r%1 == 0){
            
            printNumbers(g,(int)r );
            
        } else {
            
            printNumbers(g,r);
        }

    }   


    
    
    //Two functions are created so we can work with doubles or ints
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
