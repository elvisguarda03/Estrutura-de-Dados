package br.com.alura.estrutura.dados.queue.labs;

import br.com.alura.estrutura.dados.queue.LinkedList;

public class TesteLinked {
	public static void main(String[] args) {
		LinkedList<String> nomes = new LinkedList<>();
		
		System.out.println(nomes);
		nomes.addFirst("Elvis");
		System.out.println(nomes);
		nomes.addFirst("Bruna");
		System.out.println(nomes);
		nomes.add(1, "Carlos");
		System.out.println(nomes);
		System.out.println(nomes.removeLast());
		System.out.println(nomes);
	}
}
