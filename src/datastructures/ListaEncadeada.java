package datastructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import comparators.SortedByName;
import model.Aluno;


public class ListaEncadeada<T>{
	private Node<T> head;
	private Node<T> tail;
	private Node<T> cursor;
	
	public ListaEncadeada() {
		this.head = null;
		this.tail = null;
		this.cursor = null;
	}  

	public void append(T dado) {
		Node<T> newNode = new Node<T>(dado, this.tail, null);
		if(isEmpty()) {
			this.head = newNode;
		} else {
		tail.setNext(newNode);
		}
		this.tail = newNode;
	}
	
	public void printObjects(String msg) {
		int nc=141;
		int ne=0;
		Aluno.header00(nc,msg);
		Aluno.header01(nc);
		
		Node<T> i = head;
		while (i != null) {
			System.out.println(i.getData());
			i = i.getNext();
			ne++;
		}
		System.out.println(snf.Tools.repeatStr("=", nc));
		System.out.println(" >> Total de Elementos da Lista Encadeada: " + ne + "\n\n");
	}

	public static ListaEncadeada<Aluno> loadFromFile(FileReader arquivo) {
		ListaEncadeada<Aluno> le = new ListaEncadeada<Aluno>();
		final String SEPARADOR = ",";
		BufferedReader is = null;
		String linha = null;
		String[] dl;
		is = new BufferedReader(arquivo);
		try {
			while ((linha = is.readLine()) != null) {
				dl = linha.split(SEPARADOR);
				Aluno a = new Aluno(dl[0], dl[1], dl[2], Integer.parseInt(dl[3]), dl[4], dl[5], dl[6]);
				le.append(a);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			snf.Tools.closeReader(is);
		}
		return le;
	}

	public boolean isEmpty() {
		return this.head == null && this.tail == null;   
	}

	public boolean hasNext() {
		return this.cursor != null;
	}
	
	public boolean hasPrevious() {
		return this.cursor != null;
	}

	public T next() {
		T obj = cursor.getData();
		cursor = cursor.getNext();
		return obj;		
	}

	public T previous() {
		T obj = cursor.getData();
		cursor = cursor.getPrevious();
		return obj;		
	}

	public void stableSort(SortedByName cmp) {
		while (!this.isEmpty()) {
			Node<T> key = this.head.getNext();		// Pega segundo elemento da lista
			Node<T> j, t;
			while (key != null) {
				j = key.getPrevious();

				while ( j != null && cmp.compare(j.getData(),key.getData()) > 0) {
					this.trocarNos(j,key);
			    }
				
				j.setNext(key);
				
				
			}
			
			

			
/*			
			
			//		System.out.println(i.getData());
	//		i = i.getNext();
			System.out.println(key.getData());
*/				
	
		}

	
		
/*		
		Node<T> i = head;
		T obj = null;
		while (i != null) {
			obj = i.getData();

			if (cmp.compare(key,obj) == 0)
				break;
			
			i = i.getNext();
		}

		if (i == null) {
			snf.Tools.msg("** Objeto não foi localizado!\n");
			obj = null;
		}
		
		return obj;
	}
*/		
		
		
		
		
		
/*	
		public static int[] insertionSort(int arr[]) {
			int n = arr.length;
			for (int i=1; i<n; ++i) {
			    int key = arr[i];
			    int j = i-1;

			    while (j>=0 && arr[j] > key) {
			        arr[j+1] = arr[j];
			        j = j-1;
			    }
			    arr[j+1] = key;
			}
			return arr;
		}	
*/	
	
	
	
	
	
	
	
	}

	private void trocarNos(Node<T> j, Node<T> key) {
		Node<T> t; 
		if(j.getPrevious() == null) {
			t = key;
			key.setPrevious(null);
			key.setNext(j);
			j.setPrevious(key);
			j.setNext(key.getNext());
			t = null;
		}

		if(j.getPrevious() != null) {
			t = key;
			key.setPrevious(null);
			key.setNext(j);
			j.setPrevious(key);
			j.setNext(key.getNext());
			t = null;
		}

		
		
	}


	
	
	
	
	
	
	
	
	
	
	

}  //---------------
