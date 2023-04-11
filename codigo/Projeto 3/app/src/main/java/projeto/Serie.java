package projeto;

public class Serie {
	private String[] GENEROS;
	private String nome;
	private String genero;
	private String idioma;
	private int quantidadeDeEpisodios;
	private int audiencia;



	public Serie(String[] GENEROS, String nome, String genero, String idioma, int quantidadeDeEpisodios) {
		this.GENEROS = GENEROS;
		this.nome = nome;
		this.genero = genero;
		this.idioma = idioma;
		this.quantidadeDeEpisodios = quantidadeDeEpisodios;
	}


	public Serie() {
	}


	public void registrarAudiencia() {
		audiencia++;
	}

	public String[] getGENEROS() {
		return GENEROS;
	}

	public void setGENEROS(String[] GENEROS) {
		this.GENEROS = GENEROS;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getQuantidadeDeEpisodios() {
		return quantidadeDeEpisodios;
	}

	public void setQuantidadeDeEpisodios(int quantidadeDeEpisodios) {
		this.quantidadeDeEpisodios = quantidadeDeEpisodios;
	}

	public int getAudiencia() {
		return audiencia;
	}

	public void setAudiencia(int audiencia) {
		this.audiencia = audiencia;
	}
}
