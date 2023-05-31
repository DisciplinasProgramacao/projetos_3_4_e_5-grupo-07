package projeto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
	static Scanner scanner = new Scanner(System.in);
    static PlataformaStreaming plataforma = new PlataformaStreaming(); 
    
    public static void main(String[] args) throws IOException {
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
    }

	private static void salvaArquivos() {
		try (FileWriter clientes = new FileWriter("clientes.csv", false)) {
			clientes.write(plataforma.salvarClientes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (FileWriter series = new FileWriter("series.csv", false)) {
			series.write(plataforma.salvarSeries());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (FileWriter arquivoclientes = new FileWriter("filmes.csv", false)) {
			arquivoclientes.write(plataforma.salvarFilmes());
		} catch (IOException e) {
			e.printStackTrace();
		}
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
}
