package Amigo;

public class Amigo {

	private int idAmigo;
	private String nome;
	private String celular;

	public Amigo(int idAmigo, String nome, String celular) {
		super();
		this.idAmigo = idAmigo;
		this.nome = nome;
		this.celular = celular;
	}

	/**
	 * @return int
	 */
	public int getIdAmigo() {
		return idAmigo;
	}

	/**
	 * @param idAmigo
	 */
	public void setIdAmigo(int idAmigo) {
		this.idAmigo = idAmigo;
	}

	/**
	 * @return String
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nomeAmigo
	 */
	public void setNome(String nomeAmigo) {
		this.nome = nomeAmigo;
	}

	/**
	 * @return String
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @return String
	 */
	@Override
	public String toString() {
		return "Amigo [idAmigo= " + idAmigo + ", nome= " + nome + "]";
	}
}
