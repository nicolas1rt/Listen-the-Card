/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideproyecto;

import java.awt.Image;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ideproyecto.LeccionesJF;
import java.sql.*;
import java.util.Date;
import ideproyecto.IngresarJF;


/**
 *
 * @author Nicolas Ramirez Ivan Muza
 */
public class PartidaJF extends javax.swing.JFrame {

    /**
     * Creates new form PartidaJF
     */
    ArrayList<ImageIcon> iconosCartas = new ArrayList<>();
    ArrayList<Integer> indices = new ArrayList<>();
    ArrayList<Integer> indicesDestapados = new ArrayList<>();
    int indiceAnterior = -1;
    JLabel jLabelAnterior = null;
    Tiempo tiempo;
    
    IDEProyecto conectar = new IDEProyecto();
    Connection cn = conectar.conector();
    

    
    public PartidaJF() {
        initComponents();
        if(LeccionesJF.nombreBoton==1){
            Vector < String > numeros = new Vector < String > ();
            numeros.add("numeros/0");
            numeros.add("numeros/1");
            numeros.add("numeros/2");
            numeros.add("numeros/3");
            numeros.add("numeros/4");
            numeros.add("numeros/5");
            numeros.add("numeros/6");
            numeros.add("numeros/7");
            numeros.add("numeros/8");
            numeros.add("numeros/9");
            Collections.shuffle(numeros);
            
            iconosCartas.add(resizeIcon(numeros.elementAt(0)));
            iconosCartas.add(resizeIcon(numeros.elementAt(1)));
            iconosCartas.add(resizeIcon(numeros.elementAt(2)));
            iconosCartas.add(resizeIcon(numeros.elementAt(3)));
            iconosCartas.add(resizeIcon(numeros.elementAt(4)));
            iconosCartas.add(resizeIcon(numeros.elementAt(5)));
        }
        else if(LeccionesJF.nombreBoton==2){
            Vector < String > animales = new Vector < String > ();
            animales.add("animales/Cat");
            animales.add("animales/Cow");
            animales.add("animales/Dog");
            animales.add("animales/Elephant");
            animales.add("animales/Fox");
            animales.add("animales/Monkey");
            animales.add("animales/Panda");
            animales.add("animales/Pig");
            animales.add("animales/Rabbit");
            animales.add("animales/Sheep");
            Collections.shuffle(animales);
            
            iconosCartas.add(resizeIcon(animales.elementAt(0)));
            iconosCartas.add(resizeIcon(animales.elementAt(1)));
            iconosCartas.add(resizeIcon(animales.elementAt(2)));
            iconosCartas.add(resizeIcon(animales.elementAt(3)));
            iconosCartas.add(resizeIcon(animales.elementAt(4)));
            iconosCartas.add(resizeIcon(animales.elementAt(5)));
        }
        else if(LeccionesJF.nombreBoton==3){
            Vector < String > colores = new Vector < String > ();
            colores.add("colores/Black");
            colores.add("colores/Blue");
            colores.add("colores/Gray");
            colores.add("colores/Green");
            colores.add("colores/Orange");
            colores.add("colores/Pink");
            colores.add("colores/Purple");
            colores.add("colores/Red");
            colores.add("colores/White");
            colores.add("colores/Yellow");
            Collections.shuffle(colores);
            
            iconosCartas.add(resizeIcon(colores.elementAt(0)));
            iconosCartas.add(resizeIcon(colores.elementAt(1)));
            iconosCartas.add(resizeIcon(colores.elementAt(2)));
            iconosCartas.add(resizeIcon(colores.elementAt(3)));
            iconosCartas.add(resizeIcon(colores.elementAt(4)));
            iconosCartas.add(resizeIcon(colores.elementAt(5)));
        }
        
      

        for (int i = 0; i < 12; i++) {
            indices.add(-1);
        }
        
       
      
        for (int i = 0; i < 6; i++) {
            
            llenarIndices(i);
            llenarIndices(i);
        }

        tiempo = new Tiempo(jLabel1, this);
        tiempo.Contar();
    }

    private void llenarIndices(int i) {
        boolean flag = true;
        do {
            int pos = (int) Math.floor(Math.random() * 12);
            if (indices.get(pos) == -1) {
                indices.set(pos, i);
                flag = false;
            }
        } while (flag);
    }

    private void cerrar() {
        LeccionesJF fra = new LeccionesJF();
        fra.setVisible(true);
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel1.setText("00:00");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 30, 49, 26);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/button.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/button.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/button.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/button.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/button.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/button.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/button.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/button.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/button.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/button.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/button.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/button.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel13))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel10)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)))
                .addGap(35, 35, 35))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 70, 229, 330);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/cancel.png"))); // NOI18N
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setFocusPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(180, 10, 62, 50);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones/Background_game 1.png"))); // NOI18N
        jLabel14.setText("jLabel14");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(0, 0, 270, 410);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        cerrar();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        destaparCarta(jLabel13, 11);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        destaparCarta(jLabel12, 10);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        destaparCarta(jLabel11, 9);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        destaparCarta(jLabel10, 8);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        destaparCarta(jLabel9, 7);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        destaparCarta(jLabel8, 6);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        destaparCarta(jLabel7, 5);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        destaparCarta(jLabel6, 4);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        destaparCarta(jLabel5, 3);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        destaparCarta(jLabel4, 2);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        destaparCarta(jLabel3, 1);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        destaparCarta(jLabel2, 0);
    }//GEN-LAST:event_jLabel2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PartidaJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PartidaJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PartidaJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PartidaJF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PartidaJF().setVisible(true);
            }
        });
    }

    private ImageIcon resizeIcon(String src) {
        ImageIcon icon = new ImageIcon("src/cartas/" + src + ".png");
        Image image = icon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(63, 64, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        icon = new ImageIcon(newimg);
        return icon;
    }
   

    private void destaparCarta(JLabel jLabel, int posCarta) {
        
        
        
        System.out.println(indices.get(posCarta));
        if (!indicesDestapados.contains(indices.get(posCarta))) {
            jLabel.setIcon(iconosCartas.get(indices.get(posCarta)));
            if (indiceAnterior >= 0) {
                if (indiceAnterior == indices.get(posCarta)) {
                    indicesDestapados.add(indiceAnterior);
                    jLabelAnterior = null;
                    indiceAnterior = -1;
                } else {
                    try {
                        repaint();
                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                jLabel.setIcon(new ImageIcon("src/botones/button.png"));
                                jLabelAnterior.setIcon(new ImageIcon("src/botones/button.png"));
                                jLabelAnterior = null;
                                indiceAnterior = -1;
                                repaint();
                            }
                        }, 500);

                    } catch (Exception ex) {
                        Logger.getLogger(PartidaJF.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else {
                indiceAnterior = indices.get(posCarta);
                jLabelAnterior = jLabel;
            }
        }
        if (indicesDestapados.size() == 6) {
            tiempo.Detener();
            int puntaje = 200 - tiempo.getSegundos();
            if (puntaje < 0) {
                puntaje = 0;
            }
            JPanel panel = new JPanel();
            panel.add(new JLabel("Tiempo transcurrido: " + jLabel1.getText()));
            panel.add(new JLabel("Puntaje total: " + puntaje));
            JOptionPane.showMessageDialog(this, panel);
            
            Date objDate = new Date();
            String puntos = Integer.toString(puntaje);
            try{
            PreparedStatement pst = cn.prepareStatement("INSERT INTO avance (tiempo, puntaje, fecha, fk_nino_N) VALUES (?,?,?,?)");

            pst.setString(1, jLabel1.getText());
            pst.setString(2, puntos);
            pst.setString(3, objDate.toString());
            pst.setString(4,IngresarJF.usuarioVerificado);
            pst.executeUpdate();

            
            }
            catch(Exception e){
                System.out.println(e);

            }
            cerrar();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
