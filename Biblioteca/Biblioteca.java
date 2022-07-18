package Biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Biblioteca {

	private String nome;
	private ArrayList<Livro> alLivros;
	private float investimento;

	// construtor cria alLivros, ArrayList que fica encapsulado na classe Biblioteca
	public Biblioteca(String nome) {
		this.nome = nome;
		this.alLivros = new ArrayList<Livro>();
		investimento = 0;
	}

	// demais métodos getters, setters, toString, compareTo (para ordenação) etc
	// conforme a modelagem e encapsulamento especificados
	// mais o que estudante decidir implementar

	public void addLivro(String titulo, String autor, float preco) {
		int idLivro = alLivros.size();
		Livro livro = new Livro(idLivro, titulo, autor, preco);
		this.alLivros.add(livro);
		this.investimento += preco;
	}

	public void listarBiblioteca(Boolean showBib) {
		if (showBib) {
			System.out.println("BIBLIOTECA: " + this.nome);
			System.out.println("TOTAL INVESTIDO: " + this.investimento);
			System.out.println();
		}

		ArrayList<Livro> alLivrosCopia = new ArrayList<Livro>(alLivros);
		sortBiblioteca(alLivrosCopia);

		for (int i = 0; i < alLivrosCopia.size(); i++) {
			Livro livro = alLivrosCopia.get(i);
			System.out.println(livro);
		}
	}

	private void sortBiblioteca(ArrayList<Livro> array) {
		Collections.sort(array, new Comparator<Livro>() {
			public int compare(Livro l1, Livro l2) {
				return l1.getTitulo().compareTo(l2.getTitulo());
			}
		});
	}

	public void listaLivroParaEmprestimo() {
		ArrayList<Livro> alLivrosCopia = new ArrayList<Livro>(alLivros);
		sortBiblioteca(alLivrosCopia);

		for (int i = 0; i < alLivrosCopia.size(); i++) {
			Livro livro = alLivrosCopia.get(i);
			if (livro.getDispLivro() == Disponibilidade.DISPONIVEL)
				System.out.println(livro);
		}
	}

	public void alterarEstado(int idLivro, int idDisp) {
		Livro livro = alLivros.get(idLivro);
		switch (idDisp) {
			case 0:
				if (livro.getDispLivro() != Disponibilidade.EMPRESTADO) {
					livro.setDispLivro(Disponibilidade.CONSULTALOCAL);
				} else {
					System.out.println("NÃO É POSSÍVEL ALTERAR DE EMPRESTADO PARA CONSULTA LOCAL");
				}
				break;
			case 1:
				livro.setDispLivro(Disponibilidade.DANIFICADO);
				break;
			case 2:
				livro.setDispLivro(Disponibilidade.EXTRAVIADO);
				break;
			default:
				break;
		}
	}

	public Livro getLivro(int idLivro) {
		return alLivros.get(idLivro);
	}

	public ArrayList<Livro> getAlLivros() {
		return alLivros;
	}

	public void setAlLivros(ArrayList<Livro> alLivros) {
		this.alLivros = alLivros;
	}

	@Override
	public String toString() {
		return "Biblioteca [alLivros=" + alLivros + ", investimento=" + investimento + ", nome=" + nome + "]";
	}
}
