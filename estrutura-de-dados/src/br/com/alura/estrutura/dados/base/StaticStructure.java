package br.com.alura.estrutura.dados.base;

import java.util.Arrays;

public class StaticStructure<T> {
	protected static final int DEFAULT_CAPACITY = 10;
	protected T[] elementData;
	protected int size;
	
	@SuppressWarnings("unchecked")
	public StaticStructure(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Capacidade inválida");
		elementData = (T[]) new Object[initialCapacity];
		size = 0;
	}

	public StaticStructure() {
		this(DEFAULT_CAPACITY);
	}
	
	protected boolean add(T element) {
		ensureCapacity();
		elementData[size++] = element;
		return true;
	}

	// Overload
	protected boolean add(int index, T element) {
		rangeCheckForAdd(index);
		ensureCapacity();
		push(index);
		elementData[index] = element;
		size++;
		return true;
	}

	private void push(int index) {
		for(int i = size - 1; i >= index; i--) {
			elementData[i + 1] = elementData[i]; 
		}
	}

	private void ensureCapacity() {
		if(size == elementData.length)
			elementData = Arrays.copyOf(elementData, size * 2);
	}

	private void rangeCheckForAdd(int index) {
		if (!(index >= 0 && index < size))
			throw new IllegalArgumentException("Posição inválida!");
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	protected boolean remove(int index) {
		rangeCheck(index);
		for (int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i + 1];
		}
		elementData[--size] = null;
		return true;
	}

	private void rangeCheck(int index) {
		rangeCheckForAdd(index);
	}

	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		for (int i = 0; i < size - 1; i++) {
			sb.append(elementData[i]);
			sb.append(", ");
		}
		if (size > 0)
			sb.append(elementData[size - 1]);

		sb.append("]");
		return sb.toString();
	}
}