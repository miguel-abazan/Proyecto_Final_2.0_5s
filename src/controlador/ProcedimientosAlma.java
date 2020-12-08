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
    public static void BuscarPelicula(String a)throws SQLException{
        CallableStatement entrada = conexion.ConexionBD.getConnection().prepareCall("{call BuscarPelicula(?)}");
        entrada.setString(1, a);
        entrada.execute();
    }
    
    public static void modPelis(Pelicula a) throws SQLException{
        
        CallableStatement mod = conexion.ConexionBD.getConnection().prepareCall("{CALL ModificarDatos(?,?,?,?,?,?,?)}");
        mod.setInt(1, a.getIdPeli());
        mod.setString(2, a.getNomPeli());
        mod.setString(3, a.getCategoria());
        mod.setString(4, a.getClasific());
        mod.setString(5, a.getNomDirPeli());
        mod.setInt(6, a.getPrecio());
        mod.registerOutParameter(7, java.sql.Types.VARCHAR, 100);
        mod.execute();
        
    }

}
