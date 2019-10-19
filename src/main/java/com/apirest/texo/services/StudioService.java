package com.apirest.texo.services;

import com.apirest.texo.entities.Studio;

public interface StudioService {

	Studio findByName(String name);

	Studio persit(Studio studio);
	
}
