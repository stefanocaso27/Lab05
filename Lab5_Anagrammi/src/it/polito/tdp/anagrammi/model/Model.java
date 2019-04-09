package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	AnagrammaDAO anagrammaDAO = new AnagrammaDAO();
	
	public Set<String> listaparole;
	
	public boolean isCorrect(String anagramma){
		return anagrammaDAO.isCorrect(anagramma);
}
	
	
	public Set<String> trova(String s) {
		String parziale = "";
		this.listaparole = new HashSet<String>();
		this.recursive(s, 0, parziale, listaparole);
		
		return listaparole;
	}
	
	public void recursive(String iniziale, int level, String parziale, Set<String> listaparole) {
		if(level == iniziale.length()) {
			listaparole.add(parziale);
			
		return;
		}
		for(int i=0; i<iniziale.length(); i++) {
			char c = iniziale.charAt(i);
			if(contaLettera(c, iniziale) > contaLettera(c, parziale)) {
				parziale+=c;
				
				recursive(iniziale, level+1, parziale, listaparole);
				parziale = parziale.substring(0, parziale.length()-1);
			}
		}
		
	}

	private int contaLettera(char c, String iniziale) {
		int count = 0;
		for(int i=0; i<iniziale.length(); i++) {
			if(iniziale.charAt(i) == c)
				count++;
		}
		return count;
	}
	
	
	
}
