package model;

public class Aluno {
	private String matricula;
	private String nome;
	private String email;
	private int    idade;
	private String sexo;
	private String empresa;
	private String cidade;

	public Aluno(String matricula, String nome, String email, int idade, String sexo, String empresa, String cidade) {
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.sexo = sexo;
		this.empresa = empresa;
		this.cidade = cidade;
	}

	public Aluno(String nome, String email, int idade, String cidade) {
		this.matricula = "";
		this.nome = nome;
		this.email = email;
		this.idade = idade;
		this.sexo = "";
		this.empresa = "";
		this.cidade = cidade;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public int getIdade() {
		return idade;
	}

	public String getSexo() {
		return sexo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public String getCidade() {
		return cidade;
	}


	public String toString2() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", email=" + email + ", idade=" + idade + ", sexo="
				+ sexo + ", empresa=" + empresa + ", cidade=" + cidade + "]";
	}

//	@Override
	public String toString() {
        System.out.printf(" %-12s%-35s %-35s %7d %-6s %-20s %-20s",matricula,nome,email,idade,sexo,empresa,cidade);
		return "";
	}

	public static void header00(int nc, String msg) {
		System.out.println(snf.Tools.repeatStr("=", nc));
		System.out.println(msg);
		System.out.println(snf.Tools.repeatStr("=", nc));
	}
	
	public static void header01(int nc) {
		System.out.printf("%-11s %-35s %-35s %-6s %-6s %-20s %-20s%1s\n","| Matrícula","| Nome","| Email","| Idade","| Sexo","| Empresa","| Cidade","|");
		System.out.println(snf.Tools.repeatStr("=", nc));
	}


}
