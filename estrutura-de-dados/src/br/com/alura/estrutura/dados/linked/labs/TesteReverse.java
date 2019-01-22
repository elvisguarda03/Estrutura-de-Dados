package br.com.alura.estrutura.dados.linked.labs;

import br.com.alura.estrutura.dados.queue.ArrayList;

public class TesteReverse {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> reverse = new ArrayList<>();
		
		for(int i = 2; i < 10; i++) {
			reverse.add(i);
		}
		System.out.println(reverse);
		
		reverse.reverse();
		
		System.out.println(reverse);
	}
}
