package br.com.alura.estrutura.dados.teste;

import br.com.alura.estrutura.dados.list.List;
import br.com.alura.estrutura.dados.model.Aluno;

public class removeObject {
	
	public static void main(String[] args) {
		List<Aluno> alunos = new List<>(2);
		alunos.add(new Aluno("Elvis"));
		alunos.add(new Aluno("Eloah"));
		alunos.add(new Aluno("Bianca"));
		System.out.println(alunos.size());
		
//		System.out.println(alunos.remove(new Aluno("Elvis")));
		System.out.println(alunos.size());
//		alunos.clear();
//		System.out.println(alunos.size());
		Aluno a1 = alunos.get(alunos.indexOf(new Aluno("Bianca")));
		System.out.println("Aluno - " + a1.getNome());
		for(int i = 0; i < alunos.size(); i++) {
			System.out.println(alunos.get(i).getNome());
		}
		
	}
}
