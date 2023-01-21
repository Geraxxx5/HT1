package modelo;
/**
 * Clase Radio 
 * Tiene como objetivo representar los atributos y métodos de una radio
 * @author Gerardo Pineda, Josue Say, Pedro Pablo Guzman
 * */

//libreria para el manejor de ArrayList
import java.util.ArrayList;

public class Radio implements IRadio {

	// ATRIBUTOS
	/**
	 * estado actual de la radio 
	 * true: encendido 
	 * false: apagado
	 */
	boolean estadoActual = false;
	/**
	 * frecuencia de la radio 
	 * true: FM
	 * false: AM
	 * */
	boolean frecuencia = false; 
	/**
	 * emisora actual que reproduce la radio
	 * */
	double emisora = 530.0;
	
	/**
	 * emisoras guardadas por el usuario
	 * */
	ArrayList<Double> emisorasGuardadas = new ArrayList<>();

	// METODOS
	/**
	 * Enciende/Apaga la radio
	 * @return estadoActual, estado actual de la radio
	 * true: encendido
	 * false: apagado
	 */
	@Override
	public boolean power() {
		if (this.estadoActual) {
			this.estadoActual = false;
		} else {
			this.estadoActual = true;
		}
		return this.estadoActual;
	}

	/**
	 * Cambia el atributo frecuencia de la radio
	 * @return frecuencia, frecuencia de la radio
	 * true: FM
	 * false: AM
	 */
	@Override
	public boolean frecuencia() {
		// la radio esta encendida
		if (this.estadoActual) {
			// si frecuencia es FM la emisora actual sera 530
			if (this.frecuencia) {
				this.frecuencia = false;
				this.emisora = 530;
				
			//si frecuencia es AM la emisora actual sera 87.9
			} else {
				this.frecuencia = true;
				this.emisora = 87.9;
			}
		}
		return this.frecuencia;
	}

	/**
	 * Incrementa/decrementa el canal de la emisora
	 * @param subirBajar, variable que identifica si baja o sube de emisora
	 * true: incrementa
	 * false: decrementa
	 * */ 
	@Override
	public void cambiarEmisora(boolean subirBajar) {
		// la radio esta encendida
		if (this.estadoActual) {
			
			//segun su frecuencia aumenta
			if (this.frecuencia) {
				if (subirBajar) {
					if (this.emisora != 107.9) {
						this.emisora += 0.2;
					}
				} else {
					if (this.emisora != 87.9) {
						this.emisora -= 0.2;
					}
				}
			} else {
				if (subirBajar) {
					if (this.emisora != 1610.0) {
						this.emisora += 10;
					}
				} else {
					if (this.emisora != 530.0) {
						this.emisora -= 10;
					}
				}
			}
		}
	}

	/**
	 * Obtiene el valor del canal de la emisora actual
	 * @return emisora, emisora actual
	 * */
	@Override
	public double emisoraActual() {
		return this.emisora;
	}

	/**
	 * Guarda las emisoras que el usuario desee
	 * @param emisora, emisora que se guarda
	 * */
	@Override
	public void guardarEmisora(double emisora) {
		// radio encendida
		if (this.estadoActual) {
			
		// existe espacio para guardar una emisora
			if (emisorasGuardadas.size() != 12) {
				emisorasGuardadas.add(emisora);
			}
		}
	}

	/**
	 * Se obtiene la emisora de uno de los 12 botones seleccionado por el usuario
	 * */ 
	@Override
	public void cargarEmisoraGuardada(int posicion) {
		// radio encendida
		if (this.estadoActual) {
			// el boton que ingresa el usuario esta dentro de los de la lista
			if (posicion <= emisorasGuardadas.size() && posicion >= 0) {
				this.emisora = this.emisorasGuardadas.get(posicion);
			}
		}
	}

}
