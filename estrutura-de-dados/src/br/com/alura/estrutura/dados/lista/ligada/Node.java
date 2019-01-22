package br.com.alura.estrutura.dados.lista.ligada;

//O nó da lista é representado por:
//	*A informação armazenada
//	*A referência (ponteiro) para o próximo elemento da lista.

//Nó ou Célula
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