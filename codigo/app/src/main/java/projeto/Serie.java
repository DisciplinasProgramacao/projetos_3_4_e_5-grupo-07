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
		return super.salvar() + "," + quantidadeDeEpisodios;
	}

	@Override
	public Serie carrega(String linhacsv) {
		String[] atributos = linhacsv.split(",");
		String nome = atributos[0];
		int audiencia = Integer.parseInt(atributos[1]);
		Genero genero = Genero.fromString(atributos[2]);
		Idioma idioma = Idioma.fromString(atributos[3]);
		String dataLancamento = atributos[4];
		int quantidadeDeEpisodios = Integer.parseInt(atributos[5]);
		Serie serie = new Serie(nome, genero, idioma, dataLancamento, quantidadeDeEpisodios);
		serie.setAudiencia(audiencia);
		return serie;
	}

}
