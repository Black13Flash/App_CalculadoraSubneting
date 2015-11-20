/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Metodos;

/**
 *
 * @author Juan Yáñez (Brujo)
 */
public class Subneteo {
    
    private String direccionIP;
    private int subRedes;
    
    public Subneteo(String direccionIP,int subRedes) {
        this.direccionIP = direccionIP;
        this.subRedes = subRedes;
    }
    
    
    // Paso 1: Indentificar clase de la dirección IP by JBY
    // Retorna String de clase ejemplo: "Clase A"
    //
    // Clase A :   0 - 127
    // Clase B : 128 - 191
    // Clase C : 192 - 223
    // Clase D : 224 - 239  Multicast
    // Clase E : 240 - 255  Experimental de Laboratorio
    //
    public String obtenerClase(){
        String arregloDireccion[]=this.direccionIP.split("[.]");
        int primerOcteto= Integer.parseInt(arregloDireccion[0]);
        String clase="";
        
        if (primerOcteto <= 127) {
            clase="Clase A";
        }else if(primerOcteto >= 128 && primerOcteto <= 191){
            clase="Clase B";
        }else if(primerOcteto >= 192 && primerOcteto <= 223){
            clase="Clase C";
        }else if(primerOcteto >= 224 && primerOcteto <= 239){
            clase="Clase D";
        }else if(primerOcteto >= 240 && primerOcteto <= 255){
            clase="Clase E";
        }
        
        return clase;
    }
    
    // Paso 2: Obtener la masacara a partir de la clase by JBY
    // Retorna String de Mascara ejemplo Clase A: 8 
    //
    // Clase A :  8
    // Clase B : 16
    // Clase C : 24
    // Clase D :  0 Se manejará en la GUI
    // Clase E :  0 Se manejará en la GUI
    //
    public String mascaraClase(){
        String mascara="0";
        String clase=obtenerClase();
        
        if (clase.equalsIgnoreCase("Clase a")) {
            mascara="8";
        }else if (clase.equalsIgnoreCase("Clase b")) {
            mascara="16";
        }else if (clase.equalsIgnoreCase("Clase c")) {
            mascara="24";
        }else if (clase.equalsIgnoreCase("Clase d")) {
            mascara="0";
        }else if (clase.equalsIgnoreCase("Clase e")) {
            mascara="0";
        }
        
        return mascara;
    }
    
    // Paso 3: Obtener la mascaraSubred a partir de la MascaraClase by JBY
    // Retorna int : MascaraSubred + MascaraClase
    //
    // Clase A :  8
    // Clase B : 16
    // Clase C : 24
    // Clase D :  0 Se manejará en la GUI
    // Clase E :  0 Se manejará en la GUI
    //
    public int mascaraSubRed(){
        int subRedes = this.subRedes;
        int mascaraClase = Integer.parseInt(mascaraClase());
        int mascaraSubRed=0;
        
        int bits=2;
        
        for (int i = 0; i < 8; i++) {
            int exponente = (int) Math.pow(bits, i);
            int buscandoRango = exponente - subRedes;
            
            if (buscandoRango>=0) {
                mascaraSubRed=i;
                i=8; //Cortando el loop
            }
        }
        
        return mascaraSubRed+mascaraClase;
    }

}
