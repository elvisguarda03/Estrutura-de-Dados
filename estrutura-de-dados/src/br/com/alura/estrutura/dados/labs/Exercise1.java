package br.com.alura.estrutura.dados.labs;

import java.util.Stack;

import javax.swing.JOptionPane;

public class Exercise1 {

	public static void main(String[] args) {
		System.out.println("Utiliza��o de uma pilha!!");
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < 10; i++) {
			int number = Integer.parseInt(JOptionPane.showInputDialog("Digite um n�mero:"));
			if (number % 2 == 0)
				stack.push(number);
			else {
				if (stack.isEmpty())
					JOptionPane.showMessageDialog(null, "A pilha est� v�zia");
				else 
					JOptionPane.showMessageDialog(null, stack.pop());
			}
		}
		while (!stack.isEmpty()) {
			System.out.println("Elemento exclu�do - " + stack.pop());
		}
	}
}
