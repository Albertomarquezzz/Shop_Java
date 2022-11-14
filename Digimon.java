package Examen;

public class Digimon implements Comparable<Digimon>{
	
	private static int total=0;
	private int id;
	private String nombre;
	private double precio_venta;
	private double precio_compra;
	private static double iva=21;
	private int stock;
		
	public Digimon(int id, String nombre, double precio_venta, double precio_compra, double iva, int stock) {
		super();
		this.id = total;
		total++;
		this.nombre = nombre;
		this.precio_venta = (precio_compra+0.5)+ (precio_compra+0.5)*iva/100;
		this.precio_compra = precio_compra;
		this.iva = 21;
		this.stock = stock;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	public double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public double getIva() {
		return iva;
	}

	public boolean vender(int cantidad) {
		if (cantidad>stock) {
			System.out.println("Lo siento esa venta no se puede realizar");
			return false;
		}
		else {
			stock = stock-cantidad;
			return true;
		}
	}
	
	public boolean comprar(int cantidad) {
		stock = stock+cantidad;
		return true;
	}
	
	@Override
	public String toString() {
		return "Digimon [id=" + id + ", nombre=" + nombre + ", precio_venta=" + precio_venta + ", precio_compra="
				+ precio_compra + ", iva=" + iva + ", stock=" + stock + "]";
	}

	@Override
	public int compareTo(Digimon o) {
		if(this.getId()>o.getId()) {
			return 1;
		}
		else if(this.getId()<o.getId()) {
			return -1;
		}	
		else {
			if(this.nombre.charAt(0)>o.getNombre().charAt(0)) {
				return 1;
			}
			else if(this.nombre.charAt(0)<o.getNombre().charAt(0)) {
				return -1;
			}
			else {
				if(this.getPrecio_venta()>o.getPrecio_venta()) {
					return 1;
				}
				else if(this.getPrecio_venta()<o.getPrecio_venta()) {
					return -1;
				}
				else {
					return 0;
				}
			}
		}
	}
}
