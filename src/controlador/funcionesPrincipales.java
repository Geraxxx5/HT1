/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;

import modelo.IRadio;
import modelo.Radio;


/**
 *
 * @author Gerardo Pineda, Josue Say, Pedro Pablo Guzman
 * @version 1.0.0
 */
public class funcionesPrincipales {
    
	IRadio aR = new Radio();
	
    private Double estacion;
    boolean estadoRadio = false;
    private ArrayList<Double> emisorasfavoritas = new ArrayList<Double>();
    
    /**
     * Este metodo muestra el estado del radio 
     * @return se retorna un texto el cual indica si el radio esta encendido o apagado
     */
    public String encender(){
    	String mostrarEstado = ""; // En esta variable se guarda el texto que se mostrara 
    	if (aR.power()){
    		mostrarEstado = "EL radio esta encendido";
                estadoRadio = true;
    	}
    	else {
    		mostrarEstado = "El radio esta apagado";
                estadoRadio = false;
    	}
        return mostrarEstado;
    }
    
    /**
     * Este metodo srive para indicar en cuál frecuencia se encuentra el usuario 
     * @return regresa un texto el cual indica si el usuario se encuentra en la frecuencia AM o FM
     */
    public String cambiarFrecuencia() {
    	
    	String frecuenciaActual = "";
    	if(estadoRadio){
            if (aR.frecuencia()) {
    		frecuenciaActual = "Estas en FM";
            }
            else {
                    frecuenciaActual = "Estas en AM";
            }
        }else{
            frecuenciaActual = "La radio no esta encendida";
        }
    	
    	return frecuenciaActual;
    }
    /**
     * Este metodo devuelve un texto el cual indica la estacion
     */
    public String cambiarEstacion(boolean subirBajar) {
        String cambiar = "";
        if(estadoRadio){
            aR.cambiarEmisora(subirBajar);
            if(subirBajar){
                cambiar = "Subio la emisora a: ";
            }else{
                cambiar = "bajo la emisora a: ";
            }       
            cambiar+= aR.emisoraActual();
        }else{
            cambiar = "La radio no esta encendida";
        }
        
        return cambiar;
    }
    
    public boolean isEstadoRadio(){
        return estadoRadio;
    }
    
    /**
     * Este metodo permiter agregar emisoras favoritas
     * @param emisora representa la emisora que sera agregada 
     */
    public String agregarEmisora(double emisora) {
        String agregar = "";
        if(estadoRadio){
            if (this.emisorasfavoritas.size() != 12) {
    		this.emisorasfavoritas.add(emisora);
                aR.guardarEmisora(emisora);
            }
            else {
                    agregar = "Ya no puedes agregar mas emisoras";
            }
        }else{
            agregar = "La radio no esta encendida";
        }
    	return agregar;
    }
    
    public double obtenerEmisora(){
        return aR.emisoraActual();
    }
    
    /**
     * Este metodo devuelve la emisora actual
     * @return un string que indica la emisora seleccionada
     */
    public String emisoraActual() {
    	
    	String emactual = String.valueOf(aR.emisoraActual());
    	return "Actualmente estas escuchando la siguiente estacion: " + emactual;
    }
    
    public String seleccionarEmsiora(int posicion) {
    	String res ="";
        if(estadoRadio){
            if(posicion-1 >= 0 && posicion-1 < emisorasfavoritas.size()){
                aR.cargarEmisoraGuardada(posicion-1);
                res = "Se cambio la estacion a: "+aR.emisoraActual();
            }else{
                res = "Aun no hay emisora para ese boton";
            }
        }else{
            res = "La radio no esta encendida";
        }
    	
    	return res;
    	
    }
    
    
    /**
     * Este metodo permite cambiar la emisora
     * @param cambio un booleano que nos indica si se quiere recorrer hacia abajo o hacia arriba (si es true ira hacia arriba, si es false ira hacia abajo)
     */
    public void cambiar(boolean cambio) {
    	aR.cambiarEmisora(cambio);
    }
    
}
