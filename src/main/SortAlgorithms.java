/*
 * FACULDADE SENAC PORTO ALEGRE
 * Curso.....: Tecnologia em Análise e Desenvolvimento de Sistemas
 * Aluno.....: 631710016 - Sérgio Nunes Ferreira
 * Disciplina: Algoritmos e Programação III - 2018/1
 * Professor.: RAFAEL GUTERRES JEFFMAN
 * 
 * Atividade.: Primeiro Trabalho e APS01
 * 
 * Objetivo..: 
 * 
 * Desenvolver uma classe de lista duplamente encadeada que permite armazenar tipos de 
 * dados genéricos, e pode ter seus elementos ordenados de forma arbitrária.
 * 
 * Tarefas:
 * 
 * - Implementar uma classe que represente uma lista duplamente encadeada.
 * 
 * - Implementar nesta classe um método “efficientSort” que aceite como parâmetro 
 *   um objeto que representa o método de comparação entre dois elementos armazenados 
 *   na lista, e implementa um dos algoritmos eficientes de ordenação.
 *   
 *   - Implementar nesta classe um método “stableSort” que aceite como parâmetro um 
 *     objeto que representa o método de comparação entre dois elementos armazenados 
 *     na lista, e implementa um método de ordenação estável, que não altera a ordem das chaves.
 *     
 * - Escreva um programa de teste para a lista que mostre que os dois algoritmos de ordenação funcionam corretamente.
 *
 */

package main;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import comparators.SortedByName;
import datastructures.ListaEncadeada;
import model.Aluno;

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
		ListaEncadeada<Aluno> lista = ListaEncadeada.loadFromFile(arquivo);
//		ListaEncadeada<Aluno> lista = ListaEncadeada.loadFromFile(arquivo, new SortedByReading());
		lista.printObjects(" ** LISTA ENCADEADA - Original **");

		int [] vet = {4,6,9,8,1,3,5,2,0,7};
		System.out.println(Arrays.toString(vet));
		System.out.println(Arrays.toString(Sorters.insertionSort(vet)));
		
		Aluno a1 = new Aluno("001","Sérgio","aaa@gmail.com",53,"male","E1","C1");
		Aluno a2 = new Aluno("005","Antônio","bbb@gmail.com",22,"male","E2","C2");
		Comparator<Aluno> cmp = new SortedByName(); 
		System.out.println("\n" + cmp.compare(a1, a2));
		
		
//		lista.stableSort(new SortedByName());
//		lista.printObjects(" ** LISTA ENCADEADA - Classificada por Insertion Sort **");
		
		
	}
}