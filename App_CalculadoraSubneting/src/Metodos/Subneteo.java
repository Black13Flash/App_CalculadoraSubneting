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
    
    public Subneteo(String direccionIP) {
        this.direccionIP = direccionIP;
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
        
        if (primerOcteto < 127) {
            clase="Clase A";
        }else if(primerOcteto >= 128 && primerOcteto <= 191){
            clase="Clase B";
        }else if(primerOcteto >= 192 && primerOcteto <= 223){
            clase="Clase C";
        }else if(primerOcteto >= 224 && primerOcteto <= 239){
            clase="Clase D";
        }else if(primerOcteto >= 240 && primerOcteto <= 255){
            clase="Clase D";
        }
        
        return clase;
    }

}
