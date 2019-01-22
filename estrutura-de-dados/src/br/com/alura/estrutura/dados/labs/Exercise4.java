package br.com.alura.estrutura.dados.labs;

import java.util.EmptyStackException;
import javax.swing.JOptionPane;
import java.util.Stack;

public class Exercise4 {

	public static void main(String[] args) {
		int exe = 0;
		Stack<Livro> stack = new Stack<>();
		Livro livro = null;
		String index = null;

		for (int i = 0; i < 6; i++) {
			String nomeLivro = JOptionPane.showInputDialog("Nome do livro:");
			String isbn = JOptionPane.showInputDialog("ISBN:");
			String anoLanc = JOptionPane.showInputDialog("Ano de lançamento:");
			String nomeAutor = JOptionPane.showInputDialog("Nome do Autor:");
			stack.push(new Livro(nomeLivro, isbn, anoLanc, nomeAutor));
			exe = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
		}

		int choose = 0;
		exe = 0;
		while (exe == 0) {
			choose = Integer.parseInt(JOptionPane.showInputDialog("Escolha:" + "\n1 - Inserir um livro no topo"
					+ "\n2 - Remover um livro do topo" + "\n3 - Pegar um livro do topo"
					+ "\n4 - Verificar se existem livros cadastrados"
					+ "\n5 - Verificar quantos livros estão cadastrados" + "\n6 - Pegar um livro pelo id"
					+ "\n7 - Pegar o primeiro livro" + "\n8 - Pegar a diferença do topo da pilha para um elemento"
					+ "\n9 - Verificar se um elemento existe" + "\n10 - Remover todos os livros cadastrados"));
			switch (choose) {

			case 1:
				String nomeLivro = JOptionPane.showInputDialog("Nome do livro:");
				String isbn = JOptionPane.showInputDialog("ISBN:");
				String anoLanc = JOptionPane.showInputDialog("Ano de lançamento:");
				String nomeAutor = JOptionPane.showInputDialog("Nome do Autor:");
				stack.push(new Livro(nomeLivro, isbn, anoLanc, nomeAutor));
				break;
			case 2:
				try {
					JOptionPane.showMessageDialog(null, "Livro removido - " + stack.pop());
				} catch (EmptyStackException e) {
					System.err.println("A pilha está vázia!");
				}
				break;
			case 3:
				if (!stack.isEmpty())
					JOptionPane.showMessageDialog(null, stack.peek());
				else
					JOptionPane.showMessageDialog(null, "Não existem livros!");
				break;
			case 4:
				JOptionPane.showMessageDialog(null, stack.isEmpty() == true ? "Não existem livros cadastrados"
						: "Existem " + stack.size() + " cadastrados");
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "Número de livros cadastrados - " + stack.size());
				break;

			case 6:
				index = JOptionPane.showInputDialog("Insira o isbn do livro");
				livro = new Livro(index);
				for (Livro l : stack) {
					if (l.equals(livro)) {
						JOptionPane.showMessageDialog(null, stack.get(stack.indexOf(l)));
						break;
					}
				}
				JOptionPane.showMessageDialog(null, "O livro não existe no banco de dados");
				break;
			case 7:
				JOptionPane.showMessageDialog(null, stack.firstElement());
			case 8:
				index = JOptionPane.showInputDialog("Insira o isbn do livro");
				livro = new Livro(index);
				for (Livro l : stack) {
					if (l.equals(livro)) {
						JOptionPane.showMessageDialog(null,
								"Distância para o topo - " + stack.search(stack.get(stack.indexOf(l))));
						break;
					}
				}
				break;
			case 9:
				index = JOptionPane.showInputDialog("Insira o isbn do livro");
				boolean isExists = stack.contains(new Livro(index));
				JOptionPane.showMessageDialog(null, isExists == true ? "O  livro existe" : "O livro não existe!");
				break;
			case 10:
				if (!stack.isEmpty())
					stack.clear();
				break;
			default:
				throw new IllegalArgumentException("Opção inválida!");
			}
			index = null;
			livro = null;
			exe = JOptionPane.showConfirmDialog(null, "Deseja continuar?");
		}
	}
}