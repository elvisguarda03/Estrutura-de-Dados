package br.com.alura.estrutura.dados.teste;

import br.com.alura.estrutura.dados.Vetor;

public class RemoverElemento {
	public static void main(String[] args) {
		Vetor vet = new Vetor(3);
		
		vet.adiciona("B");
		vet.adiciona("C");
		vet.adiciona("E");
		vet.adiciona("F");
		vet.adiciona("G");
		
		System.out.println(vet);
		vet.remove(2);
		System.out.println(vet + ", " + vet.size());
		vet.adiciona(2, "E");
		System.out.println(vet + ", " + vet.size());
		vet.adiciona(0, "A");
		System.out.println(vet + ", " + vet.size());
		vet.adiciona(3, "D");
		System.out.println(vet + ", " + vet.size());
	}
}
