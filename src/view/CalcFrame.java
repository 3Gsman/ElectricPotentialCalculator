
package view;

import control.CalcController;
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
 *  @author ALTF4
 *  @version 1
 *  @see MainController MainFrame
 *  This class basically displays a window to calculate the electric potential.
 */
public final class CalcFrame extends JInternalFrame {
 
    private static final long serialVersionUID = 1L;
   
    NumberFormat x;
    double y = 0;
    public JFormattedTextField fieldx;
    public JFormattedTextField fieldy;
    public JFormattedTextField fieldresult;
    public JLabel result;
    CalcController c;
   
    /**
     *  This is the class´s contstructor; its features are: Non resizable , closable and non maximizable.
     * 
     */
    public CalcFrame(){
       super("Calculate Potential",false,true,false);
       setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
    }
   
    /**
     *  This method basically displays the window with its components.
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
       fieldresult = new JFormattedTextField(x);
                     fieldy.setValue(y);
                     fieldy.addMouseListener(new MouseAdapter() {
                     public void mouseClicked(MouseEvent e) {
                                 fieldy.setText("");
                                 }
                        });             
                     
       
       
       JLabel lbl1 = new JLabel("Position X");
       JLabel lbl2 = new JLabel("Position Y");
       JLabel lbl3 = new JLabel("Result");
       
       Font font = new Font("SanSerif",Font.PLAIN,15);  
           
       lbl1.setFont(font);
       lbl2.setFont(font);
       lbl3.setFont(font);
       
       lbl1.setBounds(130,20,85,30);
       lbl2.setBounds(130,60,85,30);
       lbl3.setBounds(140,105,85,30);
       
       fieldx.setBounds(210,20,100,30);
       fieldy.setBounds(210,60,100,30);
       fieldresult.setBounds(210,105,100,30);
       boton1.setBounds(170,160,100,30);
       
       //Here we simply add the components to the panel
       panel.add(boton1);
       panel.add(fieldx);
       panel.add(fieldy);
       panel.add(fieldresult);
       panel.add(lbl1);
       panel.add(lbl2);
       panel.add(lbl3);
       this.add(panel);
   }
 
   /**
    * This method is used on the mainFrame to add its respective controller
    * @param a 
    */
   public void addController(CalcController a){
       
       this.c = a;
       
       
   }
 
}