package Amigo;

import java.util.ArrayList;

public class ListaAmigos {

	private ArrayList<Amigo> alAmigos;

	// construtor cria alAmigos, ArrayList que fica encapsulado na classe
	// ListaAmigos
	public ListaAmigos() {
		super();
		this.alAmigos = new ArrayList<Amigo>();
	}

	public int addAmigo(String nome, String celular) {
		int idAmigo = alAmigos.size();
		Amigo amigo = new Amigo(idAmigo, nome, celular);
		alAmigos.add(amigo);
		return idAmigo;
	}

	public void listarAmigos() {
		for (int i = 0; i < alAmigos.size(); i++) {
			Amigo amigo = alAmigos.get(i);
			System.out.println(amigo);
		}
	}

	public int getListaAmigosSize() {
		return alAmigos.size();
	}

	public Amigo getAmigo(int i) {
		return alAmigos.get(i);
	}

	// demais m�todos getters, setters etc necess�rios
	// toString
	public ArrayList<Amigo> getAlAmigos() {
		return alAmigos;
	}

	public void setAlAmigos(ArrayList<Amigo> alAmigos) {
		this.alAmigos = alAmigos;
	}

	@Override
	public String toString() {
		return "ListaAmigos [alAmigos=" + alAmigos + "]";
	}
}
