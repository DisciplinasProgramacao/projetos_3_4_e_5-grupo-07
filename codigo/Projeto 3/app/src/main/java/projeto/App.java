import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.util.Scanner;


public class App {
    
    public static void main(String[] args) throws IOException {
        
        

        PlataformaStreaming plataforma = new PlataformaStreaming(); 
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar cliente");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarCliente(plataforma, scanner);
                    break;
                case 2:
                    cadastrarMidia(plataforma, scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarCliente(PlataformaStreaming plataforma, Scanner scanner) {
        System.out.println("Digite o nome completo do cliente:");
        String nCompleto = scanner.nextLine();

        System.out.println("Digite o nome de usuário do cliente:");
        String nUsuario = scanner.nextLine();

        System.out.println("Digite a senha do cliente:");
        String password = scanner.nextLine();

        Cliente cliente = new Cliente(nCompleto, nUsuario);
        plataforma.adicionarCliente(cliente);
        System.out.println("Cliente adicionado com sucesso!");

    }

    private static void cadastrarMidia(PlataformaStreaming plataforma, Scanner scanner) {

    

        switch (opcao) {
            case 1:
              
        
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
