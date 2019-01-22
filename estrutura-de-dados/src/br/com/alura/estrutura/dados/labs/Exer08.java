package br.com.alura.estrutura.dados.labs;

import java.util.Stack;

public class Exer08 {

	public static void main(String[] args) {
		Stack<Integer> origin = new Stack<>();
		Stack<Integer> dest = new Stack<>();
		Stack<Integer> aux = new Stack<>();

		origin.push(8);
		origin.push(6);
		origin.push(5);
		torreDeHanoi(origin.size(), origin, dest, aux);
	}

	public static void torreDeHanoi(int n, Stack<Integer> original, 
			Stack<Integer> dest, Stack<Integer> aux) {
		
		if(n > 0) {
			torreDeHanoi(n - 1, original, aux, dest);
			dest.push(original.pop());
			System.out.println("------");
			System.out.println("Original: " + original);
			System.out.println("Dest: " + dest);
			System.out.println("Aux: " + aux);
			torreDeHanoi(n - 1, aux, dest, original);
		}
	}
}