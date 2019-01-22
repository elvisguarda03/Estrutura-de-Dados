package br.com.alura.estrutura.dados.teste;

import br.com.alura.estrutura.dados.ListArray;
import br.com.alura.estrutura.dados.Vector;

public class ClassObject {
	
	public static void main(String[] args) {
		Vector vector = new Vector();
		
		Contato c1 = new Contato("Contato 1", "1234-5678", "contato1@email.com");
		Contato c2 = new Contato("Contato 2", "5678-4321", "contato2@email.com");
		Contato c3 = new Contato("Contato 3", "4321-6789", "contato3@email.com");
		
		vector.adiciona(c1);
		vector.adiciona(c2);
		vector.adiciona(c3);
		
		ListArray<Contato> list = new ListArray<>();
		
		System.out.println(vector);
		System.out.println(vector.equals(new Contato("Contato 2", "5678-4321", "contato2@email.com")));
	}
}
