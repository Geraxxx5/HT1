/**
 * Clase funcionesPrinciples 
 * Es la clase main que tiene como objetivo realizar en consola
 * las acciones de la clase Radio
 * @author Gerardo Pineda, Josue Say, Pedro Pablo Guzman
 * */
package controlador;

// libreria para el manejor de ArrayList
import java.util.ArrayList;
// clase del paquete modelo para referenciar acceder a los metodos de IRadio
import modelo.IRadio;
// clase del paquete modelo para referenciar a la radio
import modelo.Radio;

public class funcionesPrincipales {
    
	// instancia de la radio
	IRadio aR = new Radio();
	
	/**
	 * estación actual de la radio
	 * */
	private Double estacion;
	/**
	 * estado de la radio
	 * true: encendido
	 * false: apagado
	 * */
    boolean estadoRadio = false;
    /**
     * listado de emisoras guardadas
     * */
    private ArrayList<Double> emisorasfavoritas = new ArrayList<Double>();
    
    /**
     * Muestra al usuario si la radio esta encendida/apagada 
     * @return mostrarEstado, variable que menciona si la radio esta encendida/apaga
     */
    public String encender(){   	
    	// mensaje a mostrar
    	String mostrarEstado = "";  
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
     * muestra un mensaje al usuario sobre la frecuenci actual 
     * @return frecuenciaActual, regresa un mensaje mencionando la frecuencia
     */
    public String cambiarFrecuencia() {
    	
    	// texto a mostrar
    	String frecuenciaActual = "";
    	
    	// radio encendida
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
     * metodo que indica la emisora de la radio
     * @return cambiar, mensaje de la emisora actual
     */
    public String cambiarEstacion(boolean subirBajar) {
        // mensaje a mostrar
    	String cambiar = "";
        if(estadoRadio){
            aR.cambiarEmisora(subirBajar);
            if(subirBajar){
                cambiar = "Subio la emisora a: ";
            }else{
                cambiar = "bajo la emisora a: ";
            }       
            
            System.out.println("Ahora entro a emisoraActual");
            cambiar+= aR.emisoraActual();
        }else{
            cambiar = "La radio no esta encendida";
        }
        
        return cambiar;
    }
    
    /**
     * metodo que retorna el estado de la radio
     * @return estadoRadio, variable que almacena el estado de la radio
     * true: encendido
     * false: apagado
     * */
    public boolean isEstadoRadio(){
        return estadoRadio;
    }
    
    /**
     * agrega emisoras favoritas a un arraylist
     * @param agregar, mensaje con lemisora representa la emisora que sera agregada 
     */
    public String agregarEmisora(double emisora) {
        // mensaje a mostrar
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
    
    /**
     * obtenre la emisora que se reprocue
     * @param valor con la emisora actual
     * */
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
    
    /**
     * mostrar la emisora seleccionada por el usuario
     * @param res, mensaje con la emisora seleccionada
     * */
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
     * cambiar de emisora
     * @param cambio, variable que almacena si se desea aumentar o bajar de emisora 
     * true: aumentar
     * false: bajar
     */
    public void cambiar(boolean cambio) {
    	aR.cambiarEmisora(cambio);
    }
    
}
