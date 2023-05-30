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
		return null;
	}

}
