package br.com.alura.estrutura.dados.labs;

import java.util.Locale;

public class Livro {
	private String nome;
	private String isbn;
	private String anoLancamento;
	private String autor;

	public Livro(String nome, String isbn, String anoLancamento, String autor) {
		this.nome = nome;
		this.isbn = isbn;
		this.anoLancamento = anoLancamento;
		this.autor = autor;
	}

	public Livro(String nome, String autor) {
		this.nome = nome;
		this.autor = autor;
	}
	
	public Livro(String isbn) {
		this.isbn = isbn;
	}

	public Livro() {
	}

	public String getNome() {
		return nome;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getAutor() {
		return autor;
	}


	@Override
	public String toString() {
		return String.format(new Locale("pt", "BR"), "Nome do Livro - %s, " + "Autor - %s", nome, autor);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			throw new NullPointerException();
		if (!(o instanceof Livro))
			throw new IllegalArgumentException();
		
		Livro l = (Livro) o;
		return l.isbn.compareTo(this.isbn) == 0;
	}
}
