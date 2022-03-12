/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PSI;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 *
 * @author nicoo
 */
public class P3 {
    
    public static String decodificar(int longitud, BigDecimal numero, ArrayList<Caracter> solucion){
        
        String texto= "";
        BigDecimal prob;
        BigDecimal amplitud = new BigDecimal(0);
              
        for(int i=0; i<longitud; i++){
            prob = new BigDecimal(0);
            for (int j=0; j<solucion.size(); j++){
                prob = prob.add(solucion.get(j).getProbabilidad());
                if(numero.compareTo(prob)<0 ){
                    texto +=  solucion.get(j).getCaracter();
                    amplitud = solucion.get(j).getProbabilidad();
                    prob = prob.subtract(solucion.get(j).getProbabilidad());
                    break;
                }
            }
            numero = (numero.subtract(prob)).divide(amplitud,600,RoundingMode.HALF_UP);
        }
        return texto;
    }
}
