import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener; 
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.text.AttributeSet.ColorAttribute;

import org.w3c.dom.events.Event;


public class Ventana2 extends JFrame {
  public JPanel panel, menu, panelBienvenida, CerrarSecion;
  private JButton salir, iniciar, mostrar, ocultar;
  private ActionListener one;
  private Color face = new Color(65,103,178);
  //public Color face = new Color(97,97,97);
  private Color login = new Color(84,124,188);
  private JLabel fondo, fondo2;
  private Font tipoLetra = new  Font("calibri",Font.PLAIN,11);
  private int par=0;
  private String pass;
  private JTextField username;
  private JPasswordField password;
  private int medio = 802/2; 

  public Ventana2() {
    
    setSize(1200,800); //y x
  
    setLocationRelativeTo(null);

    setMinimumSize(new DimensionUIResource(300, 300));
    this.getContentPane();
    iniciarComponentes();
    
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  private void iniciarComponentes() {
    colocarPaneles();
    fondoPantalla();
    colocarLabels();
    nuevosPaneles();
    iniciarLabel();
    //colocarBotonesExit("\u2715",780,1);
    //colocarBotonesExit("\u25A1",758,2);
    //colocarBotonesExit("\u2013", 736,3);
    //colocarFormularios();
    //registrarse();
  }

  private void colocarPaneles() {
    panel = new JPanel();
    
    panel.setLayout(null);
    panel.setBackground(face);
    
    this.getContentPane().add(panel);
  }

  private void fondoPantalla(){
    ImageIcon fondoPantalla = new ImageIcon("fondo.jpg");
    fondo = new JLabel();

    fondo.setSize(795, 620);
    fondo.setIcon(fondoPantalla);
    fondo.setVerticalAlignment(SwingConstants.CENTER);

    fondo.setBounds(0, 0, 1200, 800);


    panel.add(fondo);
  }

  private void colocarLabels(){
    ImageIcon imgToBuy = new ImageIcon("img.png");
    JLabel conTend = new JLabel();


    conTend.setIcon(new ImageIcon(imgToBuy.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
    conTend.setVerticalAlignment(SwingConstants.CENTER);

    conTend.setBounds(medio-60, 80, 120, 120); //Y, X
  

  }
  

  private void nuevosPaneles() {
    menu = new JPanel();
    menu.setSize(250, 690);
    //menu.setBounds(5, 5, 925, 195);
    menu.setBounds(5, 5, 250, 758);
    menu.setBackground(Color.white);
    menu.setLayout(null);
    menu.setBackground(new Color(255,128,0));

    panelBienvenida = new JPanel();

    CerrarSecion = new JPanel();
    CerrarSecion.setSize(925, 70);
    CerrarSecion.setBounds(260, 5, 925, 70);
    CerrarSecion.setBackground(Color.gray);
    CerrarSecion.setLayout(null);

    panelBienvenida.setSize(925, 690);
    panelBienvenida.setBounds(260, 75, 925, 690);
    panelBienvenida.setBackground(Color.black);
    panelBienvenida.setLayout(null);
    {
    ImageIcon fondoPantalla2 = new ImageIcon("res/logo2.png");
    fondo2 = new JLabel();

    fondo2.setSize(925, 690);
    fondo2.setIcon(new ImageIcon(fondoPantalla2.getImage().getScaledInstance(925, 690, Image.SCALE_SMOOTH)));
    fondo2.setVerticalAlignment(SwingConstants.CENTER);

    fondo2.setBounds(0, 0, 925, 690);
    panelBienvenida.add(fondo2);
    }

    fondo.add(menu);
    fondo.add(CerrarSecion);
    fondo.add(panelBienvenida);


  }
  private void cambiarPanel(JPanel panelActual){
    panelBienvenida.removeAll();
    panelBienvenida.add(panelActual);
    panelBienvenida.repaint();
    panelBienvenida.revalidate();
  }

    
    
  
  private void iniciarLabel(){
  
    JLabel nuevo = new JLabel();
    JLabel paciente = new JLabel();
    JLabel historia = new JLabel();
    JLabel logo2 = new JLabel();
    JLabel numero = new JLabel();
    JLabel logotipo = new JLabel();

    JLabel imagen = new JLabel();
    JLabel imagen2 = new JLabel();
    JLabel imagen3 = new JLabel();
    JLabel imagen5 = new JLabel();
    JLabel logo = new JLabel();


    String nuevo_propietario = new String("Nuevo Propietario");
    String nuevo_paciente = new String("Nuevo Paciente");
    String nueva_historia = new String("Nueva Busqueda");





    {
      ImageIcon imageUser = new ImageIcon("res/anadir.png");
    
      imagen.setIcon(new ImageIcon(imageUser.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
      imagen.setVerticalAlignment(SwingConstants.CENTER);
      imagen.setVisible(true);
      imagen.setBounds(5, 5, 40, 40);

      Font tipoLetra = new Font("calibri",Font.BOLD,15);

      nuevo.setText(nuevo_propietario);
      nuevo.setSize(250, 40);
      nuevo.setOpaque(true);
      nuevo.add(imagen);

      nuevo.setVerticalAlignment(SwingConstants.CENTER); // left not work // right not work
      nuevo.setHorizontalAlignment(SwingConstants.CENTER);
      nuevo.setBounds(0, 70, 250, 40);
      //dato.setLayout(null);
      nuevo.setBackground(new Color(255,128,0));
      nuevo.setForeground(Color.WHITE);
      nuevo.setFont(tipoLetra);
    }
    {
      ImageIcon imageUser2 = new ImageIcon("res/paciente.png");
    
      imagen2.setIcon(new ImageIcon(imageUser2.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
      imagen2.setVerticalAlignment(SwingConstants.CENTER);
      imagen2.setVisible(true);
      imagen2.setBounds(5, 5, 40, 40);

      Font tipoLetra = new Font("calibri",Font.BOLD,15);

      paciente.setText(nuevo_paciente);
      paciente.setSize(250,40);
      paciente.setOpaque(true);
      paciente.add(imagen2);

      paciente.setVerticalAlignment(SwingConstants.CENTER); // left not work // right not work
      paciente.setHorizontalAlignment(SwingConstants.CENTER);
      paciente.setBounds(0,110, 250, 40);
      //dato.setLayout(null);
      paciente.setForeground(Color.WHITE);
      paciente.setBackground(new Color(255,128,0));
      paciente.setFont(tipoLetra);
    }
    {
      ImageIcon imageUser3 = new ImageIcon("res/notas.png");
    
      imagen3.setIcon(new ImageIcon(imageUser3.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
      imagen3.setVerticalAlignment(SwingConstants.CENTER);
      imagen3.setVisible(true);
      imagen3.setBounds(5, 5, 40, 40);

      Font tipoLetra = new Font("calibri",Font.BOLD,15);

      historia.setText(nueva_historia);
      historia.setSize(250,40);
      historia.setOpaque(true);
      historia.add(imagen3);
      historia.setVerticalAlignment(SwingConstants.CENTER); // left not work // right not work
      historia.setHorizontalAlignment(SwingConstants.CENTER);
      historia.setBounds(0,150, 250, 40);
      //dato.setLayout(null);
      historia.setForeground(Color.white);
      historia.setBackground(new Color(255,128,0));
      historia.setFont(tipoLetra);
    }
    
    {
      ImageIcon imageUser4 = new ImageIcon("res/logo.png");
    
      logo.setIcon(new ImageIcon(imageUser4.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
      logo.setVerticalAlignment(SwingConstants.CENTER);
      logo.setVisible(true);
      logo.setBounds(90, 5, 70, 70);

      Font tipoLetra = new Font("calibri",Font.BOLD,15);

      logo2.setSize(250,40);
      logo2.setOpaque(true);
      logo2.add(logo);
      logo2.setVerticalAlignment(SwingConstants.CENTER); // left not work // right not work
      logo2.setHorizontalAlignment(SwingConstants.CENTER);
      logo2.setBounds(0,550, 250, 90);
      //dato.setLayout(null);
      logo2.setForeground(Color.white);
      logo2.setBackground(new Color(255,128,0));
      logo2.setFont(tipoLetra);
    }
    // datos del desarrollador
    {

      Font tipoLetra = new Font("calibri",Font.BOLD,15);

      numero.setText("Numero +591 72707504");
      numero.setSize(250,40);
      numero.setOpaque(true);
      numero.setVerticalAlignment(SwingConstants.CENTER); // left not work // right not work
      numero.setHorizontalAlignment(SwingConstants.CENTER);
      numero.setBounds(0,660, 250, 40);
      //dato.setLayout(null);
      numero.setForeground(Color.white);
      numero.setBackground(new Color(255,128,0));
      numero.setFont(tipoLetra);
    }

    {

      Font tipoLetra = new Font("calibri",Font.BOLD,15);

      logotipo.setText("VETERINARIA");
      logotipo.setSize(250,70);
      logotipo.setOpaque(true);
      logotipo.setVerticalAlignment(SwingConstants.CENTER); // left not work // right not work
      logotipo.setHorizontalAlignment(SwingConstants.CENTER);
      logotipo.setBounds(0,0, 250, 70);
      //dato.setLayout(null);
      logotipo.setForeground(Color.white);
      logotipo.setBackground(new Color(255,128,0));
      logotipo.setFont(tipoLetra);
    }

    nuevo.setBorder(BorderFactory.createLineBorder(new Color(10,10,10), 1, false));
    paciente.setBorder(BorderFactory.createLineBorder(new Color(10,10,10), 1, false));
    logotipo.setBorder(BorderFactory.createLineBorder(new Color(93,193,185), 2, false));
    historia.setBorder(BorderFactory.createLineBorder(new Color(10,10,10), 1, false));


    nuevo.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent me) {

        nuevo.setOpaque(true);
        nuevo.revalidate();
        nuevo.repaint();
        nuevo.setBackground(new Color(242, 151, 11));

        registrarCliente nuevo2 = new registrarCliente();
        nuevo2.setLocationRelativeTo(null);
        nuevo2.setResizable(false);
        nuevo2.setUndecorated(true);
        nuevo2.setVisible(true);

        

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
       
        nuevo.setOpaque(false);
        nuevo.revalidate();
        nuevo.repaint();

      }
    });

    paciente.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent me) {

        paciente.setOpaque(true);
        paciente.revalidate();
        paciente.repaint();
        paciente.setBackground(new Color(242, 151, 11));

        paciente regis = new paciente();
          cambiarPanel(regis);

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
       
        paciente.setOpaque(false);
        paciente.revalidate();
        paciente.repaint();
      }
    });

    historia.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent me) {

        historia.setOpaque(true);
        historia.revalidate();
        historia.repaint();
        historia.setBackground(new Color(242, 151, 11));

        buscar pan = new buscar();
          cambiarPanel(pan);

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
       
        historia.setOpaque(false);
        historia.revalidate();
        historia.repaint();
      }
    });

    menu.add(nuevo);  
    menu.add(paciente);
    menu.add(historia);
    menu.add(logo2);
    menu.add(numero);
    menu.add(logotipo);

  }
































  private void colocarFormularios() {
    //char contra[] = new char[30];
    username = new JTextField("Email");
    password = new JPasswordField("Password");
    iniciar = new JButton();
    mostrar = new JButton();
    ocultar = new JButton();
    String comp = "Password";
    String contra_admin = "admin";

    username.setForeground(new Color(170,170,170));
    password.setForeground(new Color(170,170,170));
    password.setEchoChar((char)0);

    // ----------------------------------
    // usuario
    ImageIcon imageUser = new ImageIcon("src/user.png");
    JLabel userIcon = new JLabel(imageUser);

 
    userIcon.setIcon(new ImageIcon(imageUser.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
    userIcon.setVerticalAlignment(SwingConstants.CENTER);
    userIcon.setVisible(true);
    
    //userIcon.setLocation(new Point(medio+150,210));
    userIcon.setBounds(medio+145, 210, 40, 35);
    // ----------------------------------
    // password
    // ---------------------------------
    //
    ImageIcon imagePass = new ImageIcon("src/mostrar.png");
    ImageIcon imageShow = new  ImageIcon("src/ocultar.png");
    //mostrar.setBorder(new RoundedBorder(40));
    mostrar.setIcon(new ImageIcon(imagePass.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
    mostrar.setVerticalAlignment(SwingConstants.CENTER);
    mostrar.setVisible(true);
    mostrar.setBackground(new Color(255,128,0));
    mostrar.setFocusable(false);
    mostrar.setBorderPainted(false);
    mostrar.setBounds(medio+148, 250, 35, 35);
    mostrar.setLayout(null);
    mostrar.setOpaque(true);
    //contra = password.getPassword();
    pass = "";
    for (int i = 0; i < password.getPassword().length; i++) {
      pass += password.getPassword()[i];
    }
    
    MouseListener transp = new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent me) {
      }
      @Override
      public void mousePressed(MouseEvent me) {
      
      }
      @Override
      public void mouseReleased(MouseEvent me) {
        
      }
      @Override

      public void mouseEntered(MouseEvent me) {
          mostrar.setIcon(new ImageIcon(imageShow.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
          password.setEchoChar((char)0);
          mostrar.setEnabled(false);
      }
      @Override
      public void mouseExited(MouseEvent me) {
        pass = "";
        for (int i = 0; i < password.getPassword().length; i++) {
          pass += password.getPassword()[i];
        }
        if (pass.equals(comp)) {
          mostrar.setIcon(new ImageIcon(imagePass.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
          password.setEchoChar((char)0);
          return;
        }
        else {
          mostrar.setIcon(new ImageIcon(imagePass.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
          password.setEchoChar('•');
          mostrar.setEnabled(true);
        }
      }
    };
    mostrar.addMouseListener(transp);
    username.setFocusable(false);
    password.setFocusable(false);
    MouseListener Jtexts = new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent me) {

        pass = "";
        for (int i = 0; i < password.getPassword().length; i++) {
          pass += password.getPassword()[i];
        }

        if (username.getText().equals("Email")) {
          username.setText("");
          username.setForeground(Color.black);
        } else if (pass.equals(comp)){
          password.setText("");
          password.setForeground(Color.black);
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
        pass = "";
        for (int i = 0; i < password.getPassword().length; i++) {
          pass += password.getPassword()[i];
        }

        if (username.getText().equals("Email")) {
          username.setFocusable(true);
        }
        if (pass.equals(comp)){
          password.setFocusable(true);
        }
      }
      @Override
      public void mouseExited(MouseEvent me) {
      
      }
    };

    // ---------------------------------
    username.addMouseListener(Jtexts);
    password.addMouseListener(Jtexts);

    username.setHorizontalAlignment(SwingConstants.CENTER);
    username.add(userIcon);
    password.setHorizontalAlignment(SwingConstants.CENTER);
    
    iniciar.setOpaque(true);
    iniciar.setText("Log In");
    iniciar.setForeground(Color.WHITE);
    iniciar.setBorderPainted(false);
    iniciar.setFocusable(false);
    iniciar.setVisible(true);
    

    iniciar.setBackground(new Color(255,128,0));
    iniciar.setFont(new Font("arial",Font.BOLD,15));
    //iniciar.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    
    username.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 2, false));
    password.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 2, false));
    iniciar.setBorder(BorderFactory.createLineBorder(new Color(255,128,0), 2, false));
    
    username.setBounds(medio-150, 210, 300, 35);
    password.setBounds(medio-150, 250, 300, 35);
    iniciar.setBounds(medio-150, 310, 300, 35);
    

    // Luego del inicio de sesion
    ActionListener empieza = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        /*if (username.getText() == "admin") {
          JOptionPane.showMessageDialog(null, "Admin correcto");
        }
        else {
          JOptionPane.showMessageDialog(null, "Admin incorrecto");
        }*/
        pass = "";

        for (int i = 0; i < password.getPassword().length; i++) {
          pass += password.getPassword()[i];
        }

        if (username.getText().equals("admin")) {

          if (pass.equals(contra_admin)) {

            setVisible(false);
            Ventana2 admin_panel = new Ventana2();
            admin_panel.setVisible(true);
            admin_panel.setTitle("Panel de Administracion");
            admin_panel.setResizable(true);
            


          }
          else {
            JOptionPane.showMessageDialog(null, "Su contraseña o usuario es incorrecot\nVuelva a intentarlo");
          }
        }
        else {
          JOptionPane.showMessageDialog(null, "Su contraseña o usuario es incorrecot\nVuelva a intentarlo");
        }
      
      }
    };


    KeyListener eventoTecla = new KeyListener() {
      @Override
      public void keyTyped(KeyEvent ke) {
        
      }
      @Override
      public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
          password.requestFocus();
          return;
        }
        else {
          if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
            password.requestFocus();
            return;
          }
        }
      }
      @Override
      public void keyReleased(KeyEvent ke) {
        
      }
    };

    KeyListener eventoTecla2 = new KeyListener() {
      @Override
      public void keyTyped(KeyEvent ke) {
        
      }
      @Override
      public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
          iniciar.doClick();
          return;
        }
        if (ke.getKeyCode() == KeyEvent.VK_UP) {
          username.requestFocus();
          return;
        }
        
      }
      @Override
      public void keyReleased(KeyEvent ke) {

      }
    };

    username.addKeyListener(eventoTecla);
    password.addKeyListener(eventoTecla2);

    iniciar.addActionListener(empieza);

    fondo.add(username);
    fondo.add(password);
    fondo.add(iniciar);
    fondo.add(userIcon);
    fondo.add(mostrar);
  }
  public void registrarse() {
    JLabel registro = new JLabel("Sing Up for FreeSale");
    JLabel recuperar = new JLabel("Forgot Password");

    // --------------------------
    registro.setLayout(null);
    registro.setFocusable(false);
    //registro.setOpaque(true);
  
    registro.setFont(new Font("arial",Font.PLAIN,20));
    
    // --------------------------
    
    recuperar.setLayout(null);
    recuperar.setFocusable(false);
   
    
    recuperar.setFont(new Font("arial",Font.PLAIN,20));
  
    

    registro.setForeground(Color.WHITE);
    recuperar.setForeground(Color.WHITE);

    registro.setBounds(medio-90, 460, 180, 20);
    recuperar.setBounds(medio-70,520,140,20);

    MouseListener primerClick = new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent me) {

        registro.setOpaque(true);
        registro.revalidate();
        registro.repaint();
        registro.setBackground(new Color(255,128,0));
       
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
       
        registro.setOpaque(false);
        registro.revalidate();
        registro.repaint();

      }
    };
    registro.addMouseListener(primerClick);
    fondo.add(registro);
    fondo.add(recuperar);
   }
}
