package Noticias;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelRecuperarPassword extends JPanel {
    
    private JLabel labelTitulo;
    private JLabel labelInstruccion;
    private JLabel labelUsuario;
    private JTextField fieldUsuario;
    private JButton correoRecuperacion;
    private JButton botonVolver;
    private JLabel labelMensaje; // Para mostrar éxito o error (opcional)

    public PanelRecuperarPassword(Pantalla mainFrame) {
        setLayout(null);
        setBackground(new Color(237, 242, 247));
        setSize(700, 600);

        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(null);
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setBounds(150, 100, 400, 350); 
        cardPanel.setBorder(new LineBorder(new Color(220, 220, 220), 1, true));
        add(cardPanel);

        // 3. Título
        labelTitulo = new JLabel("Recuperar Cuenta");
        labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        labelTitulo.setForeground(new Color(45, 55, 72));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setBounds(0, 30, 400, 40);
        cardPanel.add(labelTitulo);
        
        labelInstruccion = new JLabel("Introduce tu nombre de usuario");
        labelInstruccion.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        labelInstruccion.setForeground(new Color(160, 174, 192));
        labelInstruccion.setHorizontalAlignment(SwingConstants.CENTER);
        labelInstruccion.setBounds(0, 70, 400, 20);
        cardPanel.add(labelInstruccion);

        labelUsuario = new JLabel("Usuario");
        labelUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        labelUsuario.setForeground(new Color(100, 100, 100));
        labelUsuario.setBounds(50, 110, 300, 20);
        cardPanel.add(labelUsuario);

        fieldUsuario = new JTextField();
        fieldUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        fieldUsuario.setBounds(50, 135, 300, 35);
        fieldUsuario.setBorder(new LineBorder(new Color(200, 200, 200), 1));
        cardPanel.add(fieldUsuario);

        correoRecuperacion = new JButton("ENVIAR CORREO");
        correoRecuperacion.setBounds(50, 200, 300, 40);
        correoRecuperacion.setFont(new Font("Segoe UI", Font.BOLD, 14));
        correoRecuperacion.setBackground(new Color(66, 153, 225));
        correoRecuperacion.setForeground(Color.WHITE);
        correoRecuperacion.setFocusPainted(false);
        correoRecuperacion.setBorderPainted(false);
        correoRecuperacion.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        correoRecuperacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = fieldUsuario.getText();
                if(!nombre.isEmpty() && GestionUsuarios.existeUsuarios(nombre)) {
                    CorreoRecuperacion.enviar(nombre);
                    
                    labelMensaje.setText("Correo enviado a " + nombre);
                    labelMensaje.setForeground(new Color(72, 187, 120));
                    labelMensaje.setVisible(true);
                } else if(nombre.isEmpty()){
                    labelMensaje.setText("Por favor escribe un usuario");
                    labelMensaje.setForeground(new Color(229, 62, 62));
                    labelMensaje.setVisible(true);
                } else {
                	labelMensaje.setText("Usuario no encontado");
                    labelMensaje.setForeground(new Color(229, 62, 62));
                    labelMensaje.setVisible(true);
                }
            }
        });
        cardPanel.add(correoRecuperacion);
        
        labelMensaje = new JLabel("");
        labelMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        labelMensaje.setHorizontalAlignment(SwingConstants.CENTER);
        labelMensaje.setBounds(0, 175, 400, 20);
        labelMensaje.setVisible(false);
        cardPanel.add(labelMensaje);

        botonVolver = new JButton("Volver al Inicio de Sesión");
        botonVolver.setBounds(50, 260, 300, 30);
        botonVolver.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        botonVolver.setForeground(new Color(100, 100, 100));
        botonVolver.setContentAreaFilled(false);
        botonVolver.setBorderPainted(false);
        botonVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 mainFrame.mostrarInicioSesion(); 
            }
        });
        cardPanel.add(botonVolver);
    }
}
