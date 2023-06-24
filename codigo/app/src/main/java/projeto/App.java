package projeto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import projeto.enums.Genero;
import projeto.enums.Idioma;

public class App {
	static Scanner scanner = new Scanner(System.in);
    static PlataformaStreaming plataforma = new PlataformaStreaming(); 
    
    public static void main(String[] args) throws IOException {
	    carregaArquivos();
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
    }

	private static void salvaArquivos() {
		try (FileWriter clientes = new FileWriter("clientes.csv", false)) {
			clientes.write(plataforma.salvarClientes());
		} catch (IOException e) {}
		try (FileWriter series = new FileWriter("series.csv", false)) {
			series.write(plataforma.salvarSeries());
		} catch (IOException e) {}
		try (FileWriter arquivoclientes = new FileWriter("filmes.csv", false)) {
			arquivoclientes.write(plataforma.salvarFilmes());
		} catch (IOException e) {}
	}

	private static void carregaArquivos() {
		try ( Scanner arquivofilmes = new Scanner(new File("filmes.csv")) ) {
			List<String> filmes = new LinkedList<String>();
			while (arquivofilmes.hasNextLine()) {
				filmes.add(arquivofilmes.nextLine());
			}
			plataforma.carregarFilmes(filmes);
		} catch (FileNotFoundException e) {}
		try ( Scanner arquivoseries = new Scanner(new File("series.csv")) ) {
			List<String> series = new LinkedList<String>();
			while (arquivoseries.hasNextLine()) {
				series.add(arquivoseries.nextLine());
			}
			plataforma.carregarSeries(series);
		} catch (FileNotFoundException e) {}
		try ( Scanner arquivoclientes = new Scanner(new File("clientes.csv")) ) {
			List<String> clientes = new LinkedList<String>();
			while (arquivoclientes.hasNextLine()) {
				clientes.add(arquivoclientes.nextLine());
			}
			plataforma.carregarClientes(clientes);
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
         scanner.nextLine(); // Limpar o buffer do scanner
         
         
         switch (opcao) {
             case 1:
            	 System.out.println("Digite o nome da série:");
                 String nome = scanner.nextLine();


                 System.out.println("Digite o nome da genero:");
                 String generoSerie = scanner.nextLine();
                 
                 System.out.println("Digite o nome da linguagem:");
                 String linguagemSerie = scanner.nextLine();

                 System.out.println("Digite a data de lançamento no formato dd/MM/yyyy:");
                 String dataLancamento = scanner.nextLine();

                 System.out.println("Digite o número de episodios:");
                 int qtdEpisodios = scanner.nextInt();
              

                 Serie serie = new Serie(nome, Genero.fromString(generoSerie), Idioma.fromString(linguagemSerie), dataLancamento, qtdEpisodios);
                 plataforma.adicionarMidia(serie);
                 System.out.println("Série adicionada com sucesso!");
                 break;

             case 2:
                
                 System.out.println("Digite o nome do filme:");
                 String nomeFilme = scanner.nextLine();
                
                 
                 System.out.println("Digite o nome do genero:");
                 String generoFilme = scanner.nextLine();
                
                 
                 System.out.println("Digite o nome do linguagem:");
                 String linguaFilme = scanner.nextLine();
                
                 
                 System.out.println("Digite a data de lançamento no formato dd/MM/yyyy:");
                 String dataLancamentoFilme = scanner.nextLine();

                 Filme filme = new Filme(nomeFilme, Genero.fromString(generoFilme), Idioma.fromString(linguaFilme),dataLancamentoFilme);
                 plataforma.adicionarMidia(filme);
                 System.out.println("Filme adicionado com sucesso!");
                 break;
             default:
                 System.out.println("Opção inválida. Tente novamente.");
         }
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
			System.out.println("0: Logout");
			int opcao = scanner.nextInt();
			switch (opcao) {
				case 1:
					System.out.println("Mídias");
					selecionaMidia(plataforma.getMidias());
					break;
				case 2:
					System.out.println("Minha Lista:");
					selecionaMidia(cliente.getHistorico());
				break;
				case 3:
					System.out.println("Histórico:");
					selecionaMidia(cliente.getMinhaLista());
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
			System.out.println("2: Ver Trailer");
			System.out.println("3: Avaliar");
			System.out.println("4: Adicionar a sua Lista");
			System.out.println("0: voltar");
			int option = scanner.nextInt();
			switch (option) {
				case 1:
					midia.assistir();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					return;
			}
		}
	}
}
