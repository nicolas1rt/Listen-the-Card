import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Serializable;
/**
 * Clase Demo: Muestra la prueba de funcionamiento inicial de nuestro prototipo
 * 
 * @author (Alejandro Cardenas & Sofía Vargas) 
 * @version (a version number or a date)
 */
public class Demo
{
    private Usuario usuario_1;
    private Tablero tablero;
    private Partida partida1;
    private Tienda tienda_demo;
    private boolean val_compra;
    private Armario armario_us1;

    /**
     * Constructor for objects of class Demo
     */
    public Demo()
    {
        //=================Creación de la tienda=================
        tienda_demo= new Tienda();
        //Se añade un nuevo artículo a la tienda
        tienda_demo.add_articulo_tienda("jeans prueba", 20, 2);
        //Se crea el usuario
        usuario_1=new Usuario("MiniRolis", "7", tienda_demo);
        //Se añade un nuevo artículo a la tienda.
        tienda_demo.add_articulo_tienda("chaqueta prueba", 20, 3);
        //Se actualiza la tienda del usuario
        usuario_1.actualizar_tienda(tienda_demo);
        //Se comprueba que el usuario no vuelva a comprar un objeto que ya tiene
        usuario_1.hacer_compra(0);
        //El usuario se compra un nuevo artículo.
        usuario_1.hacer_compra(2);
        //Se muestra los accesorios que tiene puesto el avatar del usuario.
        usuario_1.get_armario().mostrar_ropa();

        System.out.println("====================================LISTEN THE CARD====================================");
        System.out.println("\nBienvenido "+ usuario_1.getNick());
        System.out.println("\nEscoge el tamaño del tablero: \nOprime 1 para jugar en un tablero 2x2 \nOprime 2 para jugar en un tablero 2x3");
        System.out.println("\n\nSuponemos que el ususario oprimio 2\n\n");
        System.out.println("\nEscoge el tema del tablero: \nOprime 1 para jugar en un tablero sobre  animales \nOprime 2 para jugar en un tablero sobre colores");
        System.out.println("\n\nSuponemos que el ususario oprimio 1\n\n");
        System.out.println("saldo actual: "+usuario_1.get_saldo());
        partida1=new Partida(2, 2, 1, usuario_1);
        System.out.println("saldo actual"+usuario_1.get_saldo());
        
        //usuario_1.sumar_saldo(partida1.get_recompensa());
        System.out.println("===================Tienda====================");
        System.out.println("\nSuponemos que el ususario quiere realizar una compra \n");
        usuario_1.hacer_compra(8);
        //Al realizarse correctamente la compra nos vamos al armario para revisar todos los
        //artículos que el usuario ha desbloqueado.
        System.out.println("===================Armario===================");
        usuario_1.get_armario().recorrer_articulos();
        System.out.println("\nSuponemos que el ususario quiere ponerse el nuevo artículo que acaba de comprar \n");
        usuario_1.get_armario().poner_ropa(8);
        //Ahora se muestra si se lo puso o no.
        usuario_1.get_armario().mostrar_ropa();
        //Con el siguiente código se confirma que no se puede poner artículos que no tiene.
        System.out.println("\nSuponemos que el ususario quiere ponerse un artículo que no posee.\n");
        usuario_1.get_armario().poner_ropa(15);
        System.out.println("\nSuponemos que el ususario quiere quitarse algún artículo (en este caso la camiseta) \n");
        usuario_1.get_armario().quitar_ropa(1);
        usuario_1.get_armario().mostrar_ropa();

        
    }
    /**
     * Método que corre el prototipo.
     */
    public static void main(String[] args)
    {
        new Demo();
    }   
}

