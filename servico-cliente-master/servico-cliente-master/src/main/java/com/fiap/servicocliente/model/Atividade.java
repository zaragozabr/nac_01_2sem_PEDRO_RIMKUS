package com.fiap.servicocliente.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "atividades")
public class Atividade {
	@Id
	private String id; 
	
	private String nome;
	private int Rm;
	private String UrlGitHub;
	private int NumeroAtividade;
}
