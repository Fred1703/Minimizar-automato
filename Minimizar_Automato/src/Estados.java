import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Estados{
    String nome;
    //public String getNome() {return nome;}
	boolean ini;
    //public boolean getIni() {return ini;}
    boolean fim;
    //public boolean getFim() {return fim;}
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
                String nomeEstado = nome.substring(13, 14);
                String linha = bufferArq.readLine();
                while (bufferArq != null){
                	if (linha.contains("<initial")) {
                		tempini = true;
                	}
                	if(linha.contains("<final")) {
                		tempfim = true;
                	}              	
                	if (linha.contains("</state")) break;
                	linha = bufferArq.readLine();
                }
                estado.add(new Estados(nomeEstado,tempini,tempfim));
            }
            catch(IOException e){
            }
    }

}
