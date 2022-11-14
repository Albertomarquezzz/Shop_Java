package Examen;

import java.util.Comparator;

public class OrdenarPorPrecio implements Comparator<Digimon>{

	@Override
	public int compare(Digimon o1, Digimon o2) {
		return (int) (o2.getPrecio_venta()-o1.getPrecio_venta());
	}

}
