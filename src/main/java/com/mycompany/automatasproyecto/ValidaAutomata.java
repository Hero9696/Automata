/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.automatasproyecto;

import java.io.File;
import java.io.FileOutputStream;

/**
 *
 * @author mynor
 */
public class ValidaAutomata extends Automata {
    
     public String[] Obtener_array(String Cadena_texto) {
        String[] datos;
        Cadena_texto = Cadena_texto.replaceAll("\\s+", "");
        for (int i = 0; i < Cadena_texto.length(); i++) {
            if (Cadena_texto.charAt(i) == ':') {
                Cadena_texto = Cadena_texto.substring(i + 1, Cadena_texto.length());
                break;
            }
        }
        datos = Cadena_texto.split(",");
        return datos;
    }  
    
public Boolean EstaenArreglo(String busqueda, String[] Arreglo)
{
   Boolean esta = false;
   for(int i=0; i<Arreglo.length;i++)
   {
       if(Arreglo[i].equals(busqueda))
       {
           esta = true;
           break;
       }
   }
   return esta;   
}     
public  int CuentaCaracter(String busqueda, String caracter){
    int NumeroVeces = 0;
    for(int i=0 ; i<busqueda.length(); i++)
    {
        if (busqueda.substring(i, i+1).equals(caracter))
        {
            NumeroVeces += 1;
        }        
    }    
    return NumeroVeces;
}
public  String Reemplaza(String busqueda, String caracter){
    String  Resultado = "";
    for(int i=0 ; i<busqueda.length(); i++)
    {
        if (!busqueda.substring(i, i+1).equals(caracter))
        {
            Resultado += busqueda.substring(i, i+1);
        }        
    }    
    return Resultado;
}
public String ArmaGrafoGv(String[][]AutomataVec, int Simboloslen, int Estadoslen, Integer Numero, Boolean error, String EstadoPinta){
    Boolean Esdebug = true;
    String Resultado = "digraph MiAutomata {\n" +
"rankdir=LR;\n"+
"node [shape = circle];";
if(EstadoPinta.isEmpty())
{
    Esdebug = false;
}    
else
{
    EstadoPinta = Reemplaza(EstadoPinta, "*");
    EstadoPinta = Reemplaza(EstadoPinta, ">");
}
for(int i=1; i <= Estadoslen; i++)
{
    String temEstado = AutomataVec[i][0];
               temEstado = Reemplaza(temEstado, "*");
               temEstado = Reemplaza(temEstado, ">");     
    if (CuentaCaracter(AutomataVec[i][0], "*") != 0)
    {
        String linea = "\n"+AutomataVec[i][0]+"[shape = doublecircle];";
        linea = Reemplaza(linea, "*");
        linea = Reemplaza(linea, ">");    
        Resultado += linea;
    }
    if (CuentaCaracter(AutomataVec[i][0], ">") != 0)
    {
        String linea = "\n"+AutomataVec[i][0];      
        if (EstadoPinta.equals(temEstado))
        {
           linea += "[color=blue style = filled];";            
        }
        else
        {
           linea += "[color=orangered style = filled];";                 
        } 
        linea = Reemplaza(linea, "*");
        linea = Reemplaza(linea, ">");              
        Resultado += linea;
        
    }    
    if(EstadoPinta.equals(temEstado)&&CuentaCaracter(AutomataVec[i][0], ">")==0)
    {
        String linea = "\n"+AutomataVec[i][0]+"[color=blue style = filled];";
        linea = Reemplaza(linea, "*");
        linea = Reemplaza(linea, ">");    
        Resultado += linea;        
    }

    
}

for(int i=1; i<=Estadoslen; i++)
{
    for(int j=1; j<=Simboloslen; j++)
    {
        if (!AutomataVec[i][j].isEmpty())
        {
           String linea = "\n"+Reemplaza(AutomataVec[i][0], ">")+" -> "+AutomataVec[i][j]+" [ label = "+AutomataVec[0][j]+" ];";
           linea = Reemplaza(linea, "*");    
           Resultado += linea;
        }
    }
}

Resultado+= "\n}";

try{
      String Nombre = ""; 
      File archivo = null;
      if (!Esdebug)
      {
          archivo = new File("Grafox.txt");   
           Nombre = "Grafox";
      }
      else
      {
           archivo = new File("Grafod.txt");    
           Nombre = "Grafod";
      }
       
           if (archivo.createNewFile())
           { 
           }
           FileOutputStream salida = new FileOutputStream(archivo);
           byte[] Textobytes = Resultado.getBytes();
           salida.write(Textobytes);       
           generarimagen(Numero, Nombre);
}
catch(Exception e){
    error = true;
}
    return Resultado;
}
public void generarimagen(Integer Numero, String Nombre){
    try {

  
  Process ejecuta = Runtime.getRuntime().exec(new String[]{"C:/Program Files/Graphviz/bin/dot.exe","-Tpng" ,"-Gdpi=78" , System.getProperty("user.dir")+"\\"+Nombre+".txt ","-o" ,
          System.getProperty("user.dir")+"\\src\\main\\java\\icons\\"+Nombre+Numero.toString()+".png"});
  ejecuta.waitFor();
    } catch (Exception e) {
    } 
}

public Boolean ValidaCadena (String cadena, String[][] AutomataVec, Integer lenSimbolos, Integer lenEstados)
{
        Integer Inicio = -1;
        Boolean EsValida = true;     
        /*Indica posición donde Inicia*/
        for(int i=1; i<=lenEstados; i++)
        {
            if(AutomataVec[i][0].contains(">"))
            {
                Inicio = i;
                break;
            }
        }
        
        if (cadena.isEmpty())
        {
           if(AutomataVec[Inicio][0].contains("*"))
           {    
               EsValida = true;
           }
           else
           {
               EsValida = false;
           }
        }        
        else
        {
                int c = 0;
                while(EsValida)
                {
                    EsValida = false;
                    String lee = cadena.substring(c, c+1);
                    String Estado = "";
                    for(int i=1; i<=lenSimbolos; i++)
                    {
                        if(AutomataVec[0][i].equals(lee))
                        {
                            Estado = AutomataVec[Inicio][i];
                            if (!Estado.isEmpty())
                            {
                                for(int j=1; j<=lenEstados; j++)
                                {
                                    if(AutomataVec[j][0].contains(Estado))
                                    {
                                        Inicio = j;
                                        EsValida = true;
                                        break;
                                    }
                                }  
                                break;
                            }      
                            else
                            {
                                EsValida = false;
                            }
                        }
                    }                    
                    c += 1;
                    if (c == cadena.length()&&EsValida)
                    {
                        EsValida = false;
                        for(int i=1; i<=lenEstados; i++)
                        {
                            if(AutomataVec[i][0].contains(Estado)&&AutomataVec[i][0].contains("*"))
                            {
                                EsValida = true;
                                break;
                            }
                        }                        
                        break;
                    }
                }       
        }  
    return EsValida;
}
    
}
