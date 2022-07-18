package Amigo;

import java.util.ArrayList;

/**
 * Classe que contém a lista de amigos
 */
public class ListaAmigos {

	private ArrayList<Amigo> alAmigos;

	public ListaAmigos() {
		super();
		this.alAmigos = new ArrayList<Amigo>();
	}

	/**
	 * Adiciona um amigo a lista de amigos
	 * 
	 * @param nome    nome do amigo
	 * @param celular celular de amigo
	 * @return id do amigo cadastrado
	 */
	public int addAmigo(String nome, String celular) {
		int idAmigo = alAmigos.size();
		Amigo amigo = new Amigo(idAmigo, nome, celular);
		alAmigos.add(amigo);
		return idAmigo;
	}

	/**
	 * Lista todos os amigos cadastrados
	 */
	public void listarAmigos() {
		for (int i = 0; i < alAmigos.size(); i++) {
			Amigo amigo = alAmigos.get(i);
			System.out.println(amigo);
		}
	}

	/**
	 * Getter de tamanho da lista de amigos
	 * 
	 * @return tamanho da lista de amigos
	 */
	public int getListaAmigosSize() {
		return alAmigos.size();
	}

	/**
	 * Retorna um amigo baseado no index
	 * 
	 * @param i índice do amigo
	 * @return o amigo selecionado
	 */
	public Amigo getAmigo(int i) {
		return alAmigos.get(i);
	}

	/**
	 * Getter de alAmigos
	 * 
	 * @return alAmigos
	 */
	public ArrayList<Amigo> getAlAmigos() {
		return alAmigos;
	}

	/**
	 * Setter de alAmigos
	 * 
	 * @param alAmigos
	 */
	public void setAlAmigos(ArrayList<Amigo> alAmigos) {
		this.alAmigos = alAmigos;
	}

	@Override
	public String toString() {
		return "ListaAmigos [alAmigos=" + alAmigos + "]";
	}
}
