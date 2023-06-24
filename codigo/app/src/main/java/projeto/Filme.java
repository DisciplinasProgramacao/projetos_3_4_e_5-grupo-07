package projeto;

import projeto.enums.Genero;
import projeto.enums.Idioma;

public class Filme extends Midia {
	public Filme(String nome, Genero genero, Idioma idioma, String dataLancamento) {
		super(nome, genero, idioma, dataLancamento);
	}

	public static Filme carregar(String linhacsv) {
		String[] atributos = linhacsv.split(";");
		String nome = atributos[0];
		Genero genero = Genero.fromString(atributos[1]);
		Idioma idioma = Idioma.fromString(atributos[2]);
		String dataLancamento = atributos[3];
		Filme filme = new Filme(nome, genero, idioma, dataLancamento);
		return filme;
	}
}
