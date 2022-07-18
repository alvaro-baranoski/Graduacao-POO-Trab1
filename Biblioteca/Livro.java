package Biblioteca;

public class Livro {

	private int idLivro;
	private String titulo;
	private String autor;
	private float preco;
	private Disponibilidade dispLivro;

	// construtor
	public Livro(int idLivro, String titulo, String autor, float preco) {
		super();
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
		this.dispLivro = Disponibilidade.DISPONIVEL;
	}

	// métodos getters, setters, toString, compareTo etc conforme a
	// modelagem e encapsulamento especificados mais o que equipe decidir implementa

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Disponibilidade getDispLivro() {
		return dispLivro;
	}

	public void setDispLivro(Disponibilidade dispLivro) {
		this.dispLivro = dispLivro;
	}

	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", titulo=" + titulo + ", dispLivro=" + dispLivro + ", preco=" + preco
				+ "]";
	}
}
