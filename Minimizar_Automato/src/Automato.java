import java.util.ArrayList;
import java.util.HashMap;

public class Automato {
		public HashMap <Estados,ArrayList<Transitions>> etAut = new HashMap<Estados,ArrayList<Transitions>>();
		public Automato(){}
		public Automato(ArrayList<Estados> est,ArrayList<Transitions> tr) {
			for (Estados tempEst:est) {
				ArrayList<Transitions> Atr = new ArrayList<Transitions>(); 
				for (Transitions tempTr:tr) {
						if (tempTr.from.equals(tempEst.nome)) {
							Atr.add(tempTr);
						}
				}
				etAut.put(tempEst, Atr);
			}
		}
		public void retirarEstInacessiveisInuteis(Automato aut) {
				for (Estados est: aut.etAut.keySet()) {
					boolean testeina = true,testeinu = true;
					for (Transitions tr: aut.etAut.get(est)) {
						if (tr.to.equals(est.nome)) {
							testeina = false;
						}
						if(tr.from.equals(est.nome)) {
							testeinu = false;
						}
					}
					if (testeina == true || testeinu == true) {
						aut.etAut.remove(est);
					}
				}
		}
		public void tornarAutomatoTotal(Automato aut) {
			boolean teste0 = false,teste1 = false;
			Estados estd = new Estados();
			ArrayList<Transitions> transicaod = new ArrayList<Transitions>();
			estd.nome = "d";
			for (Estados est: aut.etAut.keySet()) {
				for (Transitions tr: aut.etAut.get(est)) {
						if(tr.read == "0") {
							teste0 = true;
						}
						if(tr.read == "1") {
							teste1 = true;
						}
				}
				if (teste0 == false) {
					transicaod.add(new Transitions(est.nome,estd.nome,"0"));
				}
				if (teste1 == false) {
					transicaod.add(new Transitions(est.nome,estd.nome,"1"));
				}
			}
			aut.etAut.put(estd, transicaod);
		}
		public void minimizarAutomato(Automato aut) {
			Automato aut2 = new Automato();
			for (Estados est: aut.etAut.keySet()) {
				for (Estados est2: aut2.etAut.keySet()) {
					
				}
			}
			
		}
}
