package br.com.springcomhibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.springcomhibernate.model.Produto;

@Repository
public class ProdutoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void inserir(Produto p) {
		this.manager.persist(p);
	}
	
	@Transactional 
	public List<Produto> listar(){
		TypedQuery<Produto> query = manager.createQuery("SELECT p FROM Produto p ", Produto.class);
		return query.getResultList();
	}
	
	@Transactional
	public void excluir(Produto p) {
		p = manager.find(Produto.class, p.getId());
		manager.remove(p);
	}
	
	@Transactional 
	public Produto buscarPorId(Produto p) {
		p = manager.find(Produto.class, p.getId());
		return p;
	}
	
	@Transactional
	public void alterar(Produto p) {
		manager.merge(p);
	}
	
	public List<Produto> listarPesquisa(Produto p){
		TypedQuery<Produto> query = manager.createQuery("SELECT p FROM Produto p WHERE p.nome like :nome", Produto.class);
		return query.getResultList();
	}
	
}
