/**
 * Clase Articulo: Objetos que el usuario puede comprar y ponerse.
 * @author (CardenasJeisson & VargasLaura) 
 * @version (1.0.0)
 */
public class Articulo
{

    private int id_articulo;
    private String nombre;
    private int precio;
    private int tipo_articulo;

    /**
     * Constructor de la clase Articulo.
     * @param id_articulo: Identifica el objeto clase artículo.     
     * @param nombre: Nombre del artículo.
     * @param precio: Precio del artículo.
     * @param tipo_articulo: Identificador del tipo de articulo
     *  para establecer un orden en las prendas:
     * 0. Para artículos que se pueden poner en la cabeza: Sombrero/Corona
     * 1. Para artículos que se pueden poner en el torso: Camisas/Sacos
     * 2. Para artículos que se pueden poner en las piernas: Pantalones/Bermudas
     * 3. Para artículos que se pueden poner en los pies: Zapatos/Botas.
     */
    public Articulo(int id_articulo, String nombre, int precio, int tipo_articulo)
    {
        this.tipo_articulo=tipo_articulo;
        this.id_articulo=id_articulo;
        this.nombre=nombre;
        this.precio=precio;
    }

    /**
     * Método que devuelve el tipo de artículo.
     */
    public int get_tipo(){
        return tipo_articulo;
    }

    /**
     * Método que devuelve el precio del artículo.
     */
    public int  getPrecio(){
        return precio;
    }

    /**
     * Método que devuelve el identificador del artículo.
     */
    public int get_id_articulo(){
        return id_articulo;
    }

    /**
     * Método que devuelve el nombre del artículo.
     */
    public String  getNombre(){
        return nombre;
    }

    /*public void importarDatos(){

     * Método para importar las imágenes y datos de una base de datos.

    }*/
}

