package br.com.alura.estrutura.dados.labs;

import br.com.alura.estrutura.dados.stack.Stack;

public class Teste {
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<>();
		
		System.out.println(stack);
		System.out.println(stack.size());
		System.out.println((stack.isEmpty() == true ? "Está vázia" : "Não está vázia"));
		for(int i = 1; i <= 11; i++) {
			stack.push(i);
		}
		System.out.println(stack);
		System.out.println((stack.isEmpty() == true ? "Está vázia" : "Não está vázia"));
	}
}
