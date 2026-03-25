package vista;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class PanelAhorcado extends JPanel {
    // Numero de errores actuales
    private int errores;

    public PanelAhorcado() {
        errores = 0;
    }

    public void setErrores(int errores) {
        this.errores = errores;
        repaint(); // fuerza el redibujado del panel
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Base del soporte
        g2.drawLine(50, 250, 170, 250);

        // Poste vertical
        g2.drawLine(110, 250, 110, 50);

        // Parte superior
        g2.drawLine(110, 50, 220, 50);

        // Cuerda base
        g2.drawLine(220, 50, 220, 80);

        // Cada error dibuja una parte del personaje
        if (errores >= 1) {
            // Cabeza
            g2.drawOval(195, 80, 50, 50);
        }

        if (errores >= 2) {
            // Torso
            g2.drawLine(220, 130, 220, 190);
        }

        if (errores >= 3) {
            // Brazo derecho
            g2.drawLine(220, 145, 250, 170);
        }

        if (errores >= 4) {
            // Brazo izquierdo
            g2.drawLine(220, 145, 190, 170);
        }

        if (errores >= 5) {
            // Pierna derecha
            g2.drawLine(220, 190, 250, 225);
        }

        if (errores >= 6) {
            // Pierna izquierda
            g2.drawLine(220, 190, 190, 225);
        }

        if (errores >= 7) {
            // Cuerda final
            g2.drawLine(220, 50, 220, 70);
        }
    }
}
