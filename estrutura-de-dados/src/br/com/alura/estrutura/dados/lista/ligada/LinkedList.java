package br.com.alura.estrutura.dados.lista.ligada;

//Uma lista encadeada é uma representação de uma sequência de objetos, 
//todos do mesmo tipo, na memória RAM (= random access memory) do computador.

//Remoção de um elemento que está no meio da lista - 
//Se o elemento (por exemplo, X) está no meio de uma lista, 
//a remoção dele é basicamente acertar a referência proximo do elemento a esquerda 
//e fazê-lo apontar para o próximo de X.


public class LinkedList<T> {
	private transient Node<T> first;
	private transient Node<T> actual;
	private transient int size;
	private transient Node<T> last;

	// CTRL + F = Find

	public void addFirst(T element) {
		Node<T> newNode = new Node<T>(first, element);
		first = newNode;
		if ( size == 0)
			last = first;
		size++;
	}

	public void addLast(T element) {
		if (size == 0)
			addFirst(element);
		else {
			Node<T> newNode = new Node<T>(last.getNext(), element);
			last.setNext(newNode);
			last = newNode;
			size++;
		}
	}

	public void add(int position, T element) {
		if (isEmpty())
			addFirst(element);
		else if (position == size)
			addLast(element);
		else {
			rangeCheck(position);
			Node<T> previous = getNode(position - 1);
			Node<T> newNode = new Node<T>(previous.getNext(), element);
			previous.setNext(newNode);
			size++;
		}
	}

	private void rangeCheck(int position) {
		if (!(position >= 0 || position < size))
			throw new IllegalArgumentException("Posição inválida!");
	}

	private Node<T> getNode(int index) {
		rangeCheck(index);
		Node<T> current = first;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}

	public T get(int position) {
		return actual.getElement();
	}

	public void removeFirst() {
		rangeCheck(size - 1);
		first = first.getNext();
		if (--size == 0)
			last = first;
	}

	public void removeLast() {
		if (size == 1)
			removeFirst();
		Node<T> previous = getNode(size - 2);
		previous.setNext(last.getNext());
		last = previous;
		--size;
	}

	public void remove(int position) {
		if (size == 1)
			removeFirst();
		else if (size - 1 == position)
			removeLast();
		else {
			Node<T> current = getNode(position);
			Node<T> previous = getNode(position - 1);
			previous.setNext(current.getNext());
			current.setNext(last.getNext());
			current = null;
			--size;
		}
	}

	public void remove(T element) {
		remove(indexOf(element));
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(T element) {
		return indexOf(element) >= 0;
	}

	public int size() {
		return size;
	}

	public int indexOf(T element) {
		if (first.getElement().equals(element))
			return 0;
		else if (last.getElement().equals(element))
			return size - 1;

		Node<T> current = first;
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (current.getElement().equals(element))
					return i;
				current = current.getNext();
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (current.getElement().equals(element))
					return i;
				current = current.getNext();
			}
		}
		return -1;
	}
	
	public T get() {
		return actual.getElement();
	}

	public boolean hasNext() {
		if (first == null)
			return false;
		else if (actual == null) {
			actual = first;
			return true;
		}
		else {
			boolean hasNext = this.actual.getNext() != null ? true : false;
			this.actual = this.actual.getNext();
			return hasNext;
		}
	}

	public String toString() {
		if (size == 0)
			return "[]";
		StringBuilder builder = new StringBuilder("[");
		while (hasNext()) {
			builder.append(actual.getElement());
			builder.append(", ");
		}
		return removeLastDelimiter(builder) + "]";
	}

	private String removeLastDelimiter(CharSequence builder) {
		String regex = builder.toString();
		return regex.substring(0, regex.length() - 2);
	}
}