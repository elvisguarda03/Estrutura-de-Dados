package br.com.alura.estrutura.dados.lista.ligada;

public class TesteToString {
	
	public static void main(String[] args) {
		
		ListaLigada lista = new ListaLigada();
		System.out.println(lista);
		lista.addFirst("Elvis");
 		System.out.println(lista);
		lista.addFirst("Eloah");
		System.out.println(lista);
		lista.add(1, "Bianca");
		System.out.println(lista);
		lista.addLast("Marcia");
		System.out.println(lista);
		lista.removeLast();
		System.out.println(lista);
		System.out.println(lista.get(2));
	}
}
