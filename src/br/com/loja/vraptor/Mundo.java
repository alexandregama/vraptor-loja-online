package br.com.loja.vraptor;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Resource;

@Resource
public class Mundo {

	public String boasvindas() {
		return "Funfando!";
	}
	
	public List<String> paises() {
		List<String> paises = new ArrayList<String>();
		paises.add("Brasil");
		paises.add("Argentina");
		paises.add("Paraguai");
		paises.add("Uruguai");
		
		return paises;
	}
}
