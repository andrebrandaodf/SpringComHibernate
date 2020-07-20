package br.com.springcomhibernate.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.springcomhibernate.dao.ClienteDAO;
import br.com.springcomhibernate.model.Cliente;

@RestController
public class ControllerRestCliente {

	@Autowired
	private ClienteDAO clienteDao;
	
	@RequestMapping(value = "/cliente", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Cliente> listar(){
		return clienteDao.listar();
	}

	@RequestMapping(value = "/cliente", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Cliente> inserirUsuario(@RequestBody Cliente cliente){
		try {
			clienteDao.inserir(cliente);
			return ResponseEntity.created(new URI("/cliente/" + cliente.getId())).body(cliente);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Cliente buscarTarefa(@PathVariable("id") long id) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		return clienteDao.buscarPorId(cliente);
	}	
	
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable("id") long id){
		Cliente cliente = new Cliente();
		cliente.setId(id);
		clienteDao.excluir(cliente);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/cliente/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> alterar(@PathVariable("id") long id, @RequestBody Cliente cliente){
		cliente.setId(id);
		try {
			clienteDao.alterar(cliente);
			HttpHeaders responseHeaders = new HttpHeaders();
			URI location = new URI("/cliente/" + id);
			//Retorna no cabeçalho
			responseHeaders.setLocation(location);
			ResponseEntity<Void> response = new ResponseEntity<Void>(responseHeaders, HttpStatus.OK);
			return response;
		}
		catch(URISyntaxException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
