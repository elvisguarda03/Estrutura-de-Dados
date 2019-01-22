package br.com.alura.estrutura.dados.queue;

import java.util.Arrays;
import java.util.Locale;
import java.util.NoSuchElementException;

public class ArrayList<E> implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3667822139485782193L;
	private E[] elementData;
	private static final int DEFAULT_CAPACITY = 10;
	private int size;

	@SuppressWarnings("unchecked")
	public ArrayList(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Capacidade inválida!");
		elementData = (E[]) new Object[initialCapacity];
	}

	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	public boolean add(E element) {
		if (element == null)
			throw new NullPointerException("Objeto não foi cadastrado!");
		ensureCapacity();
		elementData[size++] = element;
		return true;
	}

	public boolean add(int index, E element) {
		if (isEmpty())
			add(element);
		if (element == null)
			throw new NullPointerException("Objeto não foi cadastrado!");
		ensureCapacity();
		push(index);
		elementData[index] = element;
		size++;
		return true;
	}

	public E get(int index) {
		rangeCheck(index);
		return elementData[index];
	}

	public boolean contains(E element) {
		return indexOf(element) >= 0;
	}

	public boolean remove(E element) {
		return remove(indexOf(element));
	}

	public boolean remove(int index) {
		rangeCheck(index);
		for (int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i + 1];
		}
		elementData[--size] = null;
		return true;
	}

	public void clear() {
		if (isEmpty())
			throw new NoSuchElementException();
		for (int i = 0; i < size; i++) {
			elementData[i] = null;
		}
		size = 0;
	}

	public int size() {
		return size;
	}

	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elementData[i] == null)
					return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (elementData[i].equals(element))
					return i;
			}
		}
		return -1;
	}

	private void reverse(int decrement) {
		int increment = size - (decrement + 1);
		int half = size / 2;
		
		E aux = elementData[decrement];
		elementData[decrement] = elementData[increment];
		elementData[increment] = aux;
		if(decrement > half)
			reverse(--decrement);
	}

	public void reverse() {
		E[] newReverse = (E[]) new Object[size];
		for(int i = 0, j = size - 1; i < size; i++, j--) {
			newReverse[i] = elementData[j];
		}
		elementData = newReverse;
//		reverse(decrement);
	}

	public int lastIndexOf(E element) {
		if (element == null) {
			for (int i = size - 1; i >= 0; i--) {
				if (elementData[i] == null)
					return i;
			}
		} else {
			for (int i = size - 1; i >= 0; i--) {
				if (elementData[i].equals(element))
					return i;
			}
		}
		return -1;
	}

	private void rangeCheck(int index) {
		if (!(index >= 0 && index < size))
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	private String outOfBoundsMsg(int index) {
		return String.format(new Locale("pt", "BR"), "Index: %d, Size: %d", index, size);
	}

	private void push(int index) {
		rangeCheckForAdd(index);
		for (int i = size - 1; i >= index; i--) {
			elementData[i + 1] = elementData[i];
		}
	}

	private void rangeCheckForAdd(int index) {
		rangeCheck(index);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void ensureCapacity() {
		if (size == elementData.length)
			elementData = Arrays.copyOf(elementData, size * 2);
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "[]";
		StringBuilder builder = new StringBuilder("[");
		for (int i = 0; i < size - 1; i++) {
			builder.append(elementData[i]);
			builder.append(", ");
		}
		builder.append(elementData[size - 1]);
		builder.append("]");
		return builder.toString();
	}
}
