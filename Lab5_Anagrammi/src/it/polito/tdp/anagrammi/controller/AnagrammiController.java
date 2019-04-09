/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

	private Model model;
	private AnagrammaDAO anagrammaDAO;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="testo"
    private TextField testo; // Value injected by FXMLLoader

    @FXML // fx:id="anagramma"
    private Button anagramma; // Value injected by FXMLLoader

    @FXML // fx:id="txtAnagrammaCorr"
    private TextArea txtAnagrammaCorr; // Value injected by FXMLLoader

    @FXML // fx:id="txtAnagrammaScorr"
    private TextArea txtAnagrammaScorr; // Value injected by FXMLLoader

    @FXML // fx:id="reset"
    private Button reset; // Value injected by FXMLLoader

    @FXML
    void doCalcola(ActionEvent event) {
    	Set<String> lista = new HashSet<String>();
    	String stringa = testo.getText();
    	lista = model.trova(stringa);
    	
    	for(String anagramma : lista){
    		if(this.model.isCorrect(anagramma))
    			txtAnagrammaCorr.appendText(anagramma + "\n");
    		else
    			txtAnagrammaScorr.appendText(anagramma + "\n");
    	}
    }

    @FXML
    void doCancella(ActionEvent event) {
    	testo.clear();
    	txtAnagrammaCorr.clear();
    	txtAnagrammaScorr.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert testo != null : "fx:id=\"testo\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert anagramma != null : "fx:id=\"anagramma\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAnagrammaCorr != null : "fx:id=\"txtAnagrammaCorr\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAnagrammaScorr != null : "fx:id=\"txtAnagrammaScorr\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert reset != null : "fx:id=\"reset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
    
    public void setAnagrammaDAO(AnagrammaDAO anagrammaDAO) {
    	this.anagrammaDAO = anagrammaDAO;
    }
    
}


