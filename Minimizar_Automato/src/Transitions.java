import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
public class Transitions {
	String from;
    //public String getFrom() {return from;}
	String to;
    //public String getTo() {return to;}
	String read;
    //public String getRead() {return read;}
	ArrayList <Transitions> transicoes = new ArrayList<Transitions>();
    public Transitions() {}
	Transitions(String _from,String _to,String _read) {
		from = _from;
		to = _to;
		read = _read;
	}
	void adicionarTransicao(BufferedReader bufferArq) {
        try {
        	String fromtr = null,totr = null,readtr = null,linha = "";
			while(bufferArq != null) {
				if (linha.contains("<from")) {
					fromtr = linha.substring(9, 10);
				}
				if (linha.contains("<to")) {
					totr = linha.substring(7, 8);
				}
				if (linha.contains("<read")) {
					readtr = linha.substring(9, 10);
				}
				if (linha.contains("</transition")) break;
				linha = bufferArq.readLine();
			}
            transicoes.add(new Transitions(fromtr,totr,readtr));
        }
        catch(IOException e){
        }
}
}
