package br.com.alura.estrutura.dados.queue.teste;

import br.com.alura.estrutura.dados.queue.Queue;

public class Teste {
	
	public static void main(String[] args) {
		
		Queue<Integer> queue = new Queue<>();
		
		System.out.println(queue);
		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
		System.out.println(queue.contains(5));
	}
}
