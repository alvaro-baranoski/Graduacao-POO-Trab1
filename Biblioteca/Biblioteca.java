package Biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Classe que contém uma biblioteca com diversos livros
 */
public class Biblioteca {

	private String nome;
	private ArrayList<Livro> alLivros;
	private float investimento;

	/**
	 * Construtor da classe Biblioteca
	 * 
	 * @param nome nome da biblioteca
	 */
	public Biblioteca(String nome) {
		this.nome = nome;
		this.alLivros = new ArrayList<Livro>();
		investimento = 0;
	}

	/**
	 * Adiciona um livro em alLivros
	 * 
	 * @param titulo título do livro
	 * @param autor  autor do livro
	 * @param preco  preço do livro
	 */
	public void addLivro(String titulo, String autor, float preco) {
		int idLivro = alLivros.size();
		Livro livro = new Livro(idLivro, titulo, autor, preco);
		this.alLivros.add(livro);
		this.investimento += preco;
	}

	/**
	 * Lista todos os livros presentes na biblioteca
	 * 
	 * @param showBib flag que indica se irá mostrar o cabeçalho da lista
	 */
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

	/**
	 * Realiza o sort alfabético ascendente baseado em título de livros
	 * 
	 * @param array arrayList de entrada
	 */
	private void sortBiblioteca(ArrayList<Livro> array) {
		Collections.sort(array, new Comparator<Livro>() {
			public int compare(Livro l1, Livro l2) {
				return l1.getTitulo().compareTo(l2.getTitulo());
			}
		});
	}

	/**
	 * Printa todos os lívros que estão diposíveis para emprestimo
	 */
	public void listaLivroParaEmprestimo() {
		ArrayList<Livro> alLivrosCopia = new ArrayList<Livro>(alLivros);
		sortBiblioteca(alLivrosCopia);

		for (int i = 0; i < alLivrosCopia.size(); i++) {
			Livro livro = alLivrosCopia.get(i);
			if (livro.getDispLivro() == Disponibilidade.DISPONIVEL)
				System.out.println(livro);
		}
	}

	/**
	 * Realiza a alteração de estado de um livro
	 * 
	 * @param idLivro identificador do livro
	 * @param idDisp  identificador do estado
	 */
	public void alterarEstado(int idLivro, int idDisp) {
		Livro livro = alLivros.get(idLivro);
		switch (idDisp) {
			case 0:
				if (livro.getDispLivro() != Disponibilidade.EMPRESTADO) {
					livro.setDispLivro(Disponibilidade.CONSULTALOCAL);
				} else {
					System.out.println("NAO E POSSIVEL ALTERAR DE EMPRESTADO PARA CONSULTA LOCAL");
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
