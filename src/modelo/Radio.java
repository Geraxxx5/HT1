
package modelo;

import java.util.ArrayList;


public class Radio implements IRadio {
    //Estado actual es si esta encendido o apagado
    boolean estadoActual = false; //false es apagaado y true encendido
    boolean frecuencia = false; //false AM y true FM
    double emisora = 530.0;
    ArrayList<Double> emisorasGuardadas = new ArrayList<>();
    
    /**
     * Esta clase cambia el estado de apagado a encendido
     * @return estadoActual
     */
    @Override
    public boolean power() {
        if(this.estadoActual){
            this.estadoActual = false;
        }else{
            this.estadoActual = true;
        }
        return this.estadoActual;
    }

    /**
     * Esta clase cambia entre frecuencias y cambia la emisora para sus respectivas frecuencias
     * @return frecuencia
     */
    @Override
    public boolean frecuencia() {
        if(this.estadoActual){
            if(this.frecuencia){
                this.frecuencia = false;
                this.emisora = 530;
            }else{
                this.frecuencia = true;
                this.emisora = 87.9;
            }
        }
        return this.frecuencia;
    }

    /**
     * Sube o baja la emisora dependido del parametro que se mande y depende de la emisora sube o baja en un rango especifico
     * @param subirBajar
     */
    @Override
    public void cambiarEmisora(boolean subirBajar) {
        //True es para arriba y false es para abajo.
        if(this.estadoActual){
            if(this.frecuencia){
                if(subirBajar){
                    if(this.emisora != 107.9){
                        this.emisora+=0.2;
                    }
                }else{
                    if(this.emisora != 87.9){
                        this.emisora-=0.2;
                    }
                }        
            }else{
                if(subirBajar){
                    if(this.emisora != 1610.0){
                        this.emisora+=10;
                    }
                }else{
                    if(this.emisora != 530.0){
                        this.emisora-=10;
                    }
                }
            }
        }
    }

    /**
     * Retorna la emisora actual
     * @return emisora
     */
    @Override
    public double emisoraActual() {
        return this.emisora;
    }

    /**
     * Se le envia por medio de un parametro la emisora que se quiere guardar
     * @param emisora
     */
    @Override
    public void guardarEmisora(double emisora) {
        if(this.estadoActual){
            if(emisorasGuardadas.size() != 12){
                emisorasGuardadas.add(emisora);
            }
        }
    }

    /**
     * Manda por medio de parametro la posicion que quiere de la cancion el usuario
     * @param posicion
     */
    @Override
    public void cargarEmisoraGuardada(int posicion) {
        if(this.estadoActual){
            if(posicion<= emisorasGuardadas.size() && posicion >=0){
                this.emisora = this.emisorasGuardadas.get(posicion);
            }
        }
    }
    
}
