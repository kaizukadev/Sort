package predicates;

import interfaces.Predicado;
import model.Aluno;

public class GenderAndAgePredicate implements Predicado<Aluno> {
	String p_gender;
	int p_ageMin;
	int p_ageMax;
	
	public GenderAndAgePredicate(String p_gender, int p_ageMin, int p_ageMax) {
		this.p_gender = p_gender;
		this.p_ageMin = p_ageMin;
		this.p_ageMax = p_ageMax;
	}

	@Override
	public boolean teste(Aluno a) {
		return a.getSexo().equalsIgnoreCase(p_gender) &&
				(a.getIdade()>=p_ageMin && a.getIdade()<=p_ageMax);
	}
}
