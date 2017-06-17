/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Daniel
 */
public class XMLChooser extends JFileChooser {
    
    
    
    
    
    
    public XMLChooser(){
        
        setCurrentDirectory(new java.io.File("."));
        setDialogTitle("Choose an XML file to read");
        setFileSelectionMode(JFileChooser.FILES_ONLY);
        setAcceptAllFileFilterUsed(false);
        setFileFilter(new FileNameExtensionFilter("*.xml", "xml"));
    }

 
    
}
