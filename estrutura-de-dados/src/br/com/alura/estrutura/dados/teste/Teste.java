package br.com.alura.estrutura.dados.teste;

import br.com.alura.estrutura.dados.Vetor;

public class Teste {
	
	public static void main(String[] args) {
		Vetor vet = new Vetor(10);
		String a1 = "Estrutura de dados";
		vet.adiciona("B");
		vet.adiciona("C");
		vet.adiciona("E");
		vet.adiciona("F");
		vet.adiciona("G");
		System.out.println(vet);
		vet.adiciona(0, "A");
		System.out.println(vet);
		vet.adiciona(3, "D");
		System.out.println(vet);
	}
}
