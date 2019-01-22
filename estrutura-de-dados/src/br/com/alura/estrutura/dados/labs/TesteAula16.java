package br.com.alura.estrutura.dados.labs;

import br.com.alura.estrutura.dados.stack.Stack;

public class TesteAula16 {
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		
		System.out.println(stack.peek());
		
		System.out.println(stack.push(1));
		System.out.println(stack.push(2));
		
		System.out.println(stack);
		
		System.out.println(stack.peek());
	
		System.out.println(stack);
	}
}
