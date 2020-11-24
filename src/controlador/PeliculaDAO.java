
package controlador;
import conexion.ConexionBD;
import java.sql.*;
import modelo.Pelicula;

public class PeliculaDAO {
    
    static PreparedStatement pst;
    static ResultSet rs;
    public boolean modificarPelicula(Pelicula a) {
    			String sql = "UPDATE Peliculas SET nom_Pelicula='"+a.getNomPeli()+"', "
    					     + "Catg_Pelicula='"+a.getCategoria()
    					     +"',Clasificacion_Peli='"+a.getClasific()
    					     +"', Nom_Director_Peli= "+a.getNomDirPeli()
    					     +", Precio='"+a.getPrecio()
    					     +"' WHERE ID_Pelicula = '"+a.getIdPeli()+"'";
    			boolean res = new ConexionBD().ejecutarInstruccion(sql);
    			
    			return res; 
                        
    }         
                        
    public static String buscarFolio(String folio) {
	Connection con;
	String msj = null;
	try {
		con = ConexionBD.getConnection();
		String cons = "SELECT ID_Pelicula FROM Peliculas WHERE ID_Pelicula = ?";
		PreparedStatement pst= con.prepareStatement(cons);
		pst.setString(1, folio);
		ResultSet rs= pst.executeQuery();
		if(rs.next()) {
			msj = "Existe Folio";
			
		}else {
			msj= "No Existe Folio";
		}
		
	} catch (SQLException e) {
		// TODO: handle exception
	}
	return msj;
}
	
    }

