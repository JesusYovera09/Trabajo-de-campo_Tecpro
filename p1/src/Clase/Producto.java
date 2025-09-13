package Clase;

public class Producto {
private int cod;
private String Categoria;
private double Precio;
private int stock;
public Producto(int cod, String categoria, double precio, int stock) {
	this.cod = cod;
	Categoria = categoria;
	Precio = precio;
	this.stock = stock;
}
public int getCod() {
	return cod;
}
public void setCod(int cod) {
	this.cod = cod;
}
public String getCategoria() {
	return Categoria;
}
public void setCategoria(String categoria) {
	Categoria = categoria;
}
public double getPrecio() {
	return Precio;
}
public void setPrecio(double precio) {
	Precio = precio;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}

}
	

