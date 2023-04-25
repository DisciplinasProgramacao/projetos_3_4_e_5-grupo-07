package projeto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Filme {

	 public static void main(String[] args) {
	        String nomeArquivo = "POO_Filmes.csv";

	        try (FileReader fr = new FileReader(nomeArquivo);
	             BufferedReader br = new BufferedReader(fr)) {

	            String linha;
	            while ((linha = br.readLine()) != null) {
	                System.out.println(linha);
	            }

	        } catch (FileNotFoundException e) {
	            System.err.println("Arquivo não encontrado: " + nomeArquivo);
	        } catch (IOException e) {
	            System.err.println("Erro durante a leitura do arquivo: " + e.getMessage());
	        }
	    }
}
