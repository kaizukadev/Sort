package comparators;

import java.util.Comparator;

import model.Aluno;

public class SearchByRegistration implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return o1.getMatricula().compareTo(o2.getMatricula());
	}
}

