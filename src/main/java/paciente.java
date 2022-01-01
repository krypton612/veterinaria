import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.nio.file.PathMatcher;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.print.attribute.standard.MediaSizeName;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.AttributeSet.ColorAttribute;

import com.mysql.cj.protocol.a.ValueEncoder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class paciente extends JPanel {
    JPanel pantext, pantoxt;
    Font tipoLetra = new Font("calibri", Font.PLAIN, 13);

    JDateChooser calendario;

    Statement st;
    ResultSet rs;

    JLabel mensaje, mensaje2, mensaje3, mensaje4, mensaje5;
    JTextField nombre, nombre2, nombre3, nombre4, nombre5; // persona
    JComboBox seleccion;

    JLabel mensajeP, mensaje2P, mensaje3P, mensaje4P, mensaje5P, mensaje6P; // ANIMAL
    JTextField nombreP, nombre2P, nombre4P, nombre6P; // persona
    JComboBox nombre3P, nombre5P;

    JTextField montoEntero; // DESCRIPCION

    public paciente() {
        setSize(925, 690); // Y X

        setLayout(null);
        setBackground(Color.WHITE);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        panelSeparador();
        PonerJlabel();
        panelSeparadorAbajo();
        pacienteDatos();

    }

    private void panelSeparador() {
        pantext = new JPanel();

        pantext.setSize(160, 925);
        pantext.setLayout(null);
        pantext.setOpaque(true);
        pantext.setBackground(Color.gray);
        pantext.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        pantext.setBounds(0, 0, 925, 160);

        add(pantext);
    }

    private void panelSeparadorAbajo() {
        pantoxt = new JPanel();

        pantoxt.setSize(530, 925);
        pantoxt.setLayout(null);
        pantoxt.setOpaque(true);
        pantoxt.setBackground(Color.white);
        pantoxt.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        pantoxt.setBackground(new Color(229, 190, 1));
        pantoxt.setBounds(0, 160, 925, 530);

        add(pantoxt);
    }

    private void PonerJlabel() { // panel separador
        {

            mensaje = new JLabel("Nombre");
            mensaje.setLayout(null);

            mensaje.setBounds(5, 5, 100, 30);

            mensaje.setFont(tipoLetra);

            mensaje2 = new JLabel("Codigo");
            mensaje2.setLayout(null);

            mensaje2.setBounds(155, 5, 100, 30);

            mensaje2.setFont(tipoLetra);

            mensaje3 = new JLabel("Telefono");
            mensaje3.setLayout(null);

            mensaje3.setBounds(305, 5, 100, 30);

            mensaje3.setFont(tipoLetra);

            mensaje4 = new JLabel("CI");
            mensaje4.setLayout(null);

            mensaje4.setBounds(455, 5, 100, 30);

            mensaje4.setFont(tipoLetra);

            mensaje5 = new JLabel("Direccion");
            mensaje5.setLayout(null);

            mensaje5.setBounds(605, 5, 100, 30);

            mensaje5.setFont(tipoLetra);

            pantext.add(mensaje);
            pantext.add(mensaje2);
            pantext.add(mensaje3);
            pantext.add(mensaje4);
            pantext.add(mensaje5);
        }
        {
            nombre = new JTextField();
            nombre.setLayout(null);
            nombre.setOpaque(true);
            nombre.setBounds(5, 35, 130, 30);
            nombre.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            nombre.setFont(tipoLetra);

            nombre2 = new JTextField();
            nombre2.setLayout(null);
            nombre2.setOpaque(true);
            nombre2.setBounds(155, 35, 130, 30);
            nombre2.setBorder(BorderFactory.createLineBorder(Color.black, 2));

            nombre2.setFont(tipoLetra);

            nombre3 = new JTextField();
            nombre3.setLayout(null);
            nombre3.setOpaque(true);
            nombre3.setBounds(305, 35, 130, 30);
            nombre3.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            nombre3.setFont(tipoLetra);

            nombre4 = new JTextField();
            nombre4.setLayout(null);
            nombre4.setOpaque(true);
            nombre4.setBounds(455, 35, 130, 30);
            nombre4.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            nombre4.setFont(tipoLetra);

            nombre5 = new JTextField();
            nombre5.setLayout(null);
            nombre5.setOpaque(true);
            nombre5.setBounds(605, 35, 130, 30);
            nombre5.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            nombre5.setFont(tipoLetra);

            Conexion registrarConexion = new Conexion("veterinaria2");

            seleccion = new JComboBox();
            seleccion.setLayout(null);
            seleccion.setOpaque(true);
            seleccion.setBounds(750, 35, 130, 30);
            seleccion.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            seleccion.setFont(tipoLetra);
            seleccion.addItem("Seleccionar");

            try {
                st = registrarConexion.conectart().createStatement();

                rs = st.executeQuery("select * from propietario");
                while (rs.next()) {
                    seleccion.addItem(rs.getString("nombre"));
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al enviar " + e);
            }
            // evento click
            seleccion.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent me) {
                    seleccion.removeAllItems();
                    seleccion.addItem("Seleccionar");
                    try {
                        st = registrarConexion.conectart().createStatement();

                        rs = st.executeQuery("select * from propietario");
                        while (rs.next()) {
                            seleccion.addItem(rs.getString("nombre"));
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error al enviar " + e);
                    }

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

            seleccion.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {

                    try {

                        String dato = (String) seleccion.getSelectedItem();

                        Conexion registrarCon = new Conexion("veterinaria2");
                        Statement st2;
                        ResultSet rs2;

                        st2 = registrarCon.conectart().createStatement();
                        rs2 = st2.executeQuery("select * from propietario where nombre=\"" + dato + "\"");

                        while (rs2.next()) {
                            nombre.setText(rs2.getString("nombre"));
                            nombre2.setText(rs2.getString("id_propietario"));
                            nombre3.setText(rs2.getString("telefono"));
                            nombre4.setText(rs2.getString("cedula_identidad"));
                            nombre5.setText(rs2.getString("direccion"));
                        }

                    } catch (Exception ex) {

                    }

                }
            });

            pantext.add(seleccion);
            pantext.add(nombre);
            pantext.add(nombre2);
            pantext.add(nombre3);
            pantext.add(nombre4);
            pantext.add(nombre5);

        }
        // datos animales
        {

            mensajeP = new JLabel("Nombre");
            mensajeP.setLayout(null);
            mensajeP.setBounds(5, 70, 100, 30);
            mensajeP.setFont(tipoLetra);

            mensaje2P = new JLabel("Codigo");
            mensaje2P.setLayout(null);
            mensaje2P.setBounds(155, 70, 100, 30);
            mensaje2P.setFont(tipoLetra);

            mensaje3P = new JLabel("Especie");
            mensaje3P.setLayout(null);
            mensaje3P.setBounds(305, 70, 100, 30);
            mensaje3P.setFont(tipoLetra);

            mensaje4P = new JLabel("Raza");
            mensaje4P.setLayout(null);
            mensaje4P.setBounds(425, 70, 100, 30);
            mensaje4P.setFont(tipoLetra);

            mensaje5P = new JLabel("Sexo");
            mensaje5P.setLayout(null);
            mensaje5P.setBounds(575, 70, 100, 30);
            mensaje5P.setFont(tipoLetra);

            mensaje6P = new JLabel("Color");
            mensaje6P.setLayout(null);
            mensaje6P.setBounds(665, 70, 100, 30);
            mensaje6P.setFont(tipoLetra);

            pantext.add(mensajeP);
            pantext.add(mensaje2P);
            pantext.add(mensaje3P);
            pantext.add(mensaje4P);
            pantext.add(mensaje5P);
            pantext.add(mensaje6P);
        }
        {
            nombreP = new JTextField();
            nombreP.setLayout(null);
            nombreP.setOpaque(true);
            nombreP.setBounds(5, 100, 130, 30);
            nombreP.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            nombreP.setFont(tipoLetra);

            nombre2P = new JTextField();
            nombre2P.setLayout(null);
            nombre2P.setOpaque(true);
            nombre2P.setBounds(155, 100, 130, 30);
            nombre2P.setBorder(BorderFactory.createLineBorder(Color.black, 2));

            nombre2P.setFont(tipoLetra);

            String[] especie = { "Canino", "Caprino", "Ovino", "Porcino" };

            nombre3P = new JComboBox(especie); // jcombobox
            // nombre3P.setLayout(null);
            // nombre3P.setOpaque(true);
            nombre3P.setBounds(305, 100, 80, 30);
            nombre3P.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            nombre3P.setBackground(Color.WHITE);
            nombre3P.setFont(tipoLetra);

            nombre4P = new JTextField();
            nombre4P.setLayout(null);
            nombre4P.setOpaque(true);
            nombre4P.setBounds(425, 100, 130, 30);
            nombre4P.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            nombre4P.setFont(tipoLetra);

            String[] raza = { "Macho", "Hembra" };
            nombre5P = new JComboBox(raza); // sexo jcombox
            // nombre5P.setLayout(null);
            // nombre5P.setOpaque(true);
            nombre5P.setBounds(575, 100, 80, 30);
            nombre5P.setBackground(Color.white);
            nombre5P.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            nombre5P.setFont(tipoLetra);

            nombre6P = new JTextField();
            nombre6P.setLayout(null);
            nombre6P.setOpaque(true);
            nombre6P.setBounds(665, 100, 130, 30);
            nombre6P.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            nombre6P.setFont(tipoLetra);

            pantext.add(nombreP);
            pantext.add(nombre2P);
            pantext.add(nombre3P);
            pantext.add(nombre4P);
            pantext.add(nombre5P);
            pantext.add(nombre6P);
        }

    }

    public void pacienteDatos() {
        {
            JLabel fecha = new JLabel();
            fecha.setText("Fecha");
            fecha.setLayout(null);

            fecha.setBounds(5, 10, 70, 30);
            fecha.setForeground(Color.BLACK);
            fecha.setFont(tipoLetra);

            calendario = new JDateChooser();
            // calendario.setLayout(null);
            calendario.setBounds(50, 10, 120, 30);
            calendario.setVisible(true);
            calendario.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            
            pantoxt.add(fecha);
            pantoxt.add(calendario);

            // calendario

            JLabel monto = new JLabel();
            monto.setText("Pago servicio");
            monto.setLayout(null);

            monto.setBounds(200, 10, 100, 30);
            monto.setForeground(Color.BLACK);
            monto.setFont(tipoLetra);

            montoEntero = new JTextField();
            montoEntero.setLayout(null);

            montoEntero.setBounds(300, 10, 120, 30);
            montoEntero.setForeground(Color.BLACK);
            montoEntero.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            montoEntero.setFont(tipoLetra);

            pantoxt.add(monto);
            pantoxt.add(montoEntero);

        }
        // agregando text areas
        {
            JLabel descripcion = new JLabel();
            descripcion.setLayout(null);
            descripcion.setText("Descripcion");
            descripcion.setFont(new Font("calibri", Font.PLAIN, 11));
            descripcion.setBounds(10, 70, 100, 20);

            JLabel enfermedad = new JLabel();
            enfermedad.setLayout(null);
            enfermedad.setText("Enfermedad");
            enfermedad.setFont(new Font("calibri", Font.PLAIN, 11));
            enfermedad.setBounds(300, 70, 100, 20);

            JLabel conclucion = new JLabel();
            conclucion.setLayout(null);
            conclucion.setText("Conclusion");
            conclucion.setFont(new Font("calibri", Font.PLAIN, 11));
            conclucion.setBounds(600, 70, 100, 20);

            JTextArea descripcionText = new JTextArea();
            descripcionText.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            descripcionText.setLayout(null);
            descripcionText.setSize(300, 300);
            descripcionText.setLineWrap(true);

            descripcionText.setBounds(10, 120, 270, 370);
            descripcionText.setFont(new Font("calibri", Font.BOLD, 13));

            descripcionText.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            descripcionText.setBackground(Color.WHITE);

            JTextArea enfermedadText = new JTextArea();
            enfermedadText.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            enfermedadText.setLayout(null);
            enfermedadText.setLineWrap(true);
            enfermedadText.setSize(300, 300);
            enfermedadText.setBounds(300, 120, 270, 370);
            enfermedadText.setFont(new Font("calibri", Font.BOLD, 13));

            enfermedadText.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            enfermedadText.setBackground(Color.WHITE);

            JTextArea conclucionText = new JTextArea();
            // conclucionText.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            conclucionText.setLayout(null);
            enfermedadText.setLineWrap(true);
            conclucionText.setSize(300, 300);
            conclucionText.setBounds(600, 120, 270, 370);

            conclucionText.setFont(new Font("calibri", Font.BOLD, 13));
            conclucionText.setBorder(BorderFactory.createLineBorder(Color.black, 2));
            conclucionText.setBackground(Color.WHITE);

            JButton enviar = new JButton();

            enviar.setLayout(null);
            enviar.setOpaque(false);
            enviar.setSize(30, 300);
            enviar.setBounds(550, 10, 300, 40);
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
                    // parte de la base de datos
                    if (mensaje4.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Porfavor seleccion un propietario");
                    } else {
                        try {

                            int ano = calendario.getCalendar().get(Calendar.YEAR);
                            int mes = calendario.getCalendar().get(Calendar.MARCH);
                            int dia = calendario.getCalendar().get(Calendar.DAY_OF_MONTH);

                            String fecha1 = (ano+"-"+mes+"-"+dia);


                            System.out.println("hola mundo");
                            int value=0, value2=0;
                            String dato = (String) seleccion.getSelectedItem();

                            Conexion registrarCon = new Conexion("veterinaria2");
                            Statement st2;
                            ResultSet rs2, rs3;
                            st2 = registrarCon.conectart().createStatement();
                            st2.executeUpdate("INSERT INTO `registrar`(`id_user`, `id_propietario`) VALUES ('1','"+Integer.parseInt(nombre2.getText())+"')");

                            rs2 = st2.executeQuery("SELECT id_registrar FROM registrar order by id_registrar DESC LIMIT 1");

                           
                            st2.executeUpdate("INSERT INTO `paciente`(`id_registrar`, `nombre`, `especie`, `raza`, `color`, `edad`, `sexo`) VALUES ('"+nombre2.getText()+"','"+nombreP.getText()+"','"+(String) nombre3P.getSelectedItem()+"','"+nombre4P.getText()+"','"+nombre6P.getText()+"','"+0+"','"+(String) nombre5P.getSelectedItem()+"')");
                            st2.executeUpdate("INSERT INTO `genera`(`id_paciente`, `estado`, `precio`, `fecha`) VALUES ('"+(value+1)+"','vivo', '"+montoEntero.getText()+"','"+fecha1+"')");
                            st2.executeUpdate("INSERT INTO `diagnostico`(`id_genera`, `descripcion`, `enfermedad`, `conclusion`, `conector`) VALUES ('"+(value+1)+"','"+descripcionText.getText()+"','"+enfermedadText.getText()+"','"+conclucionText.getText()+"','"+nombre2.getText()+"')");

                            JOptionPane.showMessageDialog(null, "Paciente Agregado sin problemas");


                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Error en "+ex);
                        }
                    }

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

            // pantoxt.setSize(530, 925);

            pantoxt.add(enviar);
            pantoxt.add(descripcion);
            pantoxt.add(enfermedad);
            pantoxt.add(conclucion);
            pantoxt.add(descripcionText);
            pantoxt.add(enfermedadText);
            pantoxt.add(conclucionText);

        }
    }

}