package br.com.alura.estrutura.dados.lista.ligada;

public class ListaLigada {
	private Node first;
	private int size;
	private Node last;

	public void addFirst(Object element) {
		Node newNode = new Node(first, element);
		this.first = newNode;
		if (size == 0)
			this.last = this.first;
		size++;
	}

	public void addLast(Object element) {
		if (isEmpty())
			addFirst(element);
		else {
			Node newNode = new Node(element);
			last.setNext(newNode);
			last = newNode;
			size++;
		}
	}

	public void add(int position, Object element) {
		if (size == 0)
			addFirst(element);
		else if (position == size) {
			addLast(position);
		} else {
			Node previous = getNode(position - 1);
			Node newNode = new Node(previous.getNext(), element);
			previous.setNext(newNode);
			size++;
		}
	}

	public void rangeCheck(int position) {
		if (!(position >= 0 || position < size))
			throw new IllegalArgumentException("Posição inválida!");
	}

	public Node getNode(int position) {
		rangeCheck(position);
		Node current = first;
		for (int i = 0; i < position; i++) {
			current = current.getNext();
		}
		return current;
	}

	public Object get(int position) {
		return getNode(position).getElement();
	}

	public void removeFirst() {
		rangeCheck(size - 1);
		first = first.getNext();
		if ((--size) == 0)
			last = null;
	}

	public void removeLast() {
		if (size == 1)
			removeFirst();
		rangeCheck(size - 1);
		Node previous = getNode(size - 2);
		previous.setNext(last.getNext());
		last = previous;
		--size;
	}

	public void remove(int position) {
		rangeCheck(position);
		if (position == size - 1)
			removeLast();
		else if(position == 1)
			removeFirst();
		else {
			Node previous = getNode(position - 1);
			Node current = getNode(position);
			previous.setNext(current.getNext());
			current.setNext(last.getNext());
			current = last.getNext();
			size--;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(Object element) {
		return indexOf(element) >= 0;
	}

	public int indexOf(Object element) {
		if(first.equals(element))
			return 0;
		else if(last.equals(element))
			return size - 1;
		Node current = first;
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (current.equals(element))
					return i;
				current.getNext();
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (current.equals(element)) {
					return i;
				}
			}
		}
		return -1;
	}

	public String toString() {
		if(isEmpty())
			return "[]";
		Node current = first;
		StringBuilder builder = new StringBuilder("[");
		for (int i = 0; i < size - 1; i++) {
			builder.append(current.getElement());
			builder.append(", ");
			current = current.getNext();
		}
		if (size > 0)
			builder.append(last.getElement());
		builder.append("]");

		return builder.toString();
	}
}