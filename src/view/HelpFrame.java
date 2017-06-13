package view;

import control.HelpController;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Pablo
 */
public final class HelpFrame extends JInternalFrame {

    private static final long serialVersionUID = 1L;

    public JTextArea text;
    public JPanel panel;
    HelpController c;

    public HelpFrame() {
        super("User Manual", false, true, false);
    }

    public void crearVista() {
        /*Aqui le doy tamaño, posicion inicial y visibilidad al internal frame
	   	 Nota a tener en cuenta: los internal frame necesitan tener el setPreferredSize para trabajar mejor con ellos
         */
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(480, 520));
        this.setSize(this.getPreferredSize());
        this.setVisible(true);

        panel = new JPanel();
        //Creo el TextArea y le paso sus caracteristicas
        text = new JTextArea(30, 50);
        text.setEditable(false);
        text.setLineWrap(true);
        text.setWrapStyleWord(false);
        text.setVisible(true);

        panel.add(text, BorderLayout.CENTER);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        //Creo el scroll
        JScrollPane jsp = new JScrollPane();
        jsp.setViewportView(text);
        this.add(jsp, BorderLayout.NORTH);

        this.setVisible(true);

        //Aqui simplemente añado el panel al internalframe
        this.add(panel);
    }

    public void addController(HelpController cal) {

        this.c = cal;
    }

}
