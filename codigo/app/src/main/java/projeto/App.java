package projeto;

import java.io.IOException;
import java.util.Scanner;


public class App {
	static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException {
        PlataformaStreaming plataforma = new PlataformaStreaming(); 
        
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
/*
    

        switch (opcao) {
            case 1:
              
        
            default:
                System.out.println("Opção inválida. Tente novamente.");
        } */
    }
}
