package Noticias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class PantallaCarga extends JWindow {
	JPanel panelPrincipal;
	JLabel titulo;
	JPanel panelInferior;
	static JLabel mensaje;
	static JProgressBar barraProgreso;
	
	private Image imagenFondo;
	
	public PantallaCarga() {
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        insertarFondo();
        
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panelPrincipal.setBackground(Color.WHITE);

        titulo = new JLabel("Noticias", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(new Color(50, 50, 50));
        panelPrincipal.add(titulo, BorderLayout.CENTER);

        panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout());
        panelInferior.setBackground(Color.WHITE);
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mensaje = new JLabel("Iniciando...");
        mensaje.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        barraProgreso = new JProgressBar(0, 100);
        barraProgreso.setStringPainted(true);
        barraProgreso.setForeground(new Color(0, 120, 215)); 

        panelInferior.add(mensaje, BorderLayout.NORTH);
        panelInferior.add(barraProgreso, BorderLayout.SOUTH);

        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
        
        add(panelPrincipal);
    }
    
    private void insertarFondo() {
    	try {
            imagenFondo = new ImageIcon(getClass().getResource("images/logo.png")).getImage();
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen: " + e.getMessage());
        }
        
        panelPrincipal = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imagenFondo != null) {
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
		
	}

	public static void actualizarProgreso(int valor, String mensajeActual) {
    	barraProgreso.setValue(valor);
        mensaje.setText(mensajeActual);
    }
}
