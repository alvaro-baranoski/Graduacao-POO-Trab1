package Emprestimo;

import java.time.LocalDate;

import Amigo.Amigo;
import Biblioteca.Livro;

public class Emprestimo {

	private int idEmprestimo;
	private int idLivro;
	private int idAmigo;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	private Livro livro;
	private Amigo amigo;

	public Emprestimo(int idEmprestimo, LocalDate dataEmprestimo, Livro livro, Amigo amigo) {
		super();
		this.idEmprestimo = idEmprestimo;
		this.dataEmprestimo = dataEmprestimo;
		this.livro = livro;
		this.amigo = amigo;
	}

	public int getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public int getIdAmigo() {
		return idAmigo;
	}

	public void setIdAmigo(int idAmigo) {
		this.idAmigo = idAmigo;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Amigo getAmigo() {
		return amigo;
	}

	public void setAmigo(Amigo amigo) {
		this.amigo = amigo;
	}

	@Override
	public String toString() {
		return "Emprestimo [livro=" + livro.getTitulo() + ", amigo=" + amigo.getNome() + ", dataEmprestimo="
				+ dataEmprestimo + ", dataDevolucao=" + dataDevolucao + "]";
	}

}
