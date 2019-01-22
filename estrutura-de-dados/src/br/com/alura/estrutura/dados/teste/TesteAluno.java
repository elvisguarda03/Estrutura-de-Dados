package br.com.alura.estrutura.dados.teste;

import br.com.alura.estrutura.dados.list.List;
import br.com.alura.estrutura.dados.model.Aluno;

public class TesteAluno {

	public static void main(String[] args) {
		List<Aluno> list = new List<>();
		long inicio = System.currentTimeMillis();
		System.out.println("Tamanho - " + list.size());
		for (int i = 1; i < 100000; i++) {
			Aluno aluno = new Aluno();
			list.add(aluno);
		}
		System.out.println("Tamanho - " + list.size());
		long fim = System.currentTimeMillis();
		double tempo = (fim - inicio);
		System.out.println("Tempo em milisegundos = " + tempo);
		System.out.println(list.get(0).getNome());
		inicio = System.currentTimeMillis();
		list.remove(0);
		System.out.println(list.get(0).getNome());
		fim = System.currentTimeMillis();
		System.out.println("Tempo em milisegundos para remover = " + ((double)fim - inicio));
	
		List<Aluno> alunos = new List<>();
		inicio = System.currentTimeMillis();
		for(int i = 0; i < list.size(); i++) {
			alunos.add(list.get(i));
		}
		System.out.println("Tempo fim - " + (System.currentTimeMillis() - inicio));
		System.out.println(alunos.size());
	}
}
