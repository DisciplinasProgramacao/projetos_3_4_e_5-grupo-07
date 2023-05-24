package projeto.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Idioma
 */
public enum Idioma {
	Ingles, Portugues, Espanhol;

	private static final List<Idioma> VALUES =
	Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	public static Idioma random()  {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
