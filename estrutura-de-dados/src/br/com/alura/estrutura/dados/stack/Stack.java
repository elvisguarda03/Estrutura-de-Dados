package br.com.alura.estrutura.dados.stack;

import java.util.EmptyStackException;

import br.com.alura.estrutura.dados.base.StaticStructure;

//Pilha é uma estrutura de dados que admite remoção de elementos e inserção de novos objetos.  Mais especificamente, 
//uma  pilha (= stack)  é uma estrutura sujeita à seguinte regra de operação:  sempre que houver uma remoção,
//o elemento removido é o que está na estrutura há menos tempo. São estruturas de dados do tipo LIFO (last-in first-out), 
//onde o último elemento a ser inserido, será o primeiro a ser retirado. Assim, uma pilha permite acesso a apenas um item de dados - o último inserido. 
//Para processar o penúltimo item inserido, deve-se remover o último.

//LIFO - Last in - First out = Último a entrar primeiro a sair

// 	São exemplos de uso de pilha em um sistema:
// - Funções recursivas em compiladores;
// - Mecanismo de desfazer/refazer dos editores de texto;
// - Navegação entre páginas Web;

//A implementação de pilhas pode ser realizada através de vetor (alocação do espaço de memória para os elementos é contígua) ou através de listas encadeadas

//Numa pilha, a manipulação dos elementos é realizada em apenas uma das extremidades, chamada de topo, em oposição a outra extremidade, chamada de base.

//Uma pilha geralmente suporta 4 operações básicas:

// - TOP(PEEK): acessa-se o elemento posicionado no topo da pilha;
// - PUSH: insere um novo elemento no topo da lista;
// - POP: remove o elemento do topo da lista.
// - PULL: altera o elemento posicionado no topo da pilha;

// Contígua - Muito próxima de algo, anexa, ligada, unida.
public class Stack<T> extends StaticStructure<T> {

	public Stack(int initialCapacity) {
		super(initialCapacity);
	}

	public Stack() {
		super();
	}

	//Empilhando um elemento
	public boolean push(T element) {
		return super.add(element);
	}

	public boolean isEmpty() {
		return super.isEmpty();
	}
	
	//Espiando um elemento da pilha - Olhadinha
	public T peek() {
		if (isEmpty())
			return null;
		return elementData[size - 1];
	}
	
	//Desempilhando o último elemento
	public T pop() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException();
		return elementData[--size];
	}
}