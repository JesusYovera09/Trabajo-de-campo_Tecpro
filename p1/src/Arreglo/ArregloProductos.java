package Arreglo;

import java.util.ArrayList;

import Clase.Producto;

public class ArregloProductos {
private ArrayList<Producto>pro;
public ArregloProductos() {
	pro=new ArrayList<Producto>();
	Adicionar(new Producto(2020, "laptop", 2000, 2));
	Adicionar(new Producto(2382, "laptop", 2000, 2));
	

}
public void Adicionar(Producto x) {
	pro.add(x);
}
public int Tamaño() {
	return pro.size();
}
public Producto Obtener(int x) {
	return pro.get(x);
}
public Producto Buscar(int cod) {
    for (int i = 0; i < Tamaño(); i++) {
        if (Obtener(i).getCod() == cod) {
            return Obtener(i); 
        }
    }
    return null; 
}
public void Eliminar(Producto x)
{
	pro.remove(x);
}

public Producto BuscarCate(String  categoria) 
{
	 
	 for(int i=0; i<Tamaño(); i++)
	 {
		 if (Obtener(i).getCategoria().equalsIgnoreCase(categoria)){
			 return Obtener(i);
		 }
	 }
	 return null;
	 
}
public void limpiar()
{
	pro.clear();
}
}



