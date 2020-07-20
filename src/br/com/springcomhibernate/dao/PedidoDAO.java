package br.com.springcomhibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.springcomhibernate.model.Pedido;

@Repository
public class PedidoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void inserir(Pedido p) {
		this.manager.persist(p);
	}
}
