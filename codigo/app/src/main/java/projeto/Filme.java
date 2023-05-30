package projeto;

import projeto.enums.Genero;
import projeto.enums.Idioma;

public abstract class Filme extends Midia {
	public Filme(String nome, Genero genero, Idioma idioma, String dataLancamento) {
		super(nome, genero, idioma, dataLancamento);
	}

	@Override
	public Filme carrega(String linhacsv) {
		return null;
	}
}
