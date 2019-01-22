package br.com.alura.estrutura.dados.lista.ligada.teste;

import br.com.alura.estrutura.dados.lista.ligada.LinkedList;

public class TesteLinked {
	
	public static void main(String[] args) {
		LinkedList<String> string = new LinkedList<>();
		
		string.addFirst("Bruna");
		System.out.println(string);
		string.addFirst("Elvis");
		System.out.println(string);
		string.addFirst("Daniel");
		System.out.println(string);
		string.addLast("Messias");
		System.out.println(string);
		string.add(2, "Paulo");
		System.out.println(string);
		System.out.println(string.size());
		System.out.println(string.contains("Elvis"));
		string.remove("Elvis");
		System.out.println(string);
		System.out.println(string.size());
		System.out.println(string.contains("Elvis"));
		System.out.println(string);
		System.out.println("------------------------------");
		while(string.hasNext()) 
			System.out.println(string.get());
//		contas.addLast(new ContaCorrente(111,222));
//		contas.addFirst(new ContaPoupanca(321,456));
//		contas.add(1, new ContaCorrente(222,333));
//		
//		Conta c1 = contas.get(1);
//		c1.setTitular(new Cliente("Elvis de Sousa", "860-898-535.77", "Desenvolvedor"));
//		c1.deposita(600000);
//		c1 = contas.get(2);
//		
//		c1.setTitular(new Cliente("Bianca de Sousa", "234-935-678.88", "Engenheira de Produção"));
//		c1.deposita(300000);
//
//		c1 = contas.get(0);
//		c1.setTitular(new Cliente("Laila", "356-954-343.92", "Enfermeira"));
//		c1.deposita(3245.65);
//		for(int i = 0; i < contas.size(); i++) {
//			System.out.println(contas.hasNext());
//			System.out.println(contas.get(i).toString());
//		}
//		System.out.println(contas.hasNext());
	}
}
