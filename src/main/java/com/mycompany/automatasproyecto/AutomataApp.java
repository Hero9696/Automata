package com.mycompany.automatasproyecto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

public class AutomataApp extends JFrame {
    private JTextArea txtAreaAutomata;
    private JLabel jLabelImage;
    private JButton btnProcesar, btnSiguiente;
    private List<String> transicionesDot;
    private int transicionActual;
    
    public AutomataApp() {
        setTitle("Visualizador de Autómatas");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Panel para ingresar el autómata
        JPanel panelInput = new JPanel();
        panelInput.setLayout(new BorderLayout());
        txtAreaAutomata = new JTextArea(10, 40);
        panelInput.add(new JScrollPane(txtAreaAutomata), BorderLayout.CENTER);
        
        // Panel para botones
        JPanel panelBotones = new JPanel();
        btnProcesar = new JButton("Procesar");
        btnSiguiente = new JButton("Siguiente");
        btnSiguiente.setEnabled(false);
        panelBotones.add(btnProcesar);
        panelBotones.add(btnSiguiente);
        
        // Panel para mostrar la imagen de Graphviz
        jLabelImage = new JLabel();
        JPanel panelImage = new JPanel();
        panelImage.setLayout(new BorderLayout());
        panelImage.add(jLabelImage, BorderLayout.CENTER);
        
        // Añadimos los paneles al JFrame
        add(panelInput, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(panelImage, BorderLayout.SOUTH);
        
        // Agregar acción al botón "Procesar"
        btnProcesar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesar();
            }
        });
        
        // Agregar acción al botón "Siguiente"
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarSiguienteTransicion();
            }
        });
    }
    
    private void procesar() {
    String automataTexto = txtAreaAutomata.getText();
    if (automataTexto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "El área de texto está vacía.");
        return;
    }

    ValidaAutomata1 metodos = new ValidaAutomata1();
    int cuenta_dospuntos = metodos.CuentaCaracter(automataTexto, ":");
    int cuenta_comas = metodos.CuentaCaracter(automataTexto, ",");

    transicionActual = 0;
    transicionesDot = new ArrayList<>(); // Reiniciamos la lista de transiciones

    if (cuenta_dospuntos == 6 && cuenta_comas > 0) {
        String[] lineas = automataTexto.split("\n");
        List<String> lineasList = Arrays.stream(lineas)
                                        .filter(linea -> !linea.isEmpty())
                                        .toList();

        // Obtener símbolos y estados del autómata
        String[] Simbolos = metodos.Obtener_array(lineasList.get(0));  // Ejemplo: a,b
        String[] Estados = metodos.Obtener_array(lineasList.get(1));   // Ejemplo: q0,q1,q2
        String[] Estados_inicial = metodos.Obtener_array(lineasList.get(2)); // Ejemplo: q0
        String[] Estado_Aceptacion = metodos.Obtener_array(lineasList.get(3)); // Ejemplo: q2

        // Crear matriz AutomataVec que almacena el autómata
        String[][] AutomataVec = new String[Estados.length + 1][Simbolos.length + 1];

        // Rellenar AutomataVec con estados y transiciones
        try {
            for (int i = 0; i <= Estados.length; i++) {
                if (i != Estados.length) {
                    AutomataVec[i + 1][0] = Estados[i];  // Asignar estado
                    if (metodos.EstaenArreglo(Estados[i], Estado_Aceptacion)) {
                        AutomataVec[i + 1][0] = "*" + AutomataVec[i + 1][0];  // Marcar estado de aceptación
                    }
                    if (metodos.EstaenArreglo(Estados[i], Estados_inicial)) {
                        AutomataVec[i + 1][0] = ">" + AutomataVec[i + 1][0];  // Marcar estado inicial
                    }
                }

                // Rellenar las transiciones de AutomataVec
                for (int j = 0; j < Simbolos.length; j++) {
                    if (i == 0) {
                        AutomataVec[i][j + 1] = Simbolos[j];  // Asignar símbolos
                    } else {
                        String[] Transa = metodos.Obtener_array(lineasList.get(4 + i));  // Obtener transiciones
                        if (Transa.length != Simbolos.length) {
                            Transa = Arrays.copyOf(Transa, Simbolos.length);  // Asegurarse que todas las columnas estén presentes
                            Transa[Simbolos.length - 1] = "";
                        }
                        AutomataVec[i][j + 1] = Transa[j];  // Asignar transición
                    }
                }
            }

            // Generar el archivo DOT para cada transición usando ArmaGrafoGv
            Boolean error = false;
            for (int i = 0; i < Estados.length; i++) {
                String dotTransicion = metodos.ArmaGrafoGv(AutomataVec, Simbolos.length, Estados.length, i, error, "");
                if (!error) {
                    transicionesDot.add(dotTransicion); // Guardamos la transición en formato DOT
                } else {
                    JOptionPane.showMessageDialog(null, "Error generando la transición: " + i);
                }
            }

            // Mostrar la primera transición
            if (!transicionesDot.isEmpty()) {
                guardarYMostrarImagenGraphviz(transicionesDot.get(transicionActual));
                btnSiguiente.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede procesar el autómata");
        }
    } else {
        JOptionPane.showMessageDialog(null, "El formato del autómata no es válido.");
    }
}


    private void mostrarSiguienteTransicion() {
        if (transicionActual < transicionesDot.size() - 1) {
            transicionActual++;
            guardarYMostrarImagenGraphviz(transicionesDot.get(transicionActual));
        } else {
            JOptionPane.showMessageDialog(null, "No hay más transiciones.");
        }
    }

    private void guardarYMostrarImagenGraphviz(String dot) {
        try {
            // Guardar el archivo DOT
            String filePath = "C:\\automata\\transicion.dot";
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(dot);
            writer.close();

            // Generar la imagen usando Graphviz
            Process process = Runtime.getRuntime().exec("dot -Tpng " + filePath + " -o C:\\automata\\salidaGraphviz.png");
            process.waitFor();

            // Mostrar la imagen en el JLabel
            ImageIcon imagen = new ImageIcon("C:\\automata\\salidaGraphviz.png");
            jLabelImage.setIcon(imagen);
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Error al generar o mostrar la imagen de Graphviz");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AutomataApp().setVisible(true);
            }
        });
    }
}
