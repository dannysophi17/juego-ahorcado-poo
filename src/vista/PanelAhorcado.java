package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class PanelAhorcado extends JPanel {
    private int errores;

    public PanelAhorcado() {
        errores = 0;
        setPreferredSize(new Dimension(300, 350));
        setBackground(Color.WHITE);
    }

    public void setErrores(int errores) {
        this.errores = errores;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        g2.setColor(new Color(40, 40, 40));

        // Estructura base del ahorcado
        g2.drawLine(50, 300, 180, 300);
        g2.drawLine(115, 300, 115, 50);
        g2.drawLine(115, 50, 230, 50);
        g2.drawLine(230, 50, 230, 80);

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
            // Cuerda final y ojos en X para mostrar que perdió
            g2.drawLine(230, 50, 230, 75);

            g2.drawLine(215, 95, 223, 103);
            g2.drawLine(223, 95, 215, 103);

            g2.drawLine(237, 95, 245, 103);
            g2.drawLine(245, 95, 237, 103);
        }
    }
}
