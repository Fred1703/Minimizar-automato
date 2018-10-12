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
	    	  }/*
	    	  if (bufferLinha.contains("<from")) {
	    		  //bufferDados = bufferLinha.substring(5, 6);
	    	  }
	    	  if (bufferLinha.contains("<to")) {
	    		  //bufferDados = bufferLinha.substring(3, 4);
	    		  //tr.to.add(bufferDados);
	    	  }
	    	  if (bufferLinha.contains("<read")) {
	    		 // bufferDados = bufferLinha.substring(5, 6);
	    		 // tr.read.add(bufferDados);
	    	  }	    	  */
	    	  bufferLinha = bufferArq.readLine(); // lê da segunda até a última linha
	      }
	      arq.close();
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	          e.getMessage());
	    }
	    System.out.println();
	  }		
}
