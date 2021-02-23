import java.util.*;
/**
 * Clase Usuario: Contiene los datos del usuario, así como su saldo, y tiene acceso a los artículos del armario.
 * @author (CardenasJeisson & VargasLaura) 
 * @version (1.0.0)
 */
public class Usuario
{
    private String nick;
    private String edad;
    private int saldo;
    private Armario armario;
    private int n_tienda;//tamaño tienda
    private int contador_partidas;
    private Articulo articulos_tienda[];

    /**
     * @param nick: Nombre del usuario.
     * @param edad: Edad del usuario.
     * @param mi_tienda: Instancia de la clase tienda para cada usuario.
     * seleccionado en el armario.
     */
    public Usuario(String nick, String edad, Tienda mi_tienda)
    {
        this.contador_partidas=1;
        this.nick=nick;
        this.edad=edad;
        this.saldo=100;
        this.armario=new Armario(mi_tienda);
        this.articulos_tienda=mi_tienda.get_lista_tienda();
        armario.add_articulo_armario(0);
        armario.add_articulo_armario(1);
        armario.poner_ropa(0);
        armario.poner_ropa(1);
    }

    /**
     * Método que devuelve el armario del usuario.
     */
    public Armario get_armario(){
        return armario;
    }

    /**
     * Método que valida la compra que el usuario está intentando realizar.
     * @param id_articulo: El identificador del artículo el cual se quiere comprar.
     */
    public void hacer_compra(int id_articulo){
        boolean c1=armario.verificar_existencia(id_articulo);
        if(c1==false && (saldo>=articulos_tienda[id_articulo].getPrecio())){
            armario.add_articulo_armario(id_articulo);
            restar_saldo(articulos_tienda[id_articulo].getPrecio());
        }else{
            if(c1==true){System.out.println("Ya tienes este articulo");}
            else{System.out.println("Saldo Insuficiente");}
        }
    }

    /**
     * Método que actualiza la tienda del usuario luego de realizar una actualización a la tienda.
     * @param mi_tienda: La tienda del usuario.
     */
    public void actualizar_tienda(Tienda mi_tienda){
        this.n_tienda=mi_tienda.get_n_articulos_tienda();
        this.articulos_tienda=mi_tienda.get_lista_tienda();
    }

    /**
     * Método que devuelve el nombre del usuario (Nick).
     */
    public String getNick(){
        return nick;
    }

    /**
     * Método que devuelve la edad del usuario.
     */
    public String getEdad(){
        return edad;
    }

    /**
     * Método que devuelve el saldo del usuario.
     */
    public int get_saldo(){
        return saldo;
    }

    /**
     * Método que suma el saldo del usuario teniendo en cuenta una recompensa por pasar una partida.
     * @param recompensa: Cantidad que se obtiene al pasar una partida.
     */
    public void sumar_saldo(int recompensa){
        saldo=saldo+recompensa;
    }

    /**
     * Método que resta el saldo del usuario teniendo en cuenta el gasto que genera al comprar un artículo en la tienda.
     * @param cantidad: Cantidad que se gasta el usuario en la tienda.
     */
    public void restar_saldo(int cantidad){
        saldo=saldo-cantidad;
    }

    /**
     * Método incrementa el número de partidas jugadas del usuario.
     */
    public void incrementar_partidas(){
        this.contador_partidas++;
    }

    /**
     * Método que devuelve el número de partidas jugadas del usuario.
     */
    public int get_partidas_jugadas(){
        return this.contador_partidas;
    }

}

