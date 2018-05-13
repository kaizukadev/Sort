package comparators;

import java.util.Comparator;

import model.Aluno;

public class SearchByName implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return o1.getNome().compareTo(o2.getNome());
	}
}

