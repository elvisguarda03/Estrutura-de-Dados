package br.com.alura.estrutura.dados;

//Um vetor (ou array) é a estrutura de dados mais simples que existe.

public class Vetor {
	private String[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	private int length = 0;

	public Vetor(int initialCapacity) {
		if (initialCapacity <= 0)
			elements = new String[DEFAULT_CAPACITY];
		else
			elements = new String[initialCapacity];
	}

	public Vetor() {
		elements = new String[DEFAULT_CAPACITY];
	}

	public Vetor(String[] elements) {
		if (elements == null)
			throw new NullPointerException("Elementos não foram cadastados!");
		this.elements = elements;
		length = elements.length;
	}

//	public void adiciona(String element) {
//		//O(n) não é uma solução constante, algoritmo ineficiente
//		for(int i = 0; i < element.length(); i+=1) {
//			if(elements[i] == null) {
//				elements[i] = element;
//				break;
//			}
//		}
//	}

	public boolean adiciona(String element) {
		ensureCapacity();
		elements[length] = element;
		length++;
		return true;
	}

	// Overload
	public boolean adiciona(int index, String element) {
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
		String[] newElements = new String[length * 2];
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
		elements[--length] = null;
		return true;
	}

	private void push(int position) {
//		A próxima casa recebe o valor da casa anterior.
		for (int i = length - 1; i >= position; i--) {
			elements[i + 1] = elements[i];
		}
	}

	public int size() {
		return this.length;
	}

	public String get(int index) {
		rangeCheckForAdd(index);
		return elements[index];
	}

	// Algoritmo de busca sequencial (iterar posição por posição)
	public int contains(String element) {
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
		// return Arrays.toString(elements);
	}
}
