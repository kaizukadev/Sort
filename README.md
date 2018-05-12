![FinalResult](/data/FR.jpg)
Primeiro Trabalho e APS01
==========================

## Objetivo:

Desenvolver uma classe de lista duplamente encadeada que permite armazenar tipos de dados genéricos, e pode ter seus elementos ordenados de forma arbitrária.

## Obtenção do Código:

Crie um "fork" do repositório do trabalho, encontrado no link:

	https://github.com/rafasgj/Algoritmos2-TrabalhoFinal.git

## Tarefas obrigatórias:

Você deve, para obter o conceito C, implementar as seguintes 
funcionalidades:

- ~~Implementar uma lista duplamente encadeada que utilize Generics para 
garantir o armazenamento de objetos de um tipo específico.~~

- ~~A lista deve permitir a procura de elementos por qualquer atributo 
presente no objeto.~~

- ~~A lista deve permitir que a procura de elemntos possa ser realizada a 
partir de dois ou mais campos do objeto armazenado.~~

- ~~A lista deve conter um método para imprimir, no console, todos os 
objetos armazenados.~~

- ~~Na inicialização programa que armazena objetos do tipo Aluno, você 
deve carregar o arquivo de dados CSV, em anexo.~~

Para obter o conceito B, você deve implementar todos os items para 
obter o conceito C, e mais:

- ~~Implementar um método para remover um objeto específico da lista.~~

- ~~Implementar um método para remover todos os objeto que forem 
compatíveis com um predicado.~~

- ~~Você deve inserir um método que crie um filtro para a lista 
encadeada, criado uma nova lista encadeada com os objetos aceitos pelo 
filtro provido. O filtro pode ser criado para qualquer campo, ou 
vários, do objeto armazenado.~~

- ~~Você deve modificar a carga dos dados do arquivo CSV, de forma que a 
lista fique ordenada pelo "número de matrícula".~~

Para obter o conceito A, você deve implementar todas as funcionalidades 
para obter o conceito B, e ao menos um dos dois métodos:

- ~~Implementar o conceito de "Iterador" na lista, de forma que se possa 
adicionar objetos a partir do iterador.~~

- ~~Alterar a lista para que seja possível carregar a lista do arquivo 
ordenando a partir de um atributo qualquer.~~

## Interfaces:

As interfaces públicas das classes não podem ser modificadas, apenas 
métodos privados das classes podem adicionados.

Para obter o conceito C, você deve implementar uma lista encadeada com 
a seguinte interface pública:

```java
class ListaEncadeada<T> {
	public void append(T dado);
	public void addFirst(T dado);
	public T search(T key, Comparator<T> cmp);
	public void printObjects();
	public static ListaEncadeada<T> loadFromFile(InputStream input);
}
```

Para obter o conceito B, a lista deve possuir a seguinte interface 
pública:

```java
class ListaEncadeada<T> {
	public void append(T dado);
	public void addFirst(T dado);
	public T search(T key, Comparator<T> cmp);
	public void printObjects();
	public static ListaEncadeada<T> loadFromFile(InputStream input);

	public void remove();
	public void removeIf(Predicado<T> predicado);
	public ListaEncadeada<T> filter(Predicado<T> predicado);
}
```

Para implementar esta versão será necessária a interface Filtro:

```java
interface Predicado<T> {
	boolean teste(T objeto);
}
```

Para obter o conceito A, a lista deve possuir a seguinte interface 
pública:

```java
class ListaEncadeada<T> {
	public void append(T dado);
	public void addFirst(T dado);
	public T search(T key, Comparator<T> cmp);
	public void printObjects();
	public static ListaEncadeada<T> loadFromFile(InputStream input);
	public ListaEncadeada<T> filter(Filtro<T> filtro);

	public static ListaEncadeada<T> loadFromFile(InputStream input, 
Comparator<T> cmp);
	public Iterador<T> iterator();
}
```

Para implementar esta versão será necessária a interface Iterador:

```java
interface Iterador<T> {
	boolean hasNext();
	boolean hasPrevious();
	T next();
	T previous();
	void addBefore(T dado);
	void addAfter(T dado);
	void remove();
}
```

## Restrições:

- A lista encadeada não pode utilizar índices, ou armazenar o número de 
elementos armazenados na mesma.

- Nenhuma classe de armazenamento de dados de Java pode ser utilizada 
no desenvolvimento da classe ListaEncadeada.

- Os programas disponibilizados devem ser utilizados para testar a sua 
implementação.

## Formato do Arquivo CSV:

O arquivo CSV contém os dados de um objeto aluno por linha, separados 
por vírgula, com os seguintes campos, na ordem que aparecem:

	- Matricula
	- Nome
	- Email
	- Idade
	- Sexo
	- Empresa
	- Cidade



Tarefas:
Implementar uma classe que represente uma lista duplamente encadeada.
Implementar nesta classe um método “efficientSort” que aceite como parâmetro um objeto que representa o método de comparação entre dois elementos armazenados na lista, e implementa um dos algoritmos eficientes de ordenação.
Implementar nesta classe um método “stableSort” que aceite como parâmetro um objeto que representa o método de comparação entre dois elementos armazenados na lista, e implementa um método de ordenação estável, que não altera a ordem das chaves.
Escreva um programa de teste para a lista que mostre que os dois algoritmos de ordenação funcionam corretamente.
Entrega
Deve ser criado um repositório no Github para a entrega deste trabalho, e o link para acesso ao repositório deve ser inserido no campo de comentários do Blackboard, quando da entrega.

Atividade Prática Supervisionada
Além do primeiro conceito, este trabalho irá contar como uma APS de 6h (equivalente a DUAS aulas).

OBSERVAÇÃO: O trabalho deve ser entregue até ANTES da aula marcada para a entrega.


RS-20181-FSPOA-ALPR-PRE-ADS3N18-1
(Algoritmos e Programação III (ADS3N18-1))
