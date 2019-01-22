package br.com.alura.estrutura.dados.labs;

import br.com.alura.estrutura.dados.stack.Stack;

public class Parenteses {

	public static void main(String[] args) {
		String word = "A+B";
		imprime(word);

	}

	private static void imprime(String word) {
		int isBalance = isBalance(word);
		if (isBalance == -1)
			System.out.println("Os simbolos estão balanceados!");
		else if (isBalance == 1 || isBalance == 0)
			System.out.println("A expressão viola a 1° condição.");
		else if (isBalance == 2)
			System.out.println("A expressão viola a 2° condição.");

	}

	public static int isBalance(String word) {
		Stack<Character> stack = new Stack<>();
		int validaLeft = 0;
		int validaRight = 0;

		if (word.contains("(") && word.contains(")")) {
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == '(' || word.charAt(i) == ')') {
					stack.push(word.charAt(i));
				}
			}
		}
		while (!stack.isEmpty()) {
			if ((stack.pop() == ')'))
				validaRight++;
			else
				validaLeft++;
		}
		if (validaLeft == validaRight && validaLeft == 0)
			return 0;
		else if (validaRight > validaLeft)
			return 1;
		else if (validaLeft > validaRight)
			return 2;
		else
			return -1;
	}
}