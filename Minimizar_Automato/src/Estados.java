import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Estados {
    String nome;
	boolean ini,fim;
	ArrayList<Estados> estado = new ArrayList<Estados>();
	Estados(String _nome,boolean _ini,boolean _fim) {
		nome = _nome;
		ini = _ini;
		fim = _fim;
	}
    public Estados() {}
	void adicionarEstado(String nome,BufferedReader bufferArq) {
            try {
            	boolean tempini = false,tempfim  = false;
            	BufferedReader temp = bufferArq;
                String nomeEstado = nome.substring(13, 14);
                String linha = temp.readLine();
                int i = 0;
                while (bufferArq != null){
                	if (linha.contains("<initial")) {
                		tempini = true;
                	}
                	if(linha.contains("<final")) {
                		tempfim = true;
                	}
                	i++;                	
                	linha = temp.readLine();
                	if (i > 4) break;
                }
                estado.add(new Estados(nomeEstado,tempini,tempfim));
            }
            catch(IOException e){
            }
    }
}
