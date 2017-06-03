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
public class Grid extends JPanel {
   
    MainFrame win;
    GraphicsController gra;
    
    
    Grid(MainFrame win){
        
        this.win = win;
    }
    
    public void addController(GraphicsController gra){
        
        this.gra = gra;
    }
 
    @Override
    public void paintComponent(Graphics g){
          
        super.paintComponent(g);
       
        //X Axis marks
        for (int i = gra.getScale(); (i + gra.getScale()) <= win.getW() ; i += gra.getScale()){
            
            g.drawLine(i, win.getH()/2+10, i, win.getH()/2-10);
            
        }   
        
        //Y Axis marks
        for (int i = 0 + ((win.getH()-win.getW())/2); (i + gra.getScale()) <= win.getH() ; i += gra.getScale()){
            
            g.drawLine(win.getW()/2+10, i , win.getW()/2-10, i);
            
        }
        
        
        //Axis
        g.drawLine(0, win.getH()/2, win.getW(), win.getH()/2);
        
        g.drawLine(win.getW()/2, 0, win.getW()/2, win.getH());
        
        //Y Axis Numbers
        for(int i = 0; i<=win.getH()/gra.getScale();i++){
            g.drawString(""+ -i, win.getW()/2+5, win.getH()/2 + 20 + i * gra.getScale());
            g.drawString(""+ i, win.getW()/2+5, win.getH()/2 + 20 + i * -gra.getScale());
            
        }
        for(int i = 0; i<=win.getW()/gra.getScale();i++){
            g.drawString(""+ i, win.getW()/2+5 + i * gra.getScale(), win.getH()/2 + 20);
            g.drawString(""+ -i, win.getW()/2+5 + i * -gra.getScale(), win.getH()/2 + 20);
            
        }
        

       
        setOpaque(false);

    }   

    private Object getContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
