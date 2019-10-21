package com.apirest.texo.services;

import com.apirest.texo.entities.Studio;

public interface StudioService {

	
	/**
	 * 
	 * @author Felipe Nazário 
	 * @param name
	 * @return retorna um studio com o nome especificado
	 * 
	 */
	Studio findByName(String name);

	/**
	 * Metodo utilizado para persistir um studio 
	 * 
	 * @author Felipe Nazário 
	 * @param Studio
	 * 
	 * @return retorna um studio com o nome especificado
	 * 
	 */
	Studio persit(Studio studio);
	
}
