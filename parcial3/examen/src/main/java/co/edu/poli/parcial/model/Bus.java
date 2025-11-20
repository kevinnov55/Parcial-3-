package co.edu.poli.parcial.model;

import java.io.Serializable;

/**
 * Clase que representa un Bus, subclase de Vehiculo.
 * Incluye el número de pasajeros como atributo adicional.
 *
 * <p>Esta versión combina la estructura moderna (placa, marca, modelo,
 * capacidadCarga, conductor, pasajeros) con utilidades del diseño anterior:
 * implementación de {@link Serializable}, constructor por defecto y método
 * {@code mostrarInformacion()} para salida por consola.</p>
 *
 * @author Kevin / kevin ovalle
 * @version 1.1
 * @since 2025-10-16
 */
public class Bus extends Vehiculo {

    private static final long serialVersionUID = 1L;

    /** Número de temporadas (uso en la app original) o conteo específico */
    private int numeroTemporadas;

    /**
     * Constructor por defecto.
     * Permite crear una instancia de {@code Bus} sin inicializar sus atributos.
     */
    public Bus() { }

    /**
     * Constructor completo del Bus.
     *
     * @param placa            Placa del bus
     * @param marca            Marca del bus
     * @param fechaEstreno     Año o identificador numérico del modelo
     * @param capacidadCarga   Capacidad de carga del bus
     * @param conductor        Conductor asignado
     * @param numeroTemporadas Número de temporadas / valor específico
     */
    public Bus(String placa, String marca, int fechaEstreno, double capacidadCarga, Conductor conductor, int numeroTemporadas) {
        super(placa, marca, fechaEstreno, capacidadCarga, conductor);
        this.numeroTemporadas = numeroTemporadas;
    }

    /** @return Número de temporadas */
    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    /** @param numeroTemporadas Nuevo número de temporadas */
    public void setNumeroTemporadas(int numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }

    /**
     * Muestra en consola la información completa del bus.
     * Intenta usar getters del padre para ser independiente de la
     * visibilidad de los campos en {@code Vehiculo}.
     */
    @Override
    public void mostrarInformacion() {
        System.out.println(" Bus ");
        try {
            System.out.println("Placa           : " + getPlaca());
        } catch (Exception ignored) { System.out.println("Placa           : -"); }

        try {
            System.out.println("Marca           : " + getMarca());
        } catch (Exception ignored) { System.out.println("Marca           : -"); }

        try {
            System.out.println("Modelo          : " + getModelo());
        } catch (Exception ignored) { System.out.println("Modelo          : -"); }

        try {
            System.out.println("Capacidad       : " + getCapacidadCarga() + " kilogramos");
        } catch (Exception ignored) { System.out.println("Capacidad       : -"); }

        try {
            if (getConductor() != null) {
                System.out.println("Conductor       : " + getConductor().getNombre());
            } else {
                System.out.println("Conductor       : -");
            }
        } catch (Exception ignored) { System.out.println("Conductor       : -"); }

        System.out.println("Temporadas      : " + numeroTemporadas);
    }

    /** @return Información detallada del bus */
    @Override
    public String toString() {
        String placaStr = "";
        String marcaStr = "";
        String modeloStr = "";
        String capacidadStr = "";
        String conductorStr = "";

        try { placaStr = getPlaca(); } catch (Exception ignored) { placaStr = "null"; }
        try { marcaStr = getMarca(); } catch (Exception ignored) { marcaStr = "null"; }
        try { modeloStr = getModelo(); } catch (Exception ignored) { modeloStr = "null"; }
        try { capacidadStr = String.valueOf(getCapacidadCarga()); } catch (Exception ignored) { capacidadStr = "null"; }
        try { conductorStr = (getConductor() != null ? getConductor().getNombre() : "null"); } catch (Exception ignored) { conductorStr = "null"; }

        return "Bus [placa=" + placaStr +
                ", marca=" + marcaStr +
                ", modelo=" + modeloStr +
                ", capacidadCarga=" + capacidadStr +
                ", numeroTemporadas=" + numeroTemporadas +
                ", conductor=" + conductorStr + "]";
    }

    @Override
    public int getFechaEstreno() {
        return super.getFechaEstreno();
    }
}
