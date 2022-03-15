import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class splashscreen extends JFrame{
        JPanel fondo, cargando;
        JLabel fondo2, gift, gift2;
        public splashscreen(){
            setSize(720, 500);
            setLocationRelativeTo(null);
            this.getContentPane();
            setUndecorated(true);
            iniciarComponentes();

        }
        public void iniciarComponentes(){
            panels();
        }
        private void panels(){

            {
                fondo = new JPanel();
                fondo.setLayout(null);
                fondo.setBackground(Color.BLACK);
                this.getContentPane().add(fondo);
                fondo.add(imagen());
            
            }
            {
                fondo.add(gif());
                fondo.add(gif2());
            }
            
        }
        private JLabel imagen(){
            ImageIcon im = new ImageIcon("fondo2.jpg");
            fondo2 = new JLabel();
        
            fondo2.setSize(720, 400);
            fondo2.setIcon(new ImageIcon(im.getImage().getScaledInstance(720, 400, Image.SCALE_SMOOTH)));
        
            fondo2.setLayout(null);
            fondo2.setBounds(0, 0, 720, 400);

            return fondo2;
        }
        private JLabel gif(){
            
            gift = new JLabel();
            gift.setSize(100, 100);
            gift.setText("Cargando.........");
            gift.setForeground(Color.white);
            gift.setFont(new Font("Serif", Font.PLAIN, 17));
            gift.setLayout(null);
            gift.setBounds(50, 400, 100, 100);

            return gift;
        }
        private JLabel gif2(){
            
            Icon gifFile = new ImageIcon("cargando2.gif");
            gift2 = new JLabel();
            gift2.setSize(100, 350);
            gift2.setIcon(gifFile);
            gift2.setLayout(null);
            gift2.setBounds(170, 400, 350, 100);
            
            return gift2;
        }
}
