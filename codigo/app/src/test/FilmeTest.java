
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.security.InvalidParameterException;
import static org.junit.jupiter.api.Assertions.*;

class FilmeTest {
    private Filme filme;

    @BeforeEach
    void setUp() throws InvalidParameterException {
        filme = new Filme(1, "Filme Teste", "Romance","Portugues", 2010);
    }

    @Test
    void getDuracaoTest() {
        String nome = filme.getNome();
        assertEquals("Filme Teste", nome);
    }

    
    @Test
    void toStringTest() {
        String resultadoEsperado = "1;Filme Teste;Romance;Portugues;25/10/2000";
        String resultadoObtido = filme.toString();
        assertEquals(resultadoEsperado, resultadoObtido);
    }
}
