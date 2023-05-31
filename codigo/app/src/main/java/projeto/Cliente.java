package projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import projeto.enums.Genero;
import projeto.enums.Idioma;

/**
 * Cliente
 */
public class Cliente {
	private String nome;
	private String senha;
	private List<Serie> listaParaVer;
	private List<Serie> listaJaVista;
    private Map<Midia, Avaliacao> avaliacoes;

	public Cliente(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
		listaParaVer = new ArrayList<Serie>();
		listaJaVista = new ArrayList<Serie>();
		avaliacoes = new HashMap<Midia, Avaliacao>();
	}
	

	/**
	 * Adiciona série a lista
	 * @param serie
	 */
	public void adicionarNaLista(Serie serie) {
		listaParaVer.add(serie);
	}

	/**
	 * Retira série da lista
	 * @param serie
	 */
	public void retirarDaLista(Serie serie) {
		listaParaVer.remove(serie);
	}

	/**
	 * Retorna uma lista das séries que tenham aquele genero da lista a assistir
	 * @param genero
	 * @return
	 */
	public List<Serie> filtrarPorGenero(Genero genero) {
		return listaParaVer.stream()
			.filter(serie -> serie.getGenero().equals(genero)).collect(Collectors.toList());
	}

	/**
	 * Retorna uma lista das séries que tenham aquele idioma da lista a assistir
	 * @param idioma
	 * @return
	 */
	public List<Serie> filtrarPorIdioma(Idioma idioma) {
		return listaParaVer.stream()
			.filter(serie -> serie.getIdioma().equals(idioma)).collect(Collectors.toList());
	}
	/**
	 * Retorna uma lista das séries que tenham aquela quantidade de episodios
	 * @param n_Episodios
	 * @return
	 */
	public List<Serie> filtrarPorQtdEpisodios(int nEpisodios) {
		return listaParaVer.stream()
			.filter(serie -> serie.getQuantidadeDeEpisodios() == nEpisodios).collect(Collectors.toList());
	}
	/**
	 * registra uma audiência na série
	 * @param serie
	 */
	public void registrarAudiencia(Serie serie) {
		serie.registrarAudiencia();
	}
	/**
	 * registra uma nota para a série
	 * @param serie
	 * @param nota
	 */
	public void avalia(Serie serie, int nota, String comentario) {
		Avaliacao avaliacao = new Avaliacao(nota, comentario);
		avaliacoes.put(serie, avaliacao);
		serie.avalia(this, avaliacao);
	}
	
	public void avalia(Serie serie, int nota) {
		Avaliacao avaliacao = new Avaliacao(nota);
		avaliacoes.put(serie, avaliacao);
		serie.avalia(this, avaliacao);
	}

	public String getNome() {
		return nome;
	}

	public List<Serie> getListaParaVer() {
		return listaParaVer;
	}

	public void setListaParaVer(List<Serie> listaParaVer) {
		this.listaParaVer = listaParaVer;
	}

	public List<Serie> getListaJaVista() {
		return listaJaVista;
	}

	public void setListaJaVista(List<Serie> listaJaVista) {
		this.listaJaVista = listaJaVista;
	}

	public boolean isEspecialista() {
		return avaliacoes.size() > 5;
	}

	public boolean login(String nome, String senha) {
		return this.nome == nome && this.senha == senha;
	}

	public String salvar() {
		return nome + "," + senha;
	}

	public static Cliente carregar(String linhacsv) {
		String[] atributos = linhacsv.split(",");
		String nome = atributos[0];
		String senha = atributos[4];
		return new Cliente(nome, senha); 
	}
}
