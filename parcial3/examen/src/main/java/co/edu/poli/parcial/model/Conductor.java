package co.edu.poli.parcial.model;

import java.io.Serializable;

/**
 * Clase que representa a un conductor de vehículo.
 * 
 * <p>Combina la versión previa del sistema audiovisual con la estructura moderna
 * para uso en el sistema de transporte. Incluye identificación, nombre y licencia.</p>
 * 
 * <p>Implementa {@link Serializable} para permitir la persistencia en archivos.</p>
 * 
 * @author Kevin
 * @version 1.1
 * @since 2025-10-16
 */
public class Conductor implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Identificador único del conductor (puede ser alfanumérico) */
    private String id;

    /** Nombre completo del conductor */
    private String nombre;

    /** Tipo o número de licencia del conductor */
    private String licencia;

    /**
     * Constructor vacío por defecto.
     * <p>Permite crear un objeto {@code Conductor} sin inicializar sus atributos.</p>
     */
    public Conductor() { }

    /**
     * Constructor completo del Conductor.
     *
     * @param id        Identificador del conductor (cadena)
     * @param nombre    Nombre completo del conductor
     * @param licencia  Tipo o número de licencia del conductor
     */
    public Conductor(String id, String nombre, String licencia) {
        this.id = id;
        this.nombre = nombre;
        this.licencia = licencia;
    }

    /** @return identificador del conductor */
    public String getId() {
        return id;
    }

    /** @param id nuevo identificador */
    public void setId(String id) {
        this.id = id;
    }

    /** @return nombre completo del conductor */
    public String getNombre() {
        return nombre;
    }

    /** @param nombre nuevo nombre */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** @return licencia del conductor */
    public String getLicencia() {
        return licencia;
    }

    /** @param licencia nueva licencia del conductor */
    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    /**
     * Representación en texto del conductor.
     * 
     * @return información del conductor en formato legible.
     */
    @Override
    public String toString() {
        return "Conductor [id=" + id + ", nombre=" + nombre + ", licencia=" + licencia + "]";
    }
}
