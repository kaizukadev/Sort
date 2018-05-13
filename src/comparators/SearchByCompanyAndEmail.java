package comparators;

import java.util.Comparator;

import model.Aluno;

public class SearchByCompanyAndEmail implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		int ret = 0;
		if (o1.getEmpresa() != o2.getEmpresa())
			ret = o1.getEmpresa().compareTo(o2.getEmpresa());
		else ret = o1.getEmail().compareTo(o2.getEmail());
	
		return ret;
	}
}

