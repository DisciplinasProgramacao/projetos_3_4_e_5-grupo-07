package projeto;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import projeto.enums.Genero;
import projeto.enums.Idioma;
import projeto.exceptions.MidiaJaAvaliada;

/**
 * Midia
 */
public abstract class Midia {
    private String nome;
	private Set<String> audiencia;
    private Genero genero;
    private Idioma idioma;
	public String dataLancamento;
	private Map<String, Avaliacao> avaliacoes;

	public Midia(String nome, Genero genero, Idioma idioma, String dataLancamento) {
		this.nome = nome;
		this.genero = genero;
		this.idioma = idioma;
		this.audiencia = new HashSet<String>();
		this.dataLancamento = dataLancamento;
	}

	public void assistir(Cliente cliente) {
		this.assistir(cliente.getNome());
	}

	public void assistir(String cliente) {
		audiencia.add(cliente);
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

	public int getAudiencia() {
		return audiencia.size();
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
		return nome + ";" + audiencia + ";" + genero + ";" + idioma + ";" + dataLancamento;
	}

	public String salvarAudiencia() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome);
		sb.append(";");
		String elementos = String.join(";", audiencia);
		sb.append(elementos);
		return sb.toString();
	}

	@Override
	public String toString() {
		return nome + " - " + genero + " - " + idioma + " - Lançamento: " + dataLancamento + " - Média: " + this.getMediaAvaliacoes() ;
	}

}
