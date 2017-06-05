package proyectocargas;


import java.awt.FlowLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import javax.swing.SwingUtilities;

/**
 *
 * @author Pablo
 */
public class MainFrame extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    
    //Constructor del Jframe de pruebas que tiene su tamaño y el panel de calculo
    MainFrame(){
        super("Ventana Principal");
        this.setLayout(new FlowLayout());
        
        ProyectoCargas pc = new ProyectoCargas();
        this.setSize(600,600);
        this.setVisible(true);
        /* NOTA IMPORTANTE: si trabajamos con JFrames que tienen internal frames dentro hay que asignarlos como JDesktopPanes 
           de lo contrario se te ajusta el InternalFrame al JFrame y no se le puede cambiar el tamaño*/
        this.setContentPane(new JDesktopPane());
        pc.crearVista();
        this.add(pc);
    }
    
    
    public static void main(String[] args) {
   
   	SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
				
			}
		});
       
    }
}



