package projeto;

import projeto.enums.Genero;
import projeto.enums.Idioma;

public abstract class Filme extends Midia {
	public Filme(String nome, Genero genero, Idioma idioma) {
		super(nome, genero, idioma);
	}
}
