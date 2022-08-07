package com.dio.projeto.banco;

import com.dio.projeto.cliente.Cliente;
import com.dio.projeto.conta.implementacao.ContaGenerica;


//Facade
//Essa classe manipula o banco e falicita para as Interfaces externas.

public class Instituicao  {
	private Banco banco;
	private Cliente cliente;
	
	

	//Tratamento Design Patterns - Singleton
	private static Instituicao instancia =  new Instituicao();
	
	public static Instituicao getInstancia() { 
		return instancia;
	}

	private Instituicao() {

	}
	

	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	
	public void novoCliente(String nome, String sobrenome, int agencia, int depositoInicial ) {
		cliente = banco.novoCliente(nome, sobrenome);
		banco.novaContaCorrente(cliente, agencia, depositoInicial);
	}
	
	public void loginCliente(int agencia,int conta) {
		cliente = banco.loginCliente(agencia, conta).getCliente();
	}
	
	public void depositar(int valor) {
		cliente.getConta().depositar(valor);
	}
	
	public void sacar(int valor) {
		cliente.getConta().sacar(valor);
	}
	public void transferir(int agencia,int conta, int valor) {
		banco.transferenciaAgenciaConta(cliente, agencia, conta, valor);
	}
	public void Extrato() {
		cliente.getConta().Extrato();
	}
	
	public void clientes() {
		banco.managerListClients();
	}
	

}
