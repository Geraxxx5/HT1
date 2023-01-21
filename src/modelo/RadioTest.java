package modelo;
/**
 * Clase RadioTesT
 * Tiene como objetivo realizar pruebas unitarias de metodos esenciales de la clase radio
 * Los 2 metodos escenciales son el metodo power y frecuencia, debido a que si la radio esta encendia o apagada se realizan las demas funciones
 * y el metodo frecuencia asigna construye la emisora inicial para utilizar a lo largo de la programacion
 * */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RadioTest {

	// instancia de Radio
	IRadio r = new Radio();

	@Test
	/**
	 * se ha encendido la radio
	 */
	void testPower1() {
		boolean resultado = r.power();
		boolean expected = true;

		assertEquals(expected, resultado);
	}
	
	@Test
	/**
	 * se apaga la radio
	 * */
	void textPower2() {
		// se enciende y apaga la radio
		boolean resultado = r.power();
		resultado = r.power();
		boolean expected = false;
		
		assertEquals(expected, resultado);	
	}
	

	@Test
	/**
	 * se realizo un cambio de frecuencia
	 */
	void testFrecuencia1() {
		// se enciende radio
		r.power();
		boolean resultado = r.frecuencia();
		boolean expected = true;

		assertEquals(expected, resultado);

	}

	/**
	 * no se realiza ambio de frecuencia porque radio esta apagada
	 */
	@Test
	void testFrecuencia2() {
		boolean resultado = r.frecuencia();
		boolean expected = false;

		assertEquals(expected, resultado);
	}
	


}
