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
import vista.PanelAhorcado;

public class VentanaJuego extends JFrame {
    private JuegoAhorcado juego;
    private PanelAhorcado panelAhorcado;

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
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Titulo principal de la interfaz
        JLabel lblTitulo = new JLabel("Juego del Ahorcado", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        add(lblTitulo, BorderLayout.NORTH);

        // Panel donde se dibuja el ahorcado
        panelAhorcado = new PanelAhorcado();
        add(panelAhorcado, BorderLayout.WEST);

        // Centro: informacion del juego
        JPanel panelCentro = new JPanel(new GridLayout(3, 1, 10, 10));

        lblPalabra = new JLabel("", JLabel.CENTER);
        lblPalabra.setFont(new Font("Monospaced", Font.BOLD, 36));

        lblIntentos = new JLabel("", JLabel.CENTER);
        lblIntentos.setFont(new Font("Arial", Font.PLAIN, 18));

        lblIncorrectas = new JLabel("", JLabel.CENTER);
        lblIncorrectas.setFont(new Font("Arial", Font.BOLD, 18));
        lblIncorrectas.setForeground(new java.awt.Color(200, 0, 0));

        panelCentro.add(lblPalabra);
        panelCentro.add(lblIntentos);
        panelCentro.add(lblIncorrectas);

        add(panelCentro, BorderLayout.CENTER);

        // Derecha: botones de pistas y reinicio
        JPanel panelPistas = new JPanel(new GridLayout(4, 1, 10, 10));

        btnPistaCategoria = new JButton("Pista categoria");
        btnPistaCategoria.setBackground(new java.awt.Color(46, 204, 113));
        btnPistaCategoria.setForeground(java.awt.Color.WHITE);

        btnPistaLetra = new JButton("Pista letra");
        btnPistaLetra.setBackground(new java.awt.Color(52, 152, 219));
        btnPistaLetra.setForeground(java.awt.Color.WHITE);

        btnPistaEscrita = new JButton("Pista escrita");
        btnPistaEscrita.setBackground(new java.awt.Color(230, 126, 34));
        btnPistaEscrita.setForeground(java.awt.Color.WHITE);

        btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.setBackground(new java.awt.Color(189, 195, 199));

        panelPistas.add(btnPistaCategoria);
        panelPistas.add(btnPistaLetra);
        panelPistas.add(btnPistaEscrita);
        panelPistas.add(btnReiniciar);

        add(panelPistas, BorderLayout.EAST);

        // Sur: entrada de letras
        JPanel panelSur = new JPanel();

        txtLetra = new JTextField(3);
        txtLetra.setFont(new Font("Arial", Font.PLAIN, 20));

        btnProbar = new JButton("Adivinar");

        panelSur.add(new JLabel("Escribe una letra: "));
        panelSur.add(txtLetra);
        panelSur.add(btnProbar);

        add(panelSur, BorderLayout.SOUTH);
    }

    public void configurarEventos() {
        btnProbar.addActionListener(e -> {
            String entrada = txtLetra.getText().trim().toLowerCase();

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
                txtLetra.requestFocus();
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
            txtLetra.requestFocus();

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
