package br.com.loja.controller;

import static br.com.caelum.vraptor.view.Results.json;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class UsuarioController {

	private final Usuario usuario;
	private final Result result;

	public UsuarioController(Result result, Usuario usuario) {
		this.result = result;
		this.usuario = usuario;
	}
	
	public String sessao() {
		return usuario.getNome();
	}

	@Get
	@Path("/usuario/retorna")
	public void retorna() {
		System.out.println(usuario);
		result.use(json()).from(usuario).serialize();  
	}
	
}
