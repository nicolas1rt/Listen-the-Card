
/**
 * Clase Armario: Permite visualizar los artículos que el usuario ha comprado
 * Asigna el artículo que el usuario tendrá puesto en su avatar.
 * @author (CardenasJeisson & VargasLaura) 
 * @version (1.0.0)
 */
public class Armario
{
    private Articulo[] articulos_usuario;
    private Articulo mis_articulos[];//articulos que ha comprado el usuario
    private int n_articulos;//numero de articulos que tiene el usuario
    private int n_tienda;
    private Articulo articulos_tienda[];//articulos que tiene la tienda
    private Articulo mis_articulos_temp[];
    private Articulo articulos_puestos[];//articulos que tiene puesto el avatar
    
    /**
     * Constructor de la clase Armario.
     * @param tienda: Instancia de tienda para acceder a los artículos de la tienda.
     */
    public Armario(Tienda tienda){
        this.n_articulos=0;
        this.n_tienda=tienda.get_n_articulos_tienda();
        this.articulos_tienda=tienda.get_lista_tienda();
        this.mis_articulos=new Articulo[1];
        articulos_puestos=new Articulo[4];
    }

    /**
     * Método que añade un artículo al armario.
     * @param id_articulo: Para tener conocimiento de que artículo es que se quiere añadir al armario.
     */
    public void add_articulo_armario(int id_articulo){
        mis_articulos_temp=new Articulo[this.n_articulos+1];
        for(int i=0; i<this.n_articulos; i++){
            mis_articulos_temp[i]=mis_articulos[i];
        }
        mis_articulos_temp[this.n_articulos]=articulos_tienda[id_articulo];
        mis_articulos=new Articulo[this.n_articulos+1];
        mis_articulos=mis_articulos_temp;
        this.n_articulos++;
        System.out.println("El articulo ha sido agregado exitosamente");
    }

    /**
     * Método que cambia la ropa que tiene puesta el usuario.
     * @param id_articulo: Para tener conocimiento de que artículo es que se quiere poner el usuario..
     */
    public void poner_ropa(int id_art){
        boolean c=verificar_existencia(id_art);
        if(c==true){
            articulos_puestos[articulos_tienda[id_art].get_tipo()]=articulos_tienda[id_art];
        }  
        else{
            System.out.println("No tienes este articulo");
        }
    }

    /**
     * Método que muestra la ropa que tiene puesta el usuario.
     */
    public void mostrar_ropa(){
        System.out.println("\nRopa puesta:");
        for(int i=0;i<4;i++){
            if(articulos_puestos[i]!=null){
                System.out.println(articulos_puestos[i].getNombre());
            }
        }
    }

    /**
     * Método que quita la ropa que tiene puesta el usuario.
     * @param tipo_ropa: Para tener en cuenta que tipo de ropa se quiere quitar,
     * ya sea el sombrero/camisa/pantalón/zapatos.
     */
    public void quitar_ropa(int tipo_ropa){
        articulos_puestos[tipo_ropa]=null;
    }

    /**
     * Método que verifica que un usuario no se pueda poner una prenda que no tenga.
     * @param id_articulo: Para tener conocimiento de que artículo es que se quiere quitar el usuario.
     */
    public boolean verificar_existencia(int id_articulo){
        //Regresa False si el articulo no ha sido comprado, y True si sí.
        boolean c=false;
        for(int i=0; i<n_articulos; i++){
            if(articulos_tienda[id_articulo].get_id_articulo()==mis_articulos[i].get_id_articulo()){
                c=true;
                i=n_articulos;
            }
        }
        return c;
    }
    
    /**
     * Método que muestra la ropa que el usuario tiene en el armario.
     */
    public void recorrer_articulos(){
        for(int i=0; i<this.n_articulos; i++){
            System.out.println("Tienes "+mis_articulos[i].getNombre());        
        }
    }
    /**
     * Método que devuelve la ropa que el usuario tiene puesta.
     */
    public Articulo[] get_articulos_puestos(){
        return articulos_puestos;
    }
    /**
     * Método que devuelve los articulos que el usuario tiene en su armario.
     */
    public Articulo[] get_mis_articulos(){
        return mis_articulos;
    }
}
