
package projeto;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SerieTest {
	Serie s;
	
	@BeforeEach
	void setUp() throws Exception{
		s = new Serie( "Gotham" , "Acao" , "Portugues" , 49 , 1);
	}
	
	
	@Test
	public void testIdioma() {
		
		assertEquals("Portugues", s.getIdioma());
		
	}
	
	@Test
	public void testGenero() {
		
		assertEquals("Acao", s.getGenero());
		
	}
	
	
	@Test
	public void testQuantidadeEpisodios() {
		
		assertEquals( 49, s.getQuantidadeDeEpisodios());
		
	}
	
	
	@Test
	public void testNome() {
		
		assertEquals("Gotham", s.getNome());
		
	}
	

}

