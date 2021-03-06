package com.apirest.texo.start;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.apirest.texo.entities.Movie;
import com.apirest.texo.entities.Producer;
import com.apirest.texo.entities.Studio;
import com.apirest.texo.services.MovieService;
import com.apirest.texo.services.ProducerService;
import com.apirest.texo.services.StudioService;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Component
public class Start implements ApplicationListener<ApplicationReadyEvent>{
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	StudioService studioService;
	
	@Autowired
	ProducerService producerService;

	/*
	 * 
	 * @autor Felipe Nazário
	 * 
	 * Método utilizado para a ler o arquivo movielist.csv
	 * na pasta raiz do projeto e salvar os dados no banco de dados H2 
	 * 
	 * */
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
			
		try {
			CSVReader csvReader = new CSVReaderBuilder(new FileReader("movielist.csv")).withSkipLines(1).build();		
			List<String[]> rows = csvReader.readAll();
			Movie movie;	
			
			for(String[] row: rows) {
				String[] teste = row[0].split(";");
				movie = new Movie();
				movie.setAno(Integer.parseInt(teste[0]));
				movie.setTitle(teste[1]);
				movie.setStudios(preencheStudio(teste[2]));
				movie.setProducer(preencheProducer(teste[3]));
				movie.setWinner(teste.length == 5 ? true : false);
				
				movieService.persist(movie);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
	}

	private List<Producer> preencheProducer(String producerRow) {
		List<Producer> producers = new ArrayList<Producer>();
		producerRow = producerRow.replaceAll("and", ",");
		String[] atributs = producerRow.split(",");

		for(String atribut: atributs) {
			Producer producer = producerService.findByName(atribut.trim());
			if(producer != null) {
				producers.add(producer);
			}else {
				producer = new Producer();
				producer.setName(atribut.trim());
				producers.add(producerService.persist(producer));
			}
		}
		return producers;
	}

	private List<Studio> preencheStudio(String studioRow) {
		List<Studio> studios = new ArrayList<>();
		Studio studio;
		String[] atributs = studioRow.split(",");
		for(String atribut: atributs) { 
			studio = studioService.findByName(atribut.trim());
			if (studio != null) {
				studios.add(studio);
			} else {
				studio = new Studio();
				studio.setName(atribut.trim());
				studios.add(studioService.persit(studio));
			}
			studios.add(studio);
		}
		return studios;
	}

}