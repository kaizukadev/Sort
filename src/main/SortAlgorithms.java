/*
 * FACULDADE SENAC PORTO ALEGRE
 * Curso.....: Tecnologia em An�lise e Desenvolvimento de Sistemas
 * Aluno.....: 631710016 - S�rgio Nunes Ferreira
 * Disciplina: Algoritmos e Programa��o III - 2018/1
 * Professor.: RAFAEL GUTERRES JEFFMAN
 * 
 * Atividade.: Primeiro Trabalho e APS01
 * 
 * Objetivo..: 
 * 
 * Desenvolver uma classe de lista duplamente encadeada que permite armazenar tipos de 
 * dados gen�ricos, e pode ter seus elementos ordenados de forma arbitr�ria.
 * 
 * Tarefas:
 * 
 * - Implementar uma classe que represente uma lista duplamente encadeada.
 * 
 * - Implementar nesta classe um m�todo �efficientSort� que aceite como par�metro 
 *   um objeto que representa o m�todo de compara��o entre dois elementos armazenados 
 *   na lista, e implementa um dos algoritmos eficientes de ordena��o.
 *   
 *   - Implementar nesta classe um m�todo �stableSort� que aceite como par�metro um 
 *     objeto que representa o m�todo de compara��o entre dois elementos armazenados 
 *     na lista, e implementa um m�todo de ordena��o est�vel, que n�o altera a ordem das chaves.
 *     
 * - Escreva um programa de teste para a lista que mostre que os dois algoritmos de ordena��o funcionam corretamente.
 *
 */

package main;

import java.io.FileReader;
import java.util.Arrays;

import comparators.SearchByAgeAndCity;
import comparators.SearchByEmail;
import comparators.SearchByName;
import comparators.SortedByReading;
import datastructures.ListaEncadeada;
import interfaces.Iterador;
import model.Aluno;
import predicates.GenderAndAgePredicate;
import predicates.NamePredicate;

public class SortAlgorithms {

/*	
	private static final String name = "Francisca Bullock";
	private static final String email = "franciscabullock@glasstep.com";
	private static final int idade = 33;
	private static final String cidade = "Eastmont";
*/
	
	public static void main(String[] args) {

		String arqCSV = "data/alunos.csv";

		FileReader arquivo = snf.Tools.leitorArquivo(arqCSV);
		ListaEncadeada<Aluno> lista = ListaEncadeada.loadFromFile(arquivo, new SortedByReading());
		lista.printObjects(" ** LISTA ENCADEADA - Original **");
		

		int [] vet = {4,6,9,8,1,3,5,2,0,7};
		System.out.println(Arrays.toString(vet));
		System.err.println(Arrays.toString(Sorters.insertionSort(vet)));
		
		
		
	}
}