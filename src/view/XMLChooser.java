/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Selector for choosing XML files to load or add into the ArrayList in MainFrame.
 * 
 * @author ALTF4
 * @version 1.0
 * @see view.XMLChooser, MainController
 */
public class XMLChooser extends JFileChooser {
    
    /**
    * Constructor for the JFileChooser. Set XML files as the only type available,
    * the chooser might not read directories.
    * 
    * @param nothing
    * @return nothing
    */
    public XMLChooser(){
        
        setCurrentDirectory(new java.io.File("."));
        setDialogTitle("Choose an XML file to read");
        setFileSelectionMode(JFileChooser.FILES_ONLY);
        setAcceptAllFileFilterUsed(false);
        setFileFilter(new FileNameExtensionFilter("*.xml", "xml"));
    }   
}
