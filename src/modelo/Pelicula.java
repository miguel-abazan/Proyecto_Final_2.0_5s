
package modelo;


public class Pelicula {
    
	private int idPeli;
	private String nomPeli;
	private String categoria;
	private String clasific;
	private String nomDirPeli;
	private int precio;
	
	public Pelicula() {}

    public Pelicula(int idPeli,String nomPeli, String categoria, String clasific, String nomDirPeli, int precio) {
        this.idPeli = idPeli;
        this.nomPeli = nomPeli;
        this.categoria = categoria;
        this.clasific = clasific;
        this.nomDirPeli = nomDirPeli;
        this.precio = precio;
    }

    public int getIdPeli() {
        return idPeli;
    }

    public void setIdPeli(int idPeli) {
        this.idPeli = idPeli;
    }

   
    public String getNomPeli() {
        return nomPeli;
    }

    public void setNomPeli(String nomPeli) {
        this.nomPeli = nomPeli;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getClasific() {
        return clasific;
    }

    public void setClasific(String clasific) {
        this.clasific = clasific;
    }

    public String getNomDirPeli() {
        return nomDirPeli;
    }

    public void setNomDirPeli(String nomDirPeli) {
        this.nomDirPeli = nomDirPeli;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

}
