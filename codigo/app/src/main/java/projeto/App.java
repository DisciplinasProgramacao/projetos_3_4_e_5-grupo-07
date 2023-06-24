package projeto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import com.google.common.collect.Lists;

import projeto.enums.Genero;
import projeto.enums.Idioma;
import projeto.exceptions.MidiaJaAvaliada;

public class App {
	static Scanner scanner = new Scanner(System.in);
    static PlataformaStreaming plataforma = new PlataformaStreaming(); 
    
    public static void main(String[] args) throws IOException {
	    carregaArquivos();
		try {
			while (true) {
				System.out.println("Menu:");
				System.out.println("1. Fazer Login");
				System.out.println("2. Cadastrar cliente");
				System.out.println("3. Cadastrar Midia");
				System.out.println("0. Sair");

				System.out.print("Escolha uma opção: ");
				int opcao = scanner.nextInt();
				scanner.nextLine(); 

				switch (opcao) {
					case 1:
						Login();
						break;
					case 2:
						cadastrarCliente();
						break;
					case 3:
						cadastrarMidia();
						break;
					case 0:
						System.out.println("Saindo...");
						salvaArquivos();
						return;
					default:
						System.out.println("Opção inválida. Tente novamente.");
				}
			}
		} finally {
			salvaArquivos();
		}
    }

	private static void salvaArquivos() {
		try (FileWriter clientes = new FileWriter("clientes.csv", false)) {
			clientes.write(plataforma.salvarClientes());
		} catch (IOException e) {}
		try (FileWriter series = new FileWriter("series.csv", false)) {
			series.write(plataforma.salvarSeries());
		} catch (IOException e) {}
		try (FileWriter filmes = new FileWriter("filmes.csv", false)) {
			filmes.write(plataforma.salvarFilmes());
		} catch (IOException e) {}
		try (FileWriter audiencia = new FileWriter("audiencia.csv", false)) {
			audiencia.write(plataforma.salvarAudiencia());
		} catch (IOException e) {}
		try (FileWriter avaliacoes = new FileWriter("avaliacoes.csv", false)) {
			avaliacoes.write(plataforma.salvarAvaliacoes());
		} catch (IOException e) {}
		try (FileWriter lancamentos = new FileWriter("lancamentos.csv", false)) {
			lancamentos.write(plataforma.salvarLancamentos());
		} catch (IOException e) {}
	}

	private static void carregaArquivos() {
		try ( Scanner arquivofilmes = new Scanner(new File("filmes.csv")) ) {
			List<String> linhas = new LinkedList<String>();
			while (arquivofilmes.hasNextLine()) {
				linhas.add(arquivofilmes.nextLine());
			}
			plataforma.carregarFilmes(linhas);
		} catch (FileNotFoundException e) {}
		try ( Scanner arquivoseries = new Scanner(new File("series.csv")) ) {
			List<String> linhas = new LinkedList<String>();
			while (arquivoseries.hasNextLine()) {
				linhas.add(arquivoseries.nextLine());
			}
			plataforma.carregarSeries(linhas);
		} catch (FileNotFoundException e) {}
		try ( Scanner arquivoclientes = new Scanner(new File("clientes.csv")) ) {
			List<String> linhas = new LinkedList<String>();
			while (arquivoclientes.hasNextLine()) {
				linhas.add(arquivoclientes.nextLine());
			}
			plataforma.carregarClientes(linhas);
		} catch (FileNotFoundException e) {}
		try ( Scanner arquivoAudiencia = new Scanner(new File("audiencia.csv")) ) {
			List<String> linhas = new LinkedList<String>();
			while (arquivoAudiencia.hasNextLine()) {
				linhas.add(arquivoAudiencia.nextLine());
			}
			plataforma.carregarAudiencia(linhas);
		} catch (FileNotFoundException e) {}
		try ( Scanner arquivoAvaliacoes = new Scanner(new File("avaliacoes.csv")) ) {
			List<String> linhas = new LinkedList<String>();
			while (arquivoAvaliacoes.hasNextLine()) {
				linhas.add(arquivoAvaliacoes.nextLine());
			}
			plataforma.carregarAvaliacoes(linhas);
		} catch (FileNotFoundException e) {}
		try ( Scanner arquivoLancamentos = new Scanner(new File("lancamentos.csv")) ) {
			List<String> linhas = new LinkedList<String>();
			while (arquivoLancamentos.hasNextLine()) {
				linhas.add(arquivoLancamentos.nextLine());
			}
			plataforma.carregarLancamentos(linhas);
		} catch (FileNotFoundException e) {}
	}

    private static void cadastrarCliente() {
		int tipo;
		while (true) {
			System.out.println("Selecione o Tipo de Cliente");
			System.out.println("1: Comum");
			System.out.println("2: Profissional");
			tipo = scanner.nextInt();
			if (tipo == 1 || tipo == 2)
				break;
			System.out.println("Resposta Inválida");
		}

        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();

        System.out.println("Digite a senha do cliente:");
        String senha = scanner.nextLine();

        Cliente cliente = null;
		switch (tipo) {
			case 1:
				cliente = new ClienteComum(nome, senha);
			case 2:
				cliente = new ClienteProfissional(nome, senha);
		}
        plataforma.adicionarCliente(cliente);
        System.out.println("Cliente adicionado com sucesso!");

    }

   private static void cadastrarMidia() {

		System.out.println("Escolha o tipo de mídia:");
		System.out.println("1. Série");
		System.out.println("2. Filme");

		System.out.print("Digite a opção: ");
		int opcao = scanner.nextInt();

		Genero genero;
		Idioma idioma;
         
		Midia midia;
		while (true) {
			switch (opcao) {
				case 1:
					System.out.println("Digite o nome da série:");
					String nome = scanner.nextLine();

					genero = selecionaEnum("Selecione o Genero", Genero.class);

					idioma = selecionaEnum("Selecione o Idioma", Idioma.class);

					scanner.nextLine();
					System.out.println("Digite a data de lançamento no formato dd/MM/yyyy:");
					String dataLancamento = scanner.nextLine();

					System.out.println("Digite o número de episodios:");
					int qtdEpisodios = scanner.nextInt();
					 
					midia = new Serie(nome, genero, idioma, dataLancamento, qtdEpisodios);
					break;
				case 2:
					System.out.println("Digite o nome do filme:");
					String nomeFilme = scanner.nextLine();

					genero = selecionaEnum("Selecione o Genero", Genero.class);

					idioma = selecionaEnum("Selecione o Idioma", Idioma.class);

					scanner.nextLine();
					System.out.println("Digite a data de lançamento no formato dd/MM/yyyy:");
					String dataLancamentoFilme = scanner.nextLine();

					midia = new Filme(nomeFilme, genero, idioma,dataLancamentoFilme);
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
					continue;
			}
			break;
		}
		System.out.println("A mídia é um lançamento?");
		System.out.println("1: Sim");
		System.out.println("2: Não");
		while (true) {
			opcao = scanner.nextInt();
			switch (opcao) {
				case 1:
					plataforma.adicionarLancamento(midia);
					break;
				case 2:
					plataforma.adicionarMidia(midia);
					break;
				default:
					System.out.println("Opção inválida");
					continue;
			}
			break;
		}
		plataforma.adicionarMidia(midia);
		System.out.println("Mídia adicionada com sucesso!");
    }

	private static void Login() {
		while (true) {
			System.out.print("Informe o usuário: ");
			String usuario = scanner.nextLine();
			System.out.print("Informe a Senha: ");
			String senha = scanner.nextLine();
			if (plataforma.login(usuario, senha)) {
				menuLogado();
			} else {
				System.out.println("Usuário ou senha incorretos");
				System.out.print("Selecione 0 para sair e 1 para tentar denovo: ");
				if (scanner.nextInt() == 0) {
					break;
				}
				continue;
			}
			break;
		}
	}

	private static void selecionaMidia(List<? extends Midia> midias) {
		apresentaMidias(midias);
		int opcao;
		while (true) {
			System.out.print("Selecione uma opção ou aperte 0 para sair: ");
			opcao = scanner.nextInt();
			if (opcao == 0) {
				return;
			} else if (opcao < 0 || opcao > midias.size()) {
				System.out.println("Opção inválida, tente novamente");
				continue;
			}
			break;
		}
		menuMidia(midias.get(opcao - 1));
	}

	private static void apresentaMidias(List<? extends Midia> lista) {
		IntStream.range(0, lista.size())
			.forEach(i -> {
				Midia midia = lista.get(i);
				System.out.println((i + 1) + ": " + midia);
			});
	}

	private static void menuLogado() {
		Cliente cliente = plataforma.getClienteAtual();
		while (true) {
			System.out.println("Bem vindo " + cliente.getNome());
			System.out.println("1: Ver Mídias");
			System.out.println("2: Ver minha lista");
			System.out.println("3: Ver histórico");
			System.out.println("4: Ver Trailers");
			if (cliente instanceof ClienteProfissional)
				System.out.println("5: Ver Lançamentos");
			System.out.println("0: Logout");
			int opcao = scanner.nextInt();
			switch (opcao) {
				case 1:
					System.out.println("Mídias");
					verMidias();
					break;
				case 2:
					System.out.println("Minha Lista:");
					selecionaMidia(cliente.getHistorico());
				break;
				case 3:
					System.out.println("Histórico:");
					selecionaMidia(cliente.getMinhaLista());
					break;
				case 4:
					break;
				case 5:
					selecionaMidia(plataforma.getLancamentos());
					break;
				case 0:
					plataforma.logout();
					return;
				default:
					System.out.println("Opção inválida");
			}
		}
	}

	private static void menuMidia(Midia midia) {
		while (true) {
			System.out.println("Selecione uma opção");
			System.out.println("1: Assistir");
			System.out.println("2: Avaliar");
			System.out.println("3: Adicionar a sua Lista");
			System.out.println("0: voltar");
			int option = scanner.nextInt();
			switch (option) {
				case 1:
					plataforma.assistir(midia);;
					break;
				case 2:
					menuAvaliacao(midia);
					break;
				case 3:
					plataforma.getClienteAtual().adicionarNaLista(midia);
					break;
				case 0:
					return;
				default:
					System.out.println("Opção Inválida");
			}
		}
	}

	private static void menuAvaliacao(Midia midia) {
		Cliente cliente = plataforma.getClienteAtual();
		try {
			while (true) {
				System.out.println("Selecione a nota de 1 a 5");
				double nota = scanner.nextDouble();
				if (nota > 5 || nota < 1) {
					continue;
				}
				if (!(cliente instanceof ClienteComum)) {
					cliente.avalia(midia, nota);
				} else {
					System.out.println("Digite o comentario da avaliacao");
					String comentario = scanner.nextLine();
					cliente.avalia(midia, nota, comentario);
				}
				System.out.println("Avaliação registrada");
				break;
			}
		} catch (MidiaJaAvaliada e) {
			System.out.println("Você já avaliou essa mídia");
		}
	}

	private static <T extends Enum<T>> T selecionaEnum(String mensagem, Class<T> enumclass) {
		T[] valores = enumclass.getEnumConstants();
		while (true) {
			System.out.println(mensagem);
			IntStream.range(0, valores.length)
				.forEach(index -> System.out.println(index + ": " + valores[index]));
			int opcao = scanner.nextInt();
			if (opcao < 0 || opcao >= valores.length) {
				System.out.println("Valor inválido");
				continue;
			}
			return valores[opcao];
		}
	}

	private static void verMidias() {
		System.out.println("Selecione o tipo de filtro para a mídia");
		System.out.println("1: Genero");
		System.out.println("2: Idioma");
		System.out.println("3: Quantidade de Episódios(Somente séries)");
		System.out.println("0: Mostrar tudo");
		int opcao;
		while (true) {
			opcao = scanner.nextInt();
			switch (opcao) {
				case 1:
					selecionaMidia(plataforma.filtrarPorGenero(selecionaEnum("Selecione o genero", Genero.class).toString()));
					break;
				case 2:
					selecionaMidia(plataforma.filtrarPorIdioma(selecionaEnum("Selecione o idioma", Idioma.class).toString()));
					break;
				case 3:
					System.out.print("Digite o número de episódios: ");
					selecionaMidia(plataforma.filtrarPorQtdEpisodios(scanner.nextInt()));
					break;
				case 0:
					selecionaMidia(plataforma.getMidias());
					break;
				default:
					System.out.println("Opção inválida");
					continue;
			}
			break;
		}
	}

	private static void CriaTrailer() {
		List<Midia> midias = plataforma.getMidias();
		midias.addAll(plataforma.getLancamentos());
		System.out.println("Escolha de qual mídia deve ser o trailer");
		apresentaMidias(midias);
		int opcao = 0;
		while (true) {
			opcao = scanner.nextInt();
			if (opcao < 0 || opcao >= midias.size()) {
				System.out.print("Opção invalida, selecione novamente: ");
				continue;
			}
			break;
		}
		plataforma.adicionarTrailer(new Trailer(midias.get(opcao)));
		System.out.println("Trailer adicionado com sucesso!");
	};
}
