package projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Cliente
 */
public class Cliente {
	private String nomeDeUsuario;
	private String senha;
	private List<Serie> listaParaVer;
	private List<Serie> listaJaVista;
	private boolean especialista;
    private Map<Midia, Avaliacao> avaliacoes;

	public Cliente(String nomeDeUsuario, String senha) {
		this.nomeDeUsuario = nomeDeUsuario;
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
	public List<Serie> filtrarPorGenero(String genero) {
		return listaParaVer.stream()
			.filter(serie -> serie.getGenero().equals(genero)).collect(Collectors.toList());
	}

	/**
	 * Retorna uma lista das séries que tenham aquele idioma da lista a assistir
	 * @param idioma
	 * @return
	 */
	public List<Serie> filtrarPorIdioma(String idioma) {
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
	public void registrarAvaliacao(Serie serie, int nota) {
		serie.setAvaliacao(nota);
	}



	public String getNomeDeUsuario() {
		return nomeDeUsuario;
	}



	public void setNomeDeUsuario(String nomeDeUsuario) {
		this.nomeDeUsuario = nomeDeUsuario;
	}



	public String getSenha() {
		return senha;
	}



	public void setSenha(String senha) {
		this.senha = senha;
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
		return especialista;
	}


	public void setEspecialista(boolean especialista) {
		this.especialista = especialista;
	}
}
