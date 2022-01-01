import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet.ColorAttribute;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseEvent;

import javax.print.attribute.standard.MediaSizeName;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class buscar extends JPanel {
    JPanel pant;
    Font tipoLetra = new Font("calibri", Font.PLAIN, 14);
    Font tipoLetra2 = new Font("calibri", Font.BOLD, 12);
    private String nom, dir, cel, id;

    public buscar() {
        setSize(925, 690); // Y X

        setLayout(null);
        setBackground(Color.BLACK);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        panelPoner();
        PonerJlabel();

    }

    private void panelPoner() {
        pant = new JPanel();
        pant.setSize(925, 690); // Y X
        pant.setLayout(null);
        pant.setBackground(Color.LIGHT_GRAY);
        pant.setBorder(BorderFactory.createLineBorder(Color.GRAY, 3, false));
        pant.setBounds(20, 90, 890, 580);
        add(pant);

    }

    private void PonerJlabel() {

        JLabel nombre = new JLabel(" Nombre: ");
        nombre.setLayout(null);
        nombre.setForeground(Color.RED);
        nombre.setBounds(10, 20, 200, 40);
        nombre.setFont(tipoLetra);

        JLabel telefono = new JLabel(" Numero de celular: ");
        telefono.setLayout(null);
        telefono.setForeground(Color.RED);
        telefono.setBounds(300, 20, 200, 40);
        telefono.setFont(tipoLetra);

        JLabel direccion = new JLabel(" Direccion: ");
        direccion.setLayout(null);
        direccion.setForeground(Color.RED);
        direccion.setBounds(550, 20, 200, 40);
        direccion.setFont(tipoLetra);
        ////////////////////////////////////////////////////////////
        JLabel nombre2 = new JLabel();
        nombre2.setLayout(null);
        nombre2.setForeground(Color.WHITE);
        nombre2.setBounds(80, 20, 200, 40);
        nombre2.setFont(tipoLetra2);

        JLabel telefono2 = new JLabel();
        telefono2.setLayout(null);
        telefono2.setForeground(Color.WHITE);
        telefono2.setBounds(440, 20, 200, 40);
        telefono2.setFont(tipoLetra2);

        JLabel direccion2 = new JLabel();
        direccion2.setLayout(null);
        direccion2.setForeground(Color.WHITE);
        direccion2.setBounds(630, 20, 200, 40);
        direccion2.setFont(tipoLetra2);

        pant.add(nombre);
        pant.add(telefono);
        pant.add(direccion);

        pant.add(nombre2);
        pant.add(telefono2);
        pant.add(direccion2);

        // /////////////////////////////////////////////////////////////
        JTextField busca = new JTextField();
        busca.setLayout(null);
        busca.setBorder(BorderFactory.createLineBorder(new Color(160, 151, 17), 1, false));
        busca.setBounds(350, 20, 200, 40);

        JLabel mensaje = new JLabel("Digite CI");
        mensaje.setLayout(null);
        mensaje.setForeground(Color.WHITE);
        mensaje.setBounds(250, 20, 200, 40);
        mensaje.setFont(tipoLetra);

        JButton enviar = new JButton();

        enviar.setLayout(null);
        enviar.setOpaque(false);
        enviar.setSize(30, 100);
        enviar.setBounds(580, 20, 100, 40);
        enviar.setVisible(true);

        enviar.setOpaque(true);
        enviar.setText("Buscar");
        enviar.setForeground(Color.WHITE);
        enviar.setBorderPainted(false);
        enviar.setFocusable(false);
        enviar.setVisible(true);
        enviar.setBackground(new Color(255, 128, 0));
        enviar.setFont(new Font("arial", Font.BOLD, 15));

        // select pro.nombre,pro.telefono,pro.direccion from propietario pro;

        enviar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                // select pro.nombre,pro.telefono,pro.direccion from propietario pro where
                // cedula_identidad=7897246;
                // parte de la base de datos
                if (busca.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Porfavor escriba en buscar");
                } else {
                    try {
                        Conexion registrarCon = new Conexion("veterinaria2");
                        Statement st2;
                        ResultSet rs2, rs3;
                        st2 = registrarCon.conectart().createStatement();
                        rs2 = st2.executeQuery(
                                "select pro.nombre,pro.telefono,pro.direccion,pro.id_propietario from propietario pro where cedula_identidad="+ busca.getText());

                        while (rs2.next()) {
                            id = rs2.getString("id_propietario");
                            nom = rs2.getString("nombre");
                            cel = rs2.getString("telefono");
                            dir = rs2.getString("direccion");
                        }

                        nombre2.setText(nom);
                        telefono2.setText(cel);
                        direccion2.setText(dir);

                        String[][] matriz = new String[40][40];

                        String id_almacen = "0";
                        String tipo_almacen = "0";
                        String cantidad_almacen = "0";
                        String precio_almacen = "0";

                        Conexion primera = new Conexion("veterinaria2");

                        PilaC contenedor = new PilaC();
                        PilaC id_pedido = new PilaC();
                        PilaC cantidad = new PilaC();
                        PilaC precio = new PilaC();
                        PilaC tipo_plato = new PilaC();


                        Statement stk;
                        ResultSet rsk;

                        try {
                            stk = primera.conectart().createStatement();
                            rsk = stk.executeQuery("select * from paciente where id_registrar="+id);

                            while (rsk.next()) {
                         
                                    id_pedido.adicionar(rsk.getString("nombre"));
                                    tipo_plato.adicionar(rsk.getString("especie"));
                                    cantidad.adicionar(rsk.getString("color"));
                                    precio.adicionar(rsk.getString("sexo"));
                            

                            }
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                        int tok = 0;
                        while (!id_pedido.esVacia()) {

                            id_almacen = id_pedido.eliminar();
                            tipo_almacen = tipo_plato.eliminar();
                            cantidad_almacen = cantidad.eliminar();
                            precio_almacen = precio.eliminar();

                            String[] matsuma = { id_almacen, tipo_almacen, cantidad_almacen, precio_almacen };

                            matriz[tok] = matsuma;
                            tok = tok + 1;

                        }

                        pant.revalidate();
                        pant.repaint();

                        DefaultTableModel model = new DefaultTableModel();

                        model.addColumn("nombre");
                        model.addColumn("especie");
                        model.addColumn("raza");
                        model.addColumn("sexo");

                        for (int i = 0; i < 20; i++) {
                            model.addRow(matriz[i]);
                        }

                        JTable dado = new JTable(model);
                        dado.setBounds(10, 200, 840, 640);
                        dado.setEnabled(false);

                        // panel_1_init.add(dado);

                        JScrollPane scroll = new JScrollPane(dado, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                        // scroll.setBounds(10, 10, 940, 640);
                        scroll.setBounds(10, 200, 840, 640);

                        pant.add(scroll);
                        pant.revalidate();
                        pant.repaint();

                    } catch (Exception e) {
                        // TODO: handle exception
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
        add(enviar);
        add(busca);
        add(mensaje);
    }
}