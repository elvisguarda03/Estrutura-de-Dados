package br.com.alura.estrutura.dados.model;

//N�o � boa pr�tica ter classes que apenas carregam dados

public class Aluno {
	private String nome;

	public Aluno(String nome) {
		this.nome = nome;
	}

	public Aluno() {}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			throw new NullPointerException("Aluno n�o existe!");
		if(!(obj instanceof Aluno))
			return false;
		Aluno other = (Aluno) obj;
		if(other.nome == null)
			throw new NullPointerException("Aluno n�o possui nome!");
		
		return this.nome.equals(other.nome);
	}
	
	@Override
	public String toString() {
		return getNome();
	}
}
