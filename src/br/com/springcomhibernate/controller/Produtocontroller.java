package br.com.springcomhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.springcomhibernate.dao.ProdutoDAO;
import br.com.springcomhibernate.model.Produto;

@Controller
public class Produtocontroller {

	@Autowired
	private ProdutoDAO produtoDao;
	
	@RequestMapping("formCadastroProduto")
	public String formCadastroProduto() {
		return "formCadastroProduto";
	}
	
	@RequestMapping("cadastroProduto")
	public String cadastroCliente(Produto p) {
	
		if(p.getId() == null) {
			produtoDao.inserir(p);
		}
		else {
			produtoDao.alterar(p);
		}
		return "redirect:listaProduto";
	}
	
	@RequestMapping("excluirProduto")
	public String excluir(Produto p) {
		produtoDao.excluir(p);
		return "redirect:listaProduto";
	}
	
	@RequestMapping("buscarAlterarProduto")
	public String buscarAlterar(Produto p, Model model) {
		model.addAttribute("produto", produtoDao.buscarPorId(p));
		return "formCadastroProduto";
	}
	
	@RequestMapping("pesquisar")
	public  String pesquisar(Produto p, Model model) {
		model.addAttribute("listaCliente", produtoDao.listarPesquisa(p));
		return "listarProduto";
	}
}
