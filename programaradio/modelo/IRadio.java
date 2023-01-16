public interface iRadio{

    //Tiene que iniciar apagada y funciona para cambiar la radio de encendida a apagada
    public boolean power();

    //Treue es Fm y false AM, cuando se llama a la funcion esta cambia entre true o false
    public boolean frecuencia();

    //True es para arriba y false es para abajo.
    public void cambiarEmisora(boolean subirBajar);

    //obtener la emisora actual
    public double emisoraActual();

    //guardar la emisora en un ArrayList es el cual solo guarda al final de la lista la emisora
    public void guardarEmisora(double emisora);

    //Se le manda la posicion en la que se encuentra la emisora seleccionada
    public void cargarEmisoraGuardada(int posicion);
}