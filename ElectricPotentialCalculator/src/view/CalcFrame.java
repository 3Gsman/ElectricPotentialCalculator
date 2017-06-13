/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.CalcController;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
 

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
 
 
/**
 *
 * @author Pablo
 */
public final class CalcFrame extends JInternalFrame {
 
    private static final long serialVersionUID = 1L;
   
    NumberFormat x;
    double y = 0;
    public JFormattedTextField fieldx;
    public JFormattedTextField fieldy;
    public JLabel result;
    CalcController c;
   
    public CalcFrame(){
       super("Calculate Potential",false,true,false);
       setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
    }
   
   public void crearVista(){
       /*Aqui le doy tamaño, posicion inicial y visibilidad al internal frame
         Nota a tener en cuenta: los internal frame necesitan tener el setPreferredSize para trabajar mejor con ellos
       */
       this.setPreferredSize(new Dimension(450, 250));
       this.setSize(this.getPreferredSize());
       this.setLocation(50,30);
       this.setVisible(true);
   
       //Aqui creo el panel que contiene los botones, los campos y las etiquetas y les doy su tamaño posicion etc
       JPanel panel = new JPanel();
       panel.setSize(450,300);
       panel.setLocation(0,0);
       panel.setLayout(null);
       JButton boton1 = new JButton("Calculate");
       boton1.addActionListener(c);
       
       fieldx = new JFormattedTextField(x);
                     fieldx.setValue(y);
                     fieldx.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                                 fieldx.setText("");
                                 }
                        });
                     
       fieldy = new JFormattedTextField(x);
                     fieldy.setValue(y);
                     fieldy.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                                 fieldy.setText("");
                                 }
                        });
                     
                     
       result = new JLabel("Result");
       
       JLabel lbl1 = new JLabel("Position X");
       JLabel lbl2 = new JLabel("Position Y");
       //JLabel lbl3 = new JLabel("Resultado");
                     
           
       lbl1.setBounds(50,50,65,30);
       lbl2.setBounds(50,100,65,30);
       //lbl3.setBounds(130,150,65,30);
       fieldx.setBounds(130,50,30,30);
       fieldy.setBounds(130,100,30,30);
       result.setBounds(200,150,100,30);
       boton1.setBounds(200,65,200,50);
       
       //Aqui simplemente los añado al panel
       panel.add(boton1);
       panel.add(fieldx);
       panel.add(fieldy);
       panel.add(result);
       panel.add(lbl1);
       panel.add(lbl2);
       //panel.add(lbl3);
       this.add(panel);
   }
 
   
   public void addController(CalcController a){
       
       this.c = a;
       
       
   }
 
}