package br.com.alura.estrutura.dados.labs;

import java.util.EmptyStackException;

import javax.swing.JOptionPane;
import br.com.alura.estrutura.dados.stack.Stack;

public class Exercise2 {

	public static void main(String[] args) {
		Stack<Integer> par = new Stack<>();
		Stack<Integer> impar = new Stack<>();

		for (int i = 0; i < 10; i++) {
			int number = Integer.parseInt(JOptionPane.showInputDialog("Digite um número:"));
			if (number % 2 == 0 && number > 0)
				par.push(number);
			else if (number % 2 == 1)
				impar.push(number);
			else {
				try {
					System.out.println(par.pop());
					System.out.println(impar.pop());					
				} catch(EmptyStackException e) {
					System.err.println("A pilha está vázia não foi possível remover!");
				}
			}
		}
	}
}
