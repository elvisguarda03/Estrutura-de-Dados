package br.com.alura.estrutura.dados.labs;

import br.com.alura.estrutura.dados.stack.Stack;

public class Exer09 {
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
	
		stack.push("Mauricio");
		stack.push("Marcelo");
		stack.pop();
		stack.push("Paulo");
		stack.pop();
		stack.pop();
		stack.push("João");
	}
}
