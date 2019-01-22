package br.com.alura.estrutura.dados;

public class Vector {
	private Object[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	private int length;

	public Vector(int initialCapacity) {
		if (initialCapacity <= 0)
			elements = new Object[DEFAULT_CAPACITY];
		elements = new Object[initialCapacity];
		length = 0;
	}

	public Vector() {
		elements = new Object[DEFAULT_CAPACITY];
		length = 0;
	}

	public Vector(Object[] elements) {
		if (elements == null)
			throw new NullPointerException("Elementos inválidos!!");
		this.elements = elements;
		length = elements.length;
	}

	public boolean adiciona(Object element) {
		ensureCapacity();
		elements[length] = element;
		length++;
		return true;
	}

	// Overload
	public boolean adiciona(int index, Object element) {
		rangeCheckForAdd(index);
		ensureCapacity();

		push(index);
		elements[index] = element;
		length++;
		return true;
	}

	private void rangeCheckForAdd(int index) {
		if (!(index >= 0 || index < length))
			// Exceção para um tipo de argumento que é inválido
			throw new IllegalArgumentException("Posição inválida!");
	}

	private void rangeCheck(int index) {
		if (index >= length)
			throw new IllegalArgumentException("Posição inválida!");
	}

	private void increasesCapacity() {
		// Dobrando a capacidade do vetor.
		Object[] newElements = new Object[length * 2];
		for (int i = 0; i < length; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
	}
	
	private void ensureCapacity() {
		if (length == this.elements.length)
			increasesCapacity();
	}

	public boolean remove(int index) {
		rangeCheck(index);

		for (int i = index; i < length - 1; i++) {
			elements[i] = elements[i + 1];
		}
		elements[length] = null;
		length--;
		return true;
	}

	private void push(int position) {
		for (int i = length - 1; i >= position; i--) {
			elements[i + 1] = elements[i];
		}
	}

	public int size() {
		return this.length;
	}

	public Object get(int index) {
		rangeCheckForAdd(index);
		return elements[index];
	}

	public int contains(Object element) {
		for (int i = 0; i < length; i++) {
			if (element.equals(elements[i]))
				return i;
		}
		return -1;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		for (int i = 0; i < length - 1; i++) {
			sb.append(elements[i]);
			sb.append(", ");
		}
		if (length > 0)
			sb.append(elements[length - 1]);

		sb.append("]");
		return sb.toString();
	}
}