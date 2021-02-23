
/**
 * Clase Tienda: Encargada de los artículos que se encontrarán disponibles
 * en la tienda, además de validar la compra, teniendo en cuenta la cantidad
 * de monedas disponibles del usuario.
 * @author (CardenasJeisson & VargasLaura) 
 * @version (1.0.0)
 */
public class Tienda
{
    private Articulo[] lista_Articulo;
    private int n_articulos;
    private Articulo[] lista_temp;
    /**
     * Constructor de la clase Tienda.
     */
    public Tienda(){
        this.lista_Articulo=new Articulo[20];
        this.n_articulos=20;
        this.lista_Articulo[0]=new Articulo (0,"camisa",20, 1);
        this.lista_Articulo[1]=new Articulo (1,"pantalon",20, 2);
        this.lista_Articulo[2]=new Articulo (2,"Bandana",20, 0);
        this.lista_Articulo[3]=new Articulo (3,"Orejas de Gato",25, 0);
        this.lista_Articulo[4]=new Articulo (4,"Sombrero",30,0);
        this.lista_Articulo[5]=new Articulo (5,"Casco Bombero",35,0);
        this.lista_Articulo[6]=new Articulo (6,"Gorro Chef",40,0);
        this.lista_Articulo[7]=new Articulo (7,"Sombrero Piloto",45,0);
        this.lista_Articulo[8]=new Articulo (8,"Casco Astronauta",50,0);
        this.lista_Articulo[9]=new Articulo (9,"Corona",55,0);
        this.lista_Articulo[10]=new Articulo (10, "Camiseta1",10,1);
        this.lista_Articulo[11]=new Articulo (11,"Camiseta2",15,1);
        this.lista_Articulo[12]=new Articulo (12,"Camiseta3",20,1);
        this.lista_Articulo[13]=new Articulo (13, "Camiseta4",25,1);
        this.lista_Articulo[14]=new Articulo (14, "Camiseta5",30,1);
        this.lista_Articulo[15]=new Articulo (15, "Pantalón1",35,2);
        this.lista_Articulo[16]=new Articulo (16, "Pantalón2",40,2);
        this.lista_Articulo[17]=new Articulo (17, "Pantalón3",45,2);
        this.lista_Articulo[18]=new Articulo (18, "Pantalón4",50,2);
        this.lista_Articulo[19]=new Articulo (19, "Pantalón5",55,2);
    }

    /**
     * Método que añade un artículo a la tienda.     
     * @param nombre: Nombre del artículo.
     * @param precio: Precio del artículo.
     * @param tipo_articulo: Identificador del tipo de articulo
     *  para establecer un orden en las prendas:
     * 0. Para artículos que se pueden poner en la cabeza: Sombrero/Corona
     * 1. Para artículos que se pueden poner en el torso: Camisas/Sacos
     * 2. Para artículos que se pueden poner en las piernas: Pantalones/Bermudas
     * 3. Para artículos que se pueden poner en los pies: Zapatos/Botas.
     */
    public void add_articulo_tienda(String nombre, int precio, int tipo){
        this.lista_temp=new Articulo[n_articulos+1];
        for(int i =0; i<n_articulos; i++){
            this.lista_temp[i]=this.lista_Articulo[i];
        }
        lista_temp[n_articulos]=new Articulo(n_articulos, nombre, precio, tipo);
        this.lista_Articulo=new Articulo[n_articulos+1];
        this.lista_Articulo=lista_temp;
        this.n_articulos++;
    }

    /**
     * Método que devuelve el número de artículos en la tienda.
     */
    public int get_n_articulos_tienda(){
        return this.n_articulos;
    }

    /**
     * Método que recorre la tienda e imprime sus artículos.
     */
    public void recorrer_tienda(){
        for(int i =0; i<this.n_articulos; i++){
            System.out.println(lista_Articulo[i].getNombre()+" Precio:"+lista_Articulo[i].getPrecio());
        }
    }

    /**
     * Método que devuelve la lista de los artículos que se encuentran en la tienda.
     */
    public Articulo[] get_lista_tienda(){
        return lista_Articulo;
    }
}
