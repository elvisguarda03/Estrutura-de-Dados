package br.com.alura.estrutura.dados.teste;

import br.com.alura.estrutura.dados.Vetor;

public class Remover {

	public static void main(String[] args) {
		Vetor vet = new Vetor(3);

		vet.adiciona("B");
		vet.adiciona("C");
		vet.adiciona("E");
		vet.adiciona("F");
		vet.adiciona("G");
		System.out.println(vet);
		int contains = vet.contains("A");
		if(contains >= 0)
			vet.remove(contains);
		else
			System.out.println("Elemento não existe!");
		
		System.out.println(vet);
	}
}
