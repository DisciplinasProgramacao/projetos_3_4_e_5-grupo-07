package projeto;

import projeto.enums.Genero;

/**
 * Trailer
 */
public class Trailer {
	private Midia midia;

	public Trailer(Midia midia) {
		this.midia = midia;
	}

	public Trailer(Lancamento midia) {
		this(midia.getMidia());
	}

	public String getNomeMidia() {
		return midia.getNome();
	}
	 
	public Genero getGeneroMidia() {
		return midia.getGenero();
	}

	public String salvar() {
		return midia.getNome();
	}

	@Override
	public String toString() {
		return "Trailer de " + midia.getNome(); 
	}
}
