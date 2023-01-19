/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;

import modelo.AtributosRadio;


/**
 *
 * @author Gerardo Pineda, Josue Say, Pedro Pablo Guzman
 * @version 1.0.0
 */
public class funcionesPrincipales {
    AtributosRadio aR = new AtributosRadio();
    private Double estacion; 
    private ArrayList<Double> emisorasfavoritas = new ArrayList<Double>();
    
    /**
     * Este metodo muestra el estado del radio 
     * @return se retorna un texto el cual indica si el radio esta encendido o apagado
     */
    public String encender(){
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
    /**
     * Este metodo devuelve un texto el cual indica la estacion
     */
    public void cambiarEstacion(boolean subirBajar) {
    	if (aR.frecuencia()) {
    		this.estacion = 87.9;
    	}
    	
    	else {
    		this.estacion = 530.0;
    	}
    }
    
    /**
     * Este metodo permiter agregar emisoras favoritas
     * @param emisora representa la emisora que sera agregada 
     */
    public void agregarEmisora(double emisora) {
    	if (this.emisorasfavoritas.size() != 12) {
    		this.emisorasfavoritas.add(emisora);
    	}
    	else {
    		System.out.println("Ya no puedes agregar mas emisoras");
    	}
    }
    
    /**
     * Este metodo devuelve la emisora actual
     * @return un string que indica la emisora seleccionada
     */
    public String emisoraActual() {
    	
    	String emactual = String.valueOf(this.estacion);
    	return "Actualmente estas escuchando la siguiente estacion: " + emactual;
    }
    public String seleccionarEmsiora(int posicion) {
    	String res ="";
    	if (posicion >=12 ||posicion < 0) {
    		res = "Elegiste un valor invalido";
    		
    	}
    	else {
    		String emElegida = String.valueOf(this.emisorasfavoritas.get(posicion+1));
        	res = "Elegiste la emisora"+emElegida;
    	}
    	return res;
    	
    }
    /**
     * Este metodo permite cambiar la emisora
     * @param cambio un booleano que nos indica si se quiere recorrer hacia abajo o hacia arriba (si es true ira hacia arriba, si es false ira hacia abajo)
     */
    public void cambiar(boolean cambio) {
    	if (cambio) {
    		
    		if (aR.frecuencia()) {
    			if (this.estacion ==107.9) {
    				this.estacion = 107.9;
    			}
    			else {
    				this.estacion += 0.2;
    			}
    		}
    		else {
    			if (this.estacion ==1610.0) {
    				this.estacion = 1610.0;
    			}
    			else {
    				this.estacion +=10.0;
    			}
    		}
    	}
    	else {
    		if (aR.frecuencia()) {
    			
    			if (this.estacion == 87.9) {
    				this.estacion = 87.9;
    			}
    			else {
    				this.estacion -=0.2;
    			}
    			
    		}
    		else {
    			
    			if (this.estacion ==530.0) {
    				this.estacion = 530.0;
    			}
    			else {
    				this.estacion -= 10.0;
    			}
    			
    		}
    	}
    }
    
}
