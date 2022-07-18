package Amigo;

/**
 * Classe que mapeia um amigo que empresta um livro
 */
public class Amigo {

	private int idAmigo;
	private String nome;
	private String celular;

	/**
	 * Construtor da classe Amigo
	 * 
	 * @param idAmigo identificador único do amigo
	 * @param nome    Nome do amigo
	 * @param celular Celular do amigo
	 */
	public Amigo(int idAmigo, String nome, String celular) {
		super();
		this.idAmigo = idAmigo;
		this.nome = nome;
		this.celular = celular;
	}

	/**
	 * getter de IdAmigo
	 * 
	 * @return int
	 */
	public int getIdAmigo() {
		return idAmigo;
	}

	/**
	 * Setter de IdAmigo
	 * 
	 * @param idAmigo
	 */
	public void setIdAmigo(int idAmigo) {
		this.idAmigo = idAmigo;
	}

	/**
	 * Getter de nome
	 * 
	 * @return String
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Setter de nome
	 * 
	 * @param nomeAmigo
	 */
	public void setNome(String nomeAmigo) {
		this.nome = nomeAmigo;
	}

	/**
	 * Getter de celular
	 * 
	 * @return String
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * Setter de celular
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "Amigo [idAmigo= " + idAmigo + ", nome= " + nome + "]";
	}
}
