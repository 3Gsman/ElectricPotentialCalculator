package proyectocargas;


import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;


/**
 *
 * @author Pablo
 */
public final class ProyectoCargas extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    
   ProyectoCargas(){
       super("Calcular Potencial",false,true,false);    
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
	   JButton boton1 = new JButton("Calcular");
	   
	   JTextField campo1 = new JTextField(15);
	   JTextField campo2 = new JTextField(15);
	   
	   JLabel lbl1 = new JLabel("Posicion X");
	   JLabel lbl2 = new JLabel("Posicion Y");
	      
	   lbl1.setBounds(50,50,65,30);
	   lbl2.setBounds(50,100,65,30);
	   campo1.setBounds(130,50,30,30);
	   campo2.setBounds(130,100,30,30);
	   boton1.setBounds(200,65,200,50);
	   
	   //Aqui simplemente los añado al panel
	   panel.add(boton1);
	   panel.add(campo1);
	   panel.add(campo2);
	   panel.add(lbl1);
	   panel.add(lbl2);
	   this.add(panel);
   }


}
