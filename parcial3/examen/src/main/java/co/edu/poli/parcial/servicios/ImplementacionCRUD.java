package co.edu.poli.parcial.servicios;

import co.edu.poli.parcial.model.Vehiculo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio CRUD con serialización binaria (.dat)
 * para Pelicula y Serie.
 *
 * Guarda y carga automáticamente desde el archivo data.dat
 */
public class ImplementacionCRUD {

    private List<Vehiculo> lista;
    private final String archivo = "data.dat";

    public ImplementacionCRUD() {
        lista = new ArrayList<>();
        cargarArchivo();
    }

    /**
     * Guarda toda la lista completa en el archivo .dat
     */
    public void guardarArchivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(lista);
            System.out.println("Archivo guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    /**
     * Carga los datos del archivo .dat si existe
     */
    @SuppressWarnings("unchecked")
    public void cargarArchivo() {
        File f = new File(archivo);
        if (!f.exists()) {
            System.out.println("No existe data.dat, se creará al guardar.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            lista = (ArrayList<Vehiculo>) ois.readObject();
            System.out.println("Datos cargados correctamente.");
        } catch (Exception e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
        }
    }

    /**
     * Crea un nuevo registro
     */
    public void crear(Vehiculo p) {
        lista.add(p);
        guardarArchivo();
    }

    /**
     * Busca por código único
     */
    public Vehiculo buscarPorPlaca(String placa) {
    for (Vehiculo p : lista) {
        if (p.getPlaca() != null && p.getPlaca().equalsIgnoreCase(placa)) {
            return p;
        }
    }
    return null;
}


    /**
     * Devuelve la lista completa
     */
    public List<Vehiculo> listarTodos() {
        return lista;
    }

    /**
     * Modifica un registro existente
     */
   public boolean modificar(String placa, Vehiculo nuevo) {
    for (int i = 0; i < lista.size(); i++) {
        if (lista.get(i).getPlaca() != null &&
            lista.get(i).getPlaca().equalsIgnoreCase(placa)) {
            
            lista.set(i, nuevo);
            guardarArchivo();
            return true;
        }
    }
    return false;
}


    /**
     * Elimina un registro
     */
    public boolean eliminar(String placa) {
        Vehiculo p = buscarPorPlaca(placa);
        if (p != null) {
            lista.remove(p);
            guardarArchivo();
            return true;
        }
        return false;
    }
}
