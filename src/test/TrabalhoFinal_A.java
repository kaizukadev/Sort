/*
 * FACULDADE SENAC PORTO ALEGRE
 * Curso.....: Tecnologia em Análise e Desenvolvimento de Sistemas
 * Aluno.....: 631710016 - Sérgio Nunes Ferreira
 * Disciplina: Algoritmos e Programação II - 2017/2
 * Professor.: RAFAEL GUTERRES JEFFMAN
 * 
 * Atividade.: TRABALHO FINAL - CONCEITO "A"
 * 
 * Objetivo..: 
 * 
 * Para obter o conceito A, você deve implementar todas as funcionalidades 
 * para obter o conceito B, e ao menos um dos dois métodos:
 *
 * - Implementar o conceito de "Iterador" na lista, de forma que se possa 
 * adicionar objetos a partir do iterador.
 * 
 * - Alterar a lista para que seja possível carregar a lista do arquivo 
 * ordenando a partir de um atributo qualquer.
 *
 */

package test;

import java.io.FileReader;
import comparators.SearchByAgeAndCity;
import comparators.SearchByEmail;
import comparators.SearchByName;
import comparators.SortedByReading;
import datastructures.ListaEncadeada;
import interfaces.Iterador;
import model.Aluno;
import predicates.GenderAndAgePredicate;
import predicates.NamePredicate;

public class TrabalhoFinal_A {

	private static final String name = "Francisca Bullock";
	private static final String email = "franciscabullock@glasstep.com";
	private static final int idade = 33;
	private static final String cidade = "Eastmont";
	
	public static void main(String[] args) {

		// TRABALHO CONCEITO "C" =============================================
		String arqCSV = "data/alunos.csv";

		FileReader arquivo = snf.Tools.leitorArquivo(arqCSV);
		ListaEncadeada<Aluno> lista = ListaEncadeada.loadFromFile(arquivo, new SortedByReading());
		lista.printObjects(" ** LISTA ENCADEADA - Original - Ordenada por Leitura **");

		Aluno busca = new Aluno(name, email, idade, cidade);
		System.out.println("Dados para busca:");
		System.out.println(busca + "\n");
		
		
		System.out.println(">>> Busca por Nome:");
		System.out.println(lista.search(busca, new SearchByName()));
		System.out.println("");

		System.out.println(">>> Busca por Email:");
		System.out.println(lista.search(busca, new SearchByEmail()));
		System.out.println("");

		System.out.println(">>> Busca por Idade+Cidade:");
		System.out.println(lista.search(busca, new SearchByAgeAndCity()));
		System.out.println("");

		// TRABALHO CONCEITO "B" =============================================
		int nc=141;
		Aluno.header00(nc," Excluindo o seguinte objeto:");
		Aluno.header01(nc);
		System.out.println(lista.search(busca, new SearchByName()));
		lista.removeIf(new NamePredicate(name));
		
		System.out.println("\nTestando exclusão do objeto:");
		if (lista.search(busca, new SearchByName()) != null)
			System.out.println(name + " nao deveria estar na lista.");
		System.out.println(snf.Tools.repeatStr("=", nc));
		System.out.println("");

		arquivo = snf.Tools.leitorArquivo(arqCSV);
		lista = ListaEncadeada.loadFromFile(arquivo);
		lista.printObjects(" ** LISTA ENCADEADA - Ordenada por Matrícula **");

		// Lista nova, filtrada
		ListaEncadeada<Aluno> lista1 = lista.filter(new GenderAndAgePredicate("female", 20, 30));
		lista1.printObjects(" ** NOVA LISTA ENCADEADA - Filtrada - Mulheres entre 20 e 30 anos (inclusive) **");

		// TRABALHO CONCEITO "A" =============================================
		Iterador<Aluno> iterador = lista.iterador();
		while (iterador.hasNext()) {
			System.out.println(iterador.next().getEmail());
		}
		System.out.println("");

		// Lista nova, filtrada
		ListaEncadeada<Aluno> lista2 = lista.filter(new NamePredicate(name));
		lista2.printObjects(" ** NOVA LISTA ENCADEADA - Iterada **");

		Aluno a1 = lista2.search(busca, new SearchByName());
		Aluno a2 = new Aluno("a9583c8a","Yvonne Ayala","yvonneayala@pheast.com",38,"female","PHEAST","Chesterfield");
		Aluno a3 = new Aluno("79eb2f3e","Johnnie Bishop","johnniebishop@conjurica.com",22,"female","CONJURICA","Clay");
		
		iterador = lista2.iterador();
		while (iterador.hasNext()) {
			if (iterador.next() == a1) {
				iterador.addBefore(a3);
				iterador.addAfter(a2);
			}
		}

		lista2.printObjects(" ** NOVA LISTA ENCADEADA - Iterada - Inclusão com Iterador **");
		
		
	}
}