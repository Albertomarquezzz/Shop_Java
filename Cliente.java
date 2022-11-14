package Examen;

public class Cliente {

	private String Nombre;
	private double precio_total_gastado;
	
	public Cliente(String nombre, double precio_total_gastado) {
		super();
		Nombre = nombre;
		this.precio_total_gastado = precio_total_gastado;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public double getPrecio_total_gastado() {
		return precio_total_gastado;
	}

	public void setPrecio_total_gastado(double precio_total_gastado) {
		this.precio_total_gastado = precio_total_gastado;
	}

	@Override
	public String toString() {
		return "Cliente [Nombre=" + Nombre + ", precio_total_gastado=" + precio_total_gastado + "]";
	}
	
}
