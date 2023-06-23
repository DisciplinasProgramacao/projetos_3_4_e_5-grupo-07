package projeto;

import java.util.Map;

import projeto.enums.Genero;
import projeto.enums.Idioma;
import projeto.exceptions.MidiaJaAvaliada;

/**
 * Midia
 */
public abstract class Midia {
    private String nome;
    private int audiencia = 0;
    private Genero genero;
    private Idioma idioma;
	public String dataLancamento;
	private Map<String, Avaliacao> avaliacoes;

	public Midia(String nome, Genero genero, Idioma idioma, String dataLancamento) {
		this.nome = nome;
		this.genero = genero;
		this.idioma = idioma;
		this.dataLancamento = dataLancamento;
	}

	public void registrarAudiencia() {
		audiencia++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public void setGenero(String genero) {
		this.genero = Genero.fromString(genero);
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = Idioma.fromString(idioma);
	}

	public int getAudiencia() {
		return audiencia;
	}

	protected void setAudiencia(int audiencia) {
		this.audiencia = audiencia;
	}

	public double getMediaAvaliacoes() {
		return avaliacoes.values().stream()
		.mapToDouble(Avaliacao::getNota)
		.average().orElse(0);
	}

	public void avalia(String cliente, Avaliacao avaliacao) throws MidiaJaAvaliada {
		if (avaliacoes.containsKey(cliente)) {
			throw new MidiaJaAvaliada();
		}
		avaliacoes.put(cliente, avaliacao);
	}

	public String salvar() {
		return nome + "," + audiencia + "," + genero + "," + idioma + "," + dataLancamento;
	}

	@Override
	public String toString() {
		return nome + " - " + genero + " - " + idioma + " - Lançamento: " + dataLancamento ;
	}
}
