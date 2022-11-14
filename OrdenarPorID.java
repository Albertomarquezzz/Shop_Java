package Examen;

import java.util.Comparator;

public class OrdenarPorID implements Comparator<Digimon>{

	@Override
	public int compare(Digimon o1, Digimon o2) {
		return (int) (o1.getId()-o2.getId());
	}

}
