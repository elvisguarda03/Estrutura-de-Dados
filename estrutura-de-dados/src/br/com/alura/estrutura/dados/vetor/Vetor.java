package br.com.alura.estrutura.dados.vetor;

import br.com.alura.estrutura.dados.base.StaticStructure;

public class Vetor<T> extends StaticStructure<T> {

	public Vetor(int initialCapacity) {
		super(initialCapacity);
	}

	public Vetor() {
		super();
	}

	public boolean add(T element) {
		return super.add(element);
	}

	public boolean add(int index, T element) {
		return super.add(index, element);
	}
}
