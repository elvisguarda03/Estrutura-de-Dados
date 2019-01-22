package br.com.alura.estrutura.dados;

import java.lang.reflect.Array;

public class ListArray<T> implements java.io.Serializable {
	private static final long serialVersionUID = -468231407392174142L;
	private static final int DEFAULT_CAPACITY = 10;
	private T[] elementData;
	private int length;

	@SuppressWarnings("unchecked")
	public ListArray(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Capacidade inválida");
		elementData = (T[]) new Object[initialCapacity];
		length = 0;
	}

	public ListArray() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public ListArray(Class<T> classType, int initialCapacity) {
		elementData = (T[]) Array.newInstance(classType, initialCapacity);
	}

	public ListArray(T[] elements) {
		this.elementData = elements;
		length = elements.length;
	}

	public boolean add(T element) {
		ensureCapacity();
		elementData[length] = element;
		length++;
		return true;
	}

	// Overload
	public boolean add(int index, T element) {
		rangeCheckForAdd(index);
		ensureCapacity();
		push(index);
		elementData[index] = element;
		length++;
		return true;
	}

	private void push(int position) {
		for (int i = length - 1; i >= position; i--) {
			elementData[i + 1] = elementData[i];
		}
	}

	private void rangeCheckForAdd(int index) {
		if (!(index >= 0 || index < length))
			throw new IllegalArgumentException("Posição inválida!");
	}

	@SuppressWarnings("unchecked")
	private void increasesCapacity() {
		T[] newElements = (T[]) new Object[length * 2];
		for (int i = 0; i < length; i++) {
			newElements[i] = elementData[i];
		}
		elementData = newElements;
	}

	private void ensureCapacity() {
		if (length == this.elementData.length)
			increasesCapacity();
	}

	private void rangeCheck(int index) {
		if (index >= length)
			throw new IllegalArgumentException("Posição inválida!");
	}

	public boolean remove(int index) {
		rangeCheck(index);

		for (int i = index; i < length - 1; i++) {
			elementData[i] = elementData[i + 1];
		}
		elementData[--length] = null;
		return true;
	}

	public int size() {
		return this.length;
	}

	public T get(int index) {
		rangeCheckForAdd(index);
		return elementData[index];
	}

	public int contains(Object element) {
		for (int i = 0; i < length; i++) {
			if (element.equals(elementData[i]))
				return i;
		}
		return -1;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		for (int i = 0; i < length - 1; i++) {
			sb.append(elementData[i]);
			sb.append(", ");
		}
		if (length > 0)
			sb.append(elementData[length - 1]);

		sb.append("]");
		return sb.toString();
	}
}
