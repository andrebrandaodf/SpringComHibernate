package br.com.springcomhibernate.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.springcomhibernate.dao.ClienteDAO;
import br.com.springcomhibernate.dao.PedidoDAO;
import br.com.springcomhibernate.dao.ProdutoDAO;
import br.com.springcomhibernate.model.Cliente;
import br.com.springcomhibernate.model.ItensPedido;
import br.com.springcomhibernate.model.Pedido;

@Controller
public class Pedidocontroller {
	
	@Autowired
	private PedidoDAO pedidoDao;
	@Autowired
	private ProdutoDAO produtoDao;
	@Autowired
	private ClienteDAO clienteDao;
	private List<ItensPedido>listaAdicionados = new ArrayList<>();
	
	//Metodo responsavel por listar todos os produtos
	@RequestMapping("listaProdutoParaPedido")
	public String listarPedido(Model model) {
		model.addAttribute("listaProdutos", produtoDao.listar());
		model.addAttribute("listaCliente", clienteDao.listar());
		return "listaitensprodutosparapedido";
	}
	
	
	
	//Metodo que sera acionado via java Script
	@RequestMapping("adicionarItem")
	public void adicionarItemAoPedido(ItensPedido itens,  HttpServletResponse response) {
		listaAdicionados.add(itens);
		response.setStatus(200);
	}
	
	//Metodo que sera adicionado ao clicar no botao fechar pedido
	@RequestMapping("fecharPedido")
	public String fecharPedido(Cliente c) {
	
		Pedido p = new Pedido();
		p.setItens(listaAdicionados);
		
		listaAdicionados.forEach(i->i.setPedido(p));
		p.setCliente(c);
		pedidoDao.inserir(p);
		
		listaAdicionados.removeAll(listaAdicionados);
		return "redirect:listaProdutoParaPedido";
	}
}
