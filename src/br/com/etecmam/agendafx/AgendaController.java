package br.com.etecmam.agendafx;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

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

	private Contato contatoSelecionado;

	
	@Override public void initialize(URL location, ResourceBundle resources) {
		
		 Contato c1 = new Contato(1, "ALOISIO", "3406 7070", "aloisio@gmail.com");
		 Contato c2 = new Contato(2, "LILIAN", "3406 7071", "lilian@gmail.com");
		 Contato c3 = new Contato(3, "CLARA", "3406 7072", "clara@gmail.com");
		 
		 ArrayList<ContatoDaTabela> contatos = new ArrayList<>();
		 
		 contatos.add( new ContatoDaTabela(c1) );
		 contatos.add( new ContatoDaTabela(c2) );
		 contatos.add( new ContatoDaTabela(c3) );
		
		colCodigo.setCellValueFactory( valorDaCelula -> valorDaCelula.getValue().getCodigo() );
		colNome.setCellValueFactory( valorDaCelula -> valorDaCelula.getValue().getNome() );		
		colEmail.setCellValueFactory( valorDaCelula -> valorDaCelula.getValue().getEmail() );
		colFone.setCellValueFactory( valorDaCelula -> valorDaCelula.getValue().getFone() );
		
		tabela.getItems().addAll( contatos );
		
		codificarTabela();
		codificarBotoes();
		
	}

	private void codificarTabela() {
		
		tabela.setOnKeyReleased( evt ->{			
			if ( (evt.getCode().equals(KeyCode.DOWN)) || (evt.getCode().equals(KeyCode.UP)) )				
				atualizarDados();
		});
		
		tabela.setOnMouseClicked( evt->{
			atualizarDados();
		});
		
	}


	private void codificarBotoes() {

		btnSair.setOnAction( sair ->{			
			Platform.exit();
			System.exit(0);
		});
		
		btnNovo.setOnAction( novo ->{
			limparCampos();			
		});
		
		btnCancelar.setOnAction( cancelar ->{
			cancelar();
		});
				
		
	}

	
	private void atualizarDados() {
		
		int i = tabela.getSelectionModel().getSelectedIndex();
		
		if(i != -1) {			
			
			ContatoDaTabela c = tabela.getItems().get(i);
			
			contatoSelecionado = c.getContato();
			
			txtCodigo.setText( contatoSelecionado.getCodigo().toString() );
			txtNome.setText( contatoSelecionado.getNome() );
			txtFone.setText( contatoSelecionado.getFone() );
			txtEmail.setText( contatoSelecionado.getEmail() );
			
		}	
		
	}
	
	private void cancelar() {
		
		if( contatoSelecionado != null){
			
			txtCodigo.setText( contatoSelecionado.getCodigo().toString() );
			txtNome.setText( contatoSelecionado.getNome() );
			txtFone.setText( contatoSelecionado.getFone() );
			txtEmail.setText( contatoSelecionado.getEmail() );
		}else{
			limparCampos();
		}
	}

	private void limparCampos() {
		
		txtCodigo.setText("");
		txtNome.setText("");
		txtFone.setText("");
		txtEmail.setText("");
		
		txtCodigo.requestFocus();
		
	}

}
