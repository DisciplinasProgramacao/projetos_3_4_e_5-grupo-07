package projeto;

import java.util.StringJoiner;

/**
 * Lancamento
 */
public class Lancamento {
	private Midia midia;

	public Lancamento(Midia midia) {
		this.midia = midia;
	}

	public Midia getMidia() {
		return midia;
	}

	public String salvar() {
		return midia.getClass().getName() + ";" + midia.salvar();
	}
	
	public static Lancamento carregar(String linhacsv) {
		Midia midia;
		String[] linha = linhacsv.split(";");
		StringJoiner arg = new StringJoiner(";");
		for (int i = 1; i < linha.length; i++)
			arg.add(linha[i]);
		if (linha[0].equals(Serie.class.getName())) {
			midia = Serie.carregar(arg.toString());
		} else if (linha[0].equals(Filme.class.getName())) {
			midia = Filme.carregar(arg.toString());
		} else {
			return null;
		}
		return new Lancamento(midia);
	}
}
