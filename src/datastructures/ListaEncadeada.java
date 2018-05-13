package datastructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

import comparators.SearchByRegistration;
import interfaces.Predicado;
import model.Aluno;
import interfaces.Iterador;

public class ListaEncadeada<T> implements Iterador<T>{
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
	
	public void addFirst(T dado) {
		Node<T> newNode = new Node<T>(dado, null, this.head);
		if(isEmpty()) {
			this.tail = newNode;
		} else {
		head.setPrevious(newNode);
		}
		this.head = newNode;
	}
	
	public T search(T key, Comparator<T> cmp) {
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

				// Inclusão ordenada
				le.sortedInsert(a, new SearchByRegistration());
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			snf.Tools.closeReader(is);
		}
		return le;
	}
	
	public static ListaEncadeada<Aluno> loadFromFile(FileReader arquivo, Comparator<Aluno> cmp) {
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

				// Inclusão ordenada
				le.sortedInsert(a, cmp);
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

	private void sortedInsert(T key, Comparator<T> cmp) {
		if (this.isEmpty())
			this.append(key);
		else {
			Node<T> i = this.head;
			T obj = null;
			boolean fi = false;
			while (i != null) {
				obj = i.getData();
				if (cmp.compare(key, obj) < 0) {
					this.insertBefore(i, key);
					fi = true;
					break;
				}
				i = i.getNext();
			}

			if (!fi) {
				this.append(key);
			}
		}
	}

	public void removeIf(Predicado<T> predicado) {
		Node<T> i = head;
		T obj = null;
		while (i != null) {
			obj = i.getData();
			if (predicado.teste(obj)) {
				this.remove(i);
			}
			i = i.getNext();
		}
	}
	
	public void remove(Node<T> node) {
		while (!isEmpty()) {
			Node<T> p = node.getPrevious();
			Node<T> n = node.getNext();

			// Caso o nó excluído seja head ou tail
			if (node == this.head)
				this.head = n;
			if (node == this.tail)
				this.tail = p;

			// Excluindo
			p.setNext(n);
			n.setPrevious(p);
			break;
		}
	}

	public ListaEncadeada<T> filter(Predicado<T> predicado) {
		ListaEncadeada<T> le = new ListaEncadeada<T>();
		Node<T> i = this.head;
		T obj = null;
		while (i != null) {
			obj = i.getData();
			if (predicado.teste(obj)) {
				le.append(obj);
			}
			i = i.getNext();
		}
		return le;
	}

	public void insertBefore(Node<T> Node, T dado) {
		if(Node == this.head)
			this.addFirst(dado);
		else if (Node == null)
			this.append(dado);
		else {
			Node<T> newNode = new Node<T>(dado, Node.getPrevious(), Node);
			Node.getPrevious().setNext(newNode);;
			Node.setPrevious(newNode);
		}
	}

	public void insertAfter(Node<T> Node, T dado) {
		if(Node == this.tail || Node == null)
			this.append(dado);
		else {
			Node<T> newNode = new Node<T>(dado, Node, Node.getNext());
			Node.getNext().setPrevious(newNode);;
			Node.setNext(newNode);
		}
	}

	// Implemenção da interface Iterador

	@Override
	public Iterador<T> iterador() {
		this.cursor = head;
		return this;
	}

	@Override
	public boolean hasNext() {
		return this.cursor != null;
	}

	@Override
	public boolean hasPrevious() {
		return this.cursor != null;
	}

	@Override
	public T next() {
		T obj = cursor.getData();
		cursor = cursor.getNext();
		return obj;		
	}

	@Override
	public T previous() {
		T obj = cursor.getData();
		cursor = cursor.getPrevious();
		return obj;		
	}

	@Override
	public void addBefore(T dado) {
		insertBefore(this.cursor, dado);
	}

	@Override
	public void addAfter(T dado) {
		insertAfter(this.cursor, dado);
	}

	@Override
	public void remove() {
		if (this.cursor != null) 
			this.remove(cursor);
	}

}  //---------------
