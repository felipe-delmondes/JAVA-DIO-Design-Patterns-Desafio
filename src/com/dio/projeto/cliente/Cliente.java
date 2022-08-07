package com.dio.projeto.cliente;

import com.dio.projeto.conta.implementacao.ContaGenerica;

public class Cliente {
	private String nome;
	private String sobrenome;
	private ContaGenerica conta;
	private String chavePIX="";
	
	public Cliente(String nome, String sobrenome) {
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	

	public void setConta(ContaGenerica conta) {
		this.conta = conta;
	}
	
	public void setchavePIX(String chave) {
		this.chavePIX = chave;
	}



	public String getNome() {
		return nome;
	}



	public String getSobrenome() {
		return sobrenome;
	}



	public ContaGenerica getConta() {
		return conta;
	}



	public String getChavePIX() {
		return chavePIX;
	}



	@Override
	public String toString() {
		return "Informações do Cliente: \nNome=" + nome + "\nSobrenome=" + sobrenome + "\nConta=" + conta;
	}
	
	
}
