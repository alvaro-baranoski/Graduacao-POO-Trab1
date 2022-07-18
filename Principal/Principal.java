package Principal;

import java.util.Scanner;

import Emprestimo.*;
import Amigo.*;
import Biblioteca.*;

/**
 * Classe que contém o método main da aplicação
 */
public class Principal {

	private static Biblioteca bib = new Biblioteca("Biblioteca Pessoal");
	private static ListaEmprestimos emprestimos = new ListaEmprestimos();
	private static ListaAmigos amigos = new ListaAmigos();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		bib.addLivro("Turma da Mônica", "Monteiro Lobato", 20);
		bib.addLivro("Frankenstein", "Mary Shelly", 100);
		bib.addLivro("1984", "George Orwell", 90);
		bib.addLivro("Dom Quixote", "Miguel de Cervantes", 35);
		bib.addLivro("Hamlet", "William Shakespeare", 50);

		amigos.addAmigo("Juninho", "41 9 94023231");
		amigos.addAmigo("Bentinho", "41 9 94123120");
		amigos.addAmigo("Thiaguinho", "41 9 94143120");

		while (true) {
			Integer input = MenuPrincipal();
			switch (input) {
				case 1:
					// cadastrar livro
					cadastrarLivro();
					break;
				case 2:
					// cadastrar amigo
					cadastrarAmigo();
					break;
				case 3:
					// emprestar
					emprestar();
					break;
				case 4:
					// devolver
					devolver();
					break;
				case 5:
					// listar emprestimos atuais
					emprestimos.printEmprestimosAtuais();
					break;
				case 6:
					// listar histórico de empréstimos de um livro
					printHistoricoEmpresimos();
					break;
				case 7:
					// listar toda a biblioteca
					bib.listarBiblioteca(true);
					break;
				case 8:
					// alterar estado
					alterarEstado();
					break;
				default:
					// sair
					System.exit(0);
					break;
			}

			scanner.nextLine();
		}
	}

	/**
	 * Menu principal da aplicação
	 * 
	 * @return o índice da ação desejada
	 */
	private static int MenuPrincipal() {
		System.out.println("MENU PRINCIPAL");
		System.out.println("0 - sair");
		System.out.println("1 - cadastrar livro");
		System.out.println("2 - cadastrar amigo");
		System.out.println("3 - emprestar");
		System.out.println("4 - devolver");
		System.out.println("5 - listar emprestimos atuais");
		System.out.println("6 - listar histórico de empréstimos de um livro");
		System.out.println("7 - listar toda a biblioteca");
		System.out.println("8 - alterar estado");
		return Integer.parseInt(scanner.nextLine());
	}

	/**
	 * Realiza o cadastro de um novo livro
	 */
	private static void cadastrarLivro() {
		System.out.print("Digite o título do livro: ");
		String titulo = scanner.nextLine();

		System.out.print("Digite o autor do livro: ");
		String autor = scanner.nextLine();

		System.out.print("Digite o preço do livro: ");
		float preco = Float.parseFloat(scanner.nextLine());

		bib.addLivro(titulo, autor, preco);
	}

	/**
	 * Cadastra um novo amigo
	 */
	private static void cadastrarAmigo() {
		System.out.println("Digite o nome do amigo: ");
		String nome = scanner.nextLine();

		System.out.println("Digite o celular do amigo: ");
		String celular = scanner.nextLine();

		amigos.addAmigo(nome, celular);
	}

	/**
	 * Realiza o empréstimo de um livro a um amigo
	 */
	private static void emprestar() {
		System.out.println("Código do livro a ser emprestado: ");
		bib.listaLivroParaEmprestimo();
		int idLivro = Integer.parseInt(scanner.nextLine());
		Livro livro = bib.getLivro(idLivro);

		System.out.println("Selecione o amigo que emprestou: ");
		amigos.listarAmigos();
		int idAmigo = Integer.parseInt(scanner.nextLine());
		Amigo amigo = amigos.getAmigo(idAmigo);

		emprestimos.addEmprestimo(livro, amigo);
	}

	/**
	 * Realiza a devolução de um livro
	 */
	private static void devolver() {
		System.out.println("Código do livro a ser devolvido: ");
		emprestimos.printLivrosEmprestados();
		int idEmprestimo = Integer.parseInt(scanner.nextLine());
		emprestimos.devolver(idEmprestimo);
	}

	/**
	 * Realiza o print do histórico de empréstimos
	 */
	private static void printHistoricoEmpresimos() {
		System.out.println("Informe o id do livro: ");
		bib.listarBiblioteca(false);
		int idLivro = Integer.parseInt(scanner.nextLine());
		emprestimos.printHistoricoEmpresimos(idLivro);
	}

	/**
	 * Realiza a alteração de estado de um livro
	 */
	private static void alterarEstado() {
		System.out.println("Informe o id do livro: ");
		bib.listarBiblioteca(false);
		int idLivro = Integer.parseInt(scanner.nextLine());
		System.out.println("Informe o estado: ");
		System.out.println("0 - CONSULTA LOCAL");
		System.out.println("1 - DANIFICADO");
		System.out.println("2 - EXTRAVIADO");
		int idDisp = Integer.parseInt(scanner.nextLine());
		bib.alterarEstado(idLivro, idDisp);
	}
}
