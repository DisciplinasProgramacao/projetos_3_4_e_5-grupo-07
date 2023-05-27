package projeto.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Genero
 */
public enum Genero {
	Acao, Comedia, Suspense, Terror, Romance, Drama, FiccaoCientifica;

	private static final List<Genero> VALUES =
	Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	public static Genero random()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}