import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClienteTest {
	Private c1 Cliente;
	Serie s1;
	Serie s2;
	Serie s3;


	@BeforeEach
	void setUp() throws InvalidParameterException {
		c1 = new Cliente("Joao","abcd");
		s1 = new Serie ("Serie1", "Ação" ,"Pt-BR", "25/12/2000", 12  );
		s2 = new Serie ("Serie2", "Comedia" ,"Ingles", "30/05/2005", 18  );
		s3 = new Serie ("Serie3", "Drama" ,"Frances", "27/06/2010", 10  );
	}

	@Test
	void AddNaListaTest() {
		c1.adicionarNaLista(s1);
		Assertions.assertTrue(cliente.getListaParaVer().contains(s1));
		c1.adicionarNaLista(s2);
		Assertions.assertTrue(cliente.getListaParaVer().contains(s));
	}

	@Test
	public void adicionarNoHistorico() {

		c1.adicionarNaLista(s1);
		Assertions.assertTrue(cliente.getListaParaVer().contains(s1));
	}


	@Test
	public void retirarDaListaTest() {

		c1.adicionarNaLista(s1);
		c1.adicionarNaLista(s2);

		c1.retirarDaLista("Série 1");
		Assertions.assertFalse(c1.getListaParaVer().contains(s1));
		Assertions.assertTrue(c1.getListaParaVer().contains(s2));
	}

	@Test
	public void testFiltrarPorIdioma() {
		c1.adicionarNaLista(s1);
		List<Midia> resultado = cliente.filtrarPorIdioma("Pt-BR");
		assertEquals(1, resultado.size());
	}

	@Test
	public void testFiltrarPorQtdEpisodios() {
		c1.adicionarNaLista(s1);
		c1.adicionarNaLista(s2);
		c1.adicionarNaLista(s3);
		List<Midia> resultado = c1.filtrarPorQtdEpisodios(10);
		assertEquals(1, resultado.size());
	}

}
