package br.com.alura.estrutura.dados.lista.ligada;

//O n� da lista � representado por:
//	*A informa��o armazenada
//	*A refer�ncia (ponteiro) para o pr�ximo elemento da lista.

//N� ou C�lula
public class Node<T> {
	private T element;
	private Node<T> next;
	
	public Node(Node<T> next, T element) {
		this.element = element;
		this.next = next;
	}
	
	public Node(T element) {
		this.element = element;
		this.next = null;
	}

	public Node<T> getNext() {
		return next;
	}
	
	public void setNext(Node<T> proxima) {
		this.next = proxima;
	}
	
	public T getElement() {
		return element;
	}	
}