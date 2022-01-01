
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    String base_datos = "pollo_panchita";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "pollo";
    String password = "12345678";
    String driver = "com.mysql.cj.jdbc.Driver";
     
    Connection cx;

    public Conexion (String bd){
        this.base_datos = bd;

    }
    public Connection conectart (){
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+base_datos, user, password);
            //System.out.println(" se conecto ");
        } catch (ClassNotFoundException |SQLException ex) {
            System.out.println("no se conecto" );
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);

        }
        return cx;
    }
    public void desconectar(){
        try {
            
            cx.close();
        } catch (Exception e) {
            System.err.println("No se pudo desconectar");
        }
    }
    /*public static void main(String[] args) {
      Pila id_pedido = new Pila();
      Pila cantidad = new Pila();
      Pila precio = new Pila();
      PilaC tipo_plato = new PilaC();
      
      
      Conexion mirar = new Conexion("pollo_panchita");
      Statement st;
      ResultSet rs;

      try {
          st = mirar.conectart().createStatement();
          rs = st.executeQuery("select * from pedido");

          while (rs.next()){
            //System.out.println(rs.getInt("id_pedido")+" "+ rs.getString("tipo_plato")+" "+ rs.getInt("cantidad")+" "+ rs.getInt("precio"));
            id_pedido.adicionar(rs.getInt("id_pedido"));
            tipo_plato.adicionar(rs.getString("tipo_plato"));
            cantidad.adicionar(rs.getInt("cantidad"));
            precio.adicionar(rs.getInt("precio"));
          }
          mirar.conectart().close();
          mirar.desconectar();
        
      } catch (Exception e) {
          //TODO: handle exception
      }

      System.out.println("los id");
      id_pedido.mostrar();
      System.out.println();
      System.out.println(" los platos");
      tipo_plato.mostrar();
      System.out.println();
      System.out.println("cantidad");
      cantidad.mostrar();
      System.out.println();
      System.out.println("precio");
      precio.mostrar();

    }*/
    

}
