package principal;

import javax.swing.SwingUtilities;
import vista.VentanaJuego;

public class Main {

    public static void main(String[] args) {
        // Se usa invokeLater para iniciar la interfaz en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            VentanaJuego ventana = new VentanaJuego();
            ventana.setVisible(true);
        });
    }
}
