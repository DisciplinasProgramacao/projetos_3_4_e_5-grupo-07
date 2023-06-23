package projeto;

import java.util.List;
import java.util.Map;

/**
 * ClienteEspecialista
 */
public class ClienteEspecialista extends Cliente {
	public ClienteEspecialista(String nome, String senha) {
		super(nome, senha);
	}
	public ClienteEspecialista(String nome, String senha, Map<Midia, Avaliacao> avaliacoes, List<Midia> historico, List<Midia> minhaLista) {
		super(nome, senha);
	}
}
