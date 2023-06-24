package projeto;

import java.util.List;
import java.util.Map;

import projeto.exceptions.MidiaJaAvaliada;

/**
 * ClienteEspecialista
 */
public class ClienteEspecialista extends Cliente {
	public ClienteEspecialista(String nome, String senha) {
		super(nome, senha);
	}
	public ClienteEspecialista(String nome, String senha, Map<Midia, Avaliacao> avaliacoes, List<Midia> historico, List<Midia> minhaLista) {
		super(nome, senha);
		this.avaliacoes = avaliacoes;
		this.setHistorico(historico);
		this.setMinhaLista(minhaLista);
	}
	@Override
	public void avalia(Midia midia, int nota, String comentario) throws MidiaJaAvaliada {
		if (avaliacoes.containsKey(midia))
			throw new MidiaJaAvaliada();
		Avaliacao avaliacao = new Avaliacao(nota);
		avaliacoes.put(midia, avaliacao);
		midia.avalia(this.getNome(), avaliacao);
	}

}
