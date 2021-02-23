/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideproyecto;

/**
 *
 * @author ivanm
 */
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tiempo {

    private Timer timer = new Timer();
    private int segundos = 0;
    private JLabel jLabel;
    private JFrame frame;

    public Tiempo(JLabel jLabel, JFrame frame) {
        this.jLabel = jLabel;
        this.frame = frame;
    }

    //Clase interna que funciona como contador
    class Contador extends TimerTask {

        public JLabel jLabel;
        public JFrame frame;

        public Contador(JLabel jLabel, JFrame frame) {
            this.jLabel = jLabel;
            this.frame = frame;
        }

        public void run() {
            segundos++;
            String strTiempo = segundos % 60 + "";
            if (strTiempo.length() < 2) {
                strTiempo = "0" + strTiempo;
            }
            strTiempo = segundos / 60 + ":" + strTiempo;
            if (strTiempo.length() < 5) {
                strTiempo = "0" + strTiempo;
            }
            jLabel.setText(strTiempo);
            frame.repaint();
        }
    }

    //Crea un timer, inicia segundos a 0 y comienza a contar
    public void Contar() {
        this.segundos = 0;
        timer = new Timer();
        timer.schedule(new Contador(jLabel, frame), 0, 1000);
    }

    //Detiene el contador
    public void Detener() {
        timer.cancel();
    }

    //Metodo que retorna los segundos transcurridos
    public int getSegundos() {
        return this.segundos;
    }
}
