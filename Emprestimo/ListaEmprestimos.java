package Emprestimo;

import java.time.LocalDate;
import java.util.ArrayList;

import Amigo.Amigo;
import Biblioteca.Disponibilidade;
import Biblioteca.Livro;

public class ListaEmprestimos {

	private ArrayList<Emprestimo> alEmprestimos;

	public ListaEmprestimos() {
		super();
		this.alEmprestimos = new ArrayList<Emprestimo>();
	}

	public void addEmprestimo(Livro livro, Amigo amigo) {
		int idEmprestimo = alEmprestimos.size();
		Emprestimo emprestimo = new Emprestimo(idEmprestimo, LocalDate.now(), livro, amigo);
		livro.setDispLivro(Disponibilidade.EMPRESTADO);
		this.alEmprestimos.add(emprestimo);
	}

	public void printEmprestimosAtuais() {
		for (int i = 0; i < alEmprestimos.size(); i++) {
			var emprestimo = alEmprestimos.get(i);
			if (emprestimo.getDataDevolucao() == null)
				System.out.println(emprestimo);
		}
	}

	public void printLivrosEmprestados() {
		for (int i = 0; i < alEmprestimos.size(); i++) {
			var emprestimo = alEmprestimos.get(i);
			var livro = emprestimo.getLivro();
			if (livro.getDispLivro() == Disponibilidade.EMPRESTADO)
				System.out.println(emprestimo.getIdEmprestimo() + " | " + livro.getTitulo());
		}
	}

	public void printHistoricoEmpresimos(int idLivro) {
		for (int i = 0; i < alEmprestimos.size(); i++) {
			var emprestimo = alEmprestimos.get(i);
			var livro = emprestimo.getLivro();
			if (livro.getIdLivro() == idLivro)
				System.out.println(emprestimo);
		}
	}

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
