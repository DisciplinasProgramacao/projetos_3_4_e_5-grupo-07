package projeto;

import java.util.Map;

import projeto.enums.Genero;
import projeto.enums.Idioma;

/**
 * Midia
 */
public class Midia {
    private String nome;
    private int audiencia = 0;
    private Genero genero;
    private Idioma idioma;
	private Map<Cliente, Avaliacao> avaliacoes;

	public Midia(String nome, Genero genero, Idioma idioma) {
		this.nome = nome;
		this.genero = genero;
		this.idioma = idioma;
	}

	public Midia(String nome, String genero, String idioma) {
		this.nome = nome;
		this.genero = Genero.fromString(genero);
		this.idioma = Idioma.fromString(idioma);
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

	public void setAudiencia(int audiencia) {
		this.audiencia = audiencia;
	}

	public void avalia(Cliente cliente, Avaliacao avaliacao) {
		avaliacoes.put(cliente, avaliacao);
	}

	public String salvar() {
		return nome + "," + audiencia + "," + genero + "," + idioma;
	}

	public void carrega() {
		
	}
}
