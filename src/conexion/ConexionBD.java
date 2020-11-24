package conexion;
import java.sql.*;
import javax.swing.*;
public class ConexionBD {
    private String r;
    static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    public static Connection getConnection(){
        String url = "jdbc:sqlserver://LAPTOP-TUIEGDGS:1433;databaseName=PeliClubBD";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No Se pudo Establecer la conexion" + e.getMessage(),"Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        try {
            con = DriverManager.getConnection(url,"Miguel","1234");
        } catch (SQLException e) {
        }
        return con;
    }
    public boolean ejecutarInstruccion(String sql){
        try {
            ps = con.prepareStatement(sql);
            int r = ps.executeUpdate(sql);
            return r ==1 ? true : false;
        } catch (SQLException e) {
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
    public void cerrarConexion(){
        try {
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
