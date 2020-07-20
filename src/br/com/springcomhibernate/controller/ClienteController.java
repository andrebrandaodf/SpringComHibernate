package br.com.springcomhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.springcomhibernate.dao.ClienteDAO;
import br.com.springcomhibernate.model.Cliente;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteDAO clienteDao;
	
	@RequestMapping("formCadastroCliente")
	public String formCadastroCliente() {
		return "formCadastroCliente";
	}

	@RequestMapping("cadastroCliente")
	public String cadastroCliente(Cliente cliente) {
		if(cliente.getId() == null) {
			clienteDao.inserir(cliente);
		}
		else {
			// Adicionar o metodo de atualizar
			clienteDao.alterar(cliente);
		}
		return "redirect:formCadastroCliente";
	}
	
	@RequestMapping("listaCliente")
	public String listar(Model model) {
		model.addAttribute("listaCliente", clienteDao.listar());
		return "listarCliente";
	}
	
	@RequestMapping("excluirCliente")
	public String excluir(Cliente cliente) {
		clienteDao.excluir(cliente);
		return "redirect:listaCliente";
	}
	
	@RequestMapping("buscarAlterarCliente")
	public String buscarAlterar(Cliente cliente, Model model) {
		model.addAttribute("cliente", clienteDao.buscarPorId(cliente));
		return "formCadastroCliente";
	}
		
	@RequestMapping("pesquisarCliente")
	public String pesquisar(Cliente cliente, Model model) {
		model.addAttribute("listaCliente", clienteDao.listarPesquisa(cliente));
		return "listarCliente";
	}
}
