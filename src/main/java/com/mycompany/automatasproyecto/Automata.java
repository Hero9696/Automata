/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.automatasproyecto;

import java.awt.Image;
import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import static java.time.Clock.system;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mynor
 */
public class Automata extends javax.swing.JFrame {
JFileChooser seleccion = new JFileChooser();
//File archivo;
FileInputStream input;
FileOutputStream output;
Boolean EsNuevo = false;
String NombreCargo = "";
String NombreGuardo = "";
String[][] AutomataVec = new String[100][100];
Integer lenSimbolos = 0;
Integer lenEstados = 0;
Integer NumeroFilas = 0;
Integer NumeroColumnas = 0;
Integer Numero_archivos = 0;
DefaultTableModel modelo;
DefaultTableModel Transiciones;
DefaultTableModel cadenas;
Integer Numero=0;



    /**
     * Creates new form Inicio
     */
    public Automata() {
        initComponents();
        this.modelo = (DefaultTableModel) Tabla.getModel();   
        this.Transiciones = (DefaultTableModel) Tabla2.getModel();   
        this.cadenas = (DefaultTableModel) CadenasT.getModel();
        txt.setEnabled(false);
        Guardar.setEnabled(false);
        Probar.setEnabled(false);
        grafotxt.setEnabled(false);
        Procesar.setEnabled(false);
        
        Integer cont = 0;
        File png      = new File(System.getProperty("user.dir")+"\\src\\main\\java\\icons\\Grafox1.png");      
        while(png.exists())
        {
          png.delete();
          png = new File(System.getProperty("user.dir")+"\\src\\main\\java\\icons\\Grafox"+cont+".png");   
          cont += 1;          
        }        
        png      = new File(System.getProperty("user.dir")+"\\src\\main\\java\\icons\\Grafod1.png");      
        while(png.exists())
        {
          png.delete();
          png = new File(System.getProperty("user.dir")+"\\src\\main\\java\\icons\\Grafod"+cont+".png");   
          cont += 1;          
        }          
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        Nuevo = new javax.swing.JButton();
        Cargar = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Procesar = new javax.swing.JButton();
        Probar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        limpiar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tabla2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        grafotxt = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        CadenasT = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                CerrarVentana(evt);
            }
        });

        txt.setColumns(20);
        txt.setRows(5);
        jScrollPane1.setViewportView(txt);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Nombre Archivo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tabla.setSelectionBackground(new java.awt.Color(153, 255, 255));
        jScrollPane2.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setResizable(false);
            Tabla.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        Nuevo.setText("Nuevo Modelo");
        Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoActionPerformed(evt);
            }
        });

        Cargar.setText("Cargar Modelo");
        Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarActionPerformed(evt);
            }
        });

        Guardar.setText("Guardar Modelo");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        jLabel1.setText("Modelos Recientes");

        Procesar.setText("Procesar");
        Procesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcesarActionPerformed(evt);
            }
        });

        Probar.setText("Probar Autómata");
        Probar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProbarActionPerformed(evt);
            }
        });

        jLabel7.setText("Modelos");

        jLabel8.setText("Autómata");

        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Cargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(Procesar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Probar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Nuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Cargar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Procesar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Probar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(limpiar)
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(5, 5, 5))
        );

        Tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        Tabla2.setSelectionBackground(new java.awt.Color(153, 255, 255));
        jScrollPane4.setViewportView(Tabla2);

        jLabel2.setText("Símbolos");

        grafotxt.setColumns(20);
        grafotxt.setRows(5);
        jScrollPane3.setViewportView(grafotxt);

        jLabel3.setText("Área de texto");

        jLabel4.setText("Código en Graphviz del autómata");

        CadenasT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Cadena", "Es válida"
            }
        ));
        CadenasT.setSelectionBackground(new java.awt.Color(153, 255, 255));
        jScrollPane5.setViewportView(CadenasT);

        jLabel6.setText("Cadenas Analizadas");

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel3))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 26, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(352, 352, 352)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 17, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarActionPerformed
        // TODO add your handling code here:
        if(seleccion.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION)
        {
          File  archivo = seleccion.getSelectedFile();
            if (archivo.canRead())
            {
                if (archivo.getName().endsWith("txt"))
                {
                    txt.setText(Copiartexto(archivo));
                    EsNuevo = false;
                    NombreCargo = archivo.getName();
                    HabilitarCajas();
                    Numero_archivos += 1;
                    modelo.addRow(new Object[]{Numero_archivos, archivo.getName()});
                   // procesar();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Archivo no Compatible");
                }
            }
        }
    }//GEN-LAST:event_CargarActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        // TODO add your handling code here:
     Boolean HayError = true;
     String Mensaje = "";
     if (!txt.getText().isEmpty()) {    
         while (HayError)
         {
             HayError = false;
        if(seleccion.showDialog(null, "Guardar")==JFileChooser.APPROVE_OPTION)
        {
File            archivo=seleccion.getSelectedFile();
            NombreGuardo = archivo.getName();
            if (archivo.getName().endsWith("txt"))
               {
                   if (EsNuevo)
                   {
                      if (archivo.exists())
                      {
                          HayError = true;
                          Mensaje = "El Archivo ya existe";
                          JOptionPane.showMessageDialog(null, Mensaje);
                      }
                   }
                   else
                   {
                       if (archivo.exists() && !NombreGuardo.equals(NombreCargo))
                       {
                           HayError = ConfirmarReemplazo();
                       } 
                   }
                   if (!HayError){
                     Mensaje = GrabarTexto(archivo, txt.getText());
                     JOptionPane.showMessageDialog(null, Mensaje);
                   }
                   
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "El archivo debe tener extensión '.txt'");
                   HayError = true;
               }
            
        }              
         }
 
     }
     else
     {
        JOptionPane.showMessageDialog(null, "La Cadena esta vacia"); 
     }  
    }//GEN-LAST:event_GuardarActionPerformed

    private void NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoActionPerformed
        // TODO add your handling code here:
     Transiciones.setColumnCount(0);
     Transiciones.setRowCount(0);   
     cadenas.setRowCount(0);  
     jLabel9.setIcon(null);
     grafotxt.setText("");
     grafotxt.setEnabled(false);
     HabilitarCajas();
     EsNuevo = true;
     txt.setText("Simbolos: \n" +
                 "Estados:\n" +
                 "Estado inicial:\n" +
                 "Estados de aceptacion:\n" +
                 "Transiciones:\n" +
                 "Cadenas a Analizar:");
     Numero_archivos += 1;
     modelo.addRow(new Object[]{Numero_archivos, "Modelo.txt"});     
     jLabel9.setIcon(null);
     
    }//GEN-LAST:event_NuevoActionPerformed

    private void CerrarVentana(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_CerrarVentana
        // TODO add your handling code here:
         Object [] opciones ={"Aceptar","Cancelar"};
 int eleccion = JOptionPane.showOptionDialog(rootPane,"¿Desea cerrar la Aplicación? Su progreso puede ser Anulado","Mensaje de Confirmacion",
 JOptionPane.YES_NO_OPTION,
 JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
 if (eleccion == JOptionPane.YES_OPTION)
 {
 System.exit(0);
 }
 else
 {
     
 }
    }//GEN-LAST:event_CerrarVentana

    private void ProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcesarActionPerformed
       procesar();
    }//GEN-LAST:event_ProcesarActionPerformed

    private void ProbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProbarActionPerformed
        Prueba form2 = new Prueba();
        form2.parametros();
        form2.setVisible(true);
        
    }//GEN-LAST:event_ProbarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
limpiar("C:\\automata\\entradaGraphviz.txt");  
limpiar("C:\\automata\\salidaGraphviz.png"); 
jLabel9.setIcon(null);
txt.setText("");
grafotxt.setText("");
// TODO add your handling code here:
    }//GEN-LAST:event_limpiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
 guardarYMostrarImagenGraphviz();     // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Automata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Automata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Automata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Automata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Automata().setVisible(true);
            }
        });
    }
    
    public void limpiar(String rutaArchivo){
       File archivo = new File(rutaArchivo);
        
        // Verificar si el archivo existe
        if (archivo.exists()) {
            // Intentar eliminar el archivo
            if (archivo.delete()) {
                System.out.println("El archivo " + rutaArchivo + " fue eliminado exitosamente.");
                
            } else {
                System.out.println("No se pudo eliminar el archivo " + rutaArchivo);
                
            }
        } else {
            System.out.println("El archivo " + rutaArchivo + " no existe.");
            
        }
    }
    public String Copiartexto(File archivo) /* Introduce el texto a la ventana */ 
    {
        String Texto="";
        try
        {
           FileInputStream entrada = new FileInputStream(archivo);
           int ascii;
           while((ascii=entrada.read())!= -1)
           {
               char caracter = (char)ascii;
               Texto += caracter;
           } 
        }
        catch(Exception e)
        {
        }
        return Texto;
    }
    
        public String GrabarTexto(File archivo, String Texto) /* Graba Texto en Archivo */ 
    {
        String mensaje = "";
        
        if (EsNuevo == true)
        {
           try {
           if (archivo.createNewFile())
           { 
           }
               } catch (IOException ex) 
               {
               Logger.getLogger(Automata.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
        try
        {
           FileOutputStream salida = new FileOutputStream(archivo);
           byte[] Textobytes = Texto.getBytes();
           salida.write(Textobytes);
           mensaje = "Se ha Guardado el Archivo exitosamente";           
          
        }
        catch(Exception e)
        {
          mensaje = "";
        }
        return mensaje;
    }
public Boolean ConfirmarReemplazo()
{
    Boolean Confirmo = false;
 Object [] opciones ={"Aceptar","Cancelar"};
 int eleccion = JOptionPane.showOptionDialog(rootPane,"El Archivo ya existe, ¿Desea reemplazarlo?","Mensaje de Confirmacion",
 JOptionPane.YES_NO_OPTION,
 JOptionPane.QUESTION_MESSAGE,null,opciones,"Aceptar");
 if (eleccion == JOptionPane.YES_OPTION)
 {
    Confirmo = true;
 }  
    return !Confirmo;
}
public void HabilitarCajas()
{
    txt.setEnabled(true);
    Guardar.setEnabled(true);
    Procesar.setEnabled(true);
}

public void procesar() {
    //jLabel9.setIcon(null);
     ValidaAutomata1 metodos = new ValidaAutomata1();
    int cuenta_dospuntos = metodos.CuentaCaracter(txt.getText(), ":");
    int cuenta_comas = metodos.CuentaCaracter(txt.getText(), ",");
   
    Probar.setEnabled(false);
    grafotxt.setEnabled(false);

    Transiciones.setColumnCount(0);
    Transiciones.setRowCount(0);
    cadenas.setRowCount(0);

    if (cuenta_dospuntos == 6 && cuenta_comas > 0) {
        String[] lineas = txt.getText().split("\n");
        var lineasList = Arrays.stream(lineas)    .filter(linea -> !linea.isEmpty()) .collect(Collectors.toList());


        String[] Simbolos = metodos.Obtener_array(lineasList.get(0));
        String[] Estados = metodos.Obtener_array(lineasList.get(1));
        String[] Estados_inicial = metodos.Obtener_array(lineasList.get(2));
        String[] Estado_Aceptacion = metodos.Obtener_array(lineasList.get(3));

        try {
            for (int i = 0; i <= Estados.length; i++) {
                if (i != Estados.length) {
                    AutomataVec[i + 1][0] = Estados[i];
                    if (metodos.EstaenArreglo(Estados[i], Estado_Aceptacion)) {
                        AutomataVec[i + 1][0] = "*" + AutomataVec[i + 1][0];
                    }
                    if (metodos.EstaenArreglo(Estados[i], Estados_inicial)) {
                        AutomataVec[i + 1][0] = ">" + AutomataVec[i + 1][0];
                    }
                }
                for (int j = 0; j < Simbolos.length; j++) {
                    if (i == 0) {
                        AutomataVec[i][j + 1] = Simbolos[j];
                    } else {
                        String[] Transa = metodos.Obtener_array(lineasList.get(4 + i));
                        if (Transa.length != Simbolos.length) {
                            Transa = Arrays.copyOf(Transa, Simbolos.length);
                            Transa[Simbolos.length - 1] = "";
                        }
                        AutomataVec[i][j + 1] = Transa[j];
                    }
                }
            }

            Transiciones.addColumn("Estados");
            for (String simbolo : Simbolos) {
                Transiciones.addColumn(simbolo);
            }

            for (int i = 1; i <= Estados.length; i++) {
                String[] array = new String[Simbolos.length + 1];
                System.arraycopy(AutomataVec[i], 0, array, 0, Simbolos.length + 1);
                Transiciones.addRow(array);
            }

            /** Cadenas Válidas */
            for (int i = Estados.length + 6; i < lineasList.size(); i++) {
                String cadena = metodos.Reemplaza(lineasList.get(i), ",");
                cadena = metodos.Reemplaza(cadena, " ");
                Boolean EsValida = metodos.ValidaCadena(cadena, AutomataVec, Simbolos.length, Estados.length);
                cadenas.addRow(new Object[]{cadena, EsValida ? "Sí" : "No"});
            }

            Boolean error = false;
            grafotxt.setText(metodos.ArmaGrafoGv(AutomataVec, Simbolos.length, Estados.length, Numero, error, ""));

            if (!error) {/*
                lenSimbolos = Simbolos.length;
                lenEstados = Estados.length;
                ImageIcon imagen = new ImageIcon("C:\\automata\\salidaGraphviz.png");
                jLabel9.setIcon(imagen);*/
                guardarYMostrarImagenGraphviz();
                Numero += 1;
                Probar.setEnabled(true);
                grafotxt.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo cargar la imagen");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede procesar el autómata");
        }
    } else {
        JOptionPane.showMessageDialog(null, "No se puede procesar el autómata");
    }
}

private void guardarYMostrarImagenGraphviz() {
    String contenido = grafotxt.getText();
    String ubicacionArchivoEntrada = "C:\\automata\\entradaGraphviz.txt";
    String ubicacionArchivoSalida = "C:\\automata\\salidaGraphviz"+ System.currentTimeMillis() +".png";
    String ubicacionGraphviz = "C:\\Program Files\\Graphviz\\bin\\dot";

    try (PrintStream salida = new PrintStream(new File(ubicacionArchivoEntrada))) {
        salida.print(contenido);
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Error al guardar el archivo\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        String[] comandoString = {ubicacionGraphviz, "-Tpng", "-Gdpi=78", ubicacionArchivoEntrada, "-o", ubicacionArchivoSalida};
        Process ejecuta = Runtime.getRuntime().exec(comandoString);

        try (BufferedReader stdInput = new BufferedReader(new InputStreamReader(ejecuta.getInputStream()));
             BufferedReader stdError = new BufferedReader(new InputStreamReader(ejecuta.getErrorStream()))) {

            stdInput.lines().forEach(System.out::println);
            stdError.lines().forEach(System.out::println);
        }

        int exitCode = ejecuta.waitFor();
        if (exitCode == 0) {
            mostrarImagen(ubicacionArchivoSalida);
        } else {
            System.out.println("Error al generar la imagen. Código de salida: " + exitCode);
        }
    } catch (Exception o) {
        o.printStackTrace();
    }
}

private void mostrarImagen(String ubicacionArchivoSalida) {
    ImageIcon imagen = new ImageIcon(ubicacionArchivoSalida);
    

    JFrame frame = new JFrame("Imagen Generada");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(800, 600);
    JLabel label = new JLabel(imagen);
    frame.add(label);
    frame.setVisible(true);
}






    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CadenasT;
    private javax.swing.JButton Cargar;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Nuevo;
    private javax.swing.JButton Probar;
    public javax.swing.JButton Procesar;
    private javax.swing.JTable Tabla;
    private javax.swing.JTable Tabla2;
    public javax.swing.JTextArea grafotxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton limpiar;
    private javax.swing.JTextArea txt;
    // End of variables declaration//GEN-END:variables
}

