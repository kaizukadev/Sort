package predicates;

import interfaces.Predicado;
import model.Aluno;

public class NamePredicate implements Predicado<Aluno> {
	String p_nome;
	public NamePredicate(String name) {
		this.p_nome = name;
	}

	@Override
	public boolean teste(Aluno objeto) {
		return objeto.getNome().equalsIgnoreCase(p_nome);
	}
}
