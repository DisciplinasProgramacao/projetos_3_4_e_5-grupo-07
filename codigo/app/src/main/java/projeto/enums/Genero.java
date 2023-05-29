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

	public String toString() {
		switch (this) {
			case Acao:
				return "Ação";
			case Comedia:
				return "Comédia";
			case Suspense:
				return "Suspense";
			case Terror:
				return "Terror";
			case Romance:
				return "Romance";
			case Drama:
				return "Drama";
			case FiccaoCientifica:
				return "Ficção Cientifica";
			default:
				return null;
		}
	}

	public static Genero fromString(String value) {
		return Arrays.stream(values())
		.filter(genero -> genero.toString().equalsIgnoreCase(value))
		.findFirst()
		.orElseThrow(() -> new IllegalArgumentException("Valor inválido para Genero: " + value));
	}
}
