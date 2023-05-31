package projeto;

import java.io.FileWriter;
import java.io.IOException;
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

	public static void salvaArquivos() {
		try (FileWriter filmes = new FileWriter("clientes.csv", false)) {
			filmes.write(plataforma.salvarClientes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (FileWriter filmes = new FileWriter("series.csv", false)) {
			filmes.write(plataforma.salvarSeries());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (FileWriter filmes = new FileWriter("filmes.csv", false)) {
			filmes.write(plataforma.salvarFilmes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
