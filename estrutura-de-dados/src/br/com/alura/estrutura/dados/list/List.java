package br.com.alura.estrutura.dados.list;

import java.util.Arrays;

//Por que você nunca deve precisar de mais de 9 tentativas? 
//(Você pode pensar em uma explicação matemática?)?


//		A ideia é essa, mas as 9 tentativas, vêm do resultado da operação 300/2^9, ou seja o quociente da divisão é 
//		inferior a 1, o que nos dá o número de tentativas máximas para encontrar um número usando o método de busca binária.
//		Analisando o quociente das divisões do número 300 pelas potências de 2 vemos a quantidade de possibilidades diminuir 
//		sempre pela metade, até chegar à 8ª escolha, em que a quantidade de escolhas se resume a 1 número, e obrigatoriamente 
//		será necessária mais uma interacção para dar a resposta correcta, elevando a quantidade de a 9. 300/2^9 < 1.

public class List<T> implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5305551614196707118L;
	private T[] elementData;
	private static final int DEFAULT_CAPACITY = 10;
	private int size = 0;

	public List() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public List(int initialCapacity) {
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Capacidade ilegal " + initialCapacity);
		this.elementData = (T[]) new Object[initialCapacity];
	}

	@SuppressWarnings("null")
	public boolean add(T element) {
		if (element == null)
			throw new NullPointerException(element.getClass().getSimpleName() + " não foi cadastrado!");
		ensureCapacity();
		elementData[size] = element;
		++size;
		return true;
	}

	@SuppressWarnings("null")
	public boolean add(int index, T element) {
		if (element == null)
			throw new NullPointerException(element.getClass().getSimpleName() + " não foi cadastrado!");
		if(index == size)
			return add(element);
		rangeCheckForAdd(index);
		ensureCapacity();
		push(index);
		elementData[index] = element;
		++size;
		return true;
	}

	private void push(int index) {
		for (int i = size - 1; i >= index; i--) {
			elementData[i + 1] = elementData[i];
		}
	}

	private void rangeCheckForAdd(int index) {
		if (!(index >= 0 || index < size))
			throw new IllegalArgumentException("Argumento inválido!");
	}

	public T get(int index) {
		rangeCheck(index);
		return elementData[index];
	}

	// As exceções são uma maneira de informar para quem chamou um método que algo
	// aconteceu de maneira
	// diferente da comum.
	private void rangeCheck(int index) {
		if(index >= size)
			throw new IllegalArgumentException("Posição inválida!");
	}
	
	private void rangeCheckForRemove(int index) {
		rangeCheckForAdd(index);
	}
	private void ensureCapacity() {
		if (size == elementData.length)
			elementData = Arrays.copyOf(elementData, size * 2);
	}
	
	// A B C D E -  | A B D E - -
	// 0 1 2 3 4 5	| 0 1 2 3 4 5
	public void remove(int index) {
		rangeCheckForRemove(index);
		for (int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i + 1];
		}
		elementData[--size] = null;
	}
	
	public void remove(T element) {
		remove(indexOf(element));
	}

	public boolean contains(T other) {
		return indexOf(other) >= 0;
	}

	public void clear() {
		if (!isEmpty()) {
			for (int i = 0; i < size; i++) {
				elementData[i] = null;
			}
			size = 0;
		}
	}

	public int indexOf(T o) {
		if(o == null) {
			for(int i = 0; i < size; i++) {
				if(elementData[i] == null)
					return i;
			}
		}
		else {
			for (int i = 0; i < size; i++) {
				if (o.equals(elementData[i]))
					return i;
			}			
		}
		return -1;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// Consumo constante
	public int size() {
		return this.size;
	}
	
	public int lastIndexOf(T o) {
		if(o == null) {
			for (int i = size - 1; i >= 0; i--) {
				if(elementData[i] == null)
					return i;
			}
		}
		else {
			for (int i = size - 1; i >= 0; i--) {
				if(o.equals(elementData[i]))
					return i;
			}
		}
		return -1;
	}

	@Override
	public String toString() {
		return Arrays.toString(elementData);
	}
}