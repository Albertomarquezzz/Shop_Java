package Examen;

import java.util.Comparator;

public class OrdenarPorNombre implements Comparator<Digimon>{

	@Override
	public int compare(Digimon o1, Digimon o2) {
		return o1.getNombre().compareTo( o2.getNombre() );
	}

}
