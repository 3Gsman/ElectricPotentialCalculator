package control;

import view.CalcFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import model.Charge;

/**
 * CalcController takes care of the operations that have to be done to  ensure
 * a successful outcome while calculating the electric potential. The distance 
 * with the coordinates given is calculated to be able to apply the potential 
 * equation
 * @author ALTF4
 * @version 5.5
 * @see view.CalcFrame
 */
public class CalcController implements ActionListener {

    public CalcFrame win;
    public JFrame frmDialogo;

    public CalcController(CalcFrame win) {
        this.win = win;

    }
    /**
     * Convert the data given in the view.CalcFrame to variables that could be 
     * used in the equation.
     * @param totsl 
     */
    public void actionPerformed(ActionEvent e) {

        MainController.setPoint((double) ((Double.parseDouble(win.fieldx.getText()))),
                (double) ((Double.parseDouble(win.fieldy.getText()))));

        Point2D.Double p = MainController.getPoint();

        final double K = -9;  // Simplified constant. Real constant: -9 * 10^9.

        double total = 0;
        double d = 0;
        // Calculate the potential
        for (Charge c : MainController.getList()) {

            double x = p.x - c.getX();
            double y = p.y - c.getY();
            d = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            double r = (c.getVal() * K / d);
            total = (total + r);

            //System.out.println("Pot:" + r);
        }

        total = Math.floor(total * 100) / 100;

        if (total == 0) {
            win.fieldresult.setText(" 0 V");
            
         } else if ( total == Double.NEGATIVE_INFINITY || total == Double.POSITIVE_INFINITY) {    
            win.fieldresult.setText("Not possible");
            
        } else {
            win.fieldresult.setText(total + " · 10^3 V");

        }
    }
}
