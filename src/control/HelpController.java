/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFrame;
import view.HelpFrame;

/**
 *
 * @author German
 */
public class HelpController {
    
    public HelpFrame win;
    public JFrame frmDialogo;
    
    
   
    public HelpController(HelpFrame win){
        this.win = win;    
        
    } 
    
    public HelpController() {
        win.crearVista();
        
    }
    
   public void showText () {                                         
     
        
        File fileH = new File("Help.txt");
        
        try {
            BufferedReader read = new BufferedReader(new FileReader(fileH));
            String line = read.readLine();
            
            while(line !=null){
                win.text.append(line+" "+"\n");
                line =read.readLine();
            }
            
        } catch (Exception ex) {
            
        }
    }     
    
}