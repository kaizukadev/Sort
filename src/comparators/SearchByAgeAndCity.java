package comparators;

import java.util.Comparator;

import model.Aluno;

public class SearchByAgeAndCity implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		int ret = 0;
		if (o1.getIdade() != o2.getIdade())
			ret = Integer.toString(o1.getIdade()).compareTo(Integer.toString(o2.getIdade()));
		else ret = o1.getCidade().compareTo(o2.getCidade());
		
		return ret;
	}
}

