package br.com.alura.estrutura.dados.queue.labs;

import br.com.alura.estrutura.dados.queue.Queue;

public class TesteQueue {
	
	public static void main(String[] args) {
	
		Queue<Integer> queue = new Queue<>();
		
		System.out.println(queue);
		queue.toQueue(3);
		System.out.println(queue);
		queue.toQueue(2);
		System.out.println(queue);
		queue.toQueue(1);
		System.out.println(queue);
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty());
	}
}
