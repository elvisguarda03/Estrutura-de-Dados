package br.com.alura.estrutura.dados.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.estrutura.dados.model.Aluno;

public class Last {
	
	public static void main(String[] args) {
		ArrayList<Aluno> alunos = new ArrayList<>();
		Aluno a2 = new Aluno("Elvis");
		alunos.add(new Aluno("Elvis"));
		alunos.add(new Aluno("Eloah"));
		alunos.add(new Aluno("Bianca"));
		alunos.add(new Aluno("Elvis"));
		System.out.println(alunos.size());
		System.out.println(alunos.lastIndexOf(a2));
//		System.out.println(alunos.remove(new Aluno("Elvis")));
		System.out.println(alunos.size());
//		alunos.clear();
//		System.out.println(alunos.size());
	}
}
