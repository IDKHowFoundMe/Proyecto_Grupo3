package GUI;
import javax.swing.*;
import java.awt.*;
import helper_classes.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import BusinessLogic.Entities.CodigoBarrasGenerador;
import BusinessLogic.Entities.CodigoBarrasScanner;
import BusinessLogic.EstudianteBL;
import DataAccess.DTO.EstudianteDTO;

public class InterfazGrafica extends JFrame {
    private JLabel lblCodigoBarras, lblFoto;
    private JTextArea lblInformacion;
    private JTextField txtUsuario, txtClave;
    private EstudianteBL estudianteBL;
    private CodigoBarrasGenerador codigoBarras;
    private JPanel panelLogin, panelGeneracion;
    private StringBuilder codigoEscaneado = new StringBuilder(); //para almacenar el codigo escaneado

    public InterfazGrafica() {
        setTitle("Generador y Validador de Código de Barras");
        setSize(826, 445);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new CardLayout());

        estudianteBL = new EstudianteBL();
        codigoBarras = new CodigoBarrasGenerador();

        panelLogin = new JPanel();
        panelLogin.setLayout(null);
        panelLogin.setBackground(Color.decode("#ffffff"));

        // Fondo de Login
        agregarImagen(panelLogin, "Proyecto11\\resources\\images\\onda_azul-removebg-preview.png", 0, 0, 826, 100);
        agregarImagen(panelLogin, "Proyecto11\\resources\\images\\esquina_roja-removebg-preview.png", -5, 265, 150, 150);
        agregarImagen(panelLogin, "Proyecto11\\resources\\images\\images-removebg-preview.png", 250, 30, 300, 150);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(166, 169, 106, 18);
        lblUsuario.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
        panelLogin.add(lblUsuario);

        txtUsuario = new JTextField(20);
        txtUsuario.setBounds(265, 160, 254, 24);
        panelLogin.add(txtUsuario);

        JLabel lblClave = new JLabel("Contraseña:");
        lblClave.setBounds(167, 217, 106, 18);
        panelLogin.add(lblClave);

        txtClave = new JPasswordField(20);
        txtClave.setBounds(266, 214, 255, 24);
        panelLogin.add(txtClave);

        JButton btnLogin = new JButton("Generar Código de Barras");
        btnLogin.setBounds(266, 303, 255, 41);
        panelLogin.add(btnLogin);
        btnLogin.addActionListener(e -> generarCodigoBarras());

        panelGeneracion = new JPanel(null);
        panelGeneracion.setBackground(Color.WHITE);

        // Fondo de panelGeneracion
        agregarImagen(panelGeneracion, "Proyecto11\\resources\\images\\onda_azul-removebg-preview.png", 0, 0, 826, 100);
        agregarImagen(panelGeneracion, "Proyecto11\\resources\\images\\esquina_roja-removebg-preview.png", -5, 265, 150, 150);
        agregarImagen(panelGeneracion, "Proyecto11\\resources\\images\\images-removebg-preview.png", 250, 30, 300, 150);

        lblCodigoBarras = new JLabel();
        lblCodigoBarras.setBounds(50, 180, 200, 100);
        panelGeneracion.add(lblCodigoBarras);

        lblFoto = new JLabel();
        lblFoto.setBounds(550, 180, 150, 150);
        panelGeneracion.add(lblFoto);

        lblInformacion = new JTextArea();
        lblInformacion.setBounds(300, 180, 700, 100);
        lblInformacion.setEditable(false);
        lblInformacion.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
        panelGeneracion.add(lblInformacion);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(350, 370, 100, 30);
        btnRegresar.addActionListener(e -> regresarALogin());
        panelGeneracion.add(btnRegresar);

        add(panelLogin);
        add(panelGeneracion);
        panelGeneracion.setVisible(false);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarCodigoBarras();  // Llamamos al método para generar el código de barras
            }
        });

        // Agregar un KeyListener para capturar el código escaneado
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char caracter = e.getKeyChar();

                // Si el caracter es un salto de línea (Enter), procesar el código escaneado
                if (caracter == '\n') {
                    String codigo = codigoEscaneado.toString();
                    if (!codigo.isEmpty()) {
                        validarCodigoEscaneado(codigo);
                        codigoEscaneado.setLength(0); // Reiniciar el StringBuilder
                    }
                } else {
                    // Almacenar los caracteres del código escaneado
                    codigoEscaneado.append(caracter);
                }
            }
        });

        // Hacer que la ventana sea focusable para recibir eventos de teclado
        setFocusable(true);
    }

    private void agregarImagen(JPanel panel, String path, int x, int y, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        JLabel lbl = new JLabel(new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
        lbl.setBounds(x, y, width, height);
        panel.add(lbl);
    }

    private void generarCodigoBarras() {
        try {
            String usuario = txtUsuario.getText();
            String clave = txtClave.getText();
            if (estudianteBL.iniciarSesion(usuario, clave)) {
                String cedula = estudianteBL.getCedula();
                if (cedula == null || cedula.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No se encontró la cédula del estudiante.");
                    return;
                }
                String pathCodigo = codigoBarras.generar(cedula);
                lblCodigoBarras.setIcon(new ImageIcon(new ImageIcon(pathCodigo).getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH)));
                String pathFoto = estudianteBL.getPathFoto();
                lblFoto.setIcon(new ImageIcon(new ImageIcon(pathFoto).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                EstudianteDTO estudiante = estudianteBL.getByCedula(cedula);
                lblInformacion.setText("Cédula: " + estudiante.getCedula() + "\n" +
                                       "Nombre: " + estudiante.getNombre() + "\n" +
                                       "Apellido: " + estudiante.getApellido() + "\n" +
                                       "Nivel de Inglés: " + estudiante.getIdNivelIngles() + "\n" +
                                       "Ciclo: " + estudiante.getIdCiclo());
                panelLogin.setVisible(false);
                panelGeneracion.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar el código de barras o al obtener la información del estudiante.");
        }
    }

    private void validarCodigoEscaneado(String codigoEscaneado) {
        try {
            boolean puedeIngresar = CodigoBarrasScanner.validar(codigoEscaneado);
            if (puedeIngresar) {
                JOptionPane.showMessageDialog(this, "El estudiante puede ingresar.");
            } else {
                JOptionPane.showMessageDialog(this, "El estudiante NO puede ingresar.");
            }

            // Volver a la pantalla de inicio (login)
            remove(panelGeneracion);  // Eliminar el panel de generación
            add(panelLogin, BorderLayout.CENTER);  // Volver a agregar el panel de login
            revalidate();  // Actualizar la interfaz
            repaint();  // Volver a renderizar la ventana

            // Limpiar los campos
            txtUsuario.setText("");  // Limpiar el campo de usuario
            txtClave.setText("");  // Limpiar el campo de clave

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al validar el código de barras.");
        }
    }

    private void regresarALogin() {
        panelGeneracion.setVisible(false);
        panelLogin.setVisible(true);
        txtUsuario.setText("");
        txtClave.setText("");
    }
}
