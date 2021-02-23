import java.util.*;
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
 * Clase Partida: En esta clase se simula el juego del usuario;
 * teniendo en cuenta los movimientos que realice en el juego se clasifican en:
 * errores, intentos y aciertos. Finalmente se calcula la recompensa.
 * 
 * @author (CardenasJeisson & VargasLaura) 
 * @version (1.0.0)
 */
public class Partida
{
    private int x;
    private int y;
    private int ID_Tema;
    private Tablero tablero;
    private int mostrar[][];
    private int mostradas[][];
    private int cont_mostradas;    
    private int i1;
    private int j1;
    private int i2;
    private int j2;
    private int parejas[][];
    private int id_partida;
    private Carta Tablero[][];
    private int intentos;
    private int aciertos;
    private int errores;
    private int recompensa;

    /**
     * Constructor for objects of class Partida
     */
    public Partida(int x, int y, int ID_Tema, Usuario usuario_1)
    {
        this.id_partida=usuario_1.get_partidas_jugadas();
        this.x=x;
        this.y=y;
        this.intentos=0;
        this.aciertos=0;
        this.errores=0; 
        System.out.println("\n=========================GENERANDO LA tablero=========================");
        System.out.println("\nHola "+usuario_1.getNick()+", Bienvenid@ a tu partida #"+id_partida+"\n"); 
        this.ID_Tema=ID_Tema;
        this.mostrar= new int[x][y];//las posiciones de tarjetas que estan boca arriba
        this.mostradas= new int[x*y][3];//guarda la lista de las coordenadas ya mostradas en turnos anteriores
        this.tablero= new Tablero(x,y,ID_Tema);
        this.parejas=new int[(x*y)/2][5];
        this.parejas=tablero.get_parejas();
        int condicion_ciclo=0;        
        this.cont_mostradas=0;
        while(condicion_ciclo==0){
            System.out.println("\n----------------------------EMPIEZA EL TURNO----------------------------");
            //definir aqui i y j
            this.tablero.mostrar_tablero(mostrar);
            System.out.println("\nPor favor escoge una carta para mover");
            //se estan generando posiciones al azar de las cartas con fines de comprobacion en el DEMO
            this.i1=random_number(x);
            this.j1=random_number(y);
            this.i2=random_number(x);
            this.j2=random_number(x);
            while(mostrar[i1][j1]==1){
                this.i1=random_number(x);
                this.j1=random_number(y);
            }
            //System.out.println("Escogiste la carta: "+i1+", "+j1);
            this.mostrar[this.i1][this.j1]=1;
            this.tablero.mostrar_tablero(mostrar);
            System.out.println("\nPor favor escoge otra carta para mover");
            while(mostrar[i2][j2]==1 || (i1==i2 && j1==j2)){
                this.i2=random_number(x);
                this.j2=random_number(y);
            }
            //System.out.println("Escogiste la carta: "+i2+", "+j2);
            guardar_mostradas(i1,j1);
            guardar_mostradas(i2,j2);
            this.mostrar[this.i2][this.j2]=1;
            this.tablero.mostrar_tablero(this.mostrar);
            Tablero=this.tablero.get_Tablero();
            evaluar_jugada();
            condicion_ciclo=1;
            for(int i=0; i<this.x;i++){
                for(int j=0; j<this.y;j++){
                    if(this.mostrar[i][j]==0){
                        //si la matriz mostrar en una posiscion es 0 quiere decir que la carta esta boca abajo
                        condicion_ciclo=0;
                    }
                }
            }
        }
        finalizar_partida(usuario_1);
    }
    
    public void finalizar_partida(Usuario usuario_1){
        System.out.println("\nHAS CULMINADO LA PARTIDA\nErrores:"+errores+" Aciertos:"+aciertos+" Intentos:"+intentos);
        usuario_1.incrementar_partidas();
        calcular_recompensa();
        usuario_1.sumar_saldo(this.recompensa);
        System.out.println("\nMonedas ganadas: "+recompensa);
    }

    /**
     * En este metodo calcula la recompensa segun el numero de intentos, aciertos y errores: la cantidad de monedas que 
     * se le van a dar al usuario.
     */
    public void calcular_recompensa(){
        this.recompensa=(int)Math.floor(((((aciertos*20)+(intentos*5))/(intentos+aciertos+errores))-(errores*2))*2);
        if(this.recompensa<10){
            this.recompensa=10;
        }
    }

    /**
     * En este metodo se devuelve la recompensa que gano el usuario
     */
    public int get_recompensa(){
        return recompensa;
    }

    /**
     * En este metodo se devuelve la recompensa que gano el usuario
     */
    public void incrementar_aciertos(){
        this.aciertos++;
    }

    /**
     * En este metodo se incrementa la cantidad de aciertos de la partida
     */
    public void incrementar_errores(){
        this.errores++;
    }

    /**
     * En este metodo se incrementa la cantidad de intentos de la partida
     * OJO: un intento no es un turno, es un turno en el que no hubo acierto ni erro.
     */
    public void incrementar_intentos(){
        this.intentos++;
    }

    /**
     * En este metodo se evalua si el turno fue un acierto, un intento o un error del jugador.
     * OJO: se consideran errores SOLO SI despues de levantar la primera carta de un turno 
     * el usuario no levanta su respectiva pareja, AUN CUANDO YA LA HABIA LEVANTADO EN UN TURNO
     * ANTERIOR, lo cual indicaria que el ya conocia la ubicacion de la pareja.
     * 
     */
    public String evaluar_jugada(){
        String status;
        if(Tablero[i1][j1].get_id()==Tablero[i2][j2].get_id()){
            System.out.println("\n\nFELICIDADES, HAS ACERTADO :D");
            status="acierto";
            incrementar_aciertos();
            return status;
        }else{
            this.mostrar[this.i1][this.j1]=0;
            this.mostrar[this.i2][this.j2]=0;
            if(this.parejas[Tablero[i1][j1].get_id()][1]==i1 && this.parejas[Tablero[i1][j1].get_id()][2]==j1){
                int condi=0;
                for(int z=0; z<cont_mostradas; z++){
                    if(this.parejas[Tablero[i1][j1].get_id()][3]==mostradas[z][1] && this.parejas[Tablero[i1][j1].get_id()][4]==mostradas[z][2]){
                        condi=1;
                    }
                }
                if(condi==1){
                    System.out.println("\n\n¡OH NO!FALLASTE ESTA, SIGUE INTENTANDO");
                    status="error";
                    incrementar_errores();
                    return status;
                }
                else{
                    System.out.println("\n\nVAMOS, SIGUE INTENTANDO");
                    status="intento";
                    incrementar_intentos();
                    return status;
                }
            }
            if(this.parejas[Tablero[i1][j1].get_id()][3]==i1 && this.parejas[Tablero[i1][j1].get_id()][4]==j1){
                int condi=0;
                for(int z=0; z<cont_mostradas; z++){
                    if(this.parejas[Tablero[i1][j1].get_id()][1]==mostradas[z][1] && this.parejas[Tablero[i1][j1].get_id()][2]==mostradas[z][2]){
                        condi=1;
                    }
                }
                if(condi==1){
                    System.out.println("\n\n¡OH NO!FALLASTE ESTA, SIGUE INTENTANDO");
                    status="error";
                    incrementar_errores();
                    return status;
                }
                else{
                    System.out.println("\n\nVAMOS, SIGUE INTENTANDO");
                    status="intento";
                    incrementar_intentos();
                    return status;
                }
            }else{
                System.out.println("\n\nVAMOS, SIGUE INTENTANDO");
                incrementar_intentos();
                status="intento";
                return status;
            }
        }
    }

    /**
     * metodo para generar numeros aleatorios hasta x-1
     */
    public int random_number(int x){
        int numero_Carta = (int) Math.floor(Math.random()*x);
        return numero_Carta;
    }

    /**
     * metodo para guarda las cartas que ya han sido mostradas al jugador
     * @param i, j: posicion en el tablero de la carta que el usuario ya vio
     */
    public void guardar_mostradas(int i, int j){
        int condicion2=0;
        for(int z=0; z<cont_mostradas; z++){
            if(i==mostradas[z][1] && j==mostradas[z][2]){
                condicion2=1;
            }
        }
        if(condicion2==0){
            mostradas[cont_mostradas][0]=cont_mostradas;
            mostradas[cont_mostradas][1]=i;
            mostradas[cont_mostradas][2]=j;
            cont_mostradas++;
        }
    }
}