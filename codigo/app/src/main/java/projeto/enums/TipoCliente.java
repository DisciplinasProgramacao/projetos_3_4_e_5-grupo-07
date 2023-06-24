package projeto.enums;

import java.util.Arrays;

/**
 * TipoCliente
 */
public enum TipoCliente {
	Comum, Especialista, Profissional;

	@Override
	public String toString() {
		switch (this) {
			case Comum:
				return "Comum";
			case Especialista:
				return "Especialista";
			case Profissional:
				return "Profissional";
			default:
				return null;
		}
	}

	public static TipoCliente fromString(String value) {
		return Arrays.stream(values())
		.filter(tipo -> tipo.toString().equalsIgnoreCase(value))
		.findFirst()
		.orElseThrow(() -> new IllegalArgumentException("Valor inválido para Genero: " + value));
	}
}
