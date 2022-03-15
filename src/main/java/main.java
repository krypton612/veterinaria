import java.lang.Thread;

public class main {
  public static void main(String[] args) {
    
    try{
      splashscreen splash = new splashscreen();
      splash.setVisible(true);
      splash.setResizable(false);

      Thread.sleep(9000);

      splash.setVisible(false);


      Ventana v1 = new Ventana();
      v1.setTitle("Vetrinaria Los Amigos");
      v1.setVisible(true);
      v1.setResizable(false);
    }
    catch (Exception e){
      System.out.println(e);
    }

    
  }
}
