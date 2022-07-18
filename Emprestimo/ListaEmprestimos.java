package Emprestimo;

import java.time.LocalDate;
import java.util.ArrayList;

import Amigo.Amigo;
import Biblioteca.Disponibilidade;
import Biblioteca.Livro;

/**
 * Classe que contém uma lista de empréstimos
 */
public class ListaEmprestimos {

	private ArrayList<Emprestimo> alEmprestimos;

	public ListaEmprestimos() {
		super();
		this.alEmprestimos = new ArrayList<Emprestimo>();
	}

	/**
	 * Adiciona um novo empréstimo
	 * 
	 * @param livro livro que foi emprestado
	 * @param amigo amigo que emprestou o livro
	 */
	public void addEmprestimo(Livro livro, Amigo amigo) {
		int idEmprestimo = alEmprestimos.size();
		Emprestimo emprestimo = new Emprestimo(idEmprestimo, LocalDate.now(), livro, amigo);
		livro.setDispLivro(Disponibilidade.EMPRESTADO);
		this.alEmprestimos.add(emprestimo);
	}

	/**
	 * Realiza o print dos empréstimos atuais
	 */
	public void printEmprestimosAtuais() {
		for (int i = 0; i < alEmprestimos.size(); i++) {
			var emprestimo = alEmprestimos.get(i);
			if (emprestimo.getDataDevolucao() == null)
				System.out.println(emprestimo);
		}
	}

	/**
	 * Realiza o print dos livros emprestados junto com o id do empréstimo
	 */
	public void printLivrosEmprestados() {
		for (int i = 0; i < alEmprestimos.size(); i++) {
			var emprestimo = alEmprestimos.get(i);
			var livro = emprestimo.getLivro();
			if (emprestimo.getDataDevolucao() == null)
				System.out.println(emprestimo.getIdEmprestimo() + " | " + livro.getTitulo());
		}
	}

	/**
	 * Realiza o print de histórico de empréstimos de um livro
	 * 
	 * @param idLivro id do lívro para consultar empréstimo
	 */
	public void printHistoricoEmpresimos(int idLivro) {
		for (int i = 0; i < alEmprestimos.size(); i++) {
			var emprestimo = alEmprestimos.get(i);
			var livro = emprestimo.getLivro();
			if (livro.getIdLivro() == idLivro)
				System.out.println(emprestimo);
		}
	}

	/**
	 * Realiza a devolução de um livro
	 * 
	 * @param idEmprestimo identificador do empréstimo
	 */
	public void devolver(int idEmprestimo) {
		var emprestimo = alEmprestimos.get(idEmprestimo);
		emprestimo.setDataDevolucao(LocalDate.now());
		var livro = emprestimo.getLivro();
		livro.setDispLivro(Disponibilidade.DISPONIVEL);
	}

	public ArrayList<Emprestimo> getAlEmprestimos() {
		return alEmprestimos;
	}

	public void setAlEmprestimos(ArrayList<Emprestimo> alEmprestimos) {
		this.alEmprestimos = alEmprestimos;
	}

	@Override
	public String toString() {
		return "ListaEmprestimos [alEmprestimos=" + alEmprestimos + "]";
	}
}
