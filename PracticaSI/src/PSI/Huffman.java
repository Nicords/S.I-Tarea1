package PSI;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author nicoo
 */

class MyComparator implements Comparator<NodoHuffman> {
    @Override
    public int compare(NodoHuffman x, NodoHuffman y){
        return x.frecuencia - y.frecuencia;
    }
}

public class Huffman {
    
    public static void codificacion(NodoHuffman root, String s, ArrayList <Caracter> solucion){
  
        // si left y right son null es hoja y seteamos codificacion
        if (root.left == null && root.right == null ) {
            for(int i = 0; i<solucion.size(); i++){
                if(root.caracter == solucion.get(i).getCaracter()){
                    solucion.get(i).setCodificacionHuffman(s);
                }
            }
            return;
        }
  
        // si vamos a la izquierda 0, derecha 1
        codificacion(root.left, s + "0", solucion);
        codificacion(root.right, s + "1", solucion);
    }
  
    public static void metodoHuffman (ArrayList <Caracter> solucion){
        PriorityQueue<NodoHuffman> cola = new PriorityQueue<>(solucion.size(), new MyComparator());
  
        for (int i = 0; i < solucion.size(); i++) {
            NodoHuffman nodo = new NodoHuffman();
            nodo.caracter = solucion.get(i).getCaracter();
            nodo.frecuencia = solucion.get(i).getFrecuencia();
            nodo.left = null;
            nodo.right = null;
            cola.add(nodo);
        }
        NodoHuffman root = null;
  
        while (cola.size() > 1) {
            NodoHuffman x = cola.peek();
            cola.poll();
            NodoHuffman y = cola.peek();
            cola.poll();
  
            NodoHuffman f = new  NodoHuffman();
            f.frecuencia = x.frecuencia + y.frecuencia;
            f.caracter = '-';
            f.left = x;
            f.right = y;
            root = f;
            
            cola.add(f);
        }
        codificacion(root, "", solucion);
    }
}
