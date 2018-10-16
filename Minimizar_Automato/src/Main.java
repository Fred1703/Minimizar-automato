import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner readName = new Scanner(System.in);
	    System.out.println("Informe o nome de arquivo:\n");
	    String nome = readName.nextLine();
	    try {
	      FileReader arq = new FileReader(nome);
	      BufferedReader bufferArq = new BufferedReader(arq);
	      String bufferLinha = bufferArq.readLine();
	      Estados est = new Estados();
		  Transitions tr = new Transitions();
	      while (bufferLinha != null) {

	    	  if (bufferLinha.contains("<state")) {
	    		  est.adicionarEstado(bufferLinha,bufferArq);
	    	  }
	    	  if (bufferLinha.contains("<transition")) {
	    		  tr.adicionarTransicao(bufferArq);
	    	  }
	    	  bufferLinha = bufferArq.readLine(); // lê da segunda até a última linha
	      }
	      arq.close();
		  Automato aut = new Automato(est.estado,tr.transicoes);
		  aut.retirarEstInacessiveisInuteis(aut);
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	          e.getMessage());
	    }
	    System.out.println();
	  }		
}
