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

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
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
}
