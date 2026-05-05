package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import modelo.JuegoAhorcado;

public class VentanaJuego extends JFrame {
    private JuegoAhorcado juego;
    private PanelAhorcado panelAhorcado;

    private JLabel lblPalabra;
    private JLabel lblIntentos;
    private JLabel lblIncorrectas;
    private JLabel lblMeli;

    private JTextField txtLetra;
    private JButton btnProbar;
    private JButton btnPistaCategoria;
    private JButton btnPistaLetra;
    private JButton btnPistaEscrita;
    private JButton btnReiniciar;

    // Colores principales de la interfaz
    private final Color VERDE = new Color(0, 105, 75);
    private final Color VERDE_CLARO = new Color(0, 150, 90);
    private final Color FONDO = new Color(245, 247, 246);
    private final Color ROJO = new Color(190, 40, 40);

    // Variables pequeñas para animar a Meli
    private int movimientoMeli = 0;
    private boolean subirMeli = true;

    public VentanaJuego() {
        juego = new JuegoAhorcado();
        inicializarComponentes();
        configurarEventos();
        iniciarAnimacionMeli();
        actualizarVista();
    }

    public void inicializarComponentes() {
        setTitle("Juego del Ahorcado - POO");
        setSize(1050, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(18, 18));
        getContentPane().setBackground(FONDO);

        JLabel lblTitulo = new JLabel("Juego del Ahorcado Interactivo", JLabel.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblTitulo.setForeground(VERDE);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(18, 10, 8, 10));
        add(lblTitulo, BorderLayout.NORTH);

        panelAhorcado = new PanelAhorcado();
        panelAhorcado.setBackground(Color.WHITE);
        panelAhorcado.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(225, 225, 225)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        add(panelAhorcado, BorderLayout.WEST);

        JPanel panelCentro = new JPanel(new GridLayout(4, 1, 10, 10));
        panelCentro.setBackground(Color.WHITE);
        panelCentro.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(225, 225, 225)),
                BorderFactory.createEmptyBorder(25, 25, 25, 25)
        ));

        lblPalabra = new JLabel("", JLabel.CENTER);
        lblPalabra.setFont(new Font("Consolas", Font.BOLD, 28));
        lblPalabra.setForeground(VERDE);

        lblIntentos = new JLabel("", JLabel.CENTER);
        lblIntentos.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        lblIncorrectas = new JLabel("", JLabel.CENTER);
        lblIncorrectas.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblIncorrectas.setForeground(ROJO);

        lblMeli = new JLabel("", JLabel.CENTER);
        lblMeli.setPreferredSize(new Dimension(170, 170));
        cargarImagenMeli();

        panelCentro.add(lblPalabra);
        panelCentro.add(lblIntentos);
        panelCentro.add(lblIncorrectas);
        panelCentro.add(lblMeli);

        add(panelCentro, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new GridLayout(4, 1, 12, 12));
        panelBotones.setBackground(FONDO);
        panelBotones.setBorder(BorderFactory.createEmptyBorder(40, 10, 40, 20));
        panelBotones.setPreferredSize(new Dimension(180, 0));

        btnPistaCategoria = crearBoton("Pista categoría", VERDE_CLARO);
        btnPistaLetra = crearBoton("Pista letra", new Color(52, 152, 219));
        btnPistaEscrita = crearBoton("Pista escrita", new Color(230, 126, 34));
        btnReiniciar = crearBoton("Reiniciar", new Color(120, 130, 135));

        panelBotones.add(btnPistaCategoria);
        panelBotones.add(btnPistaLetra);
        panelBotones.add(btnPistaEscrita);
        panelBotones.add(btnReiniciar);

        add(panelBotones, BorderLayout.EAST);

        JPanel panelSur = new JPanel();
        panelSur.setBackground(FONDO);
        panelSur.setBorder(BorderFactory.createEmptyBorder(5, 10, 18, 10));

        JLabel lblEntrada = new JLabel("Escribe una letra: ");
        lblEntrada.setFont(new Font("Segoe UI", Font.BOLD, 16));

        txtLetra = new JTextField(3);
        txtLetra.setFont(new Font("Segoe UI", Font.PLAIN, 22));

        btnProbar = crearBoton("Adivinar", VERDE);

        panelSur.add(lblEntrada);
        panelSur.add(txtLetra);
        panelSur.add(btnProbar);

        add(panelSur, BorderLayout.SOUTH);
    }

    private JButton crearBoton(String texto, Color color) {
        JButton boton = new JButton(texto) {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(getBackground());
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 22, 22);
                super.paintComponent(g);
            }
        };

        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setForeground(Color.WHITE);
        boton.setBackground(color);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setContentAreaFilled(false);
        boton.setOpaque(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        Color normal = color;
        Color hover = color.darker();

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(normal);
            }
        });

        return boton;
    }

    private void cargarImagenMeli() {
        try {
            ImageIcon icono = new ImageIcon(getClass().getResource("/recursos/meli.png"));
            Image imagen = icono.getImage().getScaledInstance(135, 135, Image.SCALE_SMOOTH);
            lblMeli.setIcon(new ImageIcon(imagen));
            lblMeli.setText("Meli acompaña tu partida");
            lblMeli.setHorizontalTextPosition(JLabel.CENTER);
            lblMeli.setVerticalTextPosition(JLabel.BOTTOM);
            lblMeli.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblMeli.setForeground(VERDE);
        } catch (Exception e) {
            lblMeli.setText("Universidad Ean");
            lblMeli.setFont(new Font("Segoe UI", Font.BOLD, 15));
            lblMeli.setForeground(VERDE);
        }
    }

    private void iniciarAnimacionMeli() {
        Timer timer = new Timer(120, e -> {
            if (subirMeli) {
                movimientoMeli++;
                if (movimientoMeli >= 4) {
                    subirMeli = false;
                }
            } else {
                movimientoMeli--;
                if (movimientoMeli <= 0) {
                    subirMeli = true;
                }
            }

            lblMeli.setBorder(BorderFactory.createEmptyBorder(movimientoMeli, 0, 0, 0));
        });

        timer.start();
    }

    public void configurarEventos() {
        btnProbar.addActionListener(e -> {
            String entrada = txtLetra.getText().trim().toLowerCase();

            if (entrada.isEmpty()) {
                mostrarMensaje("Ingresa una letra para continuar.");
                return;
            }

            if (entrada.length() != 1) {
                mostrarMensaje("Solo puedes ingresar una letra por intento.");
                txtLetra.setText("");
                txtLetra.requestFocus();
                return;
            }

            char letra = entrada.charAt(0);

            if (!Character.isLetter(letra)) {
                mostrarMensaje("Debes ingresar una letra válida, no números ni símbolos.");
                txtLetra.setText("");
                txtLetra.requestFocus();
                return;
            }

            if (juego.letraYaFueUsada(letra)) {
                mostrarMensaje("Esa letra ya fue usada.\nIntenta con otra.");
                txtLetra.setText("");
                txtLetra.requestFocus();
                return;
            }

            boolean acierto = juego.probarLetra(letra);

            if (acierto) {
                mostrarMensaje("Bien.\nLa letra sí está en la palabra.");
            } else {
                mostrarMensaje("La letra no está en la palabra.\nSe suma un error.");
            }

            actualizarVista();
            txtLetra.setText("");
            txtLetra.requestFocus();

            if (juego.yaGano()) {
                mostrarMensaje("¡Ganaste!\n\nCompletaste la palabra correctamente.\nPalabra: "
                        + juego.getPalabraActual().getTexto()
                        + "\n\nPuedes iniciar una nueva partida con el botón Reiniciar.");
                bloquearEntrada();
            } else if (juego.yaPerdio()) {
                mostrarMensaje("Fin de la partida.\n\nLlegaste al máximo de 7 errores.\nLa palabra era: "
                        + juego.getPalabraActual().getTexto()
                        + "\n\nPresiona Reiniciar para intentarlo otra vez.");
                bloquearEntrada();
            }
        });

        btnPistaCategoria.addActionListener(e -> {
            mostrarMensaje(juego.usarPistaCategoria());
            btnPistaCategoria.setEnabled(false);
            actualizarVista();
        });

        btnPistaLetra.addActionListener(e -> {
            mostrarMensaje(juego.usarPistaLetra());
            btnPistaLetra.setEnabled(false);
            actualizarVista();

            if (juego.yaGano()) {
                mostrarMensaje("¡Ganaste!\n\nLa pista de letra completó la palabra.\nPalabra: "
                        + juego.getPalabraActual().getTexto()
                        + "\n\nPuedes iniciar otra partida con Reiniciar.");
                bloquearEntrada();
            }
        });

        btnPistaEscrita.addActionListener(e -> {
            mostrarMensaje(juego.usarPistaEscrita());
            btnPistaEscrita.setEnabled(false);
            actualizarVista();
        });

        btnReiniciar.addActionListener(e -> {
            juego.reiniciarJuego();
            activarEntrada();
            actualizarVista();
            mostrarMensaje("Nueva partida iniciada.\nBuena suerte.");
        });
    }

    public void actualizarVista() {
        lblPalabra.setText(formatearProgreso());
        lblIntentos.setText("Errores: " + juego.getIntentosFallidos() + " / " + juego.getMaxIntentos());

        ArrayList<Character> incorrectas = juego.getLetrasIncorrectas();
        lblIncorrectas.setText("Letras incorrectas: " + incorrectas.toString());

        panelAhorcado.setErrores(juego.getIntentosFallidos());
    }

    private String formatearProgreso() {
        StringBuilder sb = new StringBuilder();
        char[] progreso = juego.getProgresoArray();

        for (char c : progreso) {
            if (c == ' ') {
                sb.append("   ");
            } else {
                sb.append(c).append(" ");
            }
        }

        return sb.toString().trim();
    }

    private void bloquearEntrada() {
        txtLetra.setEnabled(false);
        btnProbar.setEnabled(false);
        btnPistaCategoria.setEnabled(false);
        btnPistaLetra.setEnabled(false);
        btnPistaEscrita.setEnabled(false);
    }

    private void activarEntrada() {
        txtLetra.setEnabled(true);
        btnProbar.setEnabled(true);
        btnPistaCategoria.setEnabled(true);
        btnPistaLetra.setEnabled(true);
        btnPistaEscrita.setEnabled(true);
        txtLetra.setText("");
        txtLetra.requestFocus();
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
