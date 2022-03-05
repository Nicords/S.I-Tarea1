/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PSI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nicoo
 */
class Ficheros {
    public static String leerFichero(String archivo) throws FileNotFoundException, IOException { 
    	 
        String texto ="";
        File fichero = new File(archivo);
        Scanner s = null;
       
        try {
            s = new Scanner(fichero);	
            while (s.hasNextLine()) {
		String linea = s.nextLine(); 	// Guardamos la linea en un String
                texto += linea;
                
                if(s.hasNextLine()) {
                    texto +=  "  ";
                }
            }
        } 
        catch (FileNotFoundException ex) { 
            System.out.println("Mensaje: " + ex.getMessage());
	} 
        
        finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
            if (s != null)
                s.close();
            } 
            catch (Exception ex2) {
                    System.out.println("Mensaje 2: " + ex2.getMessage());
            }
	}
        return texto;
    } 
    
    public static ArrayList<Integer> leerFicheroFrecuencias(String archivo, ArrayList<Integer> frecuencias) throws FileNotFoundException, IOException { 
    	 
        File fichero = new File(archivo);
        Scanner s = null;

        try {
            s = new Scanner(fichero);	
            while (s.hasNextLine()) {
		frecuencias.add(Integer.parseInt (s.nextLine())); 
            }
        } 
        catch (FileNotFoundException | NumberFormatException ex) { 
            System.out.println("Mensaje: " + ex.getMessage());
	} 
        
        finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
            if (s != null)
                s.close();
            } 
            catch (Exception ex2) {
                    System.out.println("Mensaje 2: " + ex2.getMessage());
            }
	}
        return frecuencias;
    } 
    
    
    public static ArrayList<Float> leerFicheroProbabilidades(String archivo, ArrayList<Float> probabilidades) throws FileNotFoundException, IOException { 
    	 
        File fichero = new File(archivo);
        Scanner s = null;

        try {
            s = new Scanner(fichero);	
            while (s.hasNextLine()) {
		probabilidades.add(Float.parseFloat (s.nextLine())); 
            }
        } 
        catch (FileNotFoundException | NumberFormatException ex) { 
            System.out.println("Mensaje: " + ex.getMessage());
	} 
        
        finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
            if (s != null)
                s.close();
            } 
            catch (Exception ex2) {
                    System.out.println("Mensaje 2: " + ex2.getMessage());
            }
	}
        return probabilidades;
    } 
}
