package arreglo;

import java.util.ArrayList;

import clase.Estudiante;

public class ArregloEstudiantes {
    private ArrayList<Estudiante> lista;

    public ArregloEstudiantes() {
        lista = new ArrayList<>();
    }

    public void agregar(Estudiante e) {
        lista.add(e);
    }

    public void eliminar(String codigo) {
        lista.removeIf(e -> e.getCodigo().equals(codigo));
    }

    public Estudiante buscar(String codigo) {
        for (Estudiante e : lista) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }
        return null;
    }

    public ArrayList<Estudiante> listar() {
        return lista;
    }
}