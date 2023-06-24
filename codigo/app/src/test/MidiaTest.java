import static org.junit.jupiter.api.Assertions.*;
import Exceptions.SenhaFracaException;
import Exceptions.SenhaIncorretaException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class MidiaTest {


	public void testCriandoFilme() {
		String nome = "Filme Teste";
		String genero = "Ação";
		String idioma = "Português";
		String dataLancamento = "20/05/2001";
		Midia midia = new Filme(nome, idioma, genero, dataLancamento);
		Assert.assertEquals("Filme Teste", midia.getNome());
		Assert.assertEquals(idioma, midia.getIdioma());
		Assert.assertEquals(genero, midia.getGenero());
	}

	@Test
	public void deveAdicionarUmaAvaliacao() throws IllegalArgumentException, SenhaFracaException {

		String nome = "Filme Teste";
		String genero = "Ação";
		String idioma = "Português";
		String dataLancamento = "20/05/2001";
		Cliente c1 = new Cliente("Joao","abcd");

		Midia m = new Filme(nome, idioma, genero, dataLancamento);

		Avaliacao a = new Avaliacao(c1.getLogin(), 4);

		m.addAvaliacao(a);

		Assert.assertEquals(1, m.getTodasAvaliacoes().size());

	}
}
