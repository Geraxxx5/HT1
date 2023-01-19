/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.AtributosRadio;


/**
 *
 * @author Gerax
 */
public class funcionesPrincipales {
    AtributosRadio aR = new AtributosRadio();
    
    public String enceder(){
    	String mostrarEstado = "";
    	if (aR.power()){
    		mostrarEstado = "EL radio esta encendido";
    	}
    	else {
    		mostrarEstado = "El radio esta apagado";
    	}
        return mostrarEstado;
    }
}
