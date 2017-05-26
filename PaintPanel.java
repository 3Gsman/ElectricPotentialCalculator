/**
 * @author Pablo Ferrer Lopez
 * Esta es la clase PaintPanel la cual hereda de JPanel para crear el panel en el cual dibujamos el tablero de ajedrez.
 * 
 */
package view;
/**
 * Estas son las clases que he tenido que importar para poder trabajar:
 * - AWT es importado ya que los métodos drawRect y fillRect son de AWT.
 * - JPanel es importado ya que trabajamos con el JPanel en esta clase.
 */
import java.awt.*;
import javax.swing.JPanel;


public class PaintPanel extends JPanel {
/**
* La siguiente linea simplemente declara una versionUID para poder trabajar con una clase que herede de JPanel sin 
* que nos de problemas
*/
	private static final long serialVersionUID = 1L;
	
/**
* En este apartado sobreescribimos el método paintComponent para poder dibujar sobre este JPanel y en el super le pasamos
* el nombre que le hallamos dado a Graphics.
*/
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
/**
* Tras esto procedemos con el tablero, primero asignamos el color blanco mediante "setColor" y creamos el cuadrado blanco 
* mediante "fillRect" que sera el que contenga los cuadrados negros mas pequeños, pasandole un tamaño y posición.
*/
		g.setColor(new Color(255,255,255));
		g.fillRect(90,80,400,400);

/**
* Después dibujamos el contorno en color negro, mediante "drawRect" y le damos las mismas características que el cuadrado
* blanco.(lo normal sería primero hacer el contorno y despues el relleno pero esta hecho al reves para no tener que
* escribir el método "setColor" mas de lo necesario ya que la siguiente parte es toda negra)
*/
		g.setColor(new Color(0,0,0));
		g.drawRect(90, 80, 400, 400);
		
/**
* Finalmente mediante dos bucles "for" dobles nos disponemos a crear los cuadrados negros que darán forma a nuestro tablero.
* En la primera parte del primer bucle le pasamos que empiece la "i" desde 140 hasta 490 aumentando 100 unidades cada vez porque dado que nuestro cuadrado 
* blanco exterior empieza con 90 unidades de distancia horizontal y que el primer cuadrado es blanco por ello empieza en 140
* dado que el cuadrado negro ocupa 50 unidades y llega hasta 490 porque el cuadrado blanco ocupa 400x400.
* 
* En la segunda parte le pasamos a la "j" que empiece en 80 hasta 480 y que valla sumando 100 unidades ya que nuestro 
* cuadrado blanco exterior empieza con 80 unidades de distancia vertical y como ocupa 400x400 por ello acaba en 480.
* 
* En el segundo bucle "for" se aplica la misma metodología pero al ser el primer cuadrado negro empieza en 90 en vez de 
* empezar en 140.
* 
*/		
		for(int i=140;i<490;i+=100){
			for(int j=80;j<480;j+=100){
			g.fillRect(i,j,50,50);
			}
		}	
		
        for(int i=90;i<490;i+=100){
        	for(int j=130;j<480;j+=100){
        		g.fillRect(i,j,50,50);
        	}
		}	
	}
}