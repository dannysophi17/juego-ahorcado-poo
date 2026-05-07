package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class PanelAhorcado extends JPanel {
    // Guarda la cantidad de errores que lleva el jugador
    private int errores;

    public PanelAhorcado() {
        errores = 0;

        // Tamaño del panel para que el dibujo no se corte
        setPreferredSize(new Dimension(300, 350));

        // Fondo blanco para que el muñeco se vea claro
        setBackground(Color.WHITE);
    }

    public void setErrores(int errores) {
        this.errores = errores;

        // Cada vez que cambian los errores, se vuelve a pintar el dibujo
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        // Grosor de las lineas del dibujo
        g2.setStroke(new BasicStroke(2));

        // Color general del ahorcado
        g2.setColor(new Color(40, 40, 40));

        // Estructura base del soporte
        g2.drawLine(50, 300, 180, 300);   // base
        g2.drawLine(115, 300, 115, 50);   // poste vertical
        g2.drawLine(115, 50, 230, 50);    // parte superior
        g2.drawLine(230, 50, 230, 80);    // cuerda inicial

        // Error 1: cabeza
        if (errores >= 1) {
            g2.drawOval(205, 80, 50, 50);
        }

        // Error 2: torso
        if (errores >= 2) {
            g2.drawLine(230, 130, 230, 195);
        }

        // Error 3: brazo derecho
        if (errores >= 3) {
            g2.drawLine(230, 145, 260, 170);
        }

        // Error 4: brazo izquierdo
        if (errores >= 4) {
            g2.drawLine(230, 145, 200, 170);
        }

        // Error 5: pierna derecha
        if (errores >= 5) {
            g2.drawLine(230, 195, 260, 240);
        }

        // Error 6: pierna izquierda
        if (errores >= 6) {
            g2.drawLine(230, 195, 200, 240);
        }

        // Error 7: cuerda final y ojos en X
        if (errores >= 7) {
            g2.drawLine(230, 50, 230, 75);

            // Ojo izquierdo en X
            g2.drawLine(215, 95, 223, 103);
            g2.drawLine(223, 95, 215, 103);

            // Ojo derecho en X
            g2.drawLine(237, 95, 245, 103);
            g2.drawLine(245, 95, 237, 103);
        }
    }
}
