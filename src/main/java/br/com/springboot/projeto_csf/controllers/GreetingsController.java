package br.com.springboot.projeto_csf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.java.util.List;
import br.com.springboot.projeto_csf.model.Usuario;
import br.com.springboot.projeto_csf.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController { 
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "Curso Spring Boot API: " + name + "!";
    } 
    
    @RequestMapping(value = "/olamundo/{nome}" , method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String retornaOlaMundo(@PathVariable String nome) {
    	
    	Usuario usuario = new Usuario();
    	usuario.setNome(nome);
    	
    	usuarioRepository.save(usuario);
		return "Ola nundo" + nome;
    }
    
    @GetMapping(value = "listatodos") /*Nosso primeiro método de API*/
    @ResponseBody /*Retorna os dados para o corpo da resposta*/
    public ResponseEntity<java.util.List<Usuario>> listaUsuario(){ 
    	
    	java.util.List<Usuario> usuarios = usuarioRepository.findAll(); /*Executa a consulta no banco de dados*/
    	
    	return new ResponseEntity<java.util.List<Usuario>>(usuarios, HttpStatus.OK); /*Retorna uma lista em JSON*/ 	
    	   	
      			
	}
    
    
}
