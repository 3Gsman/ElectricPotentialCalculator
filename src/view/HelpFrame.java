package view;

import control.HelpController;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import java.awt.Dimension;  
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author ALTF4
 * @version IQ
 * This class basically displays the help window in which the user can consult the user´s manual
 */
public final class HelpFrame extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    public JTextArea text;
    public JPanel panel;
    HelpController c;

    public HelpFrame() {
        super("User Manual", false, true, false);
    }
    
     /**
     *  This method basically displays the window with its components.
     */
    public void crearVista() {
        /*Here we give the window its size, initial position and visibility to the InternalFrame.
         Keep in mind: InternalFrames work better with the setPreferredSize command.
       */
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(480, 520));
        this.setSize(this.getPreferredSize());
        this.setVisible(true);

        panel = new JPanel();
        //We create the JTextArea and we give it its characteristics
        text = new JTextArea(30, 50);
        text.setEditable(false);
        text.setLineWrap(true);
        text.setWrapStyleWord(false);
        text.setVisible(true);

        panel.add(text, BorderLayout.CENTER);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        //We create the scroll and we add it to the JTextArea
        JScrollPane jsp = new JScrollPane();
        jsp.setViewportView(text);
        this.add(jsp, BorderLayout.NORTH);

        this.setVisible(true);

        //Here I just add the panel to the InternalFrame
        this.add(panel);
    }
    
    
    /**
     * This method is used on the mainFrame to add its respective controller
     * @param cal 
     */
    public void addController(HelpController cal) {

        this.c = cal;
    }

}
