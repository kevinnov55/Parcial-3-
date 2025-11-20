package co.edu.poli.parcial.model;

import java.io.Serializable;

/**
 * Clase que representa un Camión, subclase de Vehículo.
 * Contiene el tipo de mercancía que transporta.
 *
 * <p>Esta versión combina la estructura moderna (placa, marca, modelo,
 * capacidadCarga, conductor, tipoMercancia) con utilidades del
 * diseño anterior: implementación de {@link Serializable}, constructor
 * por defecto y método {@code mostrarInformacion()} para salida por consola.</p>
 *
 * @author Kevin / kevin ovalle
 * @version 1.1
 * @since 2025-10-16
 */
public class Camion extends Vehiculo {

    private static final long serialVersionUID = 1L;

    /** Género o tipo específico asociado al camión */
    private String genero;

    /**
     * Constructor por defecto.
     * Permite crear un objeto {@code Camion} sin inicializar sus atributos.
     */
    public Camion() { }

    /**
    /**
     * Constructor del Camión.
     *
     * @param placa          Placa del camión
     * @param marca          Marca del camión
     * @param fechaEstreno   Año o identificador numérico del modelo
     * @param capacidadCarga Capacidad de carga
     * @param conductor      Conductor asignado
     * @param genero         Género o etiqueta adicional
     */
    public Camion(String placa, String marca, int fechaEstreno, double capacidadCarga, Conductor conductor, String genero) {
        super(placa, marca, fechaEstreno, capacidadCarga, conductor);
        this.genero = genero;
    }

    /** @return Género del camión */
    public String getGenero() {
        return genero;
    }

    /** @param genero nuevo género */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Muestra en consola la información completa del camión.
     * Intenta usar getters del padre para ser independiente de la
     * visibilidad de los campos en {@code Vehiculo}.
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("\n--- Camión ---");
        try {
            System.out.println("Placa           : " + getPlaca());
        } catch (Exception e) {
            // Si no existe getPlaca(), intenta acceder al campo protegido (si aplica)
            System.out.println("Placa           : " + (super.toString())); // fallback genérico
        }

        try {
            System.out.println("Marca           : " + getMarca());
        } catch (Exception ignored) { }

        try {
            System.out.println("Modelo          : " + getModelo());
        } catch (Exception ignored) { }

        try {
            System.out.println("Capacidad carga : " + getCapacidadCarga() + " unidades");
        } catch (Exception ignored) { }

        try {
            if (getConductor() != null) {
                System.out.println("Conductor       : " + getConductor().getNombre());
            } else {
                System.out.println("Conductor       : -");
            }
        } catch (Exception ignored) { }

        System.out.println("Género          : " + (genero != null ? genero : "-"));
    }

    /** @return Información detallada del camión */
    @Override
    public String toString() {
        String placaStr = "";
        String marcaStr = "";
        String modeloStr = "";
        String capacidadStr = "";
        String conductorStr = "";

        try { placaStr = getPlaca(); } catch (Exception ignored) { }
        try { marcaStr = getMarca(); } catch (Exception ignored) { }
        try { modeloStr = getModelo(); } catch (Exception ignored) { }
        try { capacidadStr = String.valueOf(getCapacidadCarga()); } catch (Exception ignored) { }
        try { conductorStr = (getConductor() != null ? getConductor().getNombre() : "null"); } catch (Exception ignored) { }

        return "Camión [placa=" + placaStr +
                ", marca=" + marcaStr +
                ", modelo=" + modeloStr +
                ", capacidadCarga=" + capacidadStr +
                ", genero=" + genero +
                ", conductor=" + conductorStr + "]";
    }

    @Override
    public int getFechaEstreno() {
        return super.getFechaEstreno();
    }
}
