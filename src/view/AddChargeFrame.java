package view;

import control.AddChargeController;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
 

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
 
 
/**
 * @author ALTF4
 * @version IQ
 * This class displays a window in which the user can add a charge to the graph on the mainFrame
 */
public final class AddChargeFrame extends JInternalFrame {
 
    private static final long serialVersionUID = 1L;
   
    NumberFormat x;
    double y = 0;
    public JFormattedTextField fieldx;
    public JFormattedTextField fieldy;
    public JFormattedTextField fieldvalue;
    public JLabel result;
    AddChargeController c;
   
    public AddChargeFrame(){
       super("Add Charges",false,true,false);
       setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
    }
   
      /**
     *  This method displays the window with its components.
     *  @param Nothing
     */
   public void crearVista(){
      /*Here we give the window its size, initial position and visibility to the InternalFrame.
         Keep in mind: InternalFrames work better with the setPreferredSize command.
       */
       this.setPreferredSize(new Dimension(450, 250));
       this.setSize(this.getPreferredSize());
       this.setLocation(50,30);
       this.setVisible(true);
   
       //Here we create the panel with the buttons, the text areas and the labels and we give them its size, position...
       JPanel panel = new JPanel();
       panel.setSize(450,300);
       panel.setLocation(0,0);
       panel.setLayout(null);
       JButton boton1 = new JButton("Add Charge");
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
       fieldvalue = new JFormattedTextField(x);
                     fieldy.setValue(y);
                     fieldy.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                                 fieldy.setText("");
                                 }
                        });             
                     
       
       
       JLabel lbl1 = new JLabel("X Position");
       JLabel lbl2 = new JLabel("Y Position");
       JLabel lbl3 = new JLabel("Value");
       
       Font font = new Font("SanSerif",Font.PLAIN,15);  
           
       lbl1.setFont(font);
       lbl2.setFont(font);
       lbl3.setFont(font);
       
       lbl1.setBounds(130,20,85,30);
       lbl2.setBounds(130,60,85,30);
       lbl3.setBounds(140,105,85,30);
       
       fieldx.setBounds(210,20,100,30);
       fieldy.setBounds(210,60,100,30);
       fieldvalue.setBounds(210,105,100,30);
       boton1.setBounds(170,160,100,30);
       
       //Here we just add the component to the panel
       panel.add(boton1);
       panel.add(fieldx);
       panel.add(fieldy);
       panel.add(fieldvalue);
       panel.add(lbl1);
       panel.add(lbl2);
       panel.add(lbl3);
       this.add(panel);
   }
 
       
    /**
     * This method is used on the mainFrame to add its respective controller
     * @param a 
     */
   public void addController(AddChargeController a){
       
       this.c = a;
       
       
   }
 
}