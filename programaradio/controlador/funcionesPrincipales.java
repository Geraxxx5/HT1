/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.AtributosRadio;


/**
 *
 * @author Gerardo Pineda, Josue Say, Pedro Pablo Guzman
 * @version 1.0.0
 */
public class funcionesPrincipales {
    AtributosRadio aR = new AtributosRadio();
    
    /**
     * Este metodo muestra el estado del radio 
     * @return se retorna un texto el cual indica si el radio esta encendido o apagado
     */
    public String enceder(){
    	String mostrarEstado = ""; // En esta variable se guarda el texto que se mostrara 
    	if (aR.power()){
    		mostrarEstado = "EL radio esta encendido";
    	}
    	else {
    		mostrarEstado = "El radio esta apagado";
    	}
        return mostrarEstado;
    }
    
    /**
     * Este metodo srive para indicar en cuál frecuencia se encuentra el usuario 
     * @return regresa un texto el cual indica si el usuario se encuentra en la frecuencia AM o FM
     */
    
    public String cambiarFrecuencia() {
    	
    	String frecuenciaActual = "";
    	
    	if (aR.frecuencia()) {
    		frecuenciaActual = "Estas en FM";
    	}
    	else {
    		frecuenciaActual = "Estas en AM";
    	}
    	return frecuenciaActual;
    }
    
    public String cambiarEstacion() {
    	return "";
    }
    
}
