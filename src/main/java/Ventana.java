
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



public class Ventana extends JFrame {
  public JPanel panel;
  private JButton salir, iniciar, mostrar, ocultar;
  private ActionListener one;
  private Color face = new Color(65,103,178);
  //public Color face = new Color(97,97,97);
  private Color login = new Color(84,124,188);
  private JLabel fondo;
  private Font tipoLetra = new  Font("calibri",Font.PLAIN,11);
  private int par=0;
  private String pass;
  private JTextField username;
  private JPasswordField password;
  private int medio = 802/2; 

  public Ventana() {
    
    setSize(802,633);
  
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
    //colocarBotonesExit("\u2715",780,1);
    //colocarBotonesExit("\u25A1",758,2);
    //colocarBotonesExit("\u2013", 736,3);
    colocarFormularios();
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

    fondo.setBounds(0, 0, 795, 620);


    panel.add(fondo);
  }

  private void colocarLabels(){

    // -----------------------------------
    JLabel esquinaIz = new JLabel();
    esquinaIz.setText("Iniciar Secion");
    esquinaIz.setBounds(12,2,100,30);
    esquinaIz.setOpaque(false);
    esquinaIz.setFont(tipoLetra);
    esquinaIz.setForeground(Color.WHITE);
    esquinaIz.setBackground(face);
    esquinaIz.setLayout(null);
    fondo.add(esquinaIz);
    // ------------------------------------
    //
    // ------------------------------------
    // icon
    ImageIcon imgToBuy = new ImageIcon("img.png");
    JLabel conTend = new JLabel();


    conTend.setIcon(new ImageIcon(imgToBuy.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
    conTend.setVerticalAlignment(SwingConstants.CENTER);

    conTend.setBounds(medio-60, 80, 120, 120); //Y, X
    fondo.add(conTend);

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
    iniciar.setText("iniciar");
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
            admin_panel.setResizable(false);
            


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
    JLabel registro = new JLabel("Crear cuenta");
    JLabel recuperar = new JLabel("recuperar");

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
