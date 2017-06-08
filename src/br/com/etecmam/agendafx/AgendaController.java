package br.com.etecmam.agendafx;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AgendaController implements Initializable {

	@FXML private TableView<ContatoDaTabela> tabela;
	
	@FXML private TableColumn< ContatoDaTabela, Number > colCodigo;
	
	@FXML private TableColumn< ContatoDaTabela, String > colFone;

	@FXML private TableColumn< ContatoDaTabela, String > colEmail;
	
	@FXML private TableColumn< ContatoDaTabela, String > colNome;

	@FXML private TextField txtNome;

	@FXML private TextField txtEmail;

	@FXML private TextField txtCodigo;

	@FXML private TextField txtFone;

	@FXML private Button btnSalvar;
	@FXML private Button btnCancelar;
	@FXML private Button btnSair;
	@FXML private Button btnExcluir;
	@FXML private Button btnNovo;

	@Override public void initialize(URL location, ResourceBundle resources) {
		
		 Contato c1 = new Contato(1, "ALOISIO", "3406 7070", "aloisio@gmil.com");
		 Contato c2 = new Contato(2, "LILIAN", "3406 7071", "lilian@gmil.com");
		 Contato c3 = new Contato(3, "CLARA", "3406 7072", "clara@gmil.com");
		 
		 ArrayList<ContatoDaTabela> contatos = new ArrayList<>();
		 
		 contatos.add( new ContatoDaTabela(c1) );
		 contatos.add( new ContatoDaTabela(c2) );
		 contatos.add( new ContatoDaTabela(c3) );
		
		colCodigo.setCellValueFactory( valorDaCelula -> valorDaCelula.getValue().getCodigo() );
		colNome.setCellValueFactory( valorDaCelula -> valorDaCelula.getValue().getNome() );		
		colEmail.setCellValueFactory( valorDaCelula -> valorDaCelula.getValue().getEmail() );
		colFone.setCellValueFactory( valorDaCelula -> valorDaCelula.getValue().getFone() );
		
		tabela.getItems().addAll( contatos );
	}

}
