package br.com.etecmam.agendafx;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;


public class ContatoDAO {

	static EntityManagerFactory emf;

	static{ 
		emf = Persistence.createEntityManagerFactory("AGENDA_UNIT");		 
	}
	
	public static  EntityManager getEntityManager(){
		
		EntityManager em = null;
		
		try {
			em = emf.createEntityManager();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO AO ABRIR BANCO DE DADOS : " + e.getLocalizedMessage() ) ;
			System.exit(0);			
		}
		
		return em;
	}				

	static boolean adicionarContato(Contato contato){

		boolean r = false;
		
		try {
			
			EntityManager em = getEntityManager();
			
			em.getTransaction().begin();
			em.persist(contato);
			em.getTransaction().commit();
						
			r = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;

	}
	
	
	static boolean atualizarContato(Contato contato){

		boolean r = false;
		
		try {
			
			EntityManager em = getEntityManager();
			
			em.getTransaction().begin();
			em.merge(contato);
			em.getTransaction().commit();
						
			r = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;

	}
	
	public List<Contato>  listarContatos(){
		
		EntityManager em = null;
		List<Contato> contatos = null;

		try {
			
			em = getEntityManager();
			
			TypedQuery<Contato> query = em.createQuery("SELECT c FROM Contato c", Contato.class);
			contatos = query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return contatos;
		
	}
	
	public boolean apagarContato(Long codigo) {

		EntityManager em = null;
		boolean r = false;

		try {

			em = getEntityManager();
			
			Contato contato = em.find(Contato.class, codigo);
			
			em.getTransaction().begin();
			em.remove( contato );
			em.getTransaction().commit();
			
			r = true;

		} catch (Exception e) {
			e.printStackTrace();		
		}			

		return r;

	}
	


}
