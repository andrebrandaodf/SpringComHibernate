package br.com.springcomhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.springcomhibernate.model.Cliente;

@Repository
public class ClienteDAO {
	
	protected EntityManager manager;
	
	public ClienteDAO() {
		
	}
	
	@PersistenceContext
	private void setEntityManager(EntityManager manager) {
		this.manager = manager;
	} 
	
	
	@Transactional
	public void inserir(Cliente cliente) {
		this.manager.persist(cliente);
		
	}
	
	@Transactional 
	public List<Cliente> listar(){                      //"SELECT c FROM Cliente c" --> modelo do livro
		TypedQuery<Cliente> query = manager.createQuery("SELECT nome FROM Cliente cliente", Cliente.class);
		return query.getResultList();
	}
	
	@Transactional
	public void excluir(Cliente cliente) {
		cliente = manager.find(Cliente.class, cliente.getId());
		manager.remove(cliente);
	}
	
	@Transactional
	public Cliente buscarPorId(Cliente cliente) {
		cliente = manager.find(Cliente.class, cliente.getId());
		return cliente;
	}
	
	@Transactional
	public void alterar(Cliente cliente) {
		manager.merge(cliente);
	}

	public List<Cliente> listarPesquisa(Cliente cliente){ //"SELECT * FROM Cliente cliente WHERE cliente.nome like :nome"
		TypedQuery<Cliente> query = manager.createQuery("SELECT * FROM Cliente", Cliente.class);
		query.setParameter("nome", "%"+cliente.getNome()+"%");
		return query.getResultList();
	}
}
