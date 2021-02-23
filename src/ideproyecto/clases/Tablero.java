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
import java.util.*;
/**
 * Clase Tablero: Se crea el tablero (uan matriz de cartas) del tamaño y tema que indique
 * el jugador con cartas aleatorias del respectivo tema. Ordena aleatoriamente las cartas
 * con su respectiva pareja.
 * 
 * @author (CardenasJeisson & VargasLaura) 
 * @version (1.0.0)
 */
public class Tablero
{
    //Hola bebés que mas pues.
    private int ID_Tema;
    private int cantidad_Cartas;
    private int x;
    private int y;
    private int parejas[][];
    private Carta cartas_Seleccionadas[];
    private Carta cartas_Duplas[];
    private Carta cartas_leccion[];
    private Carta Tablero[][];

    /**
     * @param x: ancho del tablero (matriz de x*y)
     * @param y: largo del tablero (matriz de x*y)
     * @param ID_Tema: el identificador del tema que corresponde a la lección
     * (1 para leccion del tema animales, 2 para leccion de tema colores)
     */
    public Tablero(int x, int y, int ID_Tema)
    {
        //x,y = tamaño del tablero
        //ID_Tema se usa para poner las cartas del tema escogido 
        this.x=x;
        this.y=y;
        this.ID_Tema=ID_Tema;
        this.Tablero=generador_tablero();
        this.parejas=new int[(x*y)/2][5];
        //Parejas es un vector que guarda (id_carta, x1, y1, x2, y2)
        //donde (x1, y1) es la posicion del tablero en la que esta la primera carta con ese id,
        //y (x2, y2) es la posicion del tablero en la que esta la segunda carta con ese id (la pareja).
        this.parejas=generar_parejas();
        //este vector decidimos generarlo aqui para que en la partida no esté constantemente buscando parejas, si no que las revise en este vector.
    }

    /**
     * Método que devuelve el tablero: una matriz de tamaño [x][y]
     */
    public Carta[][] get_Tablero(){
        return Tablero;
    }

    /**Genera el tablero de juego: una matriz de tamaño [x][y]
     */
    public Carta[][] generador_tablero(){
        //Se crea una matriz de tamaño [x,y] para guardar las cartas
        Carta Tablero[][]= new Carta [x][y];
        this.cantidad_Cartas=(x*y)/2;
        ArrayList<Carta[]> lista = new ArrayList<Carta[]>();
        lista=crear_lista_Cartas();
        cartas_Seleccionadas=lista.get(0);
        cartas_Duplas=lista.get(1);
        //cartas_leccion es un vector en el que vamos a guaradar las cartas aleatoriamente
        cartas_leccion= new Carta[x*y];
        int rand_temp[]=new int[x*y];
        for(int i=0; i<(x*y); i++){
            int cond=1;

            while(cond>0){
                rand_temp[i]=random_number(x*y);
                cond=0;
                //este ciclo revisa que el randomico generado en esta iteracion no se haya generado antes:
                //si efectivamente se ha generado anteriormente se vuelve a generar.
                for(int j=0; j<i; j++){
                    if(rand_temp[i]==rand_temp[j]){
                        cond++;
                    }
                }
            }
            //aqui se acomodan las cartas en el vector
            if(rand_temp[i]>((x*y)/2)-1){
                cartas_leccion[i]=cartas_Duplas[(rand_temp[i]-(cantidad_Cartas))];
            }else{
                cartas_leccion[i]=cartas_Seleccionadas[rand_temp[i]];
            }
        }
        //ahora llenamos la matriz con el vector cartas_leccion
        int cont=0;
        for(int i=0; i<x; i++){
            for(int j=0; j<y;j++){
                Tablero[i][j]=cartas_leccion[cont];
                cont++;
            }
        }
        return Tablero;
    }

    /**
     * metodo que crea una lista de cartas que serviran para llenar el tablero
     */
    public ArrayList<Carta[]> crear_lista_Cartas(){
        //Creamos manualmente las cartas ya que en este momento no contamos con la base de datos que corresponde a 
        //los datos de las cartas del juego
        int rand_temp[]=new int[cantidad_Cartas];
        rand_temp[0]=random_number(10);//el numero aqui es 10 puesto que por el momento tenemos 10 labels para escoger las cartas
        cartas_Seleccionadas= new Carta[cantidad_Cartas];
        cartas_Duplas= new Carta[cantidad_Cartas];
        cartas_Seleccionadas[0]= new Carta(ID_Tema, rand_temp[0], 0);
        cartas_Duplas[0]= cartas_Seleccionadas[0];
        for(int i=1; i<cantidad_Cartas;i++){
            int cond=1;
            while(cond>0){
                rand_temp[i]=random_number(10);
                cond=0;
                for(int j=0; j<i; j++){
                    if(rand_temp[i]==rand_temp[j]){
                        cond++;
                    }
                }
            }
            cartas_Seleccionadas[i]= new Carta(ID_Tema, rand_temp[i], i);
            cartas_Duplas[i]= cartas_Seleccionadas[i];
        }
        ArrayList<Carta[]> list = new ArrayList<Carta[]>();
        list.add(cartas_Seleccionadas);
        list.add(cartas_Duplas);
        return list;
    }

    /**
     * metodo que guarda el id de una carta, ademas de las dos 
     * pocisiones del tablero en las que se encuentra dicha carta.
     * (Ubica las parejas para que en la clase Partida no tenga 
     * que realizarse la busqueda en muchas ocasiones)
     */
    public int[][] generar_parejas(){
        parejas=new int[(x*y)/2][5];
        int cont=0;
        for(int i=0; i<x; i++){
            for(int j=0; j<y;j++){
                //System.out.println("\n"+"i="+i+"j="+j);
                if(cont<=(x*y)){
                    for(int l=0; l<x; l++){
                        for(int m=0; m<y; m++){
                            if(Tablero[i][j].get_id()==Tablero[l][m].get_id()){
                                if(i==l && j==m){
                                }else{
                                    parejas[Tablero[i][j].get_id()][0]=Tablero[i][j].get_id();
                                    parejas[Tablero[i][j].get_id()][1]=i;
                                    parejas[Tablero[i][j].get_id()][2]=j;
                                    parejas[Tablero[i][j].get_id()][3]=l;
                                    parejas[Tablero[i][j].get_id()][4]=m;
                                    //System.out.print("\n"+parejas[Tablero[i][j].get_id()][0]+i+j+l+m);
                                    cont++;
                                    m=y;
                                    l=x;
                                }
                            }
                        }
                    }
                }else{
                    i=x;
                    j=y;
                }
            }
        }
        return parejas;
    }

    /**
     * Muestra el tablero de juego: recibe como parametro una 
     * matriz del mismo tamaño del tablero, si la matriz en una
     * cierta posicion es 0 la carta se debe mostrar boca abajo
     */
    public void mostrar_tablero(int[][] mostrar){
        //recibe como parametro una matriz del mismo tamaño del tablero
        //esta matriz indica con '1' las cartas que se encuentran boca arriba y por ende se deben poder ver
        for(int i=0; i<x; i++){
            System.out.print("\n");
            for(int j=0; j<y;j++){
                if(mostrar[i][j]==1){
                    System.out.print("\t"+Tablero[i][j].get_label()+"\t"+i+" "+j);
                }else{
                    System.out.print("\t"+"--?--"+"\t"+i+" "+j);
                }
            }
        }
    }

    /**
     * Muestra el tablero de juego: no recibe parametros, 
     * muestra todo el tablero con las cartas boca arriba.
     */
    public void mostrar_tablero(){
        for(int i=0; i<x; i++){
            System.out.print("\n");
            for(int j=0; j<y;j++){
                System.out.print("\t"+Tablero[i][j].get_label()+"\t"+i+" "+j);
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
     * Metodo que devuelve la ubicacion de las parejas en el tablero
     */
    public int[][] get_parejas(){
        return parejas;
    }
}
