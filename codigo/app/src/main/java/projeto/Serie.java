package projeto;

import projeto.enums.Genero;
import projeto.enums.Idioma;

public class Serie extends Midia {
	private int quantidadeDeEpisodios;

	public Serie(String nome, Genero genero, Idioma idioma, String dataLancamento) {
		super(nome, genero, idioma, dataLancamento);
	}

	public Serie(String nome, Genero genero, Idioma idioma, String dataLancamento, int quantidadeDeEpisodios) {
		super(nome, genero, idioma, dataLancamento);
		this.quantidadeDeEpisodios = quantidadeDeEpisodios;
	}

	public int getQuantidadeDeEpisodios() {
		return quantidadeDeEpisodios;
	}

	public void setQuantidadeDeEpisodios(int quantidadeDeEpisodios) {
		this.quantidadeDeEpisodios = quantidadeDeEpisodios;
	}

	@Override
	public String salvar() {
		return super.salvar() + ";" + quantidadeDeEpisodios;
	}

	public static Serie carregar(String linhacsv) {
		String[] atributos = linhacsv.split(";");
		String nome = atributos[0];
		Genero genero = Genero.fromString(atributos[1]);
		Idioma idioma = Idioma.fromString(atributos[2]);
		String dataLancamento = atributos[3];
		int quantidadeDeEpisodios = Integer.parseInt(atributos[4]);
		Serie serie = new Serie(nome, genero, idioma, dataLancamento, quantidadeDeEpisodios);
		return serie;
	}

	@Override
	public String toString() {
		return super.toString() + " - " + quantidadeDeEpisodios + "eps";
	}

}
