package br.com.etecmam.agendafx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AgendaController implements Initializable {

	@FXML private TableView<Agenda> tabela;
	
	@FXML private TableColumn<Agenda, Long> colCodigo;
	
	@FXML private TableColumn<Agenda, String> colFone;

	@FXML private TableColumn<Agenda, String> colEmail;
	
	@FXML private TableColumn<Agenda, String> colNome;

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
		
	}

}
