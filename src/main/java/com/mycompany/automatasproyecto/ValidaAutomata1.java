/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.automatasproyecto;

/**
 *
 * @author saman
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidaAutomata1 {

    // Cuenta la cantidad de veces que un carácter aparece en un texto.
    public int CuentaCaracter(String texto, String caracter) {
        return texto.length() - texto.replace(caracter, "").length();
    }

    // Convierte una línea de texto en un array de strings.
    public String[] Obtener_array(String linea) {
        return linea.split(",");
    }

    // Verifica si un elemento está en un array.
    public boolean EstaenArreglo(String elemento, String[] arreglo) {
        for (String item : arreglo) {
            if (item.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    // Reemplaza todas las apariciones de un carácter en una cadena.
    public String Reemplaza(String cadena, String caracter) {
        return cadena.replace(caracter, "");
    }

    // Valida si una cadena es aceptada por el autómata.
    public boolean ValidaCadena(String cadena, String[][] AutomataVec, int lenSimbolos, int lenEstados) {
        // Implementa la lógica de validación aquí.
        return true;  // Esto es solo un valor de retorno predeterminado.
    }

    // Genera la representación del grafo para Graphviz.
    public String ArmaGrafoGv(String[][] AutomataVec, int lenSimbolos, int lenEstados, int Numero, boolean error, String grafotxt) {
        StringBuilder grafo = new StringBuilder("digraph G {\n");
        for (int i = 1; i <= lenEstados; i++) {
            for (int j = 1; j <= lenSimbolos; j++) {
                if (!AutomataVec[i][j].isEmpty()) {
                    grafo.append("    ").append(AutomataVec[i][0]).append(" -> ").append(AutomataVec[i][j]).append(" [label=\"").append(AutomataVec[0][j]).append("\"];\n");
                }
            }
        }
        grafo.append("}\n");
        return grafo.toString();
    }
}
