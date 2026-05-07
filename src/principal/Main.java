package principal;

import javax.swing.SwingUtilities;
import vista.VentanaJuego;

public class Main {

    public static void main(String[] args) {
        /*
         * Este metodo es el punto de inicio del programa.
         * Se usa SwingUtilities.invokeLater para abrir la interfaz
         * en el hilo correcto de Swing.
         */
        SwingUtilities.invokeLater(() -> {
            VentanaJuego ventana = new VentanaJuego();
            ventana.setVisible(true);
        });
    }
}
