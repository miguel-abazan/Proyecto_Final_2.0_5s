/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import conexion.ConexionBD;
import java.sql.*;
import modelo.Pelicula;
public class ProcedimientosAlma extends Pelicula{
    
    public static void EntradaPelis(String nom,String cat,String cla,String dir,int pre)throws SQLException{
        CallableStatement agr =conexion.ConexionBD.getConnection().prepareCall("{CALL InsertarPelicula(?,?,?,?,?)}");
        agr.setString(1, nom);
        agr.setString(2, cat);
        agr.setString(3, cla);
        agr.setString(4, dir);
        agr.setInt(5, pre);
        agr.execute();
        
    }
    public static void EliminarPelis(int id)throws SQLException{
   
        CallableStatement del =conexion.ConexionBD.getConnection().prepareCall("{CALL EliminarPelicula(?)}");
        del.setInt(1,id );
        del.execute();
       
        
    }
    public static void BuscarPelicula(int a)throws SQLException{
        CallableStatement entrada = conexion.ConexionBD.getConnection().prepareCall("{call BuscarPelicula(?)}");
        entrada.setInt(1, a);
        entrada.execute();
    }
    
    public static void ModificarPelicula(int a,String nom,String cat,String cla,String dir,int pre)throws SQLException{
        CallableStatement mod = conexion.ConexionBD.getConnection().prepareCall("{call ActualizarPelicula(?,?,?,?,?,?)}");
        mod.setInt(0, a);
        mod.setString(1, nom);
        mod.setString(2, cat);
        mod.setString(3, cla);
        mod.setString(4, dir);
        mod.setInt(5, pre);
       
        mod.execute();
    }
    
    public static String ModificarDatos(int id,String nom, String catg, String clas, String dirpeli,int pre){
            Connection cnn; 
            String Modificar="{CALL ModificarDatos(?,?,?,?,?,?)}";
            String resultado;
        try{
           cnn=ConexionBD.getConnection();
           CallableStatement cmst= cnn.prepareCall(Modificar);
           cmst.setInt(1, id);
           cmst.setString(2,nom);
           cmst.setString(3,catg);
           cmst.setString(4,clas);
           cmst.setString(5, dirpeli);
           cmst.setInt(6, pre);
           cmst.registerOutParameter(7, java.sql.Types.VARCHAR,100);
           cmst.execute();
           resultado=cmst.getString(7);
           cnn.close();  
        }catch(SQLException sqlex){
           resultado="No se realizo la operacion" +sqlex.getMessage();
        }catch(Exception ex){System.out.println(ex.getMessage());
           resultado="No se realizo la operacion" +ex.getMessage();
        }return resultado;}
   
}
