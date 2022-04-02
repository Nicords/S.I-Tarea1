/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PSI;

import static PSI.Principal.probabilidad;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 *
 * @author nicoo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        //String caracteres= "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZáéíóúÁÉÍÓÚ.,;:-_()'+*ü ";
        Scanner lector = new Scanner(System.in);
        
        System.out.println("Elegir modo, 1= lista de probabilidades, 2= lista de frecuencias, 3= texto");
        int opcion = lector.nextInt();
        
        ArrayList solucion = new ArrayList<>();
        String codificacionHuffman="";
        String codifcicacionBL="";

        switch(opcion){
            
            case 1 -> {
                ArrayList probabilidades = new ArrayList<Float>();
                
                probabilidades = Ficheros.leerFicheroProbabilidades("C:\\Users\\nicoo\\Desktop\\Universidad\\3º carrera\\Seguridad informática\\P2\\probabilidad.txt", probabilidades);
                
                for (int i = 0; i<probabilidades.size();i++){
                    BigDecimal pro = new BigDecimal("probabilidades.get(i)");
                    solucion.add(new Caracter((char)(i+65), (int) ((float) probabilidades.get(i) *100),pro , codificacionHuffman, codifcicacionBL )); 
                }
                
                Huffman.metodoHuffman(solucion);
                resultados(solucion);
            }
                
            case 2 -> {
                ArrayList frecuencias = new ArrayList<Integer>();
                
                frecuencias = Ficheros.leerFicheroFrecuencias("C:\\Users\\nicoo\\Desktop\\Universidad\\3º carrera\\Seguridad informática\\P2\\frecuencia.txt", frecuencias);
                
                int longitud = 0;
                for (int i = 0; i<frecuencias.size();i++){
                    longitud += (int) frecuencias.get(i);
                }
                
                for (int i = 0; i<frecuencias.size();i++){
                    BigDecimal probabilidad = probabilidad((int) frecuencias.get(i), longitud);
                    solucion.add(new Caracter((char)(i+65),(int) frecuencias.get(i), probabilidad, codificacionHuffman, codifcicacionBL )); 
                }
                
                Huffman.metodoHuffman(solucion);
                resultados(solucion);
            }
                
            case 3 -> {
                String texto = Ficheros.leerFichero("C:\\Users\\nicoo\\Desktop\\Universidad\\3º carrera\\Seguridad informática\\P2\\texto.txt");
                String caracteres="";
                int var = 0;
                for (int i = 0; i< texto.length(); i ++){
                    if(caracteres.length()==0){
                        caracteres +=texto.charAt(i);
                        var =1;
                    }
                    else{
                        for(int j=0; j<caracteres.length(); j++){
                            if(texto.charAt(i) == caracteres.charAt(j)){
                                var = 1;
                            }
                            if(j==caracteres.length()-1 && var==0){
                                caracteres +=texto.charAt(i);
                            }
                        }
                    }
                    var = 0;
                }
                System.out.println("El alfabeto del texto introducido es: " +caracteres);
                System.out.println("");
                
                for (int i = 0; i<caracteres.length(); i++){
                    int cantidad = frecuencia(caracteres.charAt(i), texto);
                    BigDecimal probabilidad = probabilidad(cantidad, texto.length());
                    if(cantidad != 0){
                        solucion.add(new Caracter((caracteres.charAt(i)), cantidad , probabilidad, codificacionHuffman, codifcicacionBL));
                    }  
                }
                
                Scanner lector2 = new Scanner(System.in);
                System.out.println("Desea decodificar parte del mensaje por codificacion Aritmetica (expresion en base 10) ? 1 = si, 2= no");
                int opcion2 = lector2.nextInt();
                Scanner lector3 = new Scanner(System.in);
                System.out.println("Desea decodificar parte del mensaje por binario lineal ? 1 = si, 2= no");
                int opcion3 = lector3.nextInt();
                       
                if(opcion2 == 1){
                    System.out.println("Introduzca la longitud del mensaje");
                    int longitudMensaje = lector2.nextInt();
                    BigDecimal codificacionB10 = new BigDecimal ("0.78195382101964290078842");
                    String mensaje = P3.decodificar(longitudMensaje,codificacionB10,solucion); 
                    System.out.println();
                    System.out.println("El mensaje de codificacion aritmetica (en base 10) es: " +mensaje);
                    System.out.println();
                }
                
                if(opcion3 == 1){
                    String mensaje = P4.decodificar(solucion);
                    System.out.println();
                    System.out.println("El mensaje de codificacion por binario lineal es: " +mensaje);
                    System.out.println();
                }
                
                
                Huffman.metodoHuffman(solucion);
                resultados(solucion);
            }
                
            default ->
                
                System.out.println ("Caracter no valido");
        }
    }
    
    public static int frecuencia(char caracter, String texto){       
        int num = 0;
        
        for (int pos =0; pos < texto.length(); pos++){
            if(caracter == texto.charAt(pos)){
                num ++;
            }    
        }
        return num;
    }
      
    public static BigDecimal probabilidad (float cantidad, int longitud ){    
        
        BigDecimal pro = new BigDecimal(cantidad).divide(new BigDecimal(longitud), 100, RoundingMode.HALF_UP);
        
        return pro;
    }
    
    public static float entropia(ArrayList <Caracter> solucion){
        float entropia =0;
       
        for(int i = 0 ; i<solucion.size(); i++){
            
            float probabilidad = solucion.get(i).getProbabilidad().floatValue();
            entropia+=probabilidad*(Math.log(1.0/probabilidad)/Math.log(2));
        }

        return entropia;
    }
    
    public static float eficacia (float entropia, float longitudMedia){
        float eficacia = entropia/longitudMedia;
        return eficacia;
    }
    
    public static float longitudMedia(ArrayList<Caracter> solucion){
        float longitudMedia = 0;
        
        for(int i = 0; i<solucion.size(); i++){
            float probabilidad = solucion.get(i).getProbabilidad().floatValue();
            longitudMedia += solucion.get(i).getCodificacionHuffman().length() * probabilidad;
        }
        return longitudMedia;
    }
    
    public static void resultados(ArrayList<Caracter> solucion){
        
        Collections.sort(solucion);
        
        for(Object aux: solucion){
            System.out.println(aux);
        }
       
        float entropia = entropia(solucion);
        float longitudMedia =longitudMedia(solucion);
        float eficacia = eficacia(entropia, longitudMedia);
        System.out.println();
        System.out.println("La entropia es " + entropia);
        System.out.println();
        System.out.println("La longitud media es " + longitudMedia);
        System.out.println();
        System.out.println("La eficacia es " + eficacia);
    }
}
