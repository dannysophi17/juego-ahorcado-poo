package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class PanelAhorcado extends JPanel {
    // Guarda la cantidad de errores para saber que parte del muñeco se dibuja
    private int errores;

    public PanelAhorcado() {
        errores = 0;

        // Le damos tamaño al panel para que el dibujo sí se vea en la ventana
        setPreferredSize(new Dimension(300, 350));
    }

    public void setErrores(int errores) {
        this.errores = errores;

        // Cada vez que cambian los errores, se vuelve a pintar el panel
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Estructura base del ahorcado
        g2.drawLine(50, 300, 180, 300);   // base
        g2.drawLine(115, 300, 115, 50);   // poste vertical
        g2.drawLine(115, 50, 230, 50);    // parte superior
        g2.drawLine(230, 50, 230, 80);    // cuerda inicial

        // Cada error dibuja una parte del personaje
        if (errores >= 1) {
            g2.drawOval(205, 80, 50, 50); // cabeza
        }

        if (errores >= 2) {
            g2.drawLine(230, 130, 230, 195); // torso
        }

        if (errores >= 3) {
            g2.drawLine(230, 145, 260, 170); // brazo derecho
        }

        if (errores >= 4) {
            g2.drawLine(230, 145, 200, 170); // brazo izquierdo
        }

        if (errores >= 5) {
            g2.drawLine(230, 195, 260, 240); // pierna derecha
        }

        if (errores >= 6) {
            g2.drawLine(230, 195, 200, 240); // pierna izquierda
        }

        if (errores >= 7) {
            g2.drawLine(215, 70, 245, 70); // cuerda final
        }
    }
}
