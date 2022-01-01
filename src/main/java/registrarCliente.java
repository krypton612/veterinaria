/*
    parte de registrar terminado si ves esto ve a otro panel






*/
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseEvent;

import javax.print.attribute.standard.MediaSizeName;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order.Direction;

import org.w3c.dom.traversal.TreeWalker;

public class registrarCliente extends JFrame {
    JTextField Telefono, nombre_completo, CI;
    JTextArea direccion;
    Font tipoLetra = new Font("calibri", Font.PLAIN, 20);
    boolean valor = false;
    public registrarCliente() {
        setSize(370, 725);
        setLayout(null);
        setBackground(Color.WHITE);

        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void iniciarComponentes(){
        PonerJlabel();
    }

    public void PonerJlabel() {
        JLabel mensaje = new JLabel("Datos del propietario");

        mensaje.setLayout(null);
        
        mensaje.setBounds(0, 5, 400, 50);
        mensaje.setOpaque(false);
        mensaje.setBackground(Color.black);
        mensaje.setVerticalAlignment(SwingConstants.CENTER);
        mensaje.setHorizontalAlignment(SwingConstants.CENTER);
        mensaje.setFont(new Font("calibri", Font.BOLD, 15));
        add(mensaje);
        {
            JLabel mensaje2 = new JLabel();
            mensaje2.setLayout(null);
            mensaje2.setText("Nombre");
            mensaje2.setFont(new Font("calibri", Font.PLAIN, 11));
            mensaje2.setBounds(40, 70, 300, 20);

            nombre_completo = new JTextField();
            nombre_completo.setLayout(null);
            nombre_completo.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            nombre_completo.setBounds(40, 100, 300, 30);
            nombre_completo.setFont(new Font("calibri", Font.BOLD, 13));
            add(mensaje2);
            add(nombre_completo);
        }
        {
            JLabel mensaje3 = new JLabel();
            mensaje3.setLayout(null);
            mensaje3.setText("Telefono");
            mensaje3.setFont(new Font("calibri", Font.PLAIN, 11));
            mensaje3.setBounds(40, 150, 300, 20);

            Telefono = new JTextField();
            Telefono.setLayout(null);

            Telefono.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            Telefono.setBounds(40, 170, 300, 30);
            Telefono.setFont(new Font("calibri", Font.BOLD, 13));
            add(mensaje3);
            add(Telefono);
        }
        {
            JLabel mensaje4 = new JLabel();
            mensaje4.setLayout(null);
            mensaje4.setText("Cedula de identidad");
            mensaje4.setFont(new Font("calibri", Font.PLAIN, 11));
            mensaje4.setBounds(40, 220, 300, 20);

            CI = new JTextField();
            CI.setLayout(null);

            CI.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            CI.setBounds(40, 250, 300, 30);
            CI.setFont(new Font("calibri", Font.BOLD, 13));
            add(mensaje4);
            add(CI);
        }

        {
            JLabel mensaje5 = new JLabel();
            mensaje5.setLayout(null);
            mensaje5.setText("Direccion");
            mensaje5.setFont(new Font("calibri", Font.PLAIN, 11));
            mensaje5.setBounds(40, 300, 300, 20);


            direccion = new JTextArea();
            direccion.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            direccion.setLayout(null);
            direccion.setSize(300, 300);
            direccion.setBounds(40, 330, 300, 250);
            direccion.setFont(new Font("calibri", Font.BOLD, 13));

            add(mensaje5);
            add(direccion);
        }
        {
            JButton enviar = new JButton();

            enviar.setLayout(null);
            enviar.setOpaque(false);
            enviar.setSize(30, 100);
            enviar.setBounds(40, 630, 100, 40);
            enviar.setVisible(true);

            enviar.setOpaque(true);
            enviar.setText("enviar");
            enviar.setForeground(Color.WHITE);
            enviar.setBorderPainted(false);
            enviar.setFocusable(false);
            enviar.setVisible(true);
            enviar.setBackground(new Color(255, 128, 0));
            enviar.setFont(new Font("arial", Font.BOLD, 15));

            enviar.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    Conexion registrarConexion = new Conexion("veterinaria2");
                    Statement st;
                    ResultSet rs;

                    try {
                        st = registrarConexion.conectart().createStatement();
                        st.executeUpdate("INSERT INTO `propietario`(`nombre`, `cedula_identidad`, `direccion`, `telefono`) VALUES ('"+nombre_completo.getText()+"','"+CI.getText()+"','"+direccion.getText()+"','"+Telefono.getText()+"')");
                        JOptionPane.showMessageDialog(null, "Agregado satisfactoriamente");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al enviar "+e);
                    }

                    
                    setVisible(false);
                  
          
                }
                @Override
                public void mousePressed(MouseEvent me) {
                  
                }
                @Override
                public void mouseReleased(MouseEvent me) {
                  
                }
                @Override
                public void mouseEntered(MouseEvent me) {
          
                }
                @Override
                public void mouseExited(MouseEvent me) {
                 
                }
              });
            add(enviar);
        }
        {
            JButton ecerrar = new JButton();

            ecerrar.setLayout(null);
            ecerrar.setOpaque(false);
            ecerrar.setSize(30, 100);
            ecerrar.setBounds(190, 630, 100, 40);
            ecerrar.setVisible(true);

            ecerrar.setOpaque(true);
            ecerrar.setText("cerrar");
            ecerrar.setForeground(Color.WHITE);
            ecerrar.setBorderPainted(false);
            ecerrar.setFocusable(false);
            ecerrar.setVisible(true);
            ecerrar.setBackground(new Color(255, 128, 0));
            ecerrar.setFont(new Font("arial", Font.BOLD, 15));
            ecerrar.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    // parte de la base de datos
                    setVisible(false);
          
                }
                @Override
                public void mousePressed(MouseEvent me) {
                  
                }
                @Override
                public void mouseReleased(MouseEvent me) {
                  
                }
                @Override
                public void mouseEntered(MouseEvent me) {
          
                }
                @Override
                public void mouseExited(MouseEvent me) {
                 
                }
              
              });
            add(ecerrar);
            
        }
        
    }

}
