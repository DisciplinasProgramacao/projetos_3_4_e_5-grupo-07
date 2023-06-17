package projeto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import projeto.enums.Genero;
import projeto.enums.Idioma;

public class App {
	private enum TipoMidia {
		Filme, Serie, All;
	}


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
					break;
                case 2:
                    cadastrarCliente(plataforma);
                    break;
                case 3:
                    cadastrarMidia(plataforma);
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

    private static void cadastrarCliente(PlataformaStreaming plataforma) {
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();

        System.out.println("Digite a senha do cliente:");
        String senha = scanner.nextLine();

        Cliente cliente = new Cliente(nome, senha);
        plataforma.adicionarCliente(cliente);
        System.out.println("Cliente adicionado com sucesso!");

    }

   private static void cadastrarMidia(PlataformaStreaming plataforma) {
    	
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

	private static Midia selecionaMidia(TipoMidia tipo) {
		return null;
	}
}
