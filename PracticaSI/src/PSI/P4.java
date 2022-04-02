/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PSI;


import java.util.ArrayList;

/**
 *
 * @author nicoo
 */
public class P4 {

    public static String decodificar(ArrayList<Caracter> solucion) {

        String lista = "[0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,1,0,1,1,0,1,0,0,1,0,1,1,1,1,0,0,1,1,0,0,0,0,0,0,0,0,1,0,1,1,0,0,0,0,0,0,0,0,1,0,1,1,1,0,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,1,0,1,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,1,0,1,1,0,1,0,1,0,1,0,1,0,0,0,0,0,0,1,0,1,1,0,1,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0,1,0,1,1,1,1,0,0,1,1,0,0,0,0,0,0,0,1,1,1,1,0,0,1,0,1,0,1,0,0,1,0,1,1,1,0,0,1,1,0,1,0,1,1,0,1,1,1,0,0,1,1,1,0,0,1,1,0,1,0,1,1,0,1,0,0,1,0,1,1,0,1,1,1,1,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,1,0,1,1,0,1,1,0,1,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,1,1,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,1,0,1,1,0,1,0,1,0,1,0,1,1,0,0,1,1,0,1,0,1,1,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,1,0,0,1,1,0,0,0,0,0,0,0,1,0,0,1,1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,0,0,1,1,0,0,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,1,0,0,1,1,0,1,0,1,1,0,1,1,0,0,1,1,0,1,0,0,1,1,0,0,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,1,0,1,0,0,1,1,0,1,0,0,1,1,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,1,0,1,1,1,1,0,0,1,1,0,0,0,0,0,0,0,1,1,1,1,0,0,1,0,1,0,1,0,0,1,0,1,1,1,0,0,1,1,0,1,1,0,0,1,1,0,0,0,0,0,0,1,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,0,0,1,1,0,0,0,0,0,0,0,1,0,1,1,0,1,0,1,0,1,0,1,0,0,1,0,1,1,0,0,1,0,1,1,0,0,0,0,0,0,0,0,1,0,1,1,0,0,0,0,0,0,1,0,0,1,1,0,0,1,1,1,1,0,1,0,0,1,1,0,0,1,0,1,0,1,1,1,0,0,1,1,0,0,1,0,1,1,0,1]";
        String listaFinal = limpiaDatos(lista);
        String mensaje="";

        int longitud = (int)  Math.ceil(Math.log(solucion.size())/ Math.log(2));
        
        for (int i = 0; i < listaFinal.length(); i += longitud) {
            int valor = binarioDecimal(listaFinal.substring(i, i + longitud));
            mensaje += solucion.get(valor).getCaracter();
            solucion.get(valor).setCodificacionBL(listaFinal.substring(i, i + longitud));
        }
        
        return mensaje;

    }

    public static String limpiaDatos(String lista) {
        int indiceMatriz = 6;
        String listaLimpia = "";
        String listaFinal = "";
        for (int i = 0; i < lista.length(); i++) {
            
            if (i % 2 != 0) {
                listaLimpia += lista.charAt(i);
            }
        }

        int cola = listaLimpia.length() % indiceMatriz;
        int contador = 0;
        for (int i = 0; i < listaLimpia.length() - cola; i += 3) {
            if (contador % 2 == 0) {
                listaFinal += listaLimpia.substring(i, i + 3);
            }
            contador++;
        }

        for (int i = listaLimpia.length() - cola; i < listaLimpia.length(); i++) {
            listaFinal += listaLimpia.charAt(i);
        }
        return listaFinal;
    }

    public static int binarioDecimal(String codificacion) {
        
        long numero, digito, decimal;
        int exponente;
        numero = Long.parseLong(codificacion); 

        //proceso para pasar de binario a decimal
        exponente = 0;
        decimal = 0; //será el equivalente en base decimal
        while (numero != 0) {
            //se toma la última cifra
            digito = numero % 10;
            //se multiplica por la potencia de 2 correspondiente y se suma al número                          
            decimal = decimal + digito * (int) Math.pow(2, exponente);
            //se aumenta el exponente
            exponente++;
            //se quita la última cifra para repetir el proceso
            numero = numero / 10;
        }
        return (int) decimal;
    }

}
