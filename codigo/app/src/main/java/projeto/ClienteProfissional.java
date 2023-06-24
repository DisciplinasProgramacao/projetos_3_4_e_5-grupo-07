package projeto;

/**
 * ClienteProfissional
 */
public class ClienteProfissional extends Cliente {
	public ClienteProfissional(String nome, String senha) {
		super(nome, senha);
	}

	@Override
	public String toString() {
		return super.toString() + ";Profissional";
	}

}
