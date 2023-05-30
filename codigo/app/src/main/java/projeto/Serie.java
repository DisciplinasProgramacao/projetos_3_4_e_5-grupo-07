package projeto;

import projeto.enums.Genero;
import projeto.enums.Idioma;

public class Serie extends Midia {
	private int quantidadeDeEpisodios;

	public Serie(String nome, Genero genero, Idioma idioma) {
		super(nome, genero, idioma);
	}

	public Serie(String nome, Genero genero, Idioma idioma, int quantidadeDeEpisodios) {
		super(nome, genero, idioma);
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
}
