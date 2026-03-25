package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.JuegoAhorcado;

public class VentanaJuego extends JFrame {
    // Instancia principal del juego
    private JuegoAhorcado juego;

    // Panel encargado del dibujo del ahorcado
    private PanelAhorcado panelAhorcado;

    // Componentes principales de la interfaz
    private JLabel lblPalabra;
    private JLabel lblIntentos;
    private JLabel lblIncorrectas;
    private JTextField txtLetra;
    private JButton btnProbar;
    private JButton btnPistaCategoria;
    private JButton btnPistaLetra;
    private JButton btnPistaEscrita;
    private JButton btnReiniciar;

    public VentanaJuego() {
        juego = new JuegoAhorcado();
        inicializarComponentes();
        configurarEventos();
        actualizarVista();
    }

    public void inicializarComponentes() {
        setTitle("Juego del Ahorcado");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        panelAhorcado = new PanelAhorcado();
        add(panelAhorcado, BorderLayout.WEST);

        JPanel panelCentro = new JPanel(new GridLayout(7, 1, 10, 10));

        lblPalabra = new JLabel("", JLabel.CENTER);
        lblPalabra.setFont(new Font("Arial", Font.BOLD, 24));

        lblIntentos = new JLabel("", JLabel.CENTER);
        lblIncorrectas = new JLabel("", JLabel.CENTER);

        txtLetra = new JTextField();
        btnProbar = new JButton("Probar letra");

        btnPistaCategoria = new JButton("Pista categoria");
        btnPistaLetra = new JButton("Pista letra");
        btnPistaEscrita = new JButton("Pista escrita");
        btnReiniciar = new JButton("Reiniciar");

        panelCentro.add(lblPalabra);
        panelCentro.add(lblIntentos);
        panelCentro.add(lblIncorrectas);
        panelCentro.add(txtLetra);
        panelCentro.add(btnProbar);
        panelCentro.add(btnPistaCategoria);
        panelCentro.add(btnPistaLetra);

        add(panelCentro, BorderLayout.CENTER);

        JPanel panelSur = new JPanel();
        panelSur.add(btnPistaEscrita);
        panelSur.add(btnReiniciar);

        add(panelSur, BorderLayout.SOUTH);
    }

    public void configurarEventos() {
        btnProbar.addActionListener(e -> {
            String entrada = txtLetra.getText().trim().toLowerCase();

            // Validacion basica de entrada
            if (entrada.isEmpty()) {
                mostrarMensaje("Ingresa una letra.");
                return;
            }

            if (entrada.length() != 1) {
                mostrarMensaje("Solo debes ingresar una letra.");
                return;
            }

            char letra = entrada.charAt(0);

            if (!Character.isLetter(letra)) {
                mostrarMensaje("Debes ingresar una letra valida.");
                return;
            }

            if (juego.letraYaFueUsada(letra)) {
                mostrarMensaje("Esa letra ya fue usada.");
                txtLetra.setText("");
                return;
            }

            boolean acierto = juego.probarLetra(letra);

            if (acierto) {
                mostrarMensaje("La letra si esta en la palabra.");
            } else {
                mostrarMensaje("La letra no esta en la palabra.");
            }

            actualizarVista();
            txtLetra.setText("");

            if (juego.yaGano()) {
                mostrarMensaje("Ganaste. La palabra era: " + juego.getPalabraActual().getTexto());
            } else if (juego.yaPerdio()) {
                mostrarMensaje("Perdiste. La palabra era: " + juego.getPalabraActual().getTexto());
            }
        });

        btnPistaCategoria.addActionListener(e -> {
            mostrarMensaje(juego.usarPistaCategoria());
            actualizarVista();
        });

        btnPistaLetra.addActionListener(e -> {
            mostrarMensaje(juego.usarPistaLetra());
            actualizarVista();

            if (juego.yaGano()) {
                mostrarMensaje("Ganaste. La palabra era: " + juego.getPalabraActual().getTexto());
            }
        });

        btnPistaEscrita.addActionListener(e -> {
            mostrarMensaje(juego.usarPistaEscrita());
            actualizarVista();
        });

        btnReiniciar.addActionListener(e -> {
            juego.reiniciarJuego();
            actualizarVista();
            mostrarMensaje("Se reinicio la partida.");
        });
    }

    public void actualizarVista() {
        lblPalabra.setText(juego.getProgreso());
        lblIntentos.setText("Errores: " + juego.getIntentosFallidos() + " / " + juego.getMaxIntentos());

        ArrayList<Character> incorrectas = juego.getLetrasIncorrectas();
        lblIncorrectas.setText("Letras incorrectas: " + incorrectas.toString());

        panelAhorcado.setErrores(juego.getIntentosFallidos());
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
