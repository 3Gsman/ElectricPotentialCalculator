package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFrame;
import view.HelpFrame;

/**
 * The objective of HelpController is to ensure the proper functioning of
 * the HelpFrame (View)
 * @author ALTF4
 * @version 2.0
 * @see view.HelpFrame
 * 
 */
public class HelpController {

    public HelpFrame win;
    public JFrame frmDialogo;

    public HelpController(HelpFrame win) {
        this.win = win;

    }

    public HelpController() {
        win.crearVista();

    }
    /**
     *Assign the .txt that is going to be used in the HelpFrame textArea 
     *@param nothing  
     */
    public void showText() {

        File fileH = new File("Help.txt");

        try {
            BufferedReader read = new BufferedReader(new FileReader(fileH));
            String line = read.readLine();

            while (line != null) {
                win.text.append(line + " " + "\n");
                line = read.readLine();
            }

        } catch (Exception ex) {

        }
    }

}
