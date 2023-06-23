package projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import projeto.enums.Genero;
import projeto.enums.Idioma;
import projeto.exceptions.MidiaJaAvaliada;

/**
 * Cliente
 */
public class Cliente {
	private String nome;
	private String senha;
	private List<Midia> minhaLista;
	private List<Midia> historico;
    protected Map<Midia, Avaliacao> avaliacoes;

	public Cliente(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
		minhaLista = new ArrayList<Midia>();
		historico = new ArrayList<Midia>();
		avaliacoes = new HashMap<Midia, Avaliacao>();
	}

	/**
	 * Adiciona série a lista
	 * @param serie
	 */
	public void adicionarNaLista(Midia serie) {
		minhaLista.add(serie);
	}

	/**
	 * Retira série da lista
	 * @param serie
	 */
	public void retirarDaLista(Midia serie) {
		minhaLista.remove(serie);
	}

	/**
	 * Retorna uma lista das séries que tenham aquele genero da lista a assistir
	 * @param genero
	 * @return
	 */
	public List<Midia> filtrarPorGenero(Genero genero) {
		return minhaLista.stream()
			.filter(serie -> serie.getGenero().equals(genero))
			.toList();
	}

	/**
	 * Retorna uma lista das séries que tenham aquele idioma da lista a assistir
	 * @param idioma
	 * @return
	 */
	public List<Midia> filtrarPorIdioma(Idioma idioma) {
		return minhaLista.stream()
			.filter(serie -> serie.getIdioma().equals(idioma))
			.toList();
	}
	/**
	 * Retorna uma lista das séries que tenham aquela quantidade de episodios
	 * @param n_Episodios
	 * @return
	 */
	public List<Serie> filtrarPorQtdEpisodios(int nEpisodios) {
		return minhaLista.stream()
			.filter(Serie.class::isInstance)
			.map(Serie.class::cast)
			.filter(serie -> serie.getQuantidadeDeEpisodios() == nEpisodios)
			.toList();
	}
	/**
	 * registra uma audiência na série
	 * @param midia
	 */
	public void registrarAudiencia(Midia midia) {
		midia.registrarAudiencia();
	}
	/**
	 * registra uma nota para a série
	 * @param midia
	 * @param nota
	 */
	public void avalia(Midia midia, int nota, String comentario) throws MidiaJaAvaliada {
		if (avaliacoes.containsKey(midia))
			return;
		if (!this.isEspecialista()) {
			this.avalia(midia, nota);
			return;
		}
		Avaliacao avaliacao = new Avaliacao(nota, comentario);
		avaliacoes.put(midia, avaliacao);
		midia.avalia(this.getNome(), avaliacao);
	}
	
	public void avalia(Midia midia, int nota) throws MidiaJaAvaliada {
		if (avaliacoes.containsKey(midia))
			return;
		Avaliacao avaliacao = new Avaliacao(nota);
		avaliacoes.put(midia, avaliacao);
		midia.avalia(this.getNome(), avaliacao);
	}

	public String getNome() {
		return nome;
	}

	public List<Midia> getMinhaLista() {
		return minhaLista;
	}

	protected void setMinhaLista(List<Midia> minhaLista) {
		this.historico = minhaLista;
	}

	public List<Midia> getHistorico() {
		return historico;
	}

	public void setHistorico(List<Midia> listaJaVista) {
		this.historico = listaJaVista;
	}

	public boolean isEspecialista() {
		return avaliacoes.size() > 5;
	}

	public boolean login(String nome, String senha) {
		return this.nome.equals(nome) && this.senha.equals(senha);
	}

	public String salvar() {
		return nome + ";" + senha;
	}

	public static Cliente carregar(String linhacsv) {
		String[] atributos = linhacsv.split(";");
		String nome = atributos[0];
		String senha = atributos[1];
		return new Cliente(nome, senha); 
	}
}
