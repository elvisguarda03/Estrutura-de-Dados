package br.com.alura.estrutura.dados.labs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.alura.estrutura.dados.stack.Stack;

public class Palindrom {
	
	public static void main(String[] args) {
		imprime("Socorram-me, subi no ônibus em Marrocos.");
	}
	
	public static void imprime(String word) {
		System.out.println(isPalindromo(word) == true ? "É um palíndromo!": "Não é um palíndromo!");
	}
	
	public static boolean isPalindromo(String word) {
		Stack<Character> stack = new Stack<>();
		String palavra = verify(word);
		for(int i = 0; i < palavra.length(); i++) {
			stack.push(palavra.charAt(i));
		}
		StringBuilder builder = new StringBuilder();
		while(!stack.isEmpty())
			builder.append(stack.pop());
		String palin = builder.toString();
		if(palin.equalsIgnoreCase(palavra))
			return true;
		
		return false;
	}

	private static String verify(String word) {
		StringBuilder builder = new StringBuilder();
		Pattern pattern = Pattern.compile("\\w");
		Matcher matcher = pattern.matcher(word);
	
		while(matcher.find()) {
			builder.append(matcher.group());
		}
		return builder.toString();
	}
}