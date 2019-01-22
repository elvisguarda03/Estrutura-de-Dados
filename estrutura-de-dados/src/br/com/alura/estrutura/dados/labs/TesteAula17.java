package br.com.alura.estrutura.dados.labs;

import br.com.alura.estrutura.dados.stack.Stack;

public class TesteAula17 {
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(3);
		stack.push(4);
		stack.push(6);
		
		System.out.println(stack.isEmpty());
		
		System.out.println(stack);
		
		System.out.println(stack.size());
		
		System.out.println(stack.pop());
		
		System.out.println(stack);
	}
}
