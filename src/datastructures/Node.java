package datastructures;

public class Node<T> {
  private final T data;
  private Node<T> previous;
  private Node<T> next;

  public Node(T data, Node<T> previous, Node<T> next ) {
	this.data = data;
	this.previous = previous;
	this.next = next;
  }

  public T getData() {
	  return data;
  }

  public Node<T> getNext() {
	  return next;
  }

  public Node<T> getPrevious() {
	  return previous;
  }

  public void setNext(Node<T> next) {
	  this.next = next;
  }

  public void setPrevious(Node<T> previous) {
	  this.previous = previous;
  }


}
