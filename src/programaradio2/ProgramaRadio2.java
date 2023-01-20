/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programaradio2;

import controlador.funcionesPrincipales;
import java.util.Scanner;

/**
 *
 * @author Gerax
 */
public class ProgramaRadio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        funcionesPrincipales fp = new funcionesPrincipales();
        System.out.println("Bienvenido al programa");
        boolean bandera = true;
        while(bandera){
            System.out.println("Ingrese la opcion que desee:\n1) Enceder Radio"
                    + "\n2) Cambiar Frecuencia\n3) Avanzar de emisora\n4) Retroceder Emisora"
                    + "\n5) Guardar Emisora\n6) Seleccionar emisora guardada\n7) Apagar Radio"
                    + "\n8) Salir");
            String opc = sc.next();
            switch(opc){
                case "1":
                    System.out.println(fp.encender());
                    break;
                case "2":
                    System.out.println(fp.cambiarFrecuencia());
                    break;
                case "3":
                    System.out.println(fp.cambiarEstacion(true));
                    break;
                case "4":
                    System.out.println(fp.cambiarEstacion(false));
                    break;
                case "8":
                    bandera = false;
                    break;
                case "5":
                    System.out.println(fp.agregarEmisora(fp.obtenerEmisora()));
                    break;
                case "6":
                    if(fp.isEstadoRadio()){
                        System.out.println("Elija un numero del 1 al 12");
                        int num = sc.nextInt();
                        System.out.println(fp.seleccionarEmsiora(num));
                    }else{
                        System.out.println("La radio esta apagada");
                    }
                    break;
                case "7":
                    System.out.println(fp.encender());
                    break;
            }
        }
    }
    
}
