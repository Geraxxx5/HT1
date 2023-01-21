package programaradio2;
/**
 * Clase programaradio2
 * Es la clase main que tiene como objetivo realizar en consola las acciones de la clase funcionesPrincipales
 * @author Gerardo Pineda
 * */

// clase para el uso metodos de funcionesPrincipales 
import controlador.funcionesPrincipales;
// libreria para el manejo de ingreso de datos
import java.util.Scanner;

public class ProgramaRadio2 {

	public static void main(String[] args) {

		// instancia de Scanner para ingreso de datos
		Scanner sc = new Scanner(System.in);
		// instancia de funcionesPrincipales para el uso de metodos
		funcionesPrincipales fp = new funcionesPrincipales();
		// variable para el ingreso de la opcion del usuario
		String opc;

		System.out.println("Bienvenido al programa");

		boolean bandera = true;

		// variable para continuar el ciclo para mostrar menu
		while (bandera) {
			System.out.println("Ingrese la opcion que desee:\n1) Enceder Radio"
					+ "\n2) Cambiar Frecuencia\n3) Avanzar de emisora\n4) Retroceder Emisora"
					+ "\n5) Guardar Emisora\n6) Seleccionar emisora guardada\n7) Apagar Radio" + "\n8) Salir");
			opc = sc.next();

			// se realiza la opcion que se ingreso
			switch (opc) {
			// primera opcion: encender radio
			case "1":
				System.out.println(fp.encender());
				break;

			// segunda opcion: cambiar frecuencia
			case "2":
				System.out.println(fp.cambiarFrecuencia());
				break;
			// tercera opcion: cambiar/aumentar de emisora
			case "3":
				System.out.println(fp.cambiarEstacion(true));
				break;
			// cuarta opcion: cambiar/bajar de emisora
			case "4":
				System.out.println(fp.cambiarEstacion(false));
				break;
			// quinta opcion: guardar emisora
			case "5":
				System.out.println(fp.agregarEmisora(fp.obtenerEmisora()));
				break;
			// sexta opcion: seleccionar emisora guardada
			case "6":
				// se pregunta el boton para seleccionar la emisora
				if (fp.isEstadoRadio()) {
					System.out.println("Elija un numero del 1 al 12");
					int num = sc.nextInt();
					System.out.println(fp.seleccionarEmsiora(num));
				} else {
					System.out.println("La radio esta apagada");
				}
				break;

			// septima opcion:apagar radio
			case "7":
				System.out.println(fp.encender());
				break;

			// octava opcion: salir del programa
			case "8":
				bandera = false;
				break;
			}
		}
	}

}
