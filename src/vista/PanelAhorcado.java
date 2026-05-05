package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class PanelAhorcado extends JPanel {
    // Guarda la cantidad de errores para saber que parte dibujar
    private int errores;

    public PanelAhorcado() {
        errores = 0;

        // Esto ayuda a que el panel si tenga un espacio visible en la ventana
        setPreferredSize(new Dimension(300, 300));
    }

    public void setErrores(int errores) {
        this.errores = errores;

        // Cada vez que cambian los errores, se vuelve a dibujar el panel
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Estructura base del ahorcado
        g2.drawLine(50, 250, 170, 250);   // base
        g2.drawLine(110, 250, 110, 50);   // poste vertical
        g2.drawLine(110, 50, 220, 50);    // parte superior
        g2.drawLine(220, 50, 220, 80);    // cuerda base

        // Cada error dibuja una parte del personaje
        if (errores >= 1) {
            g2.drawOval(195, 80, 50, 50); // cabeza
        }

        if (errores >= 2) {
            g2.drawLine(220, 130, 220, 190); // torso
        }

        if (errores >= 3) {
            g2.drawLine(220, 145, 250, 170); // brazo derecho
        }

        if (errores >= 4) {
            g2.drawLine(220, 145, 190, 170); // brazo izquierdo
        }

        if (errores >= 5) {
            g2.drawLine(220, 190, 250, 225); // pierna derecha
        }

        if (errores >= 6) {
            g2.drawLine(220, 190, 190, 225); // pierna izquierda
        }

        if (errores >= 7) {
            g2.drawLine(220, 50, 220, 70); // cuerda final
        }
    }
}
