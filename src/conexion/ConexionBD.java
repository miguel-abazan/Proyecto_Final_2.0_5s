package conexion;
import java.sql.*;
import javax.swing.*;
public class ConexionBD {
   
    static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static String u;
    private static String c;
    private static Statement stm;
    private static boolean sts;
    
    public static Connection getConnection(){
       
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://LAPTOP-TUIEGDGS:1433;databaseName=PeliClubBD";
            con = DriverManager.getConnection(url,"Miguel","1234");
        } catch (ClassNotFoundException e) {
            
            JOptionPane.showMessageDialog(null, "No Se pudo Establecer la conexion" + e.getMessage(),"Error de Conexion",JOptionPane.ERROR_MESSAGE);
            
        } catch (SQLException e) {
        }
        return con;
    }
    
   public boolean ejecutarInstruccion(String sql){
        boolean res = false;
        try {
            stm = con.createStatement(); 
            stm.execute(sql); 
            res = true;  
        } catch (Exception ex) {
           //Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (Exception ex) {
             //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);    
            }
        }
        return res; 
    }
    public boolean ejecutarInstrucciones(String sql) {

        try {

            ps = con.prepareStatement(sql);

            //stm = con.createStatement();
            int r = ps.executeUpdate(sql);
            return r == 1 ? true : false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;

    }
    
    public static ResultSet ejecutarConsultaDeRegistros(String sql){
        ResultSet rs = null;
        try {
            ps= con.prepareStatement(sql);
            return ps.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return rs;
        }
    }
    public static ResultSet Consulta(String consulta){
        Connection con = getConnection();
        Statement declara;
        try{
            declara=con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(),
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    ///Login 
  public int Login(String user, String co){
      
      Integer rslt=0;
      try {
          Statement ejc = ConexionBD.con.createStatement();
          ResultSet res = ejc.executeQuery("SELECT * FROM Usuarios WHERE nom_Usuario='"+ user+ "' AND pass='"+co+"'");
          
          if(res.next()){
              JOptionPane.showMessageDialog(null, "Incgreso Correcto");
              rslt =1;
          }else{
              JOptionPane.showMessageDialog(null, "Error EN contraseña/ usuario");
              rslt =0;
          }
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Errero Consulta"+e.getMessage(),e.getMessage(), JOptionPane.ERROR_MESSAGE);
      }
      return rslt;
  }
    public void cerrarConexion(){
        try {
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
