package com.apirest.texo.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		String mensagem = ex.getCause().toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagem));
		
		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Erro> erros = listaDeErros(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers,HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Erro> listaDeErros(BindingResult bindingResult){
		List<Erro> erros = new ArrayList<>();
		for(FieldError fieldError: bindingResult.getFieldErrors()) {
			 erros.add(new Erro(fieldError.toString()));
		}
		return erros;
	}
	
	private static class Erro {
		
		private String mensagem;


		public Erro(String mensagem) {
			this.mensagem = mensagem;
		}

		public String getMensagem() {
			return mensagem;
		}
		
		
	}
}
