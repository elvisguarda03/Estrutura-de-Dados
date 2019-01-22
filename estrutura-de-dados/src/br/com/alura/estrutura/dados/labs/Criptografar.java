package br.com.alura.estrutura.dados.labs;

import java.util.Stack;

public class Criptografar {
	
	public static void main(String[] args) {
		String msg = "Uma mensagem confidencial";
		
		String encriptografada = criptografar(msg);
		System.out.println("Mensagem encriptografada - " + encriptografada);
		
		String descriptografada = descriptografar(encriptografada);
		System.out.println("Mensagem descriptografada - " + descriptografada);
	}
	
	private static String descriptografar(String encriptografada) {
		Stack<Character> desCrip = new Stack<>(); 
		StringBuilder descriptografada = new StringBuilder("");
		String help = "";
		
		for(int i = 0; i < encriptografada.length(); i++)
			desCrip.push(encriptografada.charAt(i));
		while(!desCrip.isEmpty())
			descriptografada.append(desCrip.pop());
		help = descriptografada.toString();
		String[] edit = help.split("\\W");
		
		descriptografada = new StringBuilder("");
		for(int i = edit.length - 1; i >= 0; i--) {
			descriptografada.append(edit[i]);
			descriptografada.append(" ");
		}
		return descriptografada.toString();
	}

	public static String criptografar(String msg) {
		StringBuilder criptografada = new StringBuilder("");
		String help = "";
		Stack<Character> crip = new Stack<>();
		for(int i = 0; i < msg.length(); i++)
			crip.push(msg.charAt(i));
		
		while(!crip.isEmpty()) {
			criptografada.append(crip.pop());
		}
		help = criptografada.toString();
		String[] edit = null;
		edit = help.split("\\W");
		criptografada = new StringBuilder("");
		for(int i = edit.length - 1; i >=0; i--) {
			criptografada.append(edit[i]);
			criptografada.append(" ");
		}
		return criptografada.toString();
	}
}