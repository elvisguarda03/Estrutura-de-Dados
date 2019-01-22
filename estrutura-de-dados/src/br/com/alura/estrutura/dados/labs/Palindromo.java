package br.com.alura.estrutura.dados.labs;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Palindromo {

	public static void main(String[] args) {

		String palin = "Socorram-me, subi no ônibus em Marrocos.";

		Stack<Character> stack = new Stack<>();
		System.out.println(
				isPalin(stack, palin) == true ? "Essa string é um palíndromo" : "Essa string não é um palíndromo");
	}

	public static boolean isPalin(Stack<Character> stack, String palin) {
		palin = verify(stack, palin);
		StringBuilder builder = new StringBuilder();
		while(!stack.isEmpty()) {
			builder.append(stack.pop());
		}
		String compare = builder.toString();
		if(!compare.equalsIgnoreCase(palin))
			return false;
		return true;
	}

	public static String verify(Stack<Character> stack, String palin) {
		if (palin.contains("\\W")) {
			Pattern p = Pattern.compile("\\w");
			Matcher m = p.matcher(palin);
			
			StringBuilder builder = new StringBuilder();
			while(m.find()) {
				builder.append(m.group());
			}
			String newPalin = builder.toString();
			for (int i = 0; i < newPalin.length(); i++) {
				stack.push(newPalin.charAt(i));
			}
			return newPalin;
		} else if (palin.length() % 2 == 0) {
			for (int i = palin.length() - 1; i >= palin.length() / 2; i--) {
				stack.push(palin.charAt(i));
			}
		} else {
			for (int i = palin.length() - 1; i > palin.length() / 2; i--) {
				stack.push(palin.charAt(i));
			}
		}
		return palin;
	}
}