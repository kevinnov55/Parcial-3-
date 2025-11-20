package co.edu.poli.parcial.model;

import java.io.Serializable;

/**
 * Clase abstracta que representa un Vehículo dentro del sistema.
 *
 * <p>Define los atributos y comportamientos comunes para todos los
 * vehículos, como buses o camiones. Implementa {@link Serializable}
 * para permitir su almacenamiento en archivos.</p>
 *
 * <p>Contiene información básica como placa, marca, modelo, capacidad
 * de carga y el conductor asociado.</p>
 *
 * @author Kevin
 * @version 1.1
 * @since 2025-10-16
 */
public abstract class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Placa del vehículo */
    private String placa;

    /** Marca del vehículo */
    private String marca;

    /** Año o modelo/fecha de estreno del vehículo (entero) */
    private int fechaEstreno;

    /** Capacidad de carga en kilogramos */
    private double capacidadCarga;

    /** Conductor asignado al vehículo */
    private Conductor conductor;

    /**
     * Constructor vacío por defecto.
     * Permite crear un vehículo sin inicializar atributos.
     */
    public Vehiculo() {}

    /**
    /** Constructor completo que inicializa todos los atributos del vehículo.
     *
     * @param placa          Placa del vehículo
     * @param marca          Marca del vehículo
     * @param fechaEstreno   Año o identificador numérico del modelo
     * @param capacidadCarga Capacidad de carga en kilogramos
     * @param conductor      Conductor asignado
     */
    public Vehiculo(String placa, String marca, int fechaEstreno, double capacidadCarga, Conductor conductor) {
        this.placa = placa != null ? placa : "";
        this.marca = marca;
        this.fechaEstreno = fechaEstreno;
        this.capacidadCarga = capacidadCarga;
        this.conductor = conductor;
    }


    public String getPlaca() { return placa; }
    public String getMarca() { return marca; }
    public String getModelo() { return String.valueOf(fechaEstreno); }
    public int getFechaEstreno() { return fechaEstreno; }
    public double getCapacidadCarga() { return capacidadCarga; }
    public Conductor getConductor() { return conductor; }


    public void setPlaca(String placa) { this.placa = placa; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { try { this.fechaEstreno = Integer.parseInt(modelo); } catch (Exception ignored) {} }
    public void setFechaEstreno(int fechaEstreno) { this.fechaEstreno = fechaEstreno; }
    public void setCapacidadCarga(double capacidadCarga) { this.capacidadCarga = capacidadCarga; }
    public void setConductor(Conductor conductor) { this.conductor = conductor; }

    /**
     * Método abstracto que debe ser implementado en las subclases
     * (por ejemplo, Bus o Camión) para mostrar su información completa.
     */
    public abstract void mostrarInformacion();

    /**
     * Representación genérica del vehículo.
     *
     * @return información básica del vehículo en texto.
     */
    @Override
    public String toString() {
         return "Vehiculo [placa=" + placa + ", marca=" + marca + ", modelo=" + getModelo() +
             ", capacidadCarga=" + capacidadCarga + ", conductor=" + conductor + "]";
    }

}
