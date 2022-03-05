/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PSI;

import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
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
        
        String caracteres= "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZáéíóúÁÉÍÓÚ.,;:-_()'+*ü ";
        Scanner lector = new Scanner(System.in);
        
        System.out.println("Elegir modo, 1= lista de probabilidades, 2= lista de frecuencias, 3= texto");
        int opcion = lector.nextInt();
        
        ArrayList solucion = new ArrayList<>();
        String codificacion="";

        switch(opcion){
            
            case 1 -> {
                ArrayList probabilidades = new ArrayList<Float>();
                
                probabilidades = Ficheros.leerFicheroProbabilidades("C:\\Users\\nicoo\\Desktop\\Universidad\\3º carrera\\Seguridad informática\\P2\\probabilidad.txt", probabilidades);
                
                for (int i = 0; i<probabilidades.size();i++){
                    solucion.add(new Caracter((char)(i+65), (int) ((float) probabilidades.get(i) *100), (float) probabilidades.get(i), codificacion )); 
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
                    float probabilidad = probabilidad((int) frecuencias.get(i), longitud);
                    solucion.add(new Caracter((char)(i+65),(int) frecuencias.get(i), probabilidad, codificacion)); 
                }
                
                Huffman.metodoHuffman(solucion);
                resultados(solucion);
            }
                
            case 3 -> {
                String texto = Ficheros.leerFichero("C:\\Users\\nicoo\\Desktop\\Universidad\\3º carrera\\Seguridad informática\\P2\\texto.txt");
               
                for (int i = 0; i< caracteres.length(); i ++){
                  
                    int cantidad = frecuencia(caracteres.charAt(i), texto);
                    float probabilidad = probabilidad(cantidad, texto.length());
                
                    if(cantidad != 0){
                        solucion.add(new Caracter((caracteres.charAt(i)), cantidad , probabilidad, codificacion));
                    }  
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
      
    public static float probabilidad (float cantidad, int longitud ){    
        float pro = cantidad /longitud;
        
        return pro;
    }
    
    public static float entropia(ArrayList <Caracter> solucion){
        float entropia =0;
       
        for(int i = 0 ; i<solucion.size(); i++){
            float probabilidad = solucion.get(i).getProbabilidad();
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
            longitudMedia += solucion.get(i).getCodificacion().length() * solucion.get(i).getProbabilidad();
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
        System.out.println("La efcicacia es " + eficacia);
    }
}
