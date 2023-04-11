package projeto;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Cliente
 */
public class Cliente {
	private String nomeDeUsuario;
	private String senha;
	private List<Serie> listaParaVer;
	private List<Serie> listaJaVista;

	public Cliente(String nomeDeUsuario, String senha) {
		this.nomeDeUsuario = nomeDeUsuario;
		this.senha = senha;
		listaParaVer = new ArrayList<Serie>();
		listaJaVista = new ArrayList<Serie>();
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
	public List<Serie> filtarPorGenero(String genero) {
		return listaParaVer.stream()
			.filter(serie -> serie.getGenero().equals(genero)).collect(Collectors.toList());
	}

	/**
	 * Retorna uma lista das séries que tenham aquela quantidade de episodios
	 * @param n_Episodios
	 * @return
	 */
	public List<Serie> filtarPorQuantidadeDeEpisodio(int n_Episodios) {
		return listaParaVer.stream()
			.filter(serie -> serie.getQuantidadeDeEpisodios() == n_Episodios).collect(Collectors.toList());
	}

	/**
	 * registra uma audiência na série
	 * @param serie
	 */
	public void registrarAudiencia(Serie serie) {
		serie.registrarAudiencia();
	}
}
