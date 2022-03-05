/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PSI;

/**
 *
 * @author nicoo
 */
class Caracter implements Comparable<Caracter> {
    
    private  char caracter;
    private  int frecuencia;
    private  float probabilidad;
    private  String codificacion;
    
    public Caracter(char caracter, int frecuencia, float probabilidad, String codificacion) {
	this.caracter = caracter;
	this.frecuencia = frecuencia;
        this.probabilidad =  probabilidad;
        this.codificacion = codificacion;
    }
    
    public char getCaracter() {
	return caracter;
    }

    public int getFrecuencia() {
	return frecuencia;
    }
    
    public float getProbabilidad() {
	return probabilidad;
    }
    
    public String getCodificacion(){
        return codificacion;
    }
    
    public void setCodificacion(String codificacion){
        this.codificacion = codificacion;
    }

    @Override
    public int compareTo(Caracter o) {
        if(o.getProbabilidad()>probabilidad){
            return 1;
        }else if(o.getProbabilidad()==probabilidad){
            return 0;
        }else{
            return -1;
        }
    }
    
    @Override
    public String toString() {
        return "Caracter : " + caracter + "    frecuencia : " + frecuencia + "    probabilidad : " + probabilidad + "    codificacion : " + codificacion;
    } 
}
