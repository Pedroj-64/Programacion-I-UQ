package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

public class Gimnasio {
    private String nombre;
    private LocalDate fechaInscripcion;
    private LinkedList<Miembro> miembros;
    private LinkedList<Entrenador> entrenadores;

    public Gimnasio(String nombre) {
        this.nombre = nombre;
        miembros = new LinkedList<>();
        entrenadores = new LinkedList<>();
    }

    public void agregarMiembro(Miembro miembro) {
        if (!verificarMiembro(miembro.getCedula())) {
            miembros.add(miembro);
        }
    }

    public boolean verificarMiembro(String cedula) {
        boolean centinela = false;
        for (Miembro miembro : miembros) {
            if (miembro.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public void agregarEntrenador(Entrenador entrenador) {
        if (!verificarEntrenador(entrenador.getCorreo())) {
            entrenadores.add(entrenador);
        }
    }

    public boolean verificarEntrenador(String correo) {
        boolean centinela = false;
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getCorreo().equals(correo)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public void eliminarMiembro(String cedula) {
        for (Miembro miembro : miembros) {
            if (miembro.getCedula().equals(cedula)) {
                miembros.remove(miembro);
                break;
            }
        }
    }

    public void eliminarEntrenador(String correo) {
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getCorreo().equals(correo)) {
                entrenadores.remove(entrenador);
                break;
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // --------------------------------------------------------------
    // Pilas metodos nuevos del taller

    /**
     * Metodo que muestra los nombres de los miembros de la lista en orden inverso
     */
    public void listaNombresInverso() {
        for (int i = miembros.size() - 1; i >= 0; i--) {
            Miembro miembro = miembros.get(i);
            mostrarMensaje(miembro.getNombre());
        }
    }

    /**
     * Metodo que crea una lista de miembros que son menores de 18 años.
     * 
     * @return Una lista de objetos cuya edad es menor de 18 años.
     */
    public LinkedList<Miembro> miembrosMenoresEdad() {
        LinkedList<Miembro> menores = new LinkedList<>();
        for (Miembro miembro : miembros) {
            if (miembro.getEdad() < 18) {
                menores.add(miembro);
            }
        }
        return menores;
    }
    // --------------------------------------------------------------



    // --------------------Completar los metodos---------------------

    /*
     - calcularPromedioEdad()
     
     - modaEdades()
     - elimiarNombreVocales()
     - determiarVocal()
     */

    // --------------------Completar---------------------------------

    //calcular promedio
    public void calcularPromedioEdad(){
        Collection<Integer> edades=new LinkedList<>();
        for(Miembro m : miembros){
            int edad=m.getEdad();
            edades.add(edad);
        }
        int suma=0;
        for (int edad: edades){
            suma+= edad;
        }
        int promedio=suma/edades.size();

        System.out.println("El promedio de edades de miembros del gimansio es: " + promedio);
    }

    //vocal
    private int determinarVocal(String nombre){
        int contador=0;
        char[] vocales=nombre.toLowerCase().toCharArray();
        for (char vocal: vocales){
             if(vocal=='a' || vocal=='e' || vocal=='i' || vocal=='o' || vocal=='u'){
               contador+=1;
            }
        }
         
        return contador;
        


    }

    //eliminar por vocal
    public void eliminarNombreVocales(){
        for (Miembro m: miembros){
            if(determinarVocal(m.getNombre())>=3){
                miembros.remove(m);
            }

        }
       
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public LinkedList<Miembro> getMiembros() {
        return miembros;
    }

    public void setMiembros(LinkedList<Miembro> miembros) {
        this.miembros = miembros;
    }

    public LinkedList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(LinkedList<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    @Override
    public String toString() {
        return "Gimnasio [nombre=" + nombre + ", fechaInscripcion=" + fechaInscripcion + ", miembros=" + miembros
                + ", entrenadores=" + entrenadores + "]";
    }

}
