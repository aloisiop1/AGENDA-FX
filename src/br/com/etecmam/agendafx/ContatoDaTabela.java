package br.com.etecmam.agendafx;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class ContatoDaTabela {	
	
	private Contato contato;	
	
	private SimpleLongProperty codigo;
	private SimpleStringProperty nome;
	private SimpleStringProperty email;
	private SimpleStringProperty fone;			

	public ContatoDaTabela(Contato contato) {
		setContato(contato);
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {		
		this.contato = contato;		
		codigo = new SimpleLongProperty( contato.getCodigo() ) ;
		nome = new SimpleStringProperty( contato.getNome() ) ;
		email = new SimpleStringProperty( contato.getEmail() );
		fone = new SimpleStringProperty( contato.getFone() );
	}

	// GERAR GETTERS E SETTERS

	public SimpleLongProperty getCodigo() {
		return codigo;
	}

	public void setCodigo(SimpleLongProperty codigo) {
		this.codigo = codigo;
	}

	public SimpleStringProperty getNome() {
		return nome;
	}

	public void setNome(SimpleStringProperty nome) {
		this.nome = nome;
	}

	public SimpleStringProperty getEmail() {
		return email;
	}

	public void setEmail(SimpleStringProperty email) {
		this.email = email;
	}

	public SimpleStringProperty getFone() {
		return fone;
	}

	public void setFone(SimpleStringProperty fone) {
		this.fone = fone;
	}

}
