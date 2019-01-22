package br.com.alura.estrutura.dados.stack;

import java.util.EmptyStackException;

import br.com.alura.estrutura.dados.base.StaticStructure;

//Pilha � uma estrutura de dados que admite remo��o de elementos e inser��o de novos objetos.  Mais especificamente, 
//uma  pilha (= stack)  � uma estrutura sujeita � seguinte regra de opera��o:  sempre que houver uma remo��o,
//o elemento removido � o que est� na estrutura h� menos tempo. S�o estruturas de dados do tipo LIFO (last-in first-out), 
//onde o �ltimo elemento a ser inserido, ser� o primeiro a ser retirado. Assim, uma pilha permite acesso a apenas um item de dados - o �ltimo inserido. 
//Para processar o pen�ltimo item inserido, deve-se remover o �ltimo.

//LIFO - Last in - First out = �ltimo a entrar primeiro a sair

// 	S�o exemplos de uso de pilha em um sistema:
// - Fun��es recursivas em compiladores;
// - Mecanismo de desfazer/refazer dos editores de texto;
// - Navega��o entre p�ginas Web;

//A implementa��o de pilhas pode ser realizada atrav�s de vetor (aloca��o do espa�o de mem�ria para os elementos � cont�gua) ou atrav�s de listas encadeadas

//Numa pilha, a manipula��o dos elementos � realizada em apenas uma das extremidades, chamada de topo, em oposi��o a outra extremidade, chamada de base.

//Uma pilha geralmente suporta 4 opera��es b�sicas:

// - TOP(PEEK): acessa-se o elemento posicionado no topo da pilha;
// - PUSH: insere um novo elemento no topo da lista;
// - POP: remove o elemento do topo da lista.
// - PULL: altera o elemento posicionado no topo da pilha;

// Cont�gua - Muito pr�xima de algo, anexa, ligada, unida.
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
	
	//Desempilhando o �ltimo elemento
	public T pop() throws EmptyStackException {
		if(isEmpty())
			throw new EmptyStackException();
		return elementData[--size];
	}
}