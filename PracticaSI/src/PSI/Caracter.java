/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PSI;

import java.math.BigDecimal;

/**
 *
 * @author nicoo
 */
class Caracter implements Comparable<Caracter> {
    
    private  char caracter;
    private  int frecuencia;
    private  BigDecimal probabilidad;
    private  String codificacionHuffman;
    private  String codificacionBL;
    
    public Caracter(char caracter, int frecuencia, BigDecimal probabilidad, String codificacionHuffman, String codificacionBL) {
	this.caracter = caracter;
	this.frecuencia = frecuencia;
        this.probabilidad =  probabilidad;
        this.codificacionHuffman = codificacionHuffman;
        this.codificacionBL = codificacionBL;
    }
    
    public char getCaracter() {
	return caracter;
    }

    public int getFrecuencia() {
	return frecuencia;
    }
    
    public BigDecimal getProbabilidad() {
	return probabilidad;
    }
    
    public String getCodificacionHuffman(){
        return codificacionHuffman;
    }
    
    public void setCodificacionHuffman(String codificacionHuffman){
        this.codificacionHuffman = codificacionHuffman;
    }

    public String getCodificacionBL(){
        return codificacionBL;
    }
    
    public void setCodificacionBL(String codificacionBL){
        this.codificacionBL = codificacionBL;
    }
    
    @Override
    public int compareTo(Caracter o) {
        if((o.getProbabilidad()).compareTo(probabilidad)>0){
            return 1;
        }else if((o.getProbabilidad()).compareTo(probabilidad)==0){
            return 0;
        }else{
            return -1;
        }
    }
    
    @Override
    public String toString() {
        return "Caracter : " + caracter + "    frecuencia : " + frecuencia + "    probabilidad : " + probabilidad.floatValue() + "    codificacion Huffman : " + codificacionHuffman + "    codificacion binariaLineal : " + codificacionBL;
    } 
}
