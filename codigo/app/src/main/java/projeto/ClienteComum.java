package projeto;

/**
 * ClienteComum
 */
public class ClienteComum extends Cliente {
	public ClienteComum() {
		super();
	}

	public ClienteComum(String nome, String senha) {
		super(nome, senha);
	}

	@Override
	public String salvar() {
		return super.salvar() + ";Comum";
	}

}
