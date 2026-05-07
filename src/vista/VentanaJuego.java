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
    // Instancia principal de la logica del juego
    private JuegoAhorcado juego;

    // Panel donde se dibuja el ahorcado segun los errores
    private PanelAhorcado panelAhorcado;

    // Etiquetas para mostrar informacion de la partida
    private JLabel lblPalabra;
    private JLabel lblIntentos;
    private JLabel lblIncorrectas;
    private JLabel lblMeli;

    // Campo para ingresar letras y botones de accion
    private JTextField txtLetra;
    private JButton btnProbar;
    private JButton btnPistaCategoria;
    private JButton btnPistaLetra;
    private JButton btnPistaEscrita;
    private JButton btnReiniciar;

    // Colores principales usados en la interfaz
    private final Color VERDE = new Color(0, 105, 75);
    private final Color VERDE_CLARO = new Color(0, 150, 90);
    private final Color FONDO = new Color(245, 247, 246);
    private final Color ROJO = new Color(190, 40, 40);

    // Variables para hacer una animacion sencilla de Meli
    private int movimientoMeli = 0;
    private boolean subirMeli = true;

    public VentanaJuego() {
        juego = new JuegoAhorcado();

        // Se construye la interfaz y luego se conectan los eventos
        inicializarComponentes();
        configurarEventos();

        // Animacion visual de la mascota
        iniciarAnimacionMeli();

        // Primera actualizacion de pantalla
        actualizarVista();
    }

    public void inicializarComponentes() {
        // Configuracion general de la ventana
        setTitle("Juego del Ahorcado - POO");
        setSize(1050, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(18, 18));
        getContentPane().setBackground(FONDO);

        // Icono de la ventana usando la imagen de Meli
        cargarIconoVentana();

        // Titulo principal
        JLabel lblTitulo = new JLabel("Juego del Ahorcado Interactivo", JLabel.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblTitulo.setForeground(VERDE);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(18, 10, 8, 10));
        add(lblTitulo, BorderLayout.NORTH);

        // Panel izquierdo con el dibujo del ahorcado
        panelAhorcado = new PanelAhorcado();
        panelAhorcado.setBackground(Color.WHITE);
        panelAhorcado.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(225, 225, 225)),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        add(panelAhorcado, BorderLayout.WEST);

        // Panel central donde se muestra el estado de la partida
        JPanel panelCentro = new JPanel(new GridLayout(4, 1, 10, 10));
        panelCentro.setBackground(Color.WHITE);
        panelCentro.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(225, 225, 225)),
                BorderFactory.createEmptyBorder(25, 25, 25, 25)
        ));

        // Palabra oculta con guiones y letras reveladas
        lblPalabra = new JLabel("", JLabel.CENTER);
        lblPalabra.setFont(new Font("Consolas", Font.BOLD, 28));
        lblPalabra.setForeground(VERDE);

        // Numero de errores del jugador
        lblIntentos = new JLabel("", JLabel.CENTER);
        lblIntentos.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        // Lista de letras incorrectas
        lblIncorrectas = new JLabel("", JLabel.CENTER);
        lblIncorrectas.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblIncorrectas.setForeground(ROJO);

        // Imagen de Meli dentro del panel central
        lblMeli = new JLabel("", JLabel.CENTER);
        lblMeli.setPreferredSize(new Dimension(170, 170));
        cargarImagenMeli();

        panelCentro.add(lblPalabra);
        panelCentro.add(lblIntentos);
        panelCentro.add(lblIncorrectas);
        panelCentro.add(lblMeli);

        add(panelCentro, BorderLayout.CENTER);

        // Panel derecho con pistas y reinicio
        JPanel panelBotones = new JPanel(new GridLayout(4, 1, 12, 12));
        panelBotones.setBackground(FONDO);
        panelBotones.setBorder(BorderFactory.createEmptyBorder(40, 10, 40, 20));
        panelBotones.setPreferredSize(new Dimension(180, 0));

        // Botones de pistas y reinicio
        btnPistaCategoria = crearBoton("Pista categoria", VERDE_CLARO);
        btnPistaLetra = crearBoton("Pista letra", new Color(52, 152, 219));
        btnPistaEscrita = crearBoton("Pista escrita", new Color(230, 126, 34));
        btnReiniciar = crearBoton("Reiniciar", new Color(120, 130, 135));

        panelBotones.add(btnPistaCategoria);
        panelBotones.add(btnPistaLetra);
        panelBotones.add(btnPistaEscrita);
        panelBotones.add(btnReiniciar);

        add(panelBotones, BorderLayout.EAST);

        // Panel inferior para escribir la letra
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
        /*
         * Este metodo crea botones con estilo propio.
         * Se usa para no repetir la misma configuracion en cada boton.
         */
        JButton boton = new JButton(texto) {
            @Override
            protected void paintComponent(Graphics g) {
                // Dibuja un fondo redondeado para que el boton se vea mas moderno
                g.setColor(getBackground());
                g.fillRoundRect(0, 0, getWidth(), getHeight(), 22, 22);
                super.paintComponent(g);
            }
        };

        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setForeground(Color.WHITE);
        boton.setBackground(color);

        // Se quitan bordes clasicos de Swing
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
        boton.setContentAreaFilled(false);
        boton.setOpaque(false);

        // Cursor de mano para mejorar la interaccion
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        Color normal = color;
        Color hover = color.darker();

        // Efecto sencillo cuando el mouse pasa sobre el boton
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

    private void cargarIconoVentana() {
        try {
            // Se carga la imagen como icono de la ventana
            ImageIcon icono = new ImageIcon(getClass().getResource("/recursos/meli.png"));
            setIconImage(icono.getImage());
        } catch (Exception e) {
            // Si no encuentra la imagen, la ventana funciona igual
        }
    }

    private void cargarImagenMeli() {
        try {
            // Se carga la imagen de Meli desde la carpeta recursos
            ImageIcon icono = new ImageIcon(getClass().getResource("/recursos/meli.png"));

            // Se ajusta el tamaño para que no se corte en la interfaz
            Image imagen = icono.getImage().getScaledInstance(135, 135, Image.SCALE_SMOOTH);

            lblMeli.setIcon(new ImageIcon(imagen));
            lblMeli.setText("Meli acompaña tu partida");
            lblMeli.setHorizontalTextPosition(JLabel.CENTER);
            lblMeli.setVerticalTextPosition(JLabel.BOTTOM);
            lblMeli.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            lblMeli.setForeground(VERDE);
        } catch (Exception e) {
            // Si no hay imagen, se deja un texto simple para evitar errores
            lblMeli.setText("Universidad Ean");
            lblMeli.setFont(new Font("Segoe UI", Font.BOLD, 15));
            lblMeli.setForeground(VERDE);
        }
    }

    private void iniciarAnimacionMeli() {
        /*
         * Timer permite hacer una animacion sencilla sin bloquear la interfaz.
         * En este caso Meli se mueve un poco hacia arriba y abajo.
         */
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

            // El borde cambia para simular el movimiento vertical
            lblMeli.setBorder(BorderFactory.createEmptyBorder(movimientoMeli, 0, 0, 0));
        });

        timer.start();
    }

    public void configurarEventos() {
        // Evento del boton para probar una letra
        btnProbar.addActionListener(e -> {
            String entrada = txtLetra.getText().trim().toLowerCase();

            // Validacion 1: no permitir campo vacio
            if (entrada.isEmpty()) {
                mostrarMensaje("Ingresa una letra para continuar.");
                return;
            }

            // Validacion 2: solo se permite una letra por intento
            if (entrada.length() != 1) {
                mostrarMensaje("Solo puedes ingresar una letra por intento.");
                txtLetra.setText("");
                txtLetra.requestFocus();
                return;
            }

            char letra = entrada.charAt(0);

            // Validacion 3: no permitir numeros ni simbolos
            if (!Character.isLetter(letra)) {
                mostrarMensaje("Debes ingresar una letra valida, no numeros ni simbolos.");
                txtLetra.setText("");
                txtLetra.requestFocus();
                return;
            }

            // Validacion 4: no repetir letras
            if (juego.letraYaFueUsada(letra)) {
                mostrarMensaje("Esa letra ya fue usada.\nIntenta con otra.");
                txtLetra.setText("");
                txtLetra.requestFocus();
                return;
            }

            // Se envia la letra a la logica del juego
            boolean acierto = juego.probarLetra(letra);

            if (acierto) {
                mostrarMensaje("Bien.\nLa letra si esta en la palabra.");
            } else {
                mostrarMensaje("La letra no esta en la palabra.\nSe suma un error.");
            }

            // Se actualiza la interfaz despues del intento
            actualizarVista();
            txtLetra.setText("");
            txtLetra.requestFocus();

            // Se verifica si la partida ya termino
            if (juego.yaGano()) {
                mostrarMensaje("Ganaste.\n\nCompletaste la palabra correctamente.\nPalabra: "
                        + juego.getPalabraActual().getTexto()
                        + "\n\nPuedes iniciar una nueva partida con el boton Reiniciar.");
                bloquearEntrada();
            } else if (juego.yaPerdio()) {
                mostrarMensaje("GAME OVER.\n\nLlegaste al maximo de 7 errores.\nLa palabra era: "
                        + juego.getPalabraActual().getTexto()
                        + "\n\nPresiona Reiniciar para intentarlo otra vez.");
                bloquearEntrada();
            }
        });

        // Evento para usar la pista de categoria
        btnPistaCategoria.addActionListener(e -> {
            mostrarMensaje(juego.usarPistaCategoria());
            btnPistaCategoria.setEnabled(false);
            actualizarVista();
        });

        // Evento para usar la pista de letra
        btnPistaLetra.addActionListener(e -> {
            mostrarMensaje(juego.usarPistaLetra());
            btnPistaLetra.setEnabled(false);
            actualizarVista();

            // Si la pista completa la palabra, se termina la partida
            if (juego.yaGano()) {
                mostrarMensaje("Ganaste.\n\nLa pista de letra completo la palabra.\nPalabra: "
                        + juego.getPalabraActual().getTexto()
                        + "\n\nPuedes iniciar otra partida con Reiniciar.");
                bloquearEntrada();
            }
        });

        // Evento para usar la pista escrita
        btnPistaEscrita.addActionListener(e -> {
            mostrarMensaje(juego.usarPistaEscrita());
            btnPistaEscrita.setEnabled(false);
            actualizarVista();
        });

        // Evento para reiniciar la partida
        btnReiniciar.addActionListener(e -> {
            juego.reiniciarJuego();
            activarEntrada();
            actualizarVista();
            mostrarMensaje("Nueva partida iniciada.\nBuena suerte.");
        });
    }

    public void actualizarVista() {
        /*
         * Este metodo sincroniza la interfaz con el estado actual del juego.
         * Se llama despues de cada intento, pista o reinicio.
         */
        lblPalabra.setText(formatearProgreso());
        lblIntentos.setText("Errores: " + juego.getIntentosFallidos() + " / " + juego.getMaxIntentos());

        ArrayList<Character> incorrectas = juego.getLetrasIncorrectas();
        lblIncorrectas.setText("Letras incorrectas: " + incorrectas.toString());

        // Se actualiza el dibujo segun la cantidad de errores
        panelAhorcado.setErrores(juego.getIntentosFallidos());
    }

    private String formatearProgreso() {
        /*
         * Convierte el arreglo de progreso en texto visible.
         * Los espacios de palabras compuestas se muestran automaticamente.
         */
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
        // Bloquea la entrada cuando el jugador gana o pierde
        txtLetra.setEnabled(false);
        btnProbar.setEnabled(false);
        btnPistaCategoria.setEnabled(false);
        btnPistaLetra.setEnabled(false);
        btnPistaEscrita.setEnabled(false);
    }

    private void activarEntrada() {
        // Reactiva los controles al iniciar una nueva partida
        txtLetra.setEnabled(true);
        btnProbar.setEnabled(true);
        btnPistaCategoria.setEnabled(true);
        btnPistaLetra.setEnabled(true);
        btnPistaEscrita.setEnabled(true);

        txtLetra.setText("");
        txtLetra.requestFocus();
    }

    public void mostrarMensaje(String mensaje) {
        // Metodo central para mostrar mensajes al usuario
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
