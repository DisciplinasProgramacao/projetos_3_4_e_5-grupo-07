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

	public String toString() {
		switch (this) {
			case Ingles:
				return "Ingles";
			case Portugues:
				return "Português";
			case Espanhol:
				return "Espanhol";
			default:
				return null;
		}
	}

	public static Idioma fromString(String value) {
		return Arrays.stream(values())
		.filter(idioma -> idioma.toString().equalsIgnoreCase(value))
		.findFirst()
		.orElseThrow(() -> new IllegalArgumentException("Valor inválido para Genero: " + value));
	}
}
